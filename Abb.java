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


}
