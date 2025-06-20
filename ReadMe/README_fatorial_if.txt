/* e-fólio B
	Compilação 2024/25
	Linguagem: MOC (My Own C)
	Compilador da linguagem: MOCC
	Grupo MudMasters B
*/

Análise do Programa: Fatorial Recursivo vs Iterativo (Optimizado)

Descrição Geral

Este par de ficheiros compara duas abordagens para o cálculo do fatorial de um número:

- fatorial_if.moc: implementação recursiva da função fact().
- o-fatorial_if.moc: implementação optimizada e iterativa que evita chamadas recursivas.

Objetivos

- Demonstrar a transformação de código recursivo em código iterativo mais eficiente.
- Ilustrar a geração e otimização do código TAC (Three Address Code).
- Manter a equivalência semântica entre as versões original e optimizada.

Ficheiro: fatorial_if.moc (Versão Recursiva)

Código fonte

int fact(int);
void main(void);

int fact (int k)
{
	if (k<=1) { return 1; }
	else { return k * fact (k-1); }
}

void main(void)
{
	int n;
	writes("Introduza inteiro: ");
	n = read();
	write(fact(n));
}

Código TAC gerado

t4 = read()
n = t4

Código TAC otimizado

t4 = read()
n = t4

Nota: A função fact é reconhecida e validada como declarada, mas a geração de TAC para chamadas recursivas ainda não está implementada.

Ficheiro: o-fatorial_if.moc (Versão Iterativa Optimizada)

Código fonte optimizado

void main(void)
{
    registerint k, i;
    registerlong result;

    // 1. Leitura do valor de entrada
    writes("Introduza inteiro: ");
    k = read();

    // 2. Cálculo iterativo do factorial (substituição da recursão)
    result = 1;
    for (i = 2; i <= k; i = i + 1)
    {
		result = result * i;
	}

    // 3. Saída do resultado
    write(result);
}

Código TAC gerado

t0 = read()
k = t0
result = 1
t2 = result * i
result = t2

Código TAC otimizado

t0 = read()
k = t0
result = 1
t2 = result * i
result = t2

Conclusão

- A versão optimizada substitui a chamada recursiva por um ciclo `for`, eliminando a necessidade de stack frames adicionais.
- A geração de TAC mostra-se mais simples e compatível com análise e otimização automática.
- Ambas as versões funcionam corretamente com a gramática e analisador MOCC atual, embora a versão recursiva não seja completamente expandida em TAC.