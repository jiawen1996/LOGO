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
	 * Enter a parse tree produced by the {@code crochet}
	 * labeled alternative in {@link LogoParser#bloc}.
	 * @param ctx the parse tree
	 */
	void enterCrochet(LogoParser.CrochetContext ctx);
	/**
	 * Exit a parse tree produced by the {@code crochet}
	 * labeled alternative in {@link LogoParser#bloc}.
	 * @param ctx the parse tree
	 */
	void exitCrochet(LogoParser.CrochetContext ctx);
	/**
	 * Enter a parse tree produced by the {@code repete}
	 * labeled alternative in {@link LogoParser#instruction}.
	 * @param ctx the parse tree
	 */
	void enterRepete(LogoParser.RepeteContext ctx);
	/**
	 * Exit a parse tree produced by the {@code repete}
	 * labeled alternative in {@link LogoParser#instruction}.
	 * @param ctx the parse tree
	 */
	void exitRepete(LogoParser.RepeteContext ctx);
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
	 * Enter a parse tree produced by the {@code store}
	 * labeled alternative in {@link LogoParser#instruction}.
	 * @param ctx the parse tree
	 */
	void enterStore(LogoParser.StoreContext ctx);
	/**
	 * Exit a parse tree produced by the {@code store}
	 * labeled alternative in {@link LogoParser#instruction}.
	 * @param ctx the parse tree
	 */
	void exitStore(LogoParser.StoreContext ctx);
	/**
	 * Enter a parse tree produced by the {@code move}
	 * labeled alternative in {@link LogoParser#instruction}.
	 * @param ctx the parse tree
	 */
	void enterMove(LogoParser.MoveContext ctx);
	/**
	 * Exit a parse tree produced by the {@code move}
	 * labeled alternative in {@link LogoParser#instruction}.
	 * @param ctx the parse tree
	 */
	void exitMove(LogoParser.MoveContext ctx);
	/**
	 * Enter a parse tree produced by the {@code affecter}
	 * labeled alternative in {@link LogoParser#instruction}.
	 * @param ctx the parse tree
	 */
	void enterAffecter(LogoParser.AffecterContext ctx);
	/**
	 * Exit a parse tree produced by the {@code affecter}
	 * labeled alternative in {@link LogoParser#instruction}.
	 * @param ctx the parse tree
	 */
	void exitAffecter(LogoParser.AffecterContext ctx);
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
	 * Enter a parse tree produced by the {@code declare}
	 * labeled alternative in {@link LogoParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterDeclare(LogoParser.DeclareContext ctx);
	/**
	 * Exit a parse tree produced by the {@code declare}
	 * labeled alternative in {@link LogoParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitDeclare(LogoParser.DeclareContext ctx);
	/**
	 * Enter a parse tree produced by the {@code appelle}
	 * labeled alternative in {@link LogoParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterAppelle(LogoParser.AppelleContext ctx);
	/**
	 * Exit a parse tree produced by the {@code appelle}
	 * labeled alternative in {@link LogoParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitAppelle(LogoParser.AppelleContext ctx);
	/**
	 * Enter a parse tree produced by the {@code cos}
	 * labeled alternative in {@link LogoParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterCos(LogoParser.CosContext ctx);
	/**
	 * Exit a parse tree produced by the {@code cos}
	 * labeled alternative in {@link LogoParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitCos(LogoParser.CosContext ctx);
	/**
	 * Enter a parse tree produced by the {@code loop}
	 * labeled alternative in {@link LogoParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterLoop(LogoParser.LoopContext ctx);
	/**
	 * Exit a parse tree produced by the {@code loop}
	 * labeled alternative in {@link LogoParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitLoop(LogoParser.LoopContext ctx);
	/**
	 * Enter a parse tree produced by the {@code sin}
	 * labeled alternative in {@link LogoParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterSin(LogoParser.SinContext ctx);
	/**
	 * Exit a parse tree produced by the {@code sin}
	 * labeled alternative in {@link LogoParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitSin(LogoParser.SinContext ctx);
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