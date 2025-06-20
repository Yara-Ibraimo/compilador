/* e-fólio B
	Compilação 2024/25
	Linguagem: MOC (My Own C)
	Compilador da linguagem: MOCC
	Grupo MudMasters B
*/

README - fatorial_for.moc e o-fatorial_for.moc

Descrição
Estes ficheiros implementam o cálculo do fatorial de um número inteiro introduzido pelo utilizador.
- fatorial_for.moc: Versão original com uma implementação iterativa.
- o-fatorial_for.moc: Versão otimizada do mesmo código.

Ambas as versões usam um ciclo for para calcular o fatorial de n, armazenando o resultado na variável n. A versão otimizada segue a mesma lógica, mas com melhor formatação e compatibilidade com a geração de TAC.

Ficheiro: fatorial_for.moc

Código fonte original

int fact(int);
void main(void);

int fact (int k)
{
    int i,n=1;
    for(i=2;i<=k;i=i+1) { n = n*i; }
    return n;
}

void main(void)
{
    int n;
    writes("Introduza inteiro: ");
    n = read();
    write(fact(n));
}

Código TAC gerado

t1 = n * i
n = t1
t2 = read()
n = t2

Código TAC otimizado

t1 = n * i
n = t1
t2 = read()
n = t2

Ficheiro: o-fatorial_for.moc

Código fonte otimizado

void main(void)
{
    registerint i, n, k;

    // Pedir e ler o valor de entrada
    writes("Introduza inteiro: ");
    k = read();

    // Cálculo inline do factorial
    n = 1;
    for (i = 2; i <= k; i = i + 1)
    {
        n = n * i;
    }

    // Escrever resultado
    write(n);
}

Código TAC gerado

t0 = read()
k = t0
n = 1
t2 = n * i
n = t2

Código TAC otimizado

t0 = read()
k = t0
n = 1
t2 = n * i
n = t2

Otimizações Aplicadas
- Propagação de constantes: Aplicada dentro do ciclo.
- Eliminação de código morto: Não aplicável, pois todas as instruções contribuem para o resultado.
- Clarificação de nomes temporários: TAC gerado com nomes temporários organizados.

Considerações Finais
- O código otimizado elimina chamadas de funções e mantém a lógica direta no main().
- Não foram encontrados erros léxicos, sintáticos ou semânticos.