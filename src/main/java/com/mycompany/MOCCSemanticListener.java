package com.mycompany;

import java.util.*;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import com.mycompany.MOCCParser;
import com.mycompany.MOCCBaseListener;

/**
 * Este listener é responsável por fazer a análise semântica do código MOC.
 * Através dos métodos `enterFunctionDecl`, `enterVariableDecl` e `enterAssignment`,
 * conseguimos verificar declarações duplicadas, variáveis não declaradas e manter
 * escopos corretos por função.
 */
public class MOCCSemanticListener extends MOCCBaseListener {

    // Conjunto de nomes de funções declaradas. Evita duplicações e permite validações.
    private final Set<String> declaredFunctions = new HashSet<>();

    // Mapa que associa cada função ao seu próprio escopo de variáveis (nome da função → mapa de variáveis).
    private final Map<String, Map<String, String>> functionScopes = new HashMap<>();

    // Mapa temporário que referencia o escopo atual de variáveis enquanto se analisa uma função.
    private Map<String, String> currentScopeVariables = new HashMap<>();

    /**
     * Executado ao entrar numa declaração de função.
     * Aqui registamos o nome da função e criamos um novo escopo de variáveis associado a ela.
     */
    @Override
    public void enterFunctionDecl(MOCCParser.FunctionDeclContext ctx) {
        String name = ctx.ID().getText(); // Extrai o nome da função
        declaredFunctions.add(name); // Regista a função

        // Inicializa um novo mapa de variáveis para o escopo desta função
        currentScopeVariables = new HashMap<>();
        functionScopes.put(name, currentScopeVariables);

        System.out.println("Função declarada: " + name);
    }

    /**
     * Executado ao entrar numa declaração de variável (pode ser múltipla).
     * Faz verificação de duplicações dentro do mesmo escopo de função.
     */
    @Override
    public void enterVariableDecl(MOCCParser.VariableDeclContext ctx) {
        String tipo = ctx.type().getText(); // Tipo das variáveis declaradas

        // Percorre todas as variáveis declaradas neste statement
        for (MOCCParser.VarDeclContext var : ctx.varDeclList().varDecl()) {
            String nome = var.ID().getText();

            // Verifica se a variável já existe no escopo atual
            if (currentScopeVariables.containsKey(nome)) {
                System.err.println("Erro: variável já declarada -> " + nome);
            } else {
                // Regista a variável no escopo atual
                currentScopeVariables.put(nome, tipo);
                System.out.println("Variável declarada: " + nome + " do tipo " + tipo);
            }
        }
    }

    /**
     * Executado ao entrar numa atribuição.
     * Verifica se a variável à esquerda da atribuição foi previamente declarada.
     */
    @Override
    public void enterAssignment(MOCCParser.AssignmentContext ctx) {
        String var = ctx.ID().getText(); // Nome da variável atribuída
        if (!currentScopeVariables.containsKey(var)) {
            System.err.println("Erro: variável usada sem declaração -> " + var);
        }
    }

    // Métodos de apoio para inspeção posterior (úteis em testes ou visualização)

    /**
     * Devolve o mapa completo de variáveis declaradas por função.
     */
    public Map<String, Map<String, String>> getFunctionScopes() {
        return functionScopes;
    }

    /**
     * Devolve o conjunto de funções declaradas.
     */
    public Set<String> getDeclaredFunctions() {
        return declaredFunctions;
    }
}
