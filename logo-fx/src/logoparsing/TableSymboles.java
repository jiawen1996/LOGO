package logoparsing;

import java.util.HashMap;
import java.util.Map;

public class TableSymboles {
	private Map<String, Double> tableSym;
	
	public TableSymboles() {
		this.tableSym = new HashMap<String, Double>();
	}
	
	public void creerVar(String nomVar, Double valeur) {
		tableSym.put(nomVar, valeur);
	}
	
	public Double getValeur(String nomVar) {
		return tableSym.get(nomVar);
	}
}
