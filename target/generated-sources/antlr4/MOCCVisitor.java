// Generated from MOCC.g4 by ANTLR 4.13.1

package com.mycompany;

import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link MOCCParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface MOCCVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link MOCCParser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(MOCCParser.ProgramContext ctx);
	/**
	 * Visit a parse tree produced by {@link MOCCParser#functionDecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionDecl(MOCCParser.FunctionDeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link MOCCParser#parameters}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParameters(MOCCParser.ParametersContext ctx);
	/**
	 * Visit a parse tree produced by the {@code typedIdentifier}
	 * labeled alternative in {@link MOCCParser#parameter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypedIdentifier(MOCCParser.TypedIdentifierContext ctx);
	/**
	 * Visit a parse tree produced by the {@code typedOnly}
	 * labeled alternative in {@link MOCCParser#parameter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypedOnly(MOCCParser.TypedOnlyContext ctx);
	/**
	 * Visit a parse tree produced by the {@code typedArray}
	 * labeled alternative in {@link MOCCParser#parameter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypedArray(MOCCParser.TypedArrayContext ctx);
	/**
	 * Visit a parse tree produced by the {@code typeAnonymousArray}
	 * labeled alternative in {@link MOCCParser#parameter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeAnonymousArray(MOCCParser.TypeAnonymousArrayContext ctx);
	/**
	 * Visit a parse tree produced by {@link MOCCParser#variableDecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariableDecl(MOCCParser.VariableDeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link MOCCParser#varDeclList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarDeclList(MOCCParser.VarDeclListContext ctx);
	/**
	 * Visit a parse tree produced by {@link MOCCParser#varDecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarDecl(MOCCParser.VarDeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link MOCCParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitType(MOCCParser.TypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link MOCCParser#block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlock(MOCCParser.BlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link MOCCParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement(MOCCParser.StatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MOCCParser#assignment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignment(MOCCParser.AssignmentContext ctx);
	/**
	 * Visit a parse tree produced by {@link MOCCParser#ifStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfStatement(MOCCParser.IfStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MOCCParser#whileStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhileStatement(MOCCParser.WhileStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MOCCParser#forStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForStatement(MOCCParser.ForStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MOCCParser#returnStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturnStatement(MOCCParser.ReturnStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MOCCParser#userFunctionCall}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUserFunctionCall(MOCCParser.UserFunctionCallContext ctx);
	/**
	 * Visit a parse tree produced by {@link MOCCParser#readCall}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReadCall(MOCCParser.ReadCallContext ctx);
	/**
	 * Visit a parse tree produced by {@link MOCCParser#writeCall}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWriteCall(MOCCParser.WriteCallContext ctx);
	/**
	 * Visit a parse tree produced by {@link MOCCParser#arguments}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArguments(MOCCParser.ArgumentsContext ctx);
	/**
	 * Visit a parse tree produced by {@link MOCCParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression(MOCCParser.ExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MOCCParser#cast}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCast(MOCCParser.CastContext ctx);
	/**
	 * Visit a parse tree produced by {@link MOCCParser#initList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInitList(MOCCParser.InitListContext ctx);
}