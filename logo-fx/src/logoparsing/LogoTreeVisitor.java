package logoparsing;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;

import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeProperty;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import logoparsing.LogoParser.AffecterContext;
import logoparsing.LogoParser.AppelleContext;
import logoparsing.LogoParser.AvContext;
import logoparsing.LogoParser.BaisseCrayonContext;
import logoparsing.LogoParser.BlocContext;
import logoparsing.LogoParser.BooleenContext;
import logoparsing.LogoParser.CosContext;
import logoparsing.LogoParser.CouleurContext;
import logoparsing.LogoParser.CrochetContext;
import logoparsing.LogoParser.DeclareContext;
import logoparsing.LogoParser.FixeCapContext;
import logoparsing.LogoParser.FixeXYContext;
import logoparsing.LogoParser.FloatContext;
import logoparsing.LogoParser.HasardContext;
import logoparsing.LogoParser.LeveCrayonContext;
import logoparsing.LogoParser.Liste_instructionsContext;
import logoparsing.LogoParser.LoopContext;
import logoparsing.LogoParser.MoveContext;
import logoparsing.LogoParser.MultContext;
import logoparsing.LogoParser.ParentheseContext;
import logoparsing.LogoParser.ReContext;
import logoparsing.LogoParser.RepeteContext;
import logoparsing.LogoParser.SiContext;
import logoparsing.LogoParser.SinContext;
import logoparsing.LogoParser.StoreContext;
import logoparsing.LogoParser.SumContext;
import logoparsing.LogoParser.TantqueContext;
import logoparsing.LogoParser.TdContext;
import logoparsing.LogoParser.TgContext;

public class LogoTreeVisitor extends LogoBaseVisitor<Integer> {
	Traceur traceur;
	StringProperty log = new SimpleStringProperty();
	TableSymboles tableSymb;

	// 用来保留两位小数
	DecimalFormat df = new DecimalFormat("#.00");

	public LogoTreeVisitor() {
		this.traceur = new Traceur();
		this.tableSymb = new TableSymboles();
	}

	public StringProperty logProperty() {
		return log;
	}

	public Traceur getTraceur() {
		return traceur;
	}

	// 得到解析代表表达式的子树的结果
	private Binome evaluateExpr(ParseTree expr) {
		Binome res = new Binome();

		// 访问该节点下面的所有expr结点
		res._1 = visit(expr);
		res._2 = res._1 == 0 ? getExprValue(expr) : Double.POSITIVE_INFINITY;
		return res;
	}

	private Binome evaluateBooleen(ParseTree booleen) {
		Binome res = new Binome();

		// 访问该节点下面的所有expr结点
		res._1 = visit(booleen);
		res._2 = res._1 == 0 ? getExprValue(booleen) : Double.POSITIVE_INFINITY;
		return res;
	}

	// 得到解析代表循环的子树的结果
	private Binome evaluateBloc(ParseTree bloc) {
		Binome res = new Binome();
		// 开始访问bloc子树
		res._1 = visit(bloc);
		// 在这里不用存值
		res._2 = res._1 == 0 ? getExprValue(bloc) : -1;
		return res;
	}

	private Binome evaluateLoop(ParseTree loop) {
		Binome res = new Binome();
		// 开始访问bloc子树
		ParseTree parentBloc = loop.getParent();
		while (!(parentBloc instanceof BlocContext)) {
			parentBloc = parentBloc.getParent();
		}

		if (parentBloc instanceof RepeteContext) {
			res._1 = -2;
		} else {
			res._1 = 0;
		}
		res._2 = res._1 == 0 ? getExprValue(parentBloc) : -1;
		return res;
	}

	private class Binome {
		public Binome() {
			this._1 = null;
			this._2 = (double) 0;
		}

		// 返回这一步操作是否成功
		// L'information qui indique si l'éxecution réussit

		public Integer _1;

		// stocker le résultat du calcul
		public Double _2;
	}

	/*
	 * Map des attributs associés à chaque noeud de l'arbre key = node, value =
	 * valeur de l'expression du node
	 */
	// C'est un map pour stocker des values de calcul courant
	// 存储这一步计算结果的map
	ParseTreeProperty<Double> atts = new ParseTreeProperty<Double>();

	public void setExprValue(ParseTree node, double value) {
		atts.put(node, value);
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
		Binome bilan = evaluateExpr(ctx.expr());
		if (bilan._1 == 0) {
			traceur.td(bilan._2);
			log.setValue("Tourner à droite de  " + bilan._2);
			log.setValue("\n");
		}
		return 0;
	}

	@Override
	public Integer visitAv(AvContext ctx) {
		Binome bilan = evaluateExpr(ctx.expr());
		if (bilan._1 == 0) {
			traceur.avance(bilan._2);
			log.setValue("Avance de  " + bilan._2);
			log.setValue("\n");
		}
		return bilan._1;
	}

	@Override
	public Integer visitRe(ReContext ctx) {
		if (traceur.isMoveable()) {
			Binome bilan = evaluateExpr(ctx.expr());
			if (bilan._1 == 0) {
				traceur.recule(bilan._2);
				log.setValue("Recule de  " + bilan._2);
				log.setValue("\n");
			}
			return bilan._1;

		} else {
			log.setValue("I can't move");
			log.setValue("\n");
			return -1;
		}
	}

	@Override
	public Integer visitTg(TgContext ctx) {
		if (traceur.isMoveable()) {
			Binome bilan = evaluateExpr(ctx.expr());
			if (bilan._1 == 0) {
				traceur.tg(bilan._2);
				log.setValue("Trouner à gauche de  " + bilan._2);
				log.setValue("\n");
			}
			return bilan._1;
		} else
			return -1;

	}

	@Override
	public Integer visitCouleur(CouleurContext ctx) {
		if (!traceur.isMoveable()) {
			Binome bilan = evaluateExpr(ctx.expr());
			if (bilan._1 == 0) {
				traceur.changeColeur(bilan._2);
				log.setValue("Change couleur  " + logogui.Color.values()[bilan._2.intValue()].toString());
				log.setValue("\n");
			}
			return bilan._1;
		} else {
			return -1;
		}

	}

	@Override
	public Integer visitFixeCap(FixeCapContext ctx) {
		Binome bilan = evaluateExpr(ctx.expr());
		if (bilan._1 == 0) {
			traceur.fixeCap(bilan._2);
			log.setValue("Fixer l'angle:  " + bilan._2);
			log.setValue("\n");
		}
		return bilan._1;
	}

	@Override
	public Integer visitLeveCrayon(LeveCrayonContext ctx) {
		traceur.setMoveable(false);
		return 0;
	}

	@Override
	public Integer visitBaisseCrayon(BaisseCrayonContext ctx) {
		traceur.setMoveable(true);
		return 0;
	}

	// Expressions

	@Override
	public Integer visitParenthese(ParentheseContext ctx) {
		Binome bilan = evaluateExpr(ctx.expr());
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

	// Fonctions de TD3

	@Override
	public Integer visitSum(SumContext ctx) {
		Binome left, right;
		try {
			left = evaluateExpr(ctx.expr(0));
			right = evaluateExpr(ctx.expr(1));
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
			left = evaluateExpr(ctx.expr(0));
			right = evaluateExpr(ctx.expr(1));
			if (left._1 == 0 && right._1 == 0) {
				if (ctx.getChild(1).getText().equals("/") || right._2 < 0.000001) {
					return right._1 = -1;
				}
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
		Binome bilan = evaluateExpr(ctx.expr());
		try {
			if (bilan._1 == 0) {
				Double r = Math.ceil((1 + Math.random() * (bilan._2 - 1 + 1)));
				setExprValue(ctx, r);

			} else {
				return bilan._1;
			}
		} catch (NullPointerException ex) {
			ex.printStackTrace();
		}
		return 0;
	}

	@Override
	public Integer visitCos(CosContext ctx) {
		Binome bilan = evaluateExpr(ctx.expr());
		try {
			if (bilan._1 == 0) {
				Double r = Double.parseDouble(df.format(Math.cos(Math.toRadians(bilan._2))));
				setExprValue(ctx, r);

			} else {
				return bilan._1;
			}
		} catch (NullPointerException ex) {
			ex.printStackTrace();
		}
		return 0;
	}

	@Override
	public Integer visitSin(SinContext ctx) {
		Binome bilan = evaluateExpr(ctx.expr());
		try {
			if (bilan._1 == 0) {
				Double r = Double.parseDouble(df.format(Math.sin(Math.toRadians(bilan._2))));
				setExprValue(ctx, r);

			} else {
				return bilan._1;
			}
		} catch (NullPointerException ex) {
			ex.printStackTrace();
		}
		return 0;
	}

	@Override
	public Integer visitRepete(RepeteContext ctx) {
		int compteur = 0;
		Binome expr = evaluateExpr(ctx.expr());
		Binome bloc = new Binome();
		try {
			if (expr._1 == 0) {
				compteur = (int) Math.round(expr._2);
				for (int i = 1; i < compteur + 1; i++) {
					setExprValue(ctx.bloc(), i);
					bloc = evaluateBloc(ctx.bloc());
				}
			} else {
				return expr._1 == 0 ? bloc._1 : expr._1;
			}

		} catch (NullPointerException ex) {
			ex.printStackTrace();
		}
		return 0;
	}

	@Override
	public Integer visitLoop(LoopContext ctx) {
		Binome bilan = evaluateLoop(ctx);
		setExprValue(ctx, bilan._2);
		return 0;
	}

	@Override
	public Integer visitCrochet(CrochetContext ctx) {
		Binome bilan = new Binome();
		// 访问代表循环的子树
		bilan._1 = visit(ctx.liste_instructions());
		return bilan._1;
	}

	@Override
	public Integer visitFixeXY(FixeXYContext ctx) {
		Binome x = evaluateExpr(ctx.expr(0));
		Binome y = evaluateExpr(ctx.expr(1));
		if (x._1 == 0 && y._1 == 0) {
			traceur.fixXY(x._2, y._2);
			log.setValue("Place la tortue à la position ( " + x._2 + ", " + y._2 + " )");
			log.setValue("\n");
		}
		return 0;
	}

	@Override
	public Integer visitStore(StoreContext ctx) {
		traceur.storePosition();
		log.setValue("Bien stocker la position ( " + traceur.getPosx() + ", " + traceur.getPosy() + traceur.getAngle()
				+ " )");
		log.setValue("\n");
		return 0;
	}

	@Override
	public Integer visitMove(MoveContext ctx) {
		int res = traceur.movePosition();
		if (res == 0) {
			log.setValue("Déplacer à la position ( " + traceur.getPosx() + ", " + traceur.getPosy() + traceur.getAngle()
					+ " )");
			log.setValue("\n");
		}
		return res;

	}

	@Override
	public Integer visitAffecter(AffecterContext ctx) {
		Binome var = new Binome();

		// 访问var下的子结点，并返回是否执行成功
		var._1 = visit(ctx.expr(0));
		Binome value = evaluateExpr(ctx.expr(1));
		if (var._1 == 0 && value._1 == 0) {
			String nomVar = ctx.expr(0).getText().substring(1);
			tableSymb.creerVar(nomVar, value._2);
			log.setValue("Bien affecter la variable " + nomVar + " avec " + value._2);
			log.setValue("\n");

		}
		return 0;
	}

	@Override
	public Integer visitDeclare(DeclareContext ctx) {
		String varText = ctx.VAR().getText();
		if (!tableSymb.containsKey(varText)) {
			tableSymb.creerVar(varText, null);
		}
		return 0;
	}

	@Override
	public Integer visitAppelle(AppelleContext ctx) {
		String varText = ctx.VAR().getText();
		setExprValue(ctx, tableSymb.getValeur(varText));
		return 0;
	}

	@Override
	public Integer visitBooleen(BooleenContext ctx) {
		Binome left, right;
		try {
			left = evaluateExpr(ctx.expr(0));
			right = evaluateExpr(ctx.expr(1));
			if (left._1 == 0 && right._1 == 0) {
				Integer r = null;
				if (ctx.getChild(1).getText().equals(">")) {
					r = left._2 > right._2 ? 1 : 0;
				} else {
					r = left._2 < right._2 ? 1 : 0;
				}
				setExprValue(ctx, (double) r);
			} else
				return left._1 == 0 ? right._1 : left._1;
		} catch (NullPointerException ex) {
			ex.printStackTrace();
		}
		return 0;
	}

	@Override
	public Integer visitSi(SiContext ctx) {
		Binome condition = evaluateBooleen(ctx.condition());
		Binome bloc = new Binome();
		if (condition._1 == 0) {
			bloc = condition._2 == 1 ? evaluateBloc(ctx.bloc(0)) : evaluateBloc(ctx.bloc(1));
		}
		return bloc._1;
	}

	@Override
	public Integer visitTantque(TantqueContext ctx) {
		Binome condition = evaluateBooleen(ctx.condition());
		Binome bloc = new Binome();
		while (condition._1 == 0 && condition._2 == 1) {
			setExprValue(ctx.bloc(), condition._2);
			bloc = evaluateBloc(ctx.bloc());
			condition = evaluateBooleen(ctx.condition());
		}
		return bloc._1;
	}

	@Override
	public Integer visitListe_instructions(Liste_instructionsContext ctx) {
		// TODO Auto-generated method stub
		return super.visitListe_instructions(ctx);
	}

}
