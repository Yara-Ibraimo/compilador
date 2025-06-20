// Generated from MOCC.g4 by ANTLR 4.13.1

package com.mycompany;

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link MOCCParser}.
 */
public interface MOCCListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link MOCCParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(MOCCParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link MOCCParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(MOCCParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link MOCCParser#functionDecl}.
	 * @param ctx the parse tree
	 */
	void enterFunctionDecl(MOCCParser.FunctionDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link MOCCParser#functionDecl}.
	 * @param ctx the parse tree
	 */
	void exitFunctionDecl(MOCCParser.FunctionDeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link MOCCParser#parameters}.
	 * @param ctx the parse tree
	 */
	void enterParameters(MOCCParser.ParametersContext ctx);
	/**
	 * Exit a parse tree produced by {@link MOCCParser#parameters}.
	 * @param ctx the parse tree
	 */
	void exitParameters(MOCCParser.ParametersContext ctx);
	/**
	 * Enter a parse tree produced by the {@code typedIdentifier}
	 * labeled alternative in {@link MOCCParser#parameter}.
	 * @param ctx the parse tree
	 */
	void enterTypedIdentifier(MOCCParser.TypedIdentifierContext ctx);
	/**
	 * Exit a parse tree produced by the {@code typedIdentifier}
	 * labeled alternative in {@link MOCCParser#parameter}.
	 * @param ctx the parse tree
	 */
	void exitTypedIdentifier(MOCCParser.TypedIdentifierContext ctx);
	/**
	 * Enter a parse tree produced by the {@code typedOnly}
	 * labeled alternative in {@link MOCCParser#parameter}.
	 * @param ctx the parse tree
	 */
	void enterTypedOnly(MOCCParser.TypedOnlyContext ctx);
	/**
	 * Exit a parse tree produced by the {@code typedOnly}
	 * labeled alternative in {@link MOCCParser#parameter}.
	 * @param ctx the parse tree
	 */
	void exitTypedOnly(MOCCParser.TypedOnlyContext ctx);
	/**
	 * Enter a parse tree produced by the {@code typedArray}
	 * labeled alternative in {@link MOCCParser#parameter}.
	 * @param ctx the parse tree
	 */
	void enterTypedArray(MOCCParser.TypedArrayContext ctx);
	/**
	 * Exit a parse tree produced by the {@code typedArray}
	 * labeled alternative in {@link MOCCParser#parameter}.
	 * @param ctx the parse tree
	 */
	void exitTypedArray(MOCCParser.TypedArrayContext ctx);
	/**
	 * Enter a parse tree produced by the {@code typeAnonymousArray}
	 * labeled alternative in {@link MOCCParser#parameter}.
	 * @param ctx the parse tree
	 */
	void enterTypeAnonymousArray(MOCCParser.TypeAnonymousArrayContext ctx);
	/**
	 * Exit a parse tree produced by the {@code typeAnonymousArray}
	 * labeled alternative in {@link MOCCParser#parameter}.
	 * @param ctx the parse tree
	 */
	void exitTypeAnonymousArray(MOCCParser.TypeAnonymousArrayContext ctx);
	/**
	 * Enter a parse tree produced by {@link MOCCParser#variableDecl}.
	 * @param ctx the parse tree
	 */
	void enterVariableDecl(MOCCParser.VariableDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link MOCCParser#variableDecl}.
	 * @param ctx the parse tree
	 */
	void exitVariableDecl(MOCCParser.VariableDeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link MOCCParser#varDeclList}.
	 * @param ctx the parse tree
	 */
	void enterVarDeclList(MOCCParser.VarDeclListContext ctx);
	/**
	 * Exit a parse tree produced by {@link MOCCParser#varDeclList}.
	 * @param ctx the parse tree
	 */
	void exitVarDeclList(MOCCParser.VarDeclListContext ctx);
	/**
	 * Enter a parse tree produced by {@link MOCCParser#varDecl}.
	 * @param ctx the parse tree
	 */
	void enterVarDecl(MOCCParser.VarDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link MOCCParser#varDecl}.
	 * @param ctx the parse tree
	 */
	void exitVarDecl(MOCCParser.VarDeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link MOCCParser#type}.
	 * @param ctx the parse tree
	 */
	void enterType(MOCCParser.TypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link MOCCParser#type}.
	 * @param ctx the parse tree
	 */
	void exitType(MOCCParser.TypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link MOCCParser#block}.
	 * @param ctx the parse tree
	 */
	void enterBlock(MOCCParser.BlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link MOCCParser#block}.
	 * @param ctx the parse tree
	 */
	void exitBlock(MOCCParser.BlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link MOCCParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(MOCCParser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MOCCParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(MOCCParser.StatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link MOCCParser#assignment}.
	 * @param ctx the parse tree
	 */
	void enterAssignment(MOCCParser.AssignmentContext ctx);
	/**
	 * Exit a parse tree produced by {@link MOCCParser#assignment}.
	 * @param ctx the parse tree
	 */
	void exitAssignment(MOCCParser.AssignmentContext ctx);
	/**
	 * Enter a parse tree produced by {@link MOCCParser#ifStatement}.
	 * @param ctx the parse tree
	 */
	void enterIfStatement(MOCCParser.IfStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MOCCParser#ifStatement}.
	 * @param ctx the parse tree
	 */
	void exitIfStatement(MOCCParser.IfStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link MOCCParser#whileStatement}.
	 * @param ctx the parse tree
	 */
	void enterWhileStatement(MOCCParser.WhileStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MOCCParser#whileStatement}.
	 * @param ctx the parse tree
	 */
	void exitWhileStatement(MOCCParser.WhileStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link MOCCParser#forStatement}.
	 * @param ctx the parse tree
	 */
	void enterForStatement(MOCCParser.ForStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MOCCParser#forStatement}.
	 * @param ctx the parse tree
	 */
	void exitForStatement(MOCCParser.ForStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link MOCCParser#returnStatement}.
	 * @param ctx the parse tree
	 */
	void enterReturnStatement(MOCCParser.ReturnStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MOCCParser#returnStatement}.
	 * @param ctx the parse tree
	 */
	void exitReturnStatement(MOCCParser.ReturnStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link MOCCParser#userFunctionCall}.
	 * @param ctx the parse tree
	 */
	void enterUserFunctionCall(MOCCParser.UserFunctionCallContext ctx);
	/**
	 * Exit a parse tree produced by {@link MOCCParser#userFunctionCall}.
	 * @param ctx the parse tree
	 */
	void exitUserFunctionCall(MOCCParser.UserFunctionCallContext ctx);
	/**
	 * Enter a parse tree produced by {@link MOCCParser#readCall}.
	 * @param ctx the parse tree
	 */
	void enterReadCall(MOCCParser.ReadCallContext ctx);
	/**
	 * Exit a parse tree produced by {@link MOCCParser#readCall}.
	 * @param ctx the parse tree
	 */
	void exitReadCall(MOCCParser.ReadCallContext ctx);
	/**
	 * Enter a parse tree produced by {@link MOCCParser#writeCall}.
	 * @param ctx the parse tree
	 */
	void enterWriteCall(MOCCParser.WriteCallContext ctx);
	/**
	 * Exit a parse tree produced by {@link MOCCParser#writeCall}.
	 * @param ctx the parse tree
	 */
	void exitWriteCall(MOCCParser.WriteCallContext ctx);
	/**
	 * Enter a parse tree produced by {@link MOCCParser#arguments}.
	 * @param ctx the parse tree
	 */
	void enterArguments(MOCCParser.ArgumentsContext ctx);
	/**
	 * Exit a parse tree produced by {@link MOCCParser#arguments}.
	 * @param ctx the parse tree
	 */
	void exitArguments(MOCCParser.ArgumentsContext ctx);
	/**
	 * Enter a parse tree produced by {@link MOCCParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpression(MOCCParser.ExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MOCCParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpression(MOCCParser.ExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link MOCCParser#cast}.
	 * @param ctx the parse tree
	 */
	void enterCast(MOCCParser.CastContext ctx);
	/**
	 * Exit a parse tree produced by {@link MOCCParser#cast}.
	 * @param ctx the parse tree
	 */
	void exitCast(MOCCParser.CastContext ctx);
	/**
	 * Enter a parse tree produced by {@link MOCCParser#initList}.
	 * @param ctx the parse tree
	 */
	void enterInitList(MOCCParser.InitListContext ctx);
	/**
	 * Exit a parse tree produced by {@link MOCCParser#initList}.
	 * @param ctx the parse tree
	 */
	void exitInitList(MOCCParser.InitListContext ctx);
}