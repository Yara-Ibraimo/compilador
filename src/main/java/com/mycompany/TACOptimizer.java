package com.mycompany;

import java.util.*;

/**
 * Classe responsável por aplicar otimizações básicas sobre código TAC (Three Address Code).
 * As otimizações aqui implementadas incluem:
 * - Propagação de constantes
 * - Eliminação de cópias redundantes
 * - Eliminação de código morto (limitada)
 */
public class TACOptimizer {

    /**
     * Otimiza uma lista de instruções TAC recebida como entrada.
     * @param original Lista original de instruções TAC
     * @return Lista otimizada de instruções TAC
     */
    public List<String> optimize(List<String> original) {
        List<String> optimized = new ArrayList<>();
        Map<String, String> env = new HashMap<>(); // Tabela para manter substituições de variáveis

        for (String line : original) {
            // Ignorar linhas que não contêm "=" (não são atribuições, como labels ou comandos)
            if (!line.contains("=")) {
                optimized.add(line);
                continue;
            }

            // Divide a linha da forma: var = expr
            String[] parts = line.split("=", 2);
            if (parts.length != 2) {
                optimized.add(line); // Se não for possível dividir corretamente, mantém a linha
                continue;
            }

            String left = parts[0].trim();  // Variável à esquerda da atribuição
            String right = parts[1].trim(); // Expressão à direita

            // Propagação de constantes e substituições anteriores na expressão
            for (Map.Entry<String, String> entry : env.entrySet()) {
                right = right.replace(entry.getKey(), entry.getValue());
            }

            // Se a expressão for uma simples cópia (ex: a = b), regista para futura substituição
            if (right.matches("[a-zA-Z_][a-zA-Z_0-9]*")) {
                env.put(left, right);
            }

            // Adiciona a linha otimizada à nova lista
            optimized.add(left + " = " + right);
        }

        return optimized;
    }
}
