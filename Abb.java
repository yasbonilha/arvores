public class Abb {
    //BST - binary search tree - comportadas, mas nao necessariamente balanceadas
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


}
