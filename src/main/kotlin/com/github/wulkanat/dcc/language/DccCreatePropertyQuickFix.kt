package com.github.wulkanat.dcc.language

import com.github.wulkanat.dcc.language.psi.DccFile
import com.intellij.codeInsight.intention.impl.BaseIntentionAction
import com.intellij.openapi.application.ApplicationManager
import com.intellij.openapi.command.WriteCommandAction
import com.intellij.openapi.editor.Editor
import com.intellij.openapi.project.Project
import com.intellij.openapi.vfs.VirtualFile
import com.intellij.psi.PsiFile
import com.intellij.psi.PsiManager
import com.intellij.psi.search.FileTypeIndex
import com.intellij.psi.search.GlobalSearchScope

class DccCreatePropertyQuickFix(private val key: String) : BaseIntentionAction() {
    override fun getText() = "Create property"
    override fun getFamilyName() = "DCC properties"
    override fun isAvailable(project: Project, editor: Editor?, file: PsiFile?) = true

    override fun invoke(project: Project, editor: Editor?, file: PsiFile?) {
        ApplicationManager.getApplication().invokeLater {
            val virtualFiles = FileTypeIndex.getFiles(DccFileType, GlobalSearchScope.allScope(project))

            if (virtualFiles.size == 1) {
                // createPropert
            }
        }
    }

    private fun createProperty(project: Project, file: VirtualFile) {
        WriteCommandAction.writeCommandAction(project).run<Nothing> {
            val dccFile = PsiManager.getInstance(project).findFile(file) as DccFile
            val lastChildNode = dccFile.node.lastChildNode
            // TODO: add another check for CRLF
            if (lastChildNode != null/* && !lastChildNode.getElementType().equals(SimpleTypes.CRLF)*/) {
                // dccFile.node.addChild(DccElement)
            }
        }
    }
}