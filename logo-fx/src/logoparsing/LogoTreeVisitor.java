package logoparsing;

import java.text.DecimalFormat;

import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeProperty;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import logoparsing.LogoParser.AvContext;
import logoparsing.LogoParser.BaisseCrayonContext;
import logoparsing.LogoParser.CosContext;
import logoparsing.LogoParser.CouleurContext;
import logoparsing.LogoParser.CrochetContext;
import logoparsing.LogoParser.FixeCapContext;
import logoparsing.LogoParser.FixeXYContext;
import logoparsing.LogoParser.FloatContext;
import logoparsing.LogoParser.HasardContext;
import logoparsing.LogoParser.LeveCrayonContext;
import logoparsing.LogoParser.LoopContext;
import logoparsing.LogoParser.MultContext;
import logoparsing.LogoParser.ParentheseContext;
import logoparsing.LogoParser.ReContext;
import logoparsing.LogoParser.RepeteContext;
import logoparsing.LogoParser.SinContext;
import logoparsing.LogoParser.SumContext;
import logoparsing.LogoParser.TdContext;
import logoparsing.LogoParser.TgContext;

public class LogoTreeVisitor extends LogoBaseVisitor<Integer> {
	Traceur traceur;
	StringProperty log = new SimpleStringProperty();
	
	//用来保留两位小数
	DecimalFormat df = new DecimalFormat("#.00");
	
	public LogoTreeVisitor() {
		traceur = new Traceur();
	}

	public StringProperty logProperty() {
		return log;
	}

	public Traceur getTraceur() {
		return traceur;
	}
	
	//得到解析代表表达式的子树的结果
	private Binome evaluateExpr(ParseTree expr) {
		Binome res = new Binome();
		
		//访问该节点下面的所有expr结点
		res._1 = visit(expr);
		res._2 = res._1 == 0 ?
		getExprValue(expr) : Double.POSITIVE_INFINITY; 
		return res;
	}
	
	//得到解析代表循环的子树的结果
	private Binome evaluateBloc(ParseTree bloc) {
		Binome res = new Binome();
		//开始访问bloc子树
		res._1 = visit(bloc);
		//在这里不用存值
//		res._2 = res._1 == 0 ? ;
		return res;
	}

	private class Binome {
		public Binome() {
			this._1 = null;
			this._2 = (double)0;
		}
		
		//返回这一步操作是否成功
		//L'information qui indique si l'éxecution réussit
		
		public Integer _1;
		
		//stocker le résultat du calcul
		public Double _2;

		public boolean isValid() {
			return _1 == 0;
		}
	}

	/*
	 * Map des attributs associés à chaque noeud de l'arbre key = node, value =
	 * valeur de l'expression du node
	 */
	//C'est un map pour stocker des values de calcul courant
	//存储这一步计算结果的map
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
		Binome bilan = evaluateExpr(ctx.expr());
		if (bilan._1 == 0) {
			traceur.recule(bilan._2);
			log.setValue("Recule de  " + bilan._2);
			log.setValue("\n");
		}
		return bilan._1;
	}

	@Override
	public Integer visitTg(TgContext ctx) {
		Binome bilan = evaluateExpr(ctx.expr());
		if (bilan._1 == 0) {
			traceur.tg(bilan._2);
			log.setValue("Trouner à gauche de  " + bilan._2);
			log.setValue("\n");
		}
		return bilan._1;
	}

	@Override
	public Integer visitCouleur(CouleurContext ctx) {
		Binome bilan = evaluateExpr(ctx.expr());
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


	
	//Fonctions de TD3

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
				if(ctx.getChild(1).getText().equals("/") || right._2 < 0.000001) {
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
		Binome bloc = new Binome() ;
		try {
			if (expr._1 == 0) {
				compteur = (int) Math.round(expr._2) ;
				for(int i = 0; i < compteur; i++) {
					bloc = evaluateBloc(ctx.bloc());
					System.out.println("LogoTreeVisitor.visitRepete()" + bloc._2);
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
	public Integer visitCrochet(CrochetContext ctx) {
		Binome bilan = new Binome();
		//访问代表循环的子树
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

//	@Override
//	public Integer visitLoop(LoopContext ctx) {
//		
//	}

}
