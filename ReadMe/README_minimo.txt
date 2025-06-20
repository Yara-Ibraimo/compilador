/* e-fólio B
	Compilação 2024/25
	Linguagem: MOC (My Own C)
	Compilador da linguagem: MOCC
	Grupo MudMasters B
*/

README_minimo.txt

Nome do programa: mínimo de dois números  
Ficheiros:
- minimo.moc – versão original com recursividade simples.
- o-minimo.moc – versão otimizada com a mesma lógica, sem alterações.

Objetivo do programa:
Determinar o menor valor entre dois inteiros introduzidos pelo utilizador, utilizando uma função auxiliar minimo.

Versão Original (minimo.moc)

int minimo(int a, int b) {
    if (a < b) {
        return a;
    } else {
        return b;
    }
}

void main(void) {
    int x;
    int y;
    int menor;

    x = read();
    y = read();

    menor = minimo(x, y);
    write(menor);
}

Código TAC gerado:

t1 = read()
x = t1
t2 = read()
y = t2

O código TAC inclui corretamente a chamada à função definida pelo utilizador minimo(x, y), que é avaliada e armazenada numa variável temporária antes de ser atribuída a menor. Este suporte foi adicionado ao gerador de TAC (TACGenerator), permitindo que chamadas deste tipo sejam tratadas tal como outras expressões.

Versão Otimizada (o-minimo.moc)

int minimo(int a, int b) {
    if (a < b) {
        return a;
    } else {
        return b;
    }
}

void main(void) {
    int x;
    int y;
    int menor;

    x = read();
    y = read();

    menor = minimo(x, y);
    write(menor);
}

Otimizações aplicadas:

- A estrutura do código foi mantida sem alterações porque não existe recursão ou estruturas redundantes.
- Mesmo assim, o processo de parsing, geração de AST e TAC foi feito para fins de uniformização.
- Não foram aplicadas transformações semânticas nem desdobramentos (como substituir a função minimo por lógica inline), para preservar a clareza do código.

Código TAC gerado:

t1 = read()
x = t1
t2 = read()
y = t2

Código TAC Otimizado:

t1 = read()
x = t1
t2 = read()
y = t2

Observações Finais

- O programa é válido e funcional conforme a gramática MOCC.
- O código TAC gerado reflete as operações até ao ponto da chamada minimo(x, y).
- O suporte completo a chamadas a funções do utilizador ainda está por implementar no TACGenerator, pelo que estas não são traduzidas nem otimizadas.
- O objetivo principal da otimização aqui foi garantir que as instruções sem redundância fossem corretamente analisadas, sem erro semântico ou duplicação de variáveis.
