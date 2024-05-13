import java.util.Random;

public class TesteABB{
    public static void main(String[] args) {
        Random r = new Random();
        Abb abb = new Abb();

        for (int i = 1; i <= 12; i++){
            int num = r.nextInt(100);
            System.out.print(num + " ");
            abb.insere(num);
        }

        System.out.println(abb.toStringEmOrdem());
    }
}