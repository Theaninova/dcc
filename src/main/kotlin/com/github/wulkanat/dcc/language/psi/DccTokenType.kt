package com.github.wulkanat.dcc.language.psi

import com.github.wulkanat.dcc.language.DccLang
import com.intellij.psi.tree.IElementType

class DccTokenType(debugName: String) : IElementType(debugName, DccLang) {
    override fun toString() = "DccTokenType.${super.toString()}"
}