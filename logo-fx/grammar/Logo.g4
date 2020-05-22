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

bloc :
	'[' liste_instructions ']' # crochet
;

instruction :
	'repete' expr bloc # repete
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
 | 'donne' var expr # affecter
 | '<'
; 

var:
	'"'VAR # declare
 |	':'VAR # appelle
;

expr:
	expr ('*' | '/' ) expr # mult
 |  expr ('+' | '-' ) expr # sum
 |	'hasard' (expr) # hasard
 |	'cos' '(' expr ')' # cos	
 |	'sin' '(' expr ')' # sin	
 |  FLOAT # float
 |	'loop' # loop
 | '(' expr ')' # parenthese
;





