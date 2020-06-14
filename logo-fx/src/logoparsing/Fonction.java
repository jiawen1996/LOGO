package logoparsing;

public class Fonction {
    private String nomFonction;
    private TableSymboles tableSymbLocale;
    private LogoParser.Liste_instructionsContext listeInstructions;
    private LogoParser.ExprContext result;

    public Fonction(String n, TableSymboles t, LogoParser.Liste_instructionsContext l) {
        this.nomFonction = n;
        this.tableSymbLocale = t;
        this.listeInstructions = l;
    }

    public String getNomFonction() {
        return nomFonction;
    }

    public void setNomFonction(String nomFonction) {
        this.nomFonction = nomFonction;
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

    public LogoParser.ExprContext getResult() {
        return result;
    }

    public void setResult(LogoParser.ExprContext result) {
        this.result = result;
    }
}
