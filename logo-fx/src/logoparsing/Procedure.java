package logoparsing;

import java.util.ArrayList;
import java.util.List;

public class Procedure {
    private String nomProcedure;
    private TableSymboles tableSymbLocale;
    private LogoParser.Liste_instructionsContext listeInstructions;

    public Procedure(String n, TableSymboles t, LogoParser.Liste_instructionsContext l) {
        this.nomProcedure = n;
        this.tableSymbLocale = t;
        this.listeInstructions = l;
    }

    public String getNomProcedure() {
        return nomProcedure;
    }

    public void setNomProcedure(String nomProcedure) {
        this.nomProcedure = nomProcedure;
    }

    public TableSymboles getTableSymbLocale() {
        return tableSymbLocale;
    }

    public void setTableSymbLocale(TableSymboles tableSymbLocale) {
        this.tableSymbLocale = tableSymbLocale;
    }

    public LogoParser.Liste_instructionsContext getListeInstructions() {
        return listeInstructions;
    }

    public void setListeInstructions(LogoParser.Liste_instructionsContext listeInstructions) {
        this.listeInstructions = listeInstructions;
    }

}
