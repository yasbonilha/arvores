public class No {
    //e claro que poderia por ra, nome, etc

    private int info;
    private No esquerda; //definição recursiva - filho da esquerda
    private No direita; //definição recursiva - filho da direita

    //geração de cofigo no vscode so gera os padroes, se houver alguma regra de negocio temos qu colocar
    public No(int info){
        this.info = info;
    }

    public void setInfo(int info) {
        this.info = info;
    }

    public void setEsquerda(No esquerda) {
        this.esquerda = esquerda;
    }

    public void setDireita(No direita) {
        this.direita = direita;
    }

    public int getInfo() {
        return info;
    }

    public No getEsquerda() {
        return esquerda;
    }

    public No getDireita() {
        return direita;
    }

    @Override
    public String toString() {
        return "[" + info + "]";
    }
    
    //quando temos a referencia dele, podemos amarrar a informação na arvore, da mesma forma que amarramos um enfeite na arvore de natal

    //logica de inserção - se a estrutura é recursiva, entao os metodos de manipulação tem que ser recursiva tb

}
