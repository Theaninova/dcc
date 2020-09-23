package com.github.wulkanat.dcc.language.lexer;

import com.github.wulkanat.dcc.language.DccLineMarkerProvider;import com.github.wulkanat.dcc.language.psi.DccTypes;

import com.intellij.psi.TokenType;
import com.intellij.lexer.FlexLexer;
import com.intellij.psi.tree.IElementType;
import jdk.nashorn.internal.parser.Token;
import com.github.wulkanat.dcc.language.psi.DccTypes;

%%
%class DccLexer
%implements FlexLexer
%unicode
%function advance
%type IElementType
%eof{ return;
%eof}

CRLF=\R
BLANK=[ \n\t\f]
WHITE_SPACE={CRLF} | {BLANK}

IDENTIFIER = [:jletter:] [:jletterdigit:]*

C_STYLE_COMMENT=("/*"[^"*"]{COMMENT_TAIL})|"/*"
DOC_COMMENT="/*""*"+("/"|([^"/""*"]{COMMENT_TAIL}))?
COMMENT_TAIL=([^"*"]*("*"+[^"*""/"])?)*("*"+"/")?
END_OF_LINE_COMMENT="/""/"[^\r\n]*
BLOCK_COMMENT_BODY={BLANK}*{END_OF_LINE_COMMENT}(\R{BLANK}*{END_OF_LINE_COMMENT})*
BLOCK_COMMENT_END=\R{BLANK}*("module"|"function"|{IDENTIFIER}{WHITE_SPACE}*"=")

DIGIT = [0-9]
DECIMAL = {DIGIT}+ "."? | {DIGIT}* "." {DIGIT}+
NUMBER_LITERAL = {DECIMAL} ([Ee] [+-]? {DIGIT}+)?

%state WAITING_VALUE

%%

<YYINITIAL> {
      "true"                { return DccTypes.TRUE_KEYWORD; }
      "false"               { return DccTypes.FALSE_KEYWORD; }
      "null"                { return DccTypes.NULL_KEYWORD; }

      "var"                 { return DccTypes.VAR_KEYWORD; }
      "val"                 { return DccTypes.VAL_KEYWORD; }
      "heap"                { return DccTypes.HEAP_KEYWORD; }
      "fun"                 { return DccTypes.FUN_KEYWORD; }
      "type"                { return DccTypes.TYPE_KEYWORD; }
      "weak"                { return DccTypes.WEAK_KEYWORD; }

      "."                   { return DccTypes.DOT; }
      "="                   { return DccTypes.EQUALS; }
      ","                   { return DccTypes.COMMA; }
      ";"                   { return DccTypes.SEMICOLON; }
      "-"                   { return DccTypes.MINUS; }
      "+"                   { return DccTypes.PLUS; }
      "/"                   { return DccTypes.DIV; }
      "*"                   { return DccTypes.MUL; }
      "%"                   { return DccTypes.PERC; }
      ":"                   { return DccTypes.COLON; }
      "("                   { return DccTypes.LPARENTH; }
      ")"                   { return DccTypes.RPARENTH; }
      "{"                   { return DccTypes.LBRACE; }
      "}"                   { return DccTypes.RBRACE; }
      "["                   { return DccTypes.LBRACKET; }
      "]"                   { return DccTypes.RBRACKET; }
      "#"                   { return DccTypes.HASH; }

      "<"                   { return DccTypes.LT; }
      "<="                  { return DccTypes.LE; }
      ">"                   { return DccTypes.GT; }
      ">="                  { return DccTypes.GE; }
      "=="                  { return DccTypes.EQ; }
      "!="                  { return DccTypes.NE; }

      "&&"                  { return DccTypes.AND; }
      "||"                  { return DccTypes.OR; }
      "!"                   { return DccTypes.EXCL; }

      "?"                   { return DccTypes.NULLABLE; }
      "!!"                  { return DccTypes.NOTNULL; }

      ^{BLOCK_COMMENT_BODY}
      / {BLOCK_COMMENT_END} { return DccTypes.BLOCK_COMMENT; }
      {C_STYLE_COMMENT}     { return DccTypes.C_STYLE_COMMENT; }
      {DOC_COMMENT}         { return DccTypes.DOC_COMMENT; }
      {END_OF_LINE_COMMENT} { return DccTypes.END_OF_LINE_COMMENT; }

      {NUMBER_LITERAL}      { return DccTypes.NUMBER_LITERAL; }
      {IDENTIFIER}          { return DccTypes.IDENTIFIER; }

      {CRLF}                { return DccTypes.LINE_BREAK; }
}

{WHITE_SPACE}+              { return TokenType.WHITE_SPACE; }

[^] { return TokenType.BAD_CHARACTER; }