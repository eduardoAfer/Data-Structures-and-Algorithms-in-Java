import java.util.*;

class ED007 {
    public static void main(String[] args) {
        Scanner stdin = new Scanner(System.in);
        MyStack<String> parametros = new LinkedListStack<String>();
        int N = stdin.nextInt();
        System.out.println(" N = " + N);
        int flag = 0;
        stdin.nextLine();

        for (int i = 0; i < N; i++) {
            String str = stdin.nextLine();
            // System.out.println(str);

            for (int j = 0; j < str.length(); j++) {

                if (str.charAt(j) != ' ' && str.charAt(j) != '+' && str.charAt(j) != '-' && str.charAt(j) != '*'
                        && str.charAt(j) != '/' && !isDigit(str.charAt(j))) {

                    if ((str.charAt(j) == ')' || str.charAt(j) == ']') && parametros.size() == 0) {
                        System.out.println("Erro na posicao " + j);
                        flag++;
                        break;
                    } else if ((str.charAt(j) == ']' && parametros.top().equals("("))
                            || (str.charAt(j) == ')' && parametros.top().equals("["))) {
                        System.out.println("Erro na posicao " + j);
                        flag++;
                        break;

                    }

                    else if (str.charAt(j) == '[') {
                        System.out.println("stack " + parametros + " j = " + str.charAt(j) + " em " + j);

                        parametros.push("[");

                    }

                    else if (str.charAt(j) == '(')
                        parametros.push("(");
                    else if (str.charAt(j) == ']' && parametros.top() == "[")
                        parametros.pop();
                    else if (str.charAt(j) == ')' && parametros.top() == "(")
                        parametros.pop();
                    // System.out.println("stack " + parametros + " j = " + str.charAt(j) + "em " +
                    // j);

                }
            }
            System.out.println("stack " + parametros);

            System.out.println("flag = " + flag);
            if (parametros.size() == 0 && flag == 0)
                System.out.println("Expressao bem formada");
            else if (flag == 0)
                System.out.println("Ficam parenteses por fechar");
            flag = 0;

        }

    }

    public static boolean isDigit(char a) {
        return (a >= '0' && a <= '9');

    }

}
