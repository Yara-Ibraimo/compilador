package com.mycompany;

// Importações do ANTLR para análise léxica, parsing e árvore sintática
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import org.antlr.v4.gui.TreeViewer;

// Importações específicas para a gramática MOCC
import com.mycompany.MOCCLexer;
import com.mycompany.MOCCParser;

// Bibliotecas padrão Java
import java.util.List;
import javax.swing.*;
import java.awt.Dimension;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.awt.event.*;
import java.nio.file.Path;
import java.util.*;
import static java.nio.file.Files.readString;
import java.nio.file.*;

public class App {

    // Método principal do programa
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        // Solicita o nome do ficheiro original ao utilizador (ficheiro de entrada original)
        System.out.print("Nome do ficheiro ORIGINAL (.moc): ");
        String originalFile = scanner.nextLine().trim();
        Path originalPath = Path.of(System.getProperty("user.dir"),"/src/teste/recursos/original", originalFile);

        // Solicita o nome do ficheiro otimizado ao utilizador (versão otimizada do código)
        System.out.print("Nome do ficheiro OTIMIZADO (.moc): ");
        String otimizadoFile = scanner.nextLine().trim();
        Path otimizadoPath = Path.of(System.getProperty("user.dir"),"/src/teste/recursos/otimizado", otimizadoFile);

        // Processa o primeiro ficheiro
        System.out.println("\n==== FICHEIRO ORIGINAL ====\n");
        processarFicheiro(originalPath);

        // Processa o segundo ficheiro
        System.out.println("\n==== FICHEIRO OTIMIZADO ====\n");
        processarFicheiro(otimizadoPath);
    }

    // Função que trata a leitura, parsing e análise de um ficheiro .moc
    private static void processarFicheiro(Path ficheiro) throws Exception {
        // Verifica se o ficheiro existe
        if (!Files.exists(ficheiro)) {
            System.out.println("Ficheiro não encontrado: " + ficheiro);
            return;
        }

        // Lê o conteúdo completo do ficheiro
        String input = readString(ficheiro);
        System.out.println(">> Ficheiro: " + ficheiro.getFileName());

        // Mostra o código fonte no terminal
        System.out.println("\n--- Código do ficheiro ---\n");
        System.out.println(input);

        // Cria o lexer para dividir o texto em tokens
        MOCCLexer lexer = new MOCCLexer(CharStreams.fromString(input));

        // Converte os tokens em fluxo para o parser
        CommonTokenStream tokens = new CommonTokenStream(lexer);

        // Cria o parser com base na gramática MOCC
        MOCCParser parser = new MOCCParser(tokens);

        // Gera a árvore sintática do programa
        ParseTree tree = parser.program();

        // Aplica o listener semântico para verificar declarações, variáveis, etc.
        ParseTreeWalker walker = new ParseTreeWalker();
        MOCCSemanticListener listener = new MOCCSemanticListener();
        walker.walk(listener, tree);

        // Geração de código intermédio TAC
        TACGenerator tacGen = new TACGenerator();
        List<String> tac = tacGen.generate(tree);

        // Mostra o código TAC gerado
        System.out.println("\n--- Código TAC ---\n");
        tac.forEach(System.out::println);

        // Aplica otimizações ao TAC
        TACOptimizer optimizer = new TACOptimizer();
        List<String> optimized = optimizer.optimize(tac);

        // Mostra o código TAC otimizado
        System.out.println("\n--- Código TAC Otimizado ---\n");
        optimized.forEach(System.out::println);

        // Exibe graficamente a árvore sintática abstrata
        mostrarArvore(parser, tree, ficheiro);
    }

    // Função que apresenta a árvore sintática (AST) graficamente com zoom controlado
    private static void mostrarArvore(MOCCParser parser, ParseTree tree, Path ficheiro) {
        JFrame frame = new JFrame("Árvore Sintática - MOCC" + ficheiro);
        //JPanel panel = new JPanel();

        // Cria visualização da AST com os nomes das regras da gramática
        TreeViewer viewer = new TreeViewer(Arrays.asList(parser.getRuleNames()), tree);

        // Permite zoom com o rato (CTRL + scroll)
        double[] scale = {1.0};
        viewer.setScale(scale[0]);
        viewer.setPreferredSize(new Dimension(2000, 1000));

        viewer.addMouseWheelListener(e -> {
            if (e.isControlDown()) {
                scale[0] += (e.getWheelRotation() < 0) ? 0.1 : -0.1;
                viewer.setScale(Math.max(0.1, scale[0]));
                viewer.setPreferredSize(new Dimension(
                        (int) (2000 * scale[0]),
                        (int) (1000 * scale[0])
                ));
                viewer.revalidate();
                viewer.repaint();
            }
        });

        // Janela com barras de scroll para a árvore
        JScrollPane scrollPane = new JScrollPane(viewer,
                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

        // Mostra a janela da árvore
        frame.add(scrollPane);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setVisible(true);
    }
}
