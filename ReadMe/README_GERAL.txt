/* e-fólio B
	Compilação 2024/25
	Linguagem: MOC (My Own C)
	Compilador da linguagem: MOCC
	Grupo MudMasters B
*/

README_GERAL.txt

Projeto: Compilador MOCC - Geração e Otimização de Código TAC

Grupo: MudMasters B  
Ano letivo: 2024/25  
Linguagem: MOC (My Own C)  
Ferramenta base: ANTLR 4

Objetivo Geral

O projeto visa a análise, compilação e otimização de programas escritos em MOC, através das seguintes fases:
- Análise léxica e sintática com ANTLR.
- Análise semântica com deteção de declarações inválidas.
- Geração de código intermédio TAC (Three Address Code).
- Otimização de TAC com técnicas como propagação de constantes, folding e simplificações.
- Visualização da AST (Árvore Sintática Abstrata).

Ficheiros e Componentes Criados

MOCC.g4
- Gramática ANTLR da linguagem MOC.
- Suporte a:
  - Tipos base e vetores.
  - Blocos, ciclos, condições, expressões, casts.
  - Chamadas a funções do utilizador e internas (read, write, etc.).
- Corrigida para suportar tipo[] como parâmetro, o que era necessário para double avg(double v[]).

MOCCSemanticListener.java
- Responsável por:
  - Detetar variáveis não declaradas.
  - Detetar declarações repetidas.
  - Registar funções e variáveis para uso futuro.

TACGenerator.java
- Gera código intermédio TAC a partir da árvore de análise.
- Suporta:
  - Atribuições simples e indexadas.
  - Expressões aritméticas e com operadores binários.
  - Chamadas a funções internas (read, readc, etc.) e do utilizador.
  - Conversão de chamadas como x = fact(n) em t = call fact(n).

TACOptimizer.java
- Otimizador de código TAC com:
  - Propagação de constantes.
  - Folding de expressões constantes.
  - Copy propagation entre temporários.
  - Eliminação de multiplicações por 1 ou 0.
  - Eliminação de saltos condicionais falsos.

App.java
- Interface principal de execução.
- Executa os seguintes passos:

Fluxo de Execução
1. Solicita nomes dos ficheiros original e otimizado (apenas o nome, sem o caminho).
2. Lê os ficheiros de:
   - src/teste/recursos/original/<nome>.moc
   - src/teste/recursos/otimizado/<nome>.moc
3. Para cada ficheiro:
   - Mostra o código original
   - Realiza a análise semântica.
   - Gera e imprime o TAC.
   - Aplica e imprime o TAC otimizado.
   - Mostra a árvore sintática do código otimizado (com TreeViewer).

Ficheiros README por Programa

Para cada par .moc / o- .moc, foi criado um ficheiro README_<nome>.txt com:

- Código original e otimizado.
- Código TAC gerado e otimizado.
- Análise de otimizações aplicadas.
- Considerações sobre erros, quando aplicável.
- Comparação entre versões recursiva e iterativa (para fact).

Ficheiro especial: erros_teste.moc

- Contém erros propositados para testar a robustez do compilador.
- Serve para validar a:
  - Detecção de tokens inválidos.
  - Ausência de ponto e vírgula.
  - Uso de variáveis não declaradas.
  - Parênteses mal formados.
- Não é sujeito a otimizações.

Estado Final

Todos os ficheiros originais e otimizados compilam sem erros, exceto o erros_teste.moc (intencional).  
O gerador TAC suporta funções do utilizador, vetores, ciclos e chamadas encadeadas.  
O otimizador aplica várias técnicas úteis para tornar o código mais limpo e eficiente.  
A visualização da AST é apresentada para os ficheiros otimizados.