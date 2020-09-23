package com.github.wulkanat.dcc.language

import com.intellij.codeInsight.daemon.RelatedItemLineMarkerInfo
import com.intellij.codeInsight.daemon.RelatedItemLineMarkerProvider
import com.intellij.codeInsight.navigation.NavigationGutterIconBuilder
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiJavaToken
import com.intellij.psi.PsiLiteralExpression

class DccLineMarkerProvider : RelatedItemLineMarkerProvider() {
    override fun collectNavigationMarkers(element: PsiElement, result: MutableCollection<in RelatedItemLineMarkerInfo<*>>) {
        if (element !is PsiJavaToken || element.parent !is PsiLiteralExpression) return

        val literalExpression = element.parent as PsiLiteralExpression
        val value = if (literalExpression.value is String) literalExpression.value as String else return
        if (!value.startsWith(DccAnnotator.DCC_PREFIX_STR + DccAnnotator.DCC_SEPARATOR_STR)) return

        val project = element.project
        val possibleProperties = value.substring(DccAnnotator.DCC_PREFIX_STR.length + DccAnnotator.DCC_SEPARATOR_STR.length)
        val properties = DccUtil.findProperties(project, possibleProperties)

        if (properties.isNotEmpty()) {
            val builder = NavigationGutterIconBuilder.create(DccIcons.FILE)
                    .setTargets(properties)
                    .setTooltipText("Navigate to DCC property")
            result.add(builder.createLineMarkerInfo(element))
        }
    }
}