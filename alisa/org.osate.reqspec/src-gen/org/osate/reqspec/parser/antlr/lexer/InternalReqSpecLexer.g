
/*
 * generated by Xtext
 */
lexer grammar InternalReqSpecLexer;


@header {
package org.osate.reqspec.parser.antlr.lexer;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.parser.antlr.Lexer;
}




Timecriticality : ('T'|'t')('I'|'i')('M'|'m')('E'|'e')('C'|'c')('R'|'r')('I'|'i')('T'|'t')('I'|'i')('C'|'c')('A'|'a')('L'|'l')('I'|'i')('T'|'t')('Y'|'y');

Scheduleimpact : ('S'|'s')('C'|'c')('H'|'h')('E'|'e')('D'|'d')('U'|'u')('L'|'l')('E'|'e')('I'|'i')('M'|'m')('P'|'p')('A'|'a')('C'|'c')('T'|'t');

Maturityindex : ('M'|'m')('A'|'a')('T'|'t')('U'|'u')('R'|'r')('I'|'i')('T'|'t')('Y'|'y')('I'|'i')('N'|'n')('D'|'d')('E'|'e')('X'|'x');

Specification : ('S'|'s')('P'|'p')('E'|'e')('C'|'c')('I'|'i')('F'|'f')('I'|'i')('C'|'c')('A'|'a')('T'|'t')('I'|'i')('O'|'o')('N'|'n');

Synchronized : ('S'|'s')('Y'|'y')('N'|'n')('C'|'c')('H'|'h')('R'|'r')('O'|'o')('N'|'n')('I'|'i')('Z'|'z')('E'|'e')('D'|'d');

Description : ('D'|'d')('E'|'e')('S'|'s')('C'|'c')('R'|'r')('I'|'i')('P'|'p')('T'|'t')('I'|'i')('O'|'o')('N'|'n');

Familiarity : ('F'|'f')('A'|'a')('M'|'m')('I'|'i')('L'|'l')('I'|'i')('A'|'a')('R'|'r')('I'|'i')('T'|'t')('Y'|'y');

Requirement : ('R'|'r')('E'|'e')('Q'|'q')('U'|'u')('I'|'i')('R'|'r')('E'|'e')('M'|'m')('E'|'e')('N'|'n')('T'|'t');

Stakeholder : ('S'|'s')('T'|'t')('A'|'a')('K'|'k')('E'|'e')('H'|'h')('O'|'o')('L'|'l')('D'|'d')('E'|'e')('R'|'r');

Uncertainty : ('U'|'u')('N'|'n')('C'|'c')('E'|'e')('R'|'r')('T'|'t')('A'|'a')('I'|'i')('N'|'n')('T'|'t')('Y'|'y');

Assumption : ('A'|'a')('S'|'s')('S'|'s')('U'|'u')('M'|'m')('P'|'p')('T'|'t')('I'|'i')('O'|'o')('N'|'n');

Costimpact : ('C'|'c')('O'|'o')('S'|'s')('T'|'t')('I'|'i')('M'|'m')('P'|'p')('A'|'a')('C'|'c')('T'|'t');

Instanceof : ('I'|'i')('N'|'n')('S'|'s')('T'|'t')('A'|'a')('N'|'n')('C'|'c')('E'|'e')('O'|'o')('F'|'f');

Volatility : ('V'|'v')('O'|'o')('L'|'l')('A'|'a')('T'|'t')('I'|'i')('L'|'l')('I'|'i')('T'|'t')('Y'|'y');

Conflicts : ('C'|'c')('O'|'o')('N'|'n')('F'|'f')('L'|'l')('I'|'i')('C'|'c')('T'|'t')('S'|'s');

Extension : ('E'|'e')('X'|'x')('T'|'t')('E'|'e')('N'|'n')('S'|'s')('I'|'i')('O'|'o')('N'|'n');

Guarantee : ('G'|'g')('U'|'u')('A'|'a')('R'|'r')('A'|'a')('N'|'n')('T'|'t')('E'|'e')('E'|'e');

Invariant : ('I'|'i')('N'|'n')('V'|'v')('A'|'a')('R'|'r')('I'|'i')('A'|'a')('N'|'n')('T'|'t');

Mitigates : ('M'|'m')('I'|'i')('T'|'t')('I'|'i')('G'|'g')('A'|'a')('T'|'t')('E'|'e')('S'|'s');

Predicate : ('P'|'p')('R'|'r')('E'|'e')('D'|'d')('I'|'i')('C'|'c')('A'|'a')('T'|'t')('E'|'e');

Rationale : ('R'|'r')('A'|'a')('T'|'t')('I'|'i')('O'|'o')('N'|'n')('A'|'a')('L'|'l')('E'|'e');

Riskindex : ('R'|'r')('I'|'i')('S'|'s')('K'|'k')('I'|'i')('N'|'n')('D'|'d')('E'|'e')('X'|'x');

Category : ('C'|'c')('A'|'a')('T'|'t')('E'|'e')('G'|'g')('O'|'o')('R'|'r')('Y'|'y');

Document : ('D'|'d')('O'|'o')('C'|'c')('U'|'u')('M'|'m')('E'|'e')('N'|'n')('T'|'t');

Compute : ('C'|'c')('O'|'o')('M'|'m')('P'|'p')('U'|'u')('T'|'t')('E'|'e');

Default : ('D'|'d')('E'|'e')('F'|'f')('A'|'a')('U'|'u')('L'|'l')('T'|'t');

Extends : ('E'|'e')('X'|'x')('T'|'t')('E'|'e')('N'|'n')('D'|'d')('S'|'s');

Finally : ('F'|'f')('I'|'i')('N'|'n')('A'|'a')('L'|'l')('L'|'l')('Y'|'y');

Include : ('I'|'i')('N'|'n')('C'|'c')('L'|'l')('U'|'u')('D'|'d')('E'|'e');

Refines : ('R'|'r')('E'|'e')('F'|'f')('I'|'i')('N'|'n')('E'|'e')('S'|'s');

Section : ('S'|'s')('E'|'e')('C'|'c')('T'|'t')('I'|'i')('O'|'o')('N'|'n');

Assert : ('A'|'a')('S'|'s')('S'|'s')('E'|'e')('R'|'r')('T'|'t');

Import : ('I'|'i')('M'|'m')('P'|'p')('O'|'o')('R'|'r')('T'|'t');

Issues : ('I'|'i')('S'|'s')('S'|'s')('U'|'u')('E'|'e')('S'|'s');

Output : ('O'|'o')('U'|'u')('T'|'t')('P'|'p')('U'|'u')('T'|'t');

Return : ('R'|'r')('E'|'e')('T'|'t')('U'|'u')('R'|'r')('N'|'n');

Static : ('S'|'s')('T'|'t')('A'|'a')('T'|'t')('I'|'i')('C'|'c');

Switch : ('S'|'s')('W'|'w')('I'|'i')('T'|'t')('C'|'c')('H'|'h');

Typeof : ('T'|'t')('Y'|'y')('P'|'p')('E'|'e')('O'|'o')('F'|'f');

Catch : ('C'|'c')('A'|'a')('T'|'t')('C'|'c')('H'|'h');

False : ('F'|'f')('A'|'a')('L'|'l')('S'|'s')('E'|'e');

Goals : ('G'|'g')('O'|'o')('A'|'a')('L'|'l')('S'|'s');

Input : ('I'|'i')('N'|'n')('P'|'p')('U'|'u')('T'|'t');

Super : ('S'|'s')('U'|'u')('P'|'p')('E'|'e')('R'|'r');

Throw : ('T'|'t')('H'|'h')('R'|'r')('O'|'o')('W'|'w');

Value : ('V'|'v')('A'|'a')('L'|'l')('U'|'u')('E'|'e');

While : ('W'|'w')('H'|'h')('I'|'i')('L'|'l')('E'|'e');

Case : ('C'|'c')('A'|'a')('S'|'s')('E'|'e');

Else : ('E'|'e')('L'|'l')('S'|'s')('E'|'e');

Goal : ('G'|'g')('O'|'o')('A'|'a')('L'|'l');

Null : ('N'|'n')('U'|'u')('L'|'l')('L'|'l');

This : ('T'|'t')('H'|'h')('I'|'i')('S'|'s');

True : ('T'|'t')('R'|'r')('U'|'u')('E'|'e');

With : ('W'|'w')('I'|'i')('T'|'t')('H'|'h');

ExclamationMarkEqualsSignEqualsSign : '!''=''=';

FullStopFullStopLessThanSign : '.''.''<';

EqualsSignEqualsSignEqualsSign : '=''=''=';

All : ('A'|'a')('L'|'l')('L'|'l');

For : ('F'|'f')('O'|'o')('R'|'r');

Img : ('I'|'i')('M'|'m')('G'|'g');

New : ('N'|'n')('E'|'e')('W'|'w');

See : ('S'|'s')('E'|'e')('E'|'e');

Try : ('T'|'t')('R'|'r')('Y'|'y');

Val : ('V'|'v')('A'|'a')('L'|'l');

Var : ('V'|'v')('A'|'a')('R'|'r');

ExclamationMarkEqualsSign : '!''=';

PercentSignEqualsSign : '%''=';

AmpersandAmpersand : '&''&';

AsteriskAsterisk : '*''*';

AsteriskEqualsSign : '*''=';

PlusSignPlusSign : '+''+';

PlusSignEqualsSign : '+''=';

HyphenMinusHyphenMinus : '-''-';

HyphenMinusEqualsSign : '-''=';

HyphenMinusGreaterThanSign : '-''>';

FullStopFullStop : '.''.';

SolidusEqualsSign : '/''=';

ColonColon : ':'':';

LessThanSignGreaterThanSign : '<''>';

EqualsSignEqualsSign : '=''=';

EqualsSignGreaterThanSign : '=''>';

GreaterThanSignEqualsSign : '>''=';

QuestionMarkFullStop : '?''.';

QuestionMarkColon : '?'':';

As : ('A'|'a')('S'|'s');

Do : ('D'|'d')('O'|'o');

If : ('I'|'i')('F'|'f');

VerticalLineVerticalLine : '|''|';

ExclamationMark : '!';

NumberSign : '#';

PercentSign : '%';

Ampersand : '&';

LeftParenthesis : '(';

RightParenthesis : ')';

Asterisk : '*';

PlusSign : '+';

Comma : ',';

HyphenMinus : '-';

FullStop : '.';

Solidus : '/';

Colon : ':';

Semicolon : ';';

LessThanSign : '<';

EqualsSign : '=';

GreaterThanSign : '>';

QuestionMark : '?';

CommercialAt : '@';

LeftSquareBracket : '[';

RightSquareBracket : ']';

LeftCurlyBracket : '{';

VerticalLine : '|';

RightCurlyBracket : '}';



RULE_HEX : ('0x'|'0X') ('0'..'9'|'a'..'f'|'A'..'F'|'_')+ ('#' (('b'|'B') ('i'|'I')|('l'|'L')))?;

RULE_INT : '0'..'9' ('0'..'9'|'_')*;

RULE_DECIMAL : RULE_INT (('e'|'E') ('+'|'-')? RULE_INT)? (('b'|'B') ('i'|'I'|'d'|'D')|('l'|'L'|'d'|'D'|'f'|'F'))?;

RULE_ID : '^'? ('a'..'z'|'A'..'Z'|'$'|'_') ('a'..'z'|'A'..'Z'|'$'|'_'|'0'..'9')*;

RULE_STRING : ('"' ('\\' .|~(('\\'|'"')))* '"'?|'\'' ('\\' .|~(('\\'|'\'')))* '\''?);

RULE_ML_COMMENT : '/*' ( options {greedy=false;} : . )*'*/';

RULE_SL_COMMENT : '//' ~(('\n'|'\r'))* ('\r'? '\n')?;

RULE_WS : (' '|'\t'|'\r'|'\n')+;

RULE_ANY_OTHER : .;



