// Generated from /Users/haida/Projects/nf11_tp2/logo-fx/grammar/Logo.g4 by ANTLR 4.7.2
		
  package logoparsing;

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link LogoParser}.
 */
public interface LogoListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link LogoParser#programme}.
	 * @param ctx the parse tree
	 */
	void enterProgramme(LogoParser.ProgrammeContext ctx);
	/**
	 * Exit a parse tree produced by {@link LogoParser#programme}.
	 * @param ctx the parse tree
	 */
	void exitProgramme(LogoParser.ProgrammeContext ctx);
	/**
	 * Enter a parse tree produced by {@link LogoParser#liste_instructions}.
	 * @param ctx the parse tree
	 */
	void enterListe_instructions(LogoParser.Liste_instructionsContext ctx);
	/**
	 * Exit a parse tree produced by {@link LogoParser#liste_instructions}.
	 * @param ctx the parse tree
	 */
	void exitListe_instructions(LogoParser.Liste_instructionsContext ctx);
	/**
	 * Enter a parse tree produced by the {@code av}
	 * labeled alternative in {@link LogoParser#instruction}.
	 * @param ctx the parse tree
	 */
	void enterAv(LogoParser.AvContext ctx);
	/**
	 * Exit a parse tree produced by the {@code av}
	 * labeled alternative in {@link LogoParser#instruction}.
	 * @param ctx the parse tree
	 */
	void exitAv(LogoParser.AvContext ctx);
	/**
	 * Enter a parse tree produced by the {@code re}
	 * labeled alternative in {@link LogoParser#instruction}.
	 * @param ctx the parse tree
	 */
	void enterRe(LogoParser.ReContext ctx);
	/**
	 * Exit a parse tree produced by the {@code re}
	 * labeled alternative in {@link LogoParser#instruction}.
	 * @param ctx the parse tree
	 */
	void exitRe(LogoParser.ReContext ctx);
	/**
	 * Enter a parse tree produced by the {@code td}
	 * labeled alternative in {@link LogoParser#instruction}.
	 * @param ctx the parse tree
	 */
	void enterTd(LogoParser.TdContext ctx);
	/**
	 * Exit a parse tree produced by the {@code td}
	 * labeled alternative in {@link LogoParser#instruction}.
	 * @param ctx the parse tree
	 */
	void exitTd(LogoParser.TdContext ctx);
	/**
	 * Enter a parse tree produced by the {@code tg}
	 * labeled alternative in {@link LogoParser#instruction}.
	 * @param ctx the parse tree
	 */
	void enterTg(LogoParser.TgContext ctx);
	/**
	 * Exit a parse tree produced by the {@code tg}
	 * labeled alternative in {@link LogoParser#instruction}.
	 * @param ctx the parse tree
	 */
	void exitTg(LogoParser.TgContext ctx);
	/**
	 * Enter a parse tree produced by the {@code couleur}
	 * labeled alternative in {@link LogoParser#instruction}.
	 * @param ctx the parse tree
	 */
	void enterCouleur(LogoParser.CouleurContext ctx);
	/**
	 * Exit a parse tree produced by the {@code couleur}
	 * labeled alternative in {@link LogoParser#instruction}.
	 * @param ctx the parse tree
	 */
	void exitCouleur(LogoParser.CouleurContext ctx);
	/**
	 * Enter a parse tree produced by the {@code fixeCap}
	 * labeled alternative in {@link LogoParser#instruction}.
	 * @param ctx the parse tree
	 */
	void enterFixeCap(LogoParser.FixeCapContext ctx);
	/**
	 * Exit a parse tree produced by the {@code fixeCap}
	 * labeled alternative in {@link LogoParser#instruction}.
	 * @param ctx the parse tree
	 */
	void exitFixeCap(LogoParser.FixeCapContext ctx);
	/**
	 * Enter a parse tree produced by the {@code leveCrayon}
	 * labeled alternative in {@link LogoParser#instruction}.
	 * @param ctx the parse tree
	 */
	void enterLeveCrayon(LogoParser.LeveCrayonContext ctx);
	/**
	 * Exit a parse tree produced by the {@code leveCrayon}
	 * labeled alternative in {@link LogoParser#instruction}.
	 * @param ctx the parse tree
	 */
	void exitLeveCrayon(LogoParser.LeveCrayonContext ctx);
	/**
	 * Enter a parse tree produced by the {@code baisseCrayon}
	 * labeled alternative in {@link LogoParser#instruction}.
	 * @param ctx the parse tree
	 */
	void enterBaisseCrayon(LogoParser.BaisseCrayonContext ctx);
	/**
	 * Exit a parse tree produced by the {@code baisseCrayon}
	 * labeled alternative in {@link LogoParser#instruction}.
	 * @param ctx the parse tree
	 */
	void exitBaisseCrayon(LogoParser.BaisseCrayonContext ctx);
	/**
	 * Enter a parse tree produced by the {@code fixeXY}
	 * labeled alternative in {@link LogoParser#instruction}.
	 * @param ctx the parse tree
	 */
	void enterFixeXY(LogoParser.FixeXYContext ctx);
	/**
	 * Exit a parse tree produced by the {@code fixeXY}
	 * labeled alternative in {@link LogoParser#instruction}.
	 * @param ctx the parse tree
	 */
	void exitFixeXY(LogoParser.FixeXYContext ctx);
	/**
	 * Enter a parse tree produced by the {@code mult}
	 * labeled alternative in {@link LogoParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterMult(LogoParser.MultContext ctx);
	/**
	 * Exit a parse tree produced by the {@code mult}
	 * labeled alternative in {@link LogoParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitMult(LogoParser.MultContext ctx);
	/**
	 * Enter a parse tree produced by the {@code parenthese}
	 * labeled alternative in {@link LogoParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterParenthese(LogoParser.ParentheseContext ctx);
	/**
	 * Exit a parse tree produced by the {@code parenthese}
	 * labeled alternative in {@link LogoParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitParenthese(LogoParser.ParentheseContext ctx);
	/**
	 * Enter a parse tree produced by the {@code sum}
	 * labeled alternative in {@link LogoParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterSum(LogoParser.SumContext ctx);
	/**
	 * Exit a parse tree produced by the {@code sum}
	 * labeled alternative in {@link LogoParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitSum(LogoParser.SumContext ctx);
	/**
	 * Enter a parse tree produced by the {@code float}
	 * labeled alternative in {@link LogoParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterFloat(LogoParser.FloatContext ctx);
	/**
	 * Exit a parse tree produced by the {@code float}
	 * labeled alternative in {@link LogoParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitFloat(LogoParser.FloatContext ctx);
	/**
	 * Enter a parse tree produced by the {@code hasard}
	 * labeled alternative in {@link LogoParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterHasard(LogoParser.HasardContext ctx);
	/**
	 * Exit a parse tree produced by the {@code hasard}
	 * labeled alternative in {@link LogoParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitHasard(LogoParser.HasardContext ctx);
}