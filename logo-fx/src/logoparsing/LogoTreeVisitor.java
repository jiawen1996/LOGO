package logoparsing;

import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeProperty;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import logoparsing.LogoParser.AvContext;
import logoparsing.LogoParser.BaisseCrayonContext;
import logoparsing.LogoParser.CouleurContext;
import logoparsing.LogoParser.FixeCapContext;
import logoparsing.LogoParser.FloatContext;
import logoparsing.LogoParser.LeveCrayonContext;
import logoparsing.LogoParser.ParentheseContext;
import logoparsing.LogoParser.ReContext;
import logoparsing.LogoParser.TdContext;
import logoparsing.LogoParser.TgContext;

public class LogoTreeVisitor extends LogoBaseVisitor<Integer> {
	Traceur traceur;
	StringProperty log = new SimpleStringProperty();

	public LogoTreeVisitor() {
		traceur = new Traceur();
	}

	public StringProperty logProperty() {
		return log;
	}

	public Traceur getTraceur() {
		return traceur;
	}

	/*
	 * Map des attributs associés à chaque noeud de l'arbre key = node, value =
	 * valeur de l'expression du node
	 */
	ParseTreeProperty<Double> atts = new ParseTreeProperty<Double>();

	public void setValue(ParseTree node, double value) {
		atts.put(node, value);
	}

	public double getValue(ParseTree node) {
		Double value = atts.get(node);
		if (value == null) {
			throw new NullPointerException();
		}
		return value;
	}

// Instructions de base	

	@Override
	public Integer visitTd(TdContext ctx) {
		Binome<Double> bilan = evaluate(ctx.expr());
		if (bilan._1 == 0) {
			traceur.td(bilan._2);
			log.setValue("Tourner à droite de  " + bilan._2);
			log.setValue("\n");
		}
		return 0;
	}

	@Override
	public Integer visitAv(AvContext ctx) {
		Binome<Double> bilan = evaluate(ctx.expr());
		if (bilan._1 == 0) {
			traceur.avance(bilan._2);
			log.setValue("Avance de  " + bilan._2);
			log.setValue("\n");
		}
		return bilan._1;
	}

	@Override
	public Integer visitRe(ReContext ctx) {
		Binome<Double> bilan = evaluate(ctx.expr());
		if (bilan._1 == 0) {
			traceur.recule(bilan._2);
			log.setValue("Recule de  " + bilan._2);
			log.setValue("\n");
		}
		return bilan._1;
	}

	@Override
	public Integer visitTg(TgContext ctx) {
		Binome<Double> bilan = evaluate(ctx.expr());
		if (bilan._1 == 0) {
			traceur.tg(bilan._2);
			log.setValue("Trouner à gauche de  " + bilan._2);
			log.setValue("\n");
		}
		return 0;
	}

// Expressions

	@Override
	public Integer visitParenthese(ParentheseContext ctx) {
		Binome<Double> bilan = evaluate(ctx.expr());
		if (bilan._1 == 0) {
			setValue(ctx, bilan._2);
		}
		return bilan._1;
	}

	@Override
	public Integer visitFloat(FloatContext ctx) {
		String floatText = ctx.FLOAT().getText();
		setValue(ctx, Double.valueOf(floatText));
		return 0;
	}

	private Binome<Double> evaluate(ParseTree expr) {
		Binome<Double> res = new Binome<>();
		// 访问表达式结点
		res._1 = visit(expr);
		res._2 = res.isValid() ? getValue(expr) : Double.POSITIVE_INFINITY;
		return res;
	}

	private class Binome<T> {
		// 一个查看是否符合标准的
		public Integer _1;
		public T _2;

		public boolean isValid() {
			return _1 == 0;
		}
	}

	@Override
	public Integer visitCouleur(CouleurContext ctx) {
		// TODO Auto-generated method stub
		return super.visitCouleur(ctx);
	}

	@Override
	public Integer visitFixeCap(FixeCapContext ctx) {
		// TODO Auto-generated method stub
		return super.visitFixeCap(ctx);
	}

	@Override
	public Integer visitLeveCrayon(LeveCrayonContext ctx) {
		// TODO Auto-generated method stub
		return super.visitLeveCrayon(ctx);
	}

	@Override
	public Integer visitBaisseCrayon(BaisseCrayonContext ctx) {
		// TODO Auto-generated method stub
		return super.visitBaisseCrayon(ctx);
	}

}
