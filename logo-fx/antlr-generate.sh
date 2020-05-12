export SAVECLASSPATH=$CLASSPATH
export CLASSPATH=lib/antlr-4.7.2-complete.jar
java org.antlr.v4.Tool -visitor -o src/logoparsing /Users/haida/Projects/nf11_tp2/logo-fx/grammar/Logo.g4
export CLASSPATH=$SAVECLASSPATH
