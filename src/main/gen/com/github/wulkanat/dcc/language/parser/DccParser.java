// This is a generated file. Not intended for manual editing.
package com.github.wulkanat.dcc.language.parser;

import com.intellij.lang.PsiBuilder;
import com.intellij.lang.PsiBuilder.Marker;
import static com.github.wulkanat.dcc.language.psi.DccTypes.*;
import static com.intellij.lang.parser.GeneratedParserUtilBase.*;
import com.intellij.psi.tree.IElementType;
import com.intellij.lang.ASTNode;
import com.intellij.psi.tree.TokenSet;
import com.intellij.lang.PsiParser;
import com.intellij.lang.LightPsiParser;

@SuppressWarnings({"SimplifiableIfStatement", "UnusedAssignment"})
public class DccParser implements PsiParser, LightPsiParser {

  public ASTNode parse(IElementType t, PsiBuilder b) {
    parseLight(t, b);
    return b.getTreeBuilt();
  }

  public void parseLight(IElementType t, PsiBuilder b) {
    boolean r;
    b = adapt_builder_(t, b, this, null);
    Marker m = enter_section_(b, 0, _COLLAPSE_, null);
    r = parse_root_(t, b);
    exit_section_(b, 0, m, t, r, true, TRUE_CONDITION);
  }

  protected boolean parse_root_(IElementType t, PsiBuilder b) {
    return parse_root_(t, b, 0);
  }

  static boolean parse_root_(IElementType t, PsiBuilder b, int l) {
    return dccFile(b, l + 1);
  }

  /* ********************************************************** */
  // IDENTIFIER typed_thing? EQUALS expression separator
  static boolean any_var_declaration(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "any_var_declaration")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, IDENTIFIER);
    r = r && any_var_declaration_1(b, l + 1);
    r = r && consumeToken(b, EQUALS);
    r = r && expression(b, l + 1);
    r = r && separator(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // typed_thing?
  private static boolean any_var_declaration_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "any_var_declaration_1")) return false;
    typed_thing(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // IDENTIFIER typed_thing
  public static boolean arg_declaration(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "arg_declaration")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, IDENTIFIER);
    r = r && typed_thing(b, l + 1);
    exit_section_(b, m, ARG_DECLARATION, r);
    return r;
  }

  /* ********************************************************** */
  // LPARENTH arg_declaration? (COMMA arg_declaration)* COMMA? RPARENTH
  public static boolean arg_declaration_list(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "arg_declaration_list")) return false;
    if (!nextTokenIs(b, LPARENTH)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LPARENTH);
    r = r && arg_declaration_list_1(b, l + 1);
    r = r && arg_declaration_list_2(b, l + 1);
    r = r && arg_declaration_list_3(b, l + 1);
    r = r && consumeToken(b, RPARENTH);
    exit_section_(b, m, ARG_DECLARATION_LIST, r);
    return r;
  }

  // arg_declaration?
  private static boolean arg_declaration_list_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "arg_declaration_list_1")) return false;
    arg_declaration(b, l + 1);
    return true;
  }

  // (COMMA arg_declaration)*
  private static boolean arg_declaration_list_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "arg_declaration_list_2")) return false;
    while (true) {
      int c = current_position_(b);
      if (!arg_declaration_list_2_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "arg_declaration_list_2", c)) break;
    }
    return true;
  }

  // COMMA arg_declaration
  private static boolean arg_declaration_list_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "arg_declaration_list_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && arg_declaration(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // COMMA?
  private static boolean arg_declaration_list_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "arg_declaration_list_3")) return false;
    consumeToken(b, COMMA);
    return true;
  }

  /* ********************************************************** */
  // LBRACE item_* RBRACE
  public static boolean block(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "block")) return false;
    if (!nextTokenIs(b, LBRACE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LBRACE);
    r = r && block_1(b, l + 1);
    r = r && consumeToken(b, RBRACE);
    exit_section_(b, m, BLOCK, r);
    return r;
  }

  // item_*
  private static boolean block_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "block_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!item_(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "block_1", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // C_STYLE_COMMENT | DOC_COMMENT | END_OF_LINE_COMMENT | BLOCK_COMMENT
  static boolean comment(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "comment")) return false;
    boolean r;
    r = consumeToken(b, C_STYLE_COMMENT);
    if (!r) r = consumeToken(b, DOC_COMMENT);
    if (!r) r = consumeToken(b, END_OF_LINE_COMMENT);
    if (!r) r = consumeToken(b, BLOCK_COMMENT);
    return r;
  }

  /* ********************************************************** */
  // item_*
  static boolean dccFile(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "dccFile")) return false;
    while (true) {
      int c = current_position_(b);
      if (!item_(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "dccFile", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // var_declaration | val_declaration | heap_val_declaration | heap_var_declaration
  public static boolean declaration(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "declaration")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, DECLARATION, "<declaration>");
    r = var_declaration(b, l + 1);
    if (!r) r = val_declaration(b, l + 1);
    if (!r) r = heap_val_declaration(b, l + 1);
    if (!r) r = heap_var_declaration(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // block
  public static boolean expression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "expression")) return false;
    if (!nextTokenIs(b, LBRACE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = block(b, l + 1);
    exit_section_(b, m, EXPRESSION, r);
    return r;
  }

  /* ********************************************************** */
  // FUNCTION_KEYWORD IDENTIFIER arg_declaration_list typed_thing? block
  public static boolean function_declaration(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "function_declaration")) return false;
    if (!nextTokenIs(b, FUNCTION_KEYWORD)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, FUNCTION_KEYWORD, IDENTIFIER);
    r = r && arg_declaration_list(b, l + 1);
    r = r && function_declaration_3(b, l + 1);
    r = r && block(b, l + 1);
    exit_section_(b, m, FUNCTION_DECLARATION, r);
    return r;
  }

  // typed_thing?
  private static boolean function_declaration_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "function_declaration_3")) return false;
    typed_thing(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // HEAP_KEYWORD val_declaration
  public static boolean heap_val_declaration(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "heap_val_declaration")) return false;
    if (!nextTokenIs(b, HEAP_KEYWORD)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, HEAP_KEYWORD);
    r = r && val_declaration(b, l + 1);
    exit_section_(b, m, HEAP_VAL_DECLARATION, r);
    return r;
  }

  /* ********************************************************** */
  // HEAP_KEYWORD var_declaration
  public static boolean heap_var_declaration(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "heap_var_declaration")) return false;
    if (!nextTokenIs(b, HEAP_KEYWORD)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, HEAP_KEYWORD);
    r = r && var_declaration(b, l + 1);
    exit_section_(b, m, HEAP_VAR_DECLARATION, r);
    return r;
  }

  /* ********************************************************** */
  // statement|comment
  static boolean item_(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "item_")) return false;
    boolean r;
    r = statement(b, l + 1);
    if (!r) r = comment(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // SEMICOLON | LINE_BREAK
  public static boolean separator(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "separator")) return false;
    if (!nextTokenIs(b, "<separator>", LINE_BREAK, SEMICOLON)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, SEPARATOR, "<separator>");
    r = consumeToken(b, SEMICOLON);
    if (!r) r = consumeToken(b, LINE_BREAK);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // function_declaration | declaration
  public static boolean statement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "statement")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, STATEMENT, "<statement>");
    r = function_declaration(b, l + 1);
    if (!r) r = declaration(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // COLON IDENTIFIER
  static boolean typed_thing(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "typed_thing")) return false;
    if (!nextTokenIs(b, COLON)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, COLON, IDENTIFIER);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // VAL_KEYWORD any_var_declaration
  public static boolean val_declaration(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "val_declaration")) return false;
    if (!nextTokenIs(b, VAL_KEYWORD)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, VAL_KEYWORD);
    r = r && any_var_declaration(b, l + 1);
    exit_section_(b, m, VAL_DECLARATION, r);
    return r;
  }

  /* ********************************************************** */
  // VAR_KEYWORD any_var_declaration
  public static boolean var_declaration(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "var_declaration")) return false;
    if (!nextTokenIs(b, VAR_KEYWORD)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, VAR_KEYWORD);
    r = r && any_var_declaration(b, l + 1);
    exit_section_(b, m, VAR_DECLARATION, r);
    return r;
  }

}
