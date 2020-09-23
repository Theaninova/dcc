package com.github.wulkanat.dcc.language

import com.intellij.openapi.fileTypes.LanguageFileType

object DccFileType : LanguageFileType(DccLang) {
    override fun getName(): String = "DynamicC File"
    override fun getDescription(): String = "DynamicC language file"
    override fun getDefaultExtension(): String = "dcc"
    override fun getIcon() = DccIcons.FILE
}