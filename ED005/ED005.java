import java.util.*;

public class ED005 {

    public static void main(String[] args) {
        Scanner stdin = new Scanner(System.in);

        MyStack<String> operacoes = new LinkedListStack<String>();
        int N = stdin.nextInt();

        for (int i = 0; i < N; i++) {
            String variavel = stdin.next();

            while (!variavel.equals("\n")) {
                Integer valor = Integer.valueOf(variavel);

                if (valor >= 0 && valor <= 9)
                    operacoes.push(stdin.next());
                else {
                    if (variavel.equals("+")) {
                        Integer var1 = Integer.valueOf(operacoes.pop());
                        Integer var2 = Integer.valueOf(operacoes.pop());
                        var2 += var1;
                        operacoes.push(String.valueOf(var2));
                    } else if (variavel.equals("-")) {
                        Integer var1 = Integer.valueOf(operacoes.pop());
                        Integer var2 = Integer.valueOf(operacoes.pop());
                        var2 -= var1;
                        operacoes.push(String.valueOf(var2));
                    } else if (variavel.equals("*")) {
                        Integer var1 = Integer.valueOf(operacoes.pop());
                        Integer var2 = Integer.valueOf(operacoes.pop());
                        var2 *= var1;
                        operacoes.push(String.valueOf(var2));
                    } else if (variavel.equals("/")) {
                        Integer var1 = Integer.valueOf(operacoes.pop());
                        Integer var2 = Integer.valueOf(operacoes.pop());
                        var2 /= var1;
                        operacoes.push(String.valueOf(var2));
                    }

                }
                variavel = stdin.next();

            }
            if (isNumeric(operacoes.top()))
                System.out.println(operacoes.top());
            else
                System.out.println("Expressao Incorrecta");

        }
    }

    public static boolean isNumeric(String str) {
        return str != null && str.matches("[-+]?\\d*\\.?\\d+");
    }
}
