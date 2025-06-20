/* e-fólio B
	Compilação 2024/25
	Linguagem: MOC (My Own C)
	Compilador da linguagem: MOCC
	Grupo MudMasters B
*/

README - erros_teste.moc

Objetivo do Ficheiro

Este ficheiro foi criado intencionalmente com erros de sintaxe, semântica e estrutura, com o propósito de testar a robustez do compilador MOCC e dos seus componentes:
- Analisador léxico e sintático (ANTLR)
- Analisador semântico (MOCCSemanticListener)
- Gerador de código intermédio (TACGenerator)
- Otimizador (TACOptimizer)

Observações

Este ficheiro não deve ser corrigido nem otimizado. A sua existência justifica-se apenas como parte da estratégia de validação de erros do compilador. Todos os erros detetados são esperados e pretendidos.

Código Fonte (erros_teste.moc)

int soma(int a, int b)
{
    int resultado;
    resultado = a + b$     // Erro léxico: símbolo inválido $
    return resultado        // Falta ponto e vírgula
}

void main(void)
{
    int x = 5;
    int y = 10              // Falta ponto e vírgula
    int z;
    z = soma(x, y;          // Erro de parênteses
    write(z)                // Falta ponto e vírgula
}

## Erros Detetados

- line 3:21 token recognition error at: '$'
- line 4:4 missing ';' at 'return'
- line 5:0 missing ';' at '}'
- line 10:4 missing ';' at 'int'
- line 11:17 missing ')' at ';'
- line 13:0 missing ';' at '}'

Código TAC (parcial)

t0 = a + b
resultado = t0
t1 = call soma(x, y)
z = t1

Resultado Esperado

Ao compilar este ficheiro com o compilador MOCC, o sistema deverá:
- Assinalar corretamente os erros existentes
- Recusar a geração de código TAC completo
- Garantir que os módulos de análise funcionam corretamente perante entradas inválidas

Este ficheiro serve de base para futuras extensões no tratamento de erros e não é incluído nas métricas de desempenho nem nos testes de otimização.