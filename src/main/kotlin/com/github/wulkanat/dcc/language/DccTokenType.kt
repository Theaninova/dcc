package com.github.wulkanat.dcc.language

import com.intellij.psi.tree.IElementType

class DccTokenType(debugName: String) : IElementType(debugName, DccLang) {
    override fun toString(): String {
        return "DccTokenType.${super.toString()}"
    }
}