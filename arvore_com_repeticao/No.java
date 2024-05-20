public class No {
    private int info;
    private No esquerda;
    private No direita;
    private int quantidade; //quantidade de vezes que aquele elemento foi inserido na arvore
    
    public No(int info) {
        this.info = info;
        this.quantidade = 1; //ao ser inserido, ele está 1x na árvore
    }
 
    public int getInfo() {
        return info;
    }
 
    public void setInfo(int info) {
        this.info = info;
    }
 
    public No getEsquerda() {
        return esquerda;
    }
 
    public void setEsquerda(No esquerda) {
        this.esquerda = esquerda;
    }
 
    public No getDireita() {
        return direita;
    }
 
    public void setDireita(No direita) {
        this.direita = direita;
    }
 
    @Override
    public String toString() {
        return "[info = " + info + ", quantidade = " + quantidade + "]";
    }
 
    public void incrementaQuantidade() { //quando adicionamos aquele elemento mais uma vez na árvore, incrementamos a quantidade.
        quantidade++;
    }
    public void decrementaQuantidade() {
        quantidade--;
    }
 
    public int getQuantidade() {
        return quantidade;
    }
    
}