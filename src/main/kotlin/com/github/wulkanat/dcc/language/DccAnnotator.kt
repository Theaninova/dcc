package com.github.wulkanat.dcc.language

import com.intellij.lang.annotation.AnnotationHolder
import com.intellij.lang.annotation.Annotator
import com.intellij.lang.annotation.HighlightSeverity
import com.intellij.openapi.editor.DefaultLanguageHighlighterColors
import com.intellij.openapi.util.TextRange
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiLiteralExpression

class DccAnnotator : Annotator {
    companion object {
        val DCC_PREFIX_STR = "dcc"
        val DCC_SEPARATOR_STR = ":"
    }

    override fun annotate(element: PsiElement, holder: AnnotationHolder) {
        if (element !is PsiLiteralExpression) return

        val value = if (element.value is String) element.value as String else return
        if (!value.startsWith(DCC_PREFIX_STR + DCC_SEPARATOR_STR)) return

        // Define the text ranges (start is inclusive, end is exclusive)
        // "dcc:key"
        //  01234567890
        val prefixRange = TextRange.from(element.textRange.startOffset, DCC_PREFIX_STR.length + 1)
        val separatorRange = TextRange.from(prefixRange.endOffset, DCC_SEPARATOR_STR.length)
        val keyRange = TextRange(separatorRange.endOffset, element.textRange.endOffset - 1)

        // Get the list of properties from the Project
        val possibleProperties = value.substring(DCC_PREFIX_STR.length + DCC_SEPARATOR_STR.length)
        val project = element.project
        val properties = DccUtil.findProperties(project, possibleProperties)

        // Set the annotations using the text ranges - Normally there would be one range, set by the element itself.
        holder.newAnnotation(HighlightSeverity.INFORMATION, "")
                .range(prefixRange).textAttributes(DefaultLanguageHighlighterColors.KEYWORD).create()
        holder.newAnnotation(HighlightSeverity.INFORMATION, "")
                .range(separatorRange).textAttributes(DccSyntaxHighlighter.SEPARATOR).create()

        if (properties.isEmpty()) {
            // No well-formed property found following the key-separator
            holder.newAnnotation(HighlightSeverity.ERROR, "Unresolved property").range(keyRange)
                    // Force the text attributes to Simple syntax bad character
                    .textAttributes(DccSyntaxHighlighter.BAD_CHARACTER)
                    // TODO: ** Tutorial step 18.3 - Add a quick fix for the string containing possible properties
                    // .withFix(TODO("new SimpleCreatePropertyQuickFix(possibleProperties)"))
                    // Finish creating new annotation
                    .create()
        } else {
            // Found at least one property, force the text attributes to Simple syntax value character
            holder.newAnnotation(HighlightSeverity.INFORMATION, "")
                    .range(keyRange).textAttributes(DccSyntaxHighlighter.VALUE).create()
        }
    }
}