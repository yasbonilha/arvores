import java.util.Random;

public class TesteABB{
    public static void main(String[] args) {
        Random r = new Random();
        Abb abb = new Abb();

        int total = r.nextInt(1500) + 50;
        System.out.println("total: " + total);

        for (int i = 1; i <= 12; i++){
            int num = r.nextInt(100);
            System.out.print(num + " ");
            abb.insere(num);
        }

        //toString
        System.out.println(abb.toStringEmOrdem());

        //numero de nos e altura        
        System.out.println("\n numero de nos: " + abb.numeroNos());
        System.out.println("\n altura:" + abb.altura());

        //busca
        int x = r.nextInt(total) + 1;
        if(abb.busca(x)){
            System.out.println(x + " esta na arvore");
        } else {
            System.out.println(x + " nao encontrado");
        }

        //remocao
        if(abb.remocao(x))
            System.out.println(x + " removido");
        else
            System.out.println(x + " nao encontrado");
        
    }
}