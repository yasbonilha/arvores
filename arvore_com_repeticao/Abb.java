public class Abb {
    private No raiz;
    public boolean estaVazia() {
        return raiz == null;
    }
    public void insere (int info) {
        if (estaVazia())
            raiz = new No(info);
        else 
            insereRec(info, raiz);
    }
    void insereRec (int info, No atual) {
        if (info == atual.getInfo()) //se i for igual ao elemento que está no na variavel atual, apenas incrementamos ele.
            atual.incrementaQuantidade();
        else if (info < atual.getInfo()) { //se ele for menor que o atual, ou procuramos ele mais para baixo da arvore, ou (se ele ainda nao existir) achamos um lugar para ele e criamos um no novo
            if (atual.getEsquerda() == null)
                atual.setEsquerda(new No(info));
            else 
                insereRec(info, atual.getEsquerda());
        }
        else {
            if (atual.getDireita() == null)
                atual.setDireita(new No(info));
            else 
                insereRec(info, atual.getDireita());
        }
    }
    public String toStringEmOrdem () {
        if (estaVazia()) return "arvore vazia";
        return toStringEmOrdemRec(raiz);
    }
    public String toStringEmOrdemRec (No atual) {
        if (atual == null) return "";
        
        String s = "";
        //sub-árvore da esquerda
        s += toStringEmOrdemRec(atual.getEsquerda());
        //raiz
        for (int i=1; i<=atual.getQuantidade(); i++)
            s += atual.getInfo() + " ";
        //sub-árvore da direita
        s += toStringEmOrdemRec(atual.getDireita());
        return s;
    }
    public int numeroNos () {//levar em consideracao que aqui é o numero de nos, nao o numero de elementos na arvore!!
        if (estaVazia())
            return 0;
        return numeroNosRec (raiz);
    }
    int numeroNosRec (No atual) {
        if (atual == null)
            return 0;
        return numeroNosRec(atual.getEsquerda()) + 1 + numeroNosRec(atual.getDireita());
    }
    public int altura () {
        if (estaVazia()) return 0;
        return alturaRec (raiz);
    }
    int alturaRec (No atual) {
        if (atual.getEsquerda() == null && atual.getDireita() == null)
            return 0;
        
        int nivelEsq = 0;
        if (atual.getEsquerda() != null) 
            nivelEsq = alturaRec(atual.getEsquerda());
 
        int nivelDir = atual.getDireita() != null ? alturaRec(atual.getDireita()) : 0;
 
        return nivelDir > nivelEsq ? nivelDir + 1 : nivelEsq + 1;
    }
}
 
 
 
 
 
 
 
