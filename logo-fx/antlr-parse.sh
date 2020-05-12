export SAVECLASSPATH=$CLASSPATH
export CLASSPATH=/Users/haida/Projects/nf11_tp2/logo-fx/lib/antlr-4.7.2-complete.jar
echo $CLASSPATH
java org.antlr.v4.gui.TestRig logoparsing.Logo programme -gui programs/logo-prg.txt
export CLASSPATH=$SAVECLASSPATH
