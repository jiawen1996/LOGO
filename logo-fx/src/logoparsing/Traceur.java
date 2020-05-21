/*
  * Created on 12 may. 2018
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package logoparsing;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.scene.paint.Color;
import java.util.HashMap;
import logogui.GraphParameter;

public class Traceur {
	private Color couleur;
	private double initx = 350, inity = 350; // position initiale
	private double posx = initx, posy = inity; // position courante
	private double angle = 90;
	private double teta;
	HashMap<Integer, int[]> couleurList = new HashMap<Integer, int[]>();
	ObjectProperty<GraphParameter> line;

	public Traceur() {
		setTeta();
		line = new SimpleObjectProperty<GraphParameter>();
		this.couleurList.put(0, new int[] {0,0,0});
	}

	ObjectProperty<GraphParameter> lineProperty() {
		return line;
	}

	private void setTeta() {
		teta = Math.toRadians(angle);
	}

	private void addLine(double x1, double y1, double x2, double y2) {
		line.setValue(new GraphParameter(x1, y1, x2, y2, couleur));
	}

	public void avance(double r) {
		double a = posx + r * Math.cos(teta);
		double b = posy - r * Math.sin(teta);
		addLine(posx, posy, a, b);

		posx = a;
		posy = b;
	}

	public void recule(double r) {
		double a = posx - r * Math.cos(teta);
		double b = posy + r * Math.sin(teta);
		addLine(posx, posy, a, b);

		posx = a;
		posy = b;
	}

	public void td(double r) {
		angle = (angle - r) % 360;
		setTeta();
	}
	
	public void tg(double r) {
		angle = (angle + r) % 360;
		setTeta();
	}

	public void changeColeur(double r) {
		
		couleur = Color.rgb(255,0,0);
		couleur.invert();
	}
	
	public void fixXY(double x, double y) {
		posx = x;
		posy = y;
	}

}
