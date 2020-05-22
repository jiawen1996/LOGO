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
import java.util.Stack;

import logogui.GraphParameter;

public class Traceur {
	private Color couleur;
	private double initx = 450, inity = 150; // position initiale
	private double posx = initx, posy = inity; // position courante
	private double angle = 90;
	private double teta;
	private boolean moveable;
	ObjectProperty<GraphParameter> line;
	private Stack<Double[]> positionStack;

	public Traceur() {
		setTeta();
		line = new SimpleObjectProperty<GraphParameter>();
		this.moveable = false;
		this.positionStack = new Stack<Double[]>();
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
		logogui.Color colorRGB = logogui.Color.getColor((int) r);
		couleur = javafx.scene.paint.Color.rgb(colorRGB.getR(), colorRGB.getG(), colorRGB.getB());
		couleur.invert();
	}

	public void fixXY(double x, double y) {
		posx = x;
		posy = y;
	}

	public boolean isMoveable() {
		return moveable;
	}

	public void setMoveable(boolean canMove) {
		this.moveable = canMove;
	}

	public void movePosition() {
		if (!positionStack.empty()) {
			Double[] destnation = positionStack.pop();
			setPosition(destnation);

		} else {
			return;
		}

	}

	public void setPosition(Double[] p) {
		this.posx = p[0];
		this.posy = p[1];
		this.angle = p[2];
	}

	public void storePosition() {
		Double[] p = { posx, posy, angle };
		positionStack.push(p);
	}

	public double getPosx() {
		return posx;
	}

	public double getPosy() {
		return posy;
	}

	public double getAngle() {
		return angle;
	}

}
