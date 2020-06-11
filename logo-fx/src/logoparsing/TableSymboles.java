package logoparsing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TableSymboles {
    private Map<String, Double> tableSym;
    private List<String> listeNomsParams;

    public TableSymboles() {
        this.listeNomsParams = new ArrayList<>();
        this.tableSym = new HashMap<String, Double>();
    }

    public List<String> getListeNomsParams() {
        return listeNomsParams;
    }

    public void setListeNomsParams(List<String> listeNomsParams) {
        this.listeNomsParams = listeNomsParams;
    }

    public void addNomParam(String n) {
        listeNomsParams.add(n);
    }

    public Boolean containsKey(String nomVar) {
        return tableSym.containsKey(nomVar);
    }

    public void creerVar(String nomVar, Double valeur) {
        tableSym.put(nomVar, valeur);
    }

    public Double getValeur(String nomVar) {
        return tableSym.get(nomVar);
    }
}
