import java.util.*;

public class TestMyQueue {
    public static void main(String[] args) {
        Scanner stdin = new Scanner(System.in);
        int n = stdin.nextInt();
        // Criacao da fila
        MyQueue<String> q = new LinkedListQueue<String>();
        MyQueue<String> a = new LinkedListQueue<String>();
        MyQueue<String> b = new LinkedListQueue<String>();

        // Exemplo de insercao de elementos na fila
        for (int i = 1; i < n; i++) {
            String dado = stdin.next();
            q.enqueue(dado);
        }

        System.out.println(q);

        ED196.process(q, a, b);
        System.out.println("q = " + q);
        System.out.println("a = " + a);
        System.out.println("b = " + b);

    }
}