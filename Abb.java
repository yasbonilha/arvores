public class Abb {
    //BST - binary search tree - comportadas, mas nao necessariamente balanceadas
    //pode ser qualquer tipo de dado que possa ser ordenado
    //definição recursiva - todo nó é a raiz de uma subarvore
    //verificar repetição por árvore é muito mais barato computacionalmente - podemos colocar o numero de vezes que ele aparece no no ou podemos colocá-lo de novo, mas a primeira opção é melhor porque voce nao precisa ficar varrendo a lista toda para achar.
    //se olharmos uma a uma em um vetor- complexidade de bubble sort, pois temos que comparar todo mundo com todo mundo. já na abb, descartamos metade da amostra atual a cada passo, o que otimiza a busca. temos associado a cada elemento uma lista ligada (no caso do exemplo de compactação de imagem, por exemplo) que diz todas as posições que o elemento aparece
    //como percorrer uma arvore - começa pela raiz e vai para os galhos. podemos percorrer pela pré-ordem (começa pela raiz, vai todas da esquerda e depois todas da direita), ou pela pós ordem (ao contrario). isso é chamado busca pela profundidade. passamos a raiz da arvore como parametro, mas so processamos ela depois que varremos a subarvore da esquerda
    //numero igual à raiz ou vai estar logo na esquerda ou vai ser o ultimo filho da direita da subarvore da esquerda (quando colocamos o elemento de novo). se colocarmos a lista ligada para cada elemento, quando formos printar, temos que printar aquele elemento o numero de vezes que  lista diz


    //codigo duplicado - colocar um atributo quantidade e no construtor vai ser um. - quando o nó nasce, ele só é vito uma vez até agora
    //public void incrementaquantidade e decrementaquantidade.
    //mudamos o tostring porque queremos saber quantas vezes ele aparece (exatamente o que está escrito na anotação aqui em cima)
    // é que agora eu só penso em voceeeeê, nao é que eu esteja apaixonado, eu to falando seerio, eu nao quero ninguem mas se voce quiser eu quero (tchu tchuru tchurutchu tchu tchuru tchurutchu)

    // String toStringEmOrdemRec (No atual) {
    //     if (atual == null)
    //         return "";
    //     String s = "";

    //     s = s + toStringEmOrdemRec(atual.getEsquerda());
    //     for (int i=1; i <= atual.getQuantidade(); i++){
    //         s = s + atual.getInfo() + " ";
    //     }
    //     s = s + toStringEmOrdemRec(atual.getDireita());
    //     return s;

    // } //além disso, tem que colocar o quantidade no arquivo nó do codigo duplicado e criar um getQuantidade()

    private No raiz; //elemento de controle - construtor padrao começa null se nao houver gente


    public boolean estaVazia() {
        return raiz==null;
    }

    public void insere(int i){
        //so o que importa para o usuario e que ele esta colocando um inteiro. nao importa que isso bai virar um no depois

        No novo = new No(i);
            if(estaVazia())
                raiz = novo;
            else 
                insereRec(novo, raiz); //passamos o No e a posição que vamos adotar como parametro - a descida sera recursiva e a direção vai ser a comparação (nesse caso, de maior menor)
        }

        public void insereRec(No novo, No atual){
            if (atual !=  null){
                if (novo.getInfo() <= atual.getInfo()){
                    if(atual.getEsquerda() == null){
                        atual.setEsquerda(novo);
                    }
                    else{
                        insereRec(novo, atual.getEsquerda());
                    }
                } else{
                    if(atual.getDireita() == null){
                        atual.setDireita(novo);
                    }
                    else{
                        insereRec(novo, atual.getDireita());
                }
            }
        }
    }

    //nao é override porque é um processamento em arvore. estamos fazendo um tostring mas poderia ser qualquer tipo de processamento
    //o toString da estrutura sempre vai dar uma dica de como fazemos a varredura dessa estrutura
    public String toStringEmOrdem() {
        if(estaVazia())
            return "arvore vazia";
        return toStringEmOrdemRec(raiz);
    }

    String toStringEmOrdemRec ( No atual ) {
        if ( atual == null ) { //temos que perguntar pois a subarvore de aalguma raiz pode ser null (a subarvore acabou)
            return "";
        }
        return toStringEmOrdemRec(atual.getEsquerda()) + atual.getInfo() + " " + toStringEmOrdemRec(atual.getDireita()); //aqui estamos criando uma arvore de fibonacci basicamente. primeiro ele vai pegar tudo que esta à esquerda, depois vai pegar a informação da raiz, depois vai pegar todas as informações da direita.
    }

    public int numeroNos (){
        if (estaVazia()) {
            return 0;
        }
        return numeroNosRec(raiz);
    }

    //para achar a quantidade de nos, o metodo varre a subarvore da esquerda e conta todos os nos, pega a raiz (1 no) e varre a subarvore da direita
    int numeroNosRec (No atual) {
        if (atual == null) return 0;
        return numeroNosRec(atual.getEsquerda()) + 1 + numeroNosRec(atual.getDireita());
    }

    public int altura() {
        if (estaVazia()) return 0;
        return alturaRec(raiz);
    }

    int alturaRec( No atual) { // a recursao é um problema de implementação do desenvolvedor!! o usuário não precisa saber como estamos fazendo o que ele quer.
        if (atual.getEsquerda() == null && atual.getDireita() == null) return 0;

        int nivelEsq = 0;
        if (atual.getEsquerda() != null) {
            nivelEsq = alturaRec(atual.getEsquerda());
        }

        int nivelDir = atual.getDireita()!= null ? alturaRec(atual.getDireita()) : 0;

        return nivelDir > nivelEsq ? nivelDir + 1 : nivelEsq + 1;
        //vai pegar a subarvore que tem mais niveis (que corresponde ao nivel real da arvore)
    }

    public boolean busca (int x) {
        if (estaVazia()) return false;
        return buscaRec( x, raiz);
    }

    boolean buscaRec(int x, No atual) { //aqu ja fizemos a avaliacao de se esta vazia ou nao
        // podemos fazer dos dois jeitos, os dois estao corretos e possuem o mesmo desempenho. a unica coisa é que temos que escolher como que fazemos para fazer igual dos dois lados para nao azedar a recursao. o primeiro metodo requer a verificaçao antes da chamada. já o modo dois faz a verificacao do no na chegada da chamada.

        //metodo 1
        // if (x == atual.getInfo()) return true;
        // if (x <= atual.getInfo())
        //     if (atual.getEsquerda() != null) //so podemos entrar mais na arvore se a subarvore nao for nula!
        //         return buscaRec(x, atual.getEsquerda());
        //         else return false;

        
        //metodo 2 - achamos a legibilidade um pouco melhor, a machion disse que gosta mais porque acha que temos mais controle. ainda podemos nomear uma variavel local para armazenar a informação do atual e tirar o = do <= da condicao do if - já que ja testamos essa possibilidade na linha de cima
        if (atual == null) return false;
        if (atual.getInfo() == x) return true;
        if (x <= atual.getInfo()) return buscaRec(x, atual.getEsquerda());
        return buscaRec(x, atual.getDireita());
            
    }

    //algumas implementações optam por nao remover os nos da arvore, so definir um atributo para se eles estao ativos ou nao. dessa forma, eles ainda participam da arvore quando vamos procurar algum lugar para inserir um novo elemento, mas na hora de mostrar a arvore so levamos em consideracao os nos ativos
    public boolean remocao(int x) {
        if(estaVazia()) return false;
        return remocaoRec(x, raiz, null, false);
    }

    //flag eFilhoEsquerdo indica se ele é filho da esquerda ou nao. no caso de ser raiz, ele va ser falso, mas nao vai ser usado (porque a raiz nao é filha)
    //temos que fazer a verificação de se for raiz para qualquer caso de numero de filhos
    boolean remocaoRec(int x, No atual, No pai, boolean eFilhoEsquerdo){
        //quando vamos remover um elemento, quem sera atualizado sera o pai dele. logo, para remove-lo, teremos que saber quem era o pai dele. faremos a primeira versao considerando que o elemento a ser removido nao é a raiz e que nao temos o pai armazenado nos atributos do no - mais facil
        if (atual == null) return false;
        if (atual.getInfo() == x) {
            if(atual.getEsquerda() == null && atual.getDireita() == null) { // no a ser removido nao tem filhos
                if(atual == raiz) //se ele nao tiver filhos e for excluida, nao existe mais arvore (a raiz vira null)
                    raiz = null;
                if( eFilhoEsquerdo )
                    pai.setEsquerda(null);
                else
                    pai.setDireita(null);
            }
            else{
                if (atual.getEsquerda() == null) { //como ele passou do primeiro if, significa que ele so tem filho da direita
                    if (atual == raiz) 
                        raiz = atual.getDireita();
                    else if(eFilhoEsquerdo)
                        pai.setEsquerda(atual.getDireita());
                    else pai.setDireita(atual.getDireita());
                }
                else if (atual.getDireita() == null) { // so tem filho da esquerda (temos que colocar dessa forma porque ele pode ter filhos dos dois lados)
                    if (atual == raiz) 
                        raiz = atual.getEsquerda();
                    else if(eFilhoEsquerdo)
                        pai.setEsquerda(atual.getEsquerda());
                    else pai.setDireita(atual.getEsquerda());
                }
                else{ //tem os dois filhos - o sucessor é o menor valor maior que o número a ser removido. isso garante que o atributo esquerda seja nulo, ou seja, esteja disponível (palavras da grande machion) - vamos pendurar a subarvore da esquerda do pai do elemento no braço livre da esquerda do sucessor (menor valor maior que o número a ser removido). enquanto isso, o braco direito do elemento a ser removido vai ser "doado" para o braço esquerdo do valor pai do elemento a ser removido (ou seja, pai do pai). = tudo isso para um no que é removido à esquerda
                // a subarvore da direita do no a ser removido vai ser sub (dir/esq) do pai e a subarvore da esquerda do no a ser removido vai ser a subarvore da esquerda do sucessor (sendo que esquerda ou direita depende do eFilhoEsquerda)
                //a subarvore da esquerda é adotada pelo sucessor (sucessor é o menor entre os maiores que o atual - o menor filho da subarvore da direita)
                    No sucessor = atual.getDireita();
                    while ( sucessor.getEsquerda() != null) {
                        sucessor = sucessor.getEsquerda(); //nao precisa ser recursivo porque eu estou andando em uma direcao so
                    }
                    sucessor.setEsquerda(atual.getEsquerda()); //criamos uma ligação entre o menor elemento da subarvore da direita (o sucessor) e a subarvore da esquerda do elemento a ser removido
                    
                    //a subarvore da direita é adotada pelo pai ou é a raiz (a raiz vai ser a subarvore da direita)
                    if(pai == null) {
                        raiz = atual.getDireita();
                    } else if (eFilhoEsquerdo) { //porque se ele nao tem pai, ele é a raiz. logo, se nao colocarmos else if, ele vai cair no ultimo else e vai dar nullpointer exception
                        pai.setEsquerda(atual.getDireita());
                    } else {
                        pai.setDireita(atual.getDireita());
                    }
                }
            }
            return true;
        }
        else if ( x < atual.getInfo()){
            eFilhoEsquerdo = true;
            pai = atual; //vamos passar o atual como pai e dizer que o filho é da esquerda (é assim que fazemos a atribuição dessas variaveis)
            return remocaoRec(x, atual.getEsquerda(), pai, eFilhoEsquerdo);

        }else{ //x é maior
            eFilhoEsquerdo = false;
            pai = atual;
            return remocaoRec(x, atual.getDireita(), pai, eFilhoEsquerdo);


        }
    }

}
