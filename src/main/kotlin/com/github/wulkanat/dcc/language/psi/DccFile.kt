package com.github.wulkanat.dcc.language.psi

import com.github.wulkanat.dcc.language.DccFileType
import com.github.wulkanat.dcc.language.DccLang
import com.intellij.extapi.psi.PsiFileBase
import com.intellij.psi.FileViewProvider

class DccFile(viewProvider: FileViewProvider) : PsiFileBase(viewProvider, DccLang) {
    override fun getFileType() = DccFileType
    override fun toString() = "DynamicC File"
}