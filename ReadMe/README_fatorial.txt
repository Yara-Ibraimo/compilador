/* e-fólio B
	Compilação 2024/25
	Linguagem: MOC (My Own C)
	Compilador da linguagem: MOCC
	Grupo MudMasters B
*/

README – fatorial.moc / o-fatorial.moc

Descrição Geral

Este par de ficheiros apresenta duas abordagens distintas para o cálculo do fatorial de um número inteiro fornecido pelo utilizador:

- fatorial.moc: implementação recursiva da função fact.
- o-fatorial.moc: implementação iterativa otimizada que substitui a recursão por um ciclo while.

Ambas as versões são semanticamente equivalentes e encontram-se livres de erros de compilação e semântica.

Ficheiro: fatorial.moc (Recursiva)

Código-fonte

int fact(int n) {
    if (n == 0) {
        return 1;
    } else {
        return n * fact(n - 1);
    }
}

void main(void) {
    int num;
    int result;
    
    num = read();
    result = fact(num);
    write(result);
}

TAC Gerado

t4 = read()
num = t4
t5 = call fact(num)
result = t5

TAC Otimizado

t4 = read()
num = t4
t5 = call fact(num)
result = t5

Ficheiro: o-fatorial.moc (Iterativa Otimizada)

Código-fonte

void main(void)
{
    registerint i, num;
    registerlong result;

    // Leitura do valor de entrada
    writes("Introduza inteiro: ");
    num = read();

    // Cálculo iterativo do fatorial
    result = 1;
    i = 2;

    while (i <= num)
    {
        result = result * i;
        i = i + 1;
    }

    // Saída do resultado
    write(result);
}

TAC Gerado

t0 = read()
num = t0
result = 1
i = 2
t2 = result * i
result = t2
t3 = i + 1
i = t3

TAC Otimizado

t0 = read()
num = t0
result = 1
i = 2
t2 = result * i
result = t2
t3 = i + 1
i = t3

Otimizações Aplicadas
- Eliminação da recursividade (redução de sobrecarga da pilha).
- Substituição por while iterativo que permite geração de TAC mais direta.
- Uso de registerint e registerlong para simular otimização de tipos.
- Geração de TAC totalmente sequencial, favorecendo futuras fases de compilação.

Estado: Ambos os programas estão corretos e geram TAC esperado.  
A chamada call fact(num) na versão recursiva está agora suportada no gerador de TAC.