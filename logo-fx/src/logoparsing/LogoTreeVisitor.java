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
import logoparsing.LogoParser.HasardContext;
import logoparsing.LogoParser.LeveCrayonContext;
import logoparsing.LogoParser.MultContext;
import logoparsing.LogoParser.ParentheseContext;
import logoparsing.LogoParser.ReContext;
import logoparsing.LogoParser.SumContext;
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
	
	public void setExprValue(ParseTree node, double value) {
		atts.put(node, value);
	}

	public double getValue(ParseTree node) {
		Double value = atts.get(node);
		if (value == null) {
			throw new NullPointerException();
		}
		return value;
	}

	public Double getExprValue(ParseTree node) {
		Double value = atts.get(node);
		if (value == null) {
			throw new NullPointerException();
		}
		return value;
	}

// Instructions de base	

	@Override
	public Integer visitTd(TdContext ctx) {
		Binome bilan = evaluate(ctx.expr());
		if (bilan._1 == 0) {
			traceur.td(bilan._2);
			log.setValue("Tourner à droite de  " + bilan._2);
			log.setValue("\n");
		}
		return 0;
	}

	@Override
	public Integer visitAv(AvContext ctx) {
		Binome bilan = evaluate(ctx.expr());
		if (bilan._1 == 0) {
			traceur.avance(bilan._2);
			log.setValue("Avance de  " + bilan._2);
			log.setValue("\n");
		}
		return bilan._1;
	}

	@Override
	public Integer visitRe(ReContext ctx) {
		Binome bilan = evaluate(ctx.expr());
		if (bilan._1 == 0) {
			traceur.recule(bilan._2);
			log.setValue("Recule de  " + bilan._2);
			log.setValue("\n");
		}
		return bilan._1;
	}

	@Override
	public Integer visitTg(TgContext ctx) {
		Binome bilan = evaluate(ctx.expr());
		if (bilan._1 == 0) {
			traceur.tg(bilan._2);
			log.setValue("Trouner à gauche de  " + bilan._2);
			log.setValue("\n");
		}
		return bilan._1;
	}

	@Override
	public Integer visitCouleur(CouleurContext ctx) {
		Binome bilan = evaluate(ctx.expr());
		if (bilan._1 == 0) {
			traceur.changeColeur(bilan._2);
			log.setValue("Change couleur  " + bilan._2);
			log.setValue("\n");
		}
		return bilan._1;
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

// Expressions

	@Override
	public Integer visitParenthese(ParentheseContext ctx) {
		Binome bilan = evaluate(ctx.expr());
		if (bilan._1 == 0) {
			setExprValue(ctx, bilan._2);
		}
		return bilan._1;
	}

	@Override
	public Integer visitFloat(FloatContext ctx) {
		String floatText = ctx.FLOAT().getText();
		setExprValue(ctx, Float.parseFloat(floatText));
		return 0;
	}

	private Binome evaluate(ParseTree expr) {
		Binome res = new Binome();
		res._1 = visit(expr);
		res._2 = res._1 == 0 ?
		getExprValue(expr) : Double.POSITIVE_INFINITY; return res;
	}

	private class Binome {
		public Integer _1;
		public Double _2;

		public boolean isValid() {
			return _1 == 0;
		}
	}

	@Override
	public Integer visitSum(SumContext ctx) {
		Binome left, right;
		try {
			left = evaluate(ctx.expr(0));
			right = evaluate(ctx.expr(1));
			if (left._1 == 0 && right._1 == 0) {
				Double r = ctx.getChild(1).getText().equals("+") ? left._2 + right._2 : left._2 - right._2;
				setExprValue(ctx, r);
			} else
				return left._1 == 0 ? right._1 : left._1;
		} catch (NullPointerException ex) {
			ex.printStackTrace();
		}
		return 0;

	}

	@Override
	public Integer visitMult(MultContext ctx) {
		Binome left, right;
		try {
			left = evaluate(ctx.expr(0));
			right = evaluate(ctx.expr(1));
			if (left._1 == 0 && right._1 == 0) {
				Double r = ctx.getChild(1).getText().equals("*") ? left._2 * right._2 : left._2 / right._2;
				setExprValue(ctx, r);
			} else
				return left._1 == 0 ? right._1 : left._1;
		} catch (NullPointerException ex) {
			ex.printStackTrace();
		}
		return 0;
	}

	@Override
	// retourner une double entre 1 et un resultat de l'expression
	public Integer visitHasard(HasardContext ctx) {
		Binome bilan = evaluate(ctx.expr());
		try {
			if (bilan._1 == 0) {
				Double r = Math.ceil((1+Math.random()*(bilan._2 - 1 + 1)));
				setExprValue(ctx, r);
				
			} else {
				return bilan._1;
			}
		} catch (NullPointerException ex) {
			ex.printStackTrace();
		}
		return 0;
	}

}
