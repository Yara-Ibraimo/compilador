// Definição da gramática MOC
grammar MOCC;

@header {
package com.mycompany;
}

// ----------------------
// Regras Sintáticas
// ----------------------

// Ponto de entrada
program
    : (functionDecl | variableDecl)* EOF
    ;

// Declaração de funções (suporta funções completas ou apenas protótipos)
functionDecl
    : type ID '(' parameters ')' ( block | ';' )
    | type ID '(' ')' block
    ;

// Declaração de parâmetros (com suporte a vetores e tipos anónimos)
parameters
    : 'void'
    | parameter (',' parameter)*
    ;

// Parametrização expandida
parameter
    : type ID                # typedIdentifier
    | type                  # typedOnly
    | type ID '[' ']'       # typedArray
    | type '[' ']'          # typeAnonymousArray
    ;

// Declaração de variáveis
variableDecl
    : type varDeclList ';'
    ;

varDeclList
    : varDecl (',' varDecl)*
    ;

varDecl
    : ID ('[' INT ']')? (ASSIGN expression)?
    ;

// Tipos de dados permitidos
type
    : 'int' | 'double' | 'char' | 'void' | REGISTERINT | REGISTERLONG
    ;

// Bloco de código
block
    : '{' statement* '}'
    ;

// Declarações e instruções
statement
    : variableDecl
    | assignment
    | userFunctionCall ';'
    | writeCall ';'
    | ifStatement
    | whileStatement
    | forStatement
    | returnStatement
    | block
    ;

// Atribuições
assignment
    : (ID | ID '[' expression ']') ASSIGN expression ';'
    ;

// Estruturas de controlo
ifStatement
    : 'if' '(' expression ')' block ('else' block)?
    ;

whileStatement
    : 'while' '(' expression ')' block
    ;

forStatement
    : 'for' '(' expression? ';' expression ';' expression ')' block
    ;

// Instrução de retorno
returnStatement
    : 'return' expression? ';'
    ;

// Chamadas de funções
userFunctionCall
    : ID '(' arguments? ')'
    ;

readCall
    : ('read' | 'readc' | 'reads') '(' ')'
    ;

writeCall
    : ('write' | 'writec' | 'writes' | 'writev') '(' arguments? ')'
    ;

// Argumentos
arguments
    : expression (',' expression)*
    ;

// Expressões
expression
    : cast
    | expression op=(MUL | DIV) expression
    | expression op=(ADD | SUB) expression
    | expression op=(LT | LE | GT | GE | EQ | NEQ) expression
    | '(' expression ')'
    | userFunctionCall
    | readCall
    | ID '[' expression ']'
    | ID
    | INT
    | DOUBLE
    | CHAR
    | STRING
    | ID ASSIGN expression   // Atribuição dentro da expressão
    ;

// Casts
cast
    : '(' ('int' | 'double') ')' expression
    ;

// Inicialização por lista (vetores)
initList
    : '{' expression (',' expression)* '}'
    ;

// ----------------------
// Tokens Léxicos
// ----------------------

REGISTERINT  : 'registerint' ;
REGISTERLONG : 'registerlong' ;

MUL     : '*' ;
DIV     : '/' ;
ADD     : '+' ;
SUB     : '-' ;
LT      : '<' ;
LE      : '<=' ;
GT      : '>' ;
GE      : '>=' ;
EQ      : '==' ;
NEQ     : '!=' ;
ASSIGN  : '=' ;

ID      : [a-zA-Z_][a-zA-Z_0-9]* ;
INT     : [0-9]+ ;
DOUBLE  : [0-9]+ '.' [0-9]+ ;
CHAR    : '\'' . '\'' ;
STRING  : '"' (~["\\] | '\\' .)* '"' ;

WS              : [ \t\r\n]+ -> skip ;
COMMENT         : '/*' .*? '*/' -> skip ;
LINE_COMMENT    : '//' ~[\r\n]* -> skip ;
