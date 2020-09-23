package com.github.wulkanat.dcc.language.psi.impl

import com.github.wulkanat.dcc.language.psi.DccProperty
import com.github.wulkanat.dcc.language.psi.DccTypes

object DccPsiImplUtil {
    @JvmStatic
    fun getKey(element: DccProperty): String? = null
        // element.node.findChildByType(DccTypes.KEY)?.text?.replace("\\\\ ", " ") TODO

    @JvmStatic
    fun getValue(element: DccProperty): String? = null
            // element.node.findChildByType(DccTypes.VALUE)?.text TODO
}