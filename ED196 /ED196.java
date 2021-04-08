
import java.util.*;

public class ED196 {

    public static void process(MyQueue<String> q, MyQueue<String> a, MyQueue<String> b) {
        String[] data = new String[2];
        int tamanho = q.size();
        tamanho /= 2;
        for (int i = 0; i < tamanho; i++) {
            data[0] = q.dequeue();
            data[1] = q.dequeue();
            if (data[1].equals("A"))
                a.enqueue(data[0]);
            else if (data[0].equals("B"))
                b.enqueue(data[0]);
            else {
                if (a.size() < b.size())
                    a.enqueue(data[0]);
                else
                    b.enqueue(data[0]);
            }
        }

    }
}
