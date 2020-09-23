// This is a generated file. Not intended for manual editing.
package com.github.wulkanat.dcc.language.psi;

import com.intellij.psi.tree.IElementType;
import com.intellij.psi.PsiElement;
import com.intellij.lang.ASTNode;
import com.github.wulkanat.dcc.language.DccTokenType;
import com.github.wulkanat.dcc.language.psi.impl.*;

public interface DccTypes {

  IElementType ARG_DECLARATION = new DccElementType("ARG_DECLARATION");
  IElementType ARG_DECLARATION_LIST = new DccElementType("ARG_DECLARATION_LIST");
  IElementType BLOCK = new DccElementType("BLOCK");
  IElementType DECLARATION = new DccElementType("DECLARATION");
  IElementType EXPRESSION = new DccElementType("EXPRESSION");
  IElementType FUNCTION_DECLARATION = new DccElementType("FUNCTION_DECLARATION");
  IElementType HEAP_VAL_DECLARATION = new DccElementType("HEAP_VAL_DECLARATION");
  IElementType HEAP_VAR_DECLARATION = new DccElementType("HEAP_VAR_DECLARATION");
  IElementType SEPARATOR = new DccElementType("SEPARATOR");
  IElementType STATEMENT = new DccElementType("STATEMENT");
  IElementType VAL_DECLARATION = new DccElementType("VAL_DECLARATION");
  IElementType VAR_DECLARATION = new DccElementType("VAR_DECLARATION");

  IElementType BLOCK_COMMENT = new DccTokenType("BLOCK_COMMENT");
  IElementType COLON = new DccTokenType("COLON");
  IElementType COMMA = new DccTokenType("COMMA");
  IElementType C_STYLE_COMMENT = new DccTokenType("C_STYLE_COMMENT");
  IElementType DOC_COMMENT = new DccTokenType("DOC_COMMENT");
  IElementType END_OF_LINE_COMMENT = new DccTokenType("END_OF_LINE_COMMENT");
  IElementType EQUALS = new DccTokenType("EQUALS");
  IElementType FUNCTION_KEYWORD = new DccTokenType("FUNCTION_KEYWORD");
  IElementType HEAP_KEYWORD = new DccTokenType("HEAP_KEYWORD");
  IElementType IDENTIFIER = new DccTokenType("IDENTIFIER");
  IElementType LBRACE = new DccTokenType("LBRACE");
  IElementType LINE_BREAK = new DccTokenType("LINE_BREAK");
  IElementType LPARENTH = new DccTokenType("LPARENTH");
  IElementType RBRACE = new DccTokenType("RBRACE");
  IElementType RPARENTH = new DccTokenType("RPARENTH");
  IElementType SEMICOLON = new DccTokenType("SEMICOLON");
  IElementType VAL_KEYWORD = new DccTokenType("VAL_KEYWORD");
  IElementType VAR_KEYWORD = new DccTokenType("VAR_KEYWORD");

  class Factory {
    public static PsiElement createElement(ASTNode node) {
      IElementType type = node.getElementType();
      if (type == ARG_DECLARATION) {
        return new DccArgDeclarationImpl(node);
      }
      else if (type == ARG_DECLARATION_LIST) {
        return new DccArgDeclarationListImpl(node);
      }
      else if (type == BLOCK) {
        return new DccBlockImpl(node);
      }
      else if (type == DECLARATION) {
        return new DccDeclarationImpl(node);
      }
      else if (type == EXPRESSION) {
        return new DccExpressionImpl(node);
      }
      else if (type == FUNCTION_DECLARATION) {
        return new DccFunctionDeclarationImpl(node);
      }
      else if (type == HEAP_VAL_DECLARATION) {
        return new DccHeapValDeclarationImpl(node);
      }
      else if (type == HEAP_VAR_DECLARATION) {
        return new DccHeapVarDeclarationImpl(node);
      }
      else if (type == SEPARATOR) {
        return new DccSeparatorImpl(node);
      }
      else if (type == STATEMENT) {
        return new DccStatementImpl(node);
      }
      else if (type == VAL_DECLARATION) {
        return new DccValDeclarationImpl(node);
      }
      else if (type == VAR_DECLARATION) {
        return new DccVarDeclarationImpl(node);
      }
      throw new AssertionError("Unknown element type: " + type);
    }
  }
}
