lexer grammar ColonStatementLexer;

@header {
    package org.jdbi.v3.internal.lexer;
}

@lexer::members {
  @Override
  public void reportError(RecognitionException e) {
    throw new IllegalArgumentException(e);
  }
}

fragment QUOTE: '\'';
fragment ESCAPE: '\\';
fragment ESCAPE_QUOTE: ESCAPE QUOTE;
fragment DOUBLE_QUOTE: '"';
fragment COLON: ':';
fragment DOUBLE_COLON: {input.LA(2) == ':'}?=> '::';
fragment NAME: 'a'..'z' | 'A'..'Z' | '0'..'9' | '_' | '.' | '#';

COMMENT: '/*' .* '*/';
QUOTED_TEXT: QUOTE (ESCAPE_QUOTE | ~QUOTE)* QUOTE;
DOUBLE_QUOTED_TEXT: DOUBLE_QUOTE (~DOUBLE_QUOTE)+ DOUBLE_QUOTE;
ESCAPED_TEXT : ESCAPE . ;

NAMED_PARAM: COLON (NAME)+;
POSITIONAL_PARAM: '?';

LITERAL: (NAME | ' ' | '\t' | '\n' | '\r' | ',' | '@' | '!' | '=' | DOUBLE_COLON | ';' | '(' | ')' | '[' | ']'
         | '+' | '-' | '<' | '>' | '%' | '&' | '^' | '|' | '$' | '~' | '{' | '}' | '`')+ | '*' | '/';
