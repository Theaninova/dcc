package com.github.wulkanat.dcc.language

import com.github.wulkanat.dcc.language.psi.DccFile
import com.github.wulkanat.dcc.language.psi.DccProperty
import com.intellij.openapi.project.Project
import com.intellij.psi.PsiManager
import com.intellij.psi.search.FileTypeIndex
import com.intellij.psi.search.GlobalSearchScope
import com.intellij.psi.util.PsiTreeUtil

object DccUtil {
    @JvmStatic
    fun findProperties(project: Project, key: String): List<DccProperty> {
        val result = arrayListOf<DccProperty>()
        val virtualFiles = FileTypeIndex.getFiles(DccFileType, GlobalSearchScope.allScope(project))

        for (virtualFile in virtualFiles) {
            val simpleFile = PsiManager.getInstance(project).findFile(virtualFile) as DccFile? ?: continue
            val properties = PsiTreeUtil.getChildrenOfType(simpleFile, DccProperty::class.java) ?: continue

            for (property in properties) {
                if (key == property?.key) {
                    result.add(property)
                }
            }
        }

        return result
    }

    @JvmStatic
    fun findProperties(project: Project): List<DccProperty> {
        val result = arrayListOf<DccProperty>()
        val virtualFiles = FileTypeIndex.getFiles(DccFileType, GlobalSearchScope.allScope(project))

        for (virtualFile in virtualFiles) {
            val simpleFile = PsiManager.getInstance(project).findFile(virtualFile) as DccFile? ?: continue
            val properties = PsiTreeUtil.getChildrenOfType(simpleFile, DccProperty::class.java) ?: continue

            for (property in properties) {
                if (property != null) result.add(property)
            }
        }

        return result
    }
}