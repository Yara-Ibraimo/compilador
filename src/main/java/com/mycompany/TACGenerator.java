package com.mycompany;

import com.mycompany.MOCCBaseVisitor;
import com.mycompany.MOCCParser;
import java.util.List;
import java.util.*;
import org.antlr.v4.runtime.tree.*;

/**
 * Esta classe é responsável pela geração de código intermédio no formato TAC (Three Address Code).
 * Ela estende o visitor gerado pelo ANTLR a partir da gramática MOCC, visitando a AST para produzir instruções TAC.
 */
public class TACGenerator extends MOCCBaseVisitor<List<String>> {

    private int tempCounter = 0; // Contador para gerar variáveis temporárias (t0, t1, t2, ...)
    private List<String> tac = new ArrayList<>(); // Lista onde serão armazenadas as instruções TAC geradas

    // Método auxiliar para gerar o nome de uma nova variável temporária
    private String newTemp() {
        return "t" + (tempCounter++);
    }

    /**
     * Método principal que inicia a visita à árvore sintática para gerar o código TAC.
     * @param tree A árvore sintática (AST) completa do programa.
     * @return Lista de strings representando o código TAC.
     */
    public List<String> generate(ParseTree tree) {
        this.visit(tree); // Inicia a visita à AST
        return tac;       // Retorna as instruções TAC geradas
    }

    /**
     * Visita uma atribuição do tipo: var = expressão;
     * Gera o código TAC para a expressão e a atribuição.
     */
    @Override
    public List<String> visitAssignment(MOCCParser.AssignmentContext ctx) {
        String varName = ctx.ID().getText(); // Nome da variável à esquerda do '='
        List<String> exprCode = visit(ctx.expression(0)); // Gera TAC para a expressão à direita

        // Verifica se a expressão é válida
        if (exprCode.isEmpty()) {
            System.err.println("Erro: expressão inválida na linha -> " + ctx.getText());
            return List.of(); // Retorna lista vazia se houver erro
        }

        // Último elemento da lista é o resultado da expressão
        String result = exprCode.get(exprCode.size() - 1);

        // Adiciona todas as instruções intermediárias geradas, exceto o último resultado
        tac.addAll(exprCode.subList(0, exprCode.size() - 1));

        // Adiciona a instrução de atribuição final: var = resultado
        tac.add(varName + " = " + result);
        return tac;
    }

    /**
     * Visita uma expressão (aritmética, chamada, constante, etc.).
     * Retorna uma lista de instruções TAC parciais e o último valor calculado.
     */
    @Override
    public List<String> visitExpression(MOCCParser.ExpressionContext ctx) {
        List<String> code = new ArrayList<>();

        // Caso seja um número inteiro
        if (ctx.INT() != null) {
            code.add(ctx.INT().getText());
            return code;
        }

        // Caso seja uma variável simples (ex: x)
        if (ctx.ID() != null && ctx.expression().isEmpty()) {
            code.add(ctx.ID().getText());
            return code;
        }

        // Caso seja uma expressão binária (ex: x + y, a * b, etc.)
        if (ctx.op != null && ctx.expression().size() == 2) {
            List<String> left = visit(ctx.expression(0));  // Visita o operando esquerdo
            List<String> right = visit(ctx.expression(1)); // Visita o operando direito

            // Verificação de erro em operandos
            if (left.isEmpty() || right.isEmpty()) {
                return List.of();
            }

            // Últimos valores calculados de cada lado
            String l = left.get(left.size() - 1);
            String r = right.get(right.size() - 1);

            // Junta o código gerado anteriormente, excluindo os últimos resultados
            code.addAll(left.subList(0, left.size() - 1));
            code.addAll(right.subList(0, right.size() - 1));

            // Gera nova variável temporária para guardar o resultado da operação
            String temp = newTemp();
            code.add(temp + " = " + l + " " + ctx.op.getText() + " " + r);
            code.add(temp); // Adiciona a variável temporária como resultado da expressão

            return code;
        }

        // Expressão entre parênteses: (expr)
        if (ctx.getChildCount() == 3 && ctx.getChild(0).getText().equals("(")) {
            return visit(ctx.expression(0));
        }

        // Caso seja uma chamada a uma função interna como read()
        if (ctx.readCall() != null) {
            String temp = newTemp();
            code.add(temp + " = " + ctx.readCall().getText());
            code.add(temp);
            return code;
        }

        // Caso seja uma chamada a uma função definida pelo utilizador
        if (ctx.userFunctionCall() != null) {
            String argsStr = "";
            List<String> argsCode = new ArrayList<>();

            // Gera código TAC para cada argumento da função
            if (ctx.userFunctionCall().arguments() != null) {
                for (MOCCParser.ExpressionContext expr : ctx.userFunctionCall().arguments().expression()) {
                    List<String> argCode = visit(expr);
                    if (!argCode.isEmpty()) {
                        argsCode.addAll(argCode.subList(0, argCode.size() - 1));
                        argsStr += (argsStr.isEmpty() ? "" : ", ") + argCode.get(argCode.size() - 1);
                    }
                }
            }

            code.addAll(argsCode); // Instruções TAC dos argumentos
            String temp = newTemp();
            code.add(temp + " = call " + ctx.userFunctionCall().ID().getText() + "(" + argsStr + ")");
            code.add(temp);
            return code;
        }

        // Caso nenhum caso se aplique (expressão incompleta ou inválida)
        return code;
    }
}
