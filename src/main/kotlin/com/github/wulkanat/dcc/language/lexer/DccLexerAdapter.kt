package com.github.wulkanat.dcc.language.lexer

import com.intellij.lexer.FlexAdapter

class DccLexerAdapter : FlexAdapter(DccLexer(null))