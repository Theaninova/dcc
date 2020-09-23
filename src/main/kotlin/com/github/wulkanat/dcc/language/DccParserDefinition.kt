package com.github.wulkanat.dcc.language

import com.github.wulkanat.dcc.language.lexer.DccLexerAdapter
import com.github.wulkanat.dcc.language.parser.DccParser
import com.github.wulkanat.dcc.language.psi.DccFile
import com.github.wulkanat.dcc.language.psi.DccTypes
import com.intellij.lang.ASTNode
import com.intellij.lang.ParserDefinition
import com.intellij.openapi.project.Project
import com.intellij.psi.FileViewProvider
import com.intellij.psi.PsiElement
import com.intellij.psi.TokenType
import com.intellij.psi.tree.IFileElementType
import com.intellij.psi.tree.TokenSet

class DccParserDefinition : ParserDefinition {
    companion object {
        val WHITE_SPACES = TokenSet.create(TokenType.WHITE_SPACE)
        val COMMENTS = TokenSet.create(DccTypes.BLOCK_COMMENT)

        val FILE = IFileElementType(DccLang)
    }

    override fun createLexer(project: Project?) = DccLexerAdapter()
    override fun getWhitespaceTokens() = WHITE_SPACES
    override fun getCommentTokens() = COMMENTS
    override fun getStringLiteralElements(): TokenSet = TokenSet.EMPTY
    override fun createParser(project: Project?) = DccParser()
    override fun getFileNodeType() = FILE
    override fun createFile(viewProvider: FileViewProvider) = DccFile(viewProvider)
    override fun spaceExistenceTypeBetweenTokens(left: ASTNode?, right: ASTNode?) = ParserDefinition.SpaceRequirements.MAY
    override fun createElement(node: ASTNode?): PsiElement = DccTypes.Factory.createElement(node)
}