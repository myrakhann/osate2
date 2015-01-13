
/*
* generated by Xtext
*/
lexer grammar InternalReqSpecLexer;


@header {
package org.osate.reqspec.ui.contentassist.antlr.lexer;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.ui.editor.contentassist.antlr.internal.Lexer;
}




Specification : ('S'|'s')('P'|'p')('E'|'e')('C'|'c')('I'|'i')('F'|'f')('I'|'i')('C'|'c')('A'|'a')('T'|'t')('I'|'i')('O'|'o')('N'|'n');

Description : ('D'|'d')('E'|'e')('S'|'s')('C'|'c')('R'|'r')('I'|'i')('P'|'p')('T'|'t')('I'|'i')('O'|'o')('N'|'n');

Requirement : ('R'|'r')('E'|'e')('Q'|'q')('U'|'u')('I'|'i')('R'|'r')('E'|'e')('M'|'m')('E'|'e')('N'|'n')('T'|'t');

Stakeholder : ('S'|'s')('T'|'t')('A'|'a')('K'|'k')('E'|'e')('H'|'h')('O'|'o')('L'|'l')('D'|'d')('E'|'e')('R'|'r');

Decomposed : ('D'|'d')('E'|'e')('C'|'c')('O'|'o')('M'|'m')('P'|'p')('O'|'o')('S'|'s')('E'|'e')('D'|'d');

Parameters : ('P'|'p')('A'|'a')('R'|'r')('A'|'a')('M'|'m')('E'|'e')('T'|'t')('E'|'e')('R'|'r')('S'|'s');

Conflicts : ('C'|'c')('O'|'o')('N'|'n')('F'|'f')('L'|'l')('I'|'i')('C'|'c')('T'|'t')('S'|'s');

Mitigated : ('M'|'m')('I'|'i')('T'|'t')('I'|'i')('G'|'g')('A'|'a')('T'|'t')('E'|'e')('D'|'d');

Rationale : ('R'|'r')('A'|'a')('T'|'t')('I'|'i')('O'|'o')('N'|'n')('A'|'a')('L'|'l')('E'|'e');

Category : ('C'|'c')('A'|'a')('T'|'t')('E'|'e')('G'|'g')('O'|'o')('R'|'r')('Y'|'y');

Document : ('D'|'d')('O'|'o')('C'|'c')('U'|'u')('M'|'m')('E'|'e')('N'|'n')('T'|'t');

Evolved : ('E'|'e')('V'|'v')('O'|'o')('L'|'l')('V'|'v')('E'|'e')('D'|'d');

Evolves : ('E'|'e')('V'|'v')('O'|'o')('L'|'l')('V'|'v')('E'|'e')('S'|'s');

Library : ('L'|'l')('I'|'i')('B'|'b')('R'|'r')('A'|'a')('R'|'r')('Y'|'y');

Refined : ('R'|'r')('E'|'e')('F'|'f')('I'|'i')('N'|'n')('E'|'e')('D'|'d');

Warning : ('W'|'w')('A'|'a')('R'|'r')('N'|'n')('I'|'i')('N'|'n')('G'|'g');

Assert : ('A'|'a')('S'|'s')('S'|'s')('E'|'e')('R'|'r')('T'|'t');

Folder : ('F'|'f')('O'|'o')('L'|'l')('D'|'d')('E'|'e')('R'|'r');

Hazard : ('H'|'h')('A'|'a')('Z'|'z')('A'|'a')('R'|'r')('D'|'d');

Issues : ('I'|'i')('S'|'s')('S'|'s')('U'|'u')('E'|'e')('S'|'s');

Error : ('E'|'e')('R'|'r')('R'|'r')('O'|'o')('R'|'r');

Goals : ('G'|'g')('O'|'o')('A'|'a')('L'|'l')('S'|'s');

Title : ('T'|'t')('I'|'i')('T'|'t')('L'|'l')('E'|'e');

Goal : ('G'|'g')('O'|'o')('A'|'a')('L'|'l');

Info : ('I'|'i')('N'|'n')('F'|'f')('O'|'o');

With : ('W'|'w')('I'|'i')('T'|'t')('H'|'h');

ApostropheApostropheApostrophe : '\'''\'''\'';

For : ('F'|'f')('O'|'o')('R'|'r');

See : ('S'|'s')('E'|'e')('E'|'e');

ExclamationMarkEqualsSign : '!''=';

ColonColon : ':'':';

EqualsSignLessThanSign : '=''<';

GreaterThanSignEqualsSign : '>''=';

By : ('B'|'b')('Y'|'y');

Of : ('O'|'o')('F'|'f');

To : ('T'|'t')('O'|'o');

NumberSign : '#';

LeftParenthesis : '(';

RightParenthesis : ')';

Comma : ',';

FullStop : '.';

Solidus : '/';

Colon : ':';

LessThanSign : '<';

EqualsSign : '=';

GreaterThanSign : '>';

LeftSquareBracket : '[';

RightSquareBracket : ']';



RULE_ID : '^'? ('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'_'|'0'..'9')*;

RULE_INT : ('0'..'9')+;

RULE_STRING : ('"' ('\\' .|~(('\\'|'"')))* '"'|'\'' ('\\' .|~(('\\'|'\'')))* '\'');

RULE_ML_COMMENT : '/*' ( options {greedy=false;} : . )*'*/';

RULE_SL_COMMENT : '//' ~(('\n'|'\r'))* ('\r'? '\n')?;

RULE_WS : (' '|'\t'|'\r'|'\n')+;

RULE_ANY_OTHER : .;



