grammar Logo ; 

@header {		
  package logoparsing;
}

FLOAT : [0-9][0-9]*('.'[0-9]+)? ;
VAR : [a-zA-Z][a-zA-Z]* ;
WS : [ \t\r\n]+ -> skip ;
COMMENT1 : '//' .*? [\r\n]+ -> skip;
COMMENT2 : '/*' .*? '*/' -> skip;

programme :
 liste_instructions  
;

liste_instructions :   
 (instruction)+    
;

instruction :
	'repete' expr '[' liste_instructions ']' # repete
 |  'av' expr # av
 | 're' expr # re
 | 'td' expr # td 
 | 'tg' expr # tg
 | 'fcc' expr # couleur
 | 'fcap' expr # fixeCap
 | 'lc' # leveCrayon
 | 'bc' # baisseCrayon
 | 'fpos' '[' expr ',' expr ']' # fixeXY
 | 'store' # store
 | 'move' # move
 | 'donne' '"' VAR expr # affecter
 | 'si' expr '[' liste_instructions ']' ('[' liste_instructions ']')? # si
 | 'tantque' expr '[' liste_instructions ']' # tantque
;


expr:
	expr ('*' | '/' ) expr # mult
 |  expr ('+' | '-' ) expr # sum
 |  expr ('>' | '<' | '<=' | '>=' | '!=' | '==') expr # booleen
 |	'hasard' (expr) # hasard
 |	'cos' '(' expr ')' # cos
 |	'sin' '(' expr ')' # sin
 |  FLOAT # float
 |	'loop' # loop
 |	':'VAR # appelle
 | '(' expr ')' # parenthese
;





