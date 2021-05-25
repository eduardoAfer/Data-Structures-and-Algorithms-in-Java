import java.util.*;

class Cliente {
    String NOME;
    int SEGUNDO_CHEGADA, NUMERO_PRODUTOS;

    Cliente(String NOME, int SEGUNDO_CHEGADA, int NUMERO_PRODUTOS) {
        this.NOME = NOME;
        this.SEGUNDO_CHEGADA = SEGUNDO_CHEGADA;
        this.NUMERO_PRODUTOS = NUMERO_PRODUTOS;
    }
}

class FilaAtendimento {
    int K;
    MyQueue<Clientes> fila;

    FilaAtendimento(int K) {
        fila = new LinkedListQueue<Clientes>();
        this.K = K;
    }
}

class ED115 {

    private static FilaAtendinento atendimentoCaixas[];

    public static void flag1(Scanner stdin, int qntCaixas) {

        atendimentoCaixas = new FilaAtendimento[qntCaixas];
        for (int i = 0; i < qntCaixas; i++) {
            int K = stdin.nextInt();

            atendimentoCaixas[i] = new FilaAtendimento(K);
        }

        int qntClientes = stdin.nextInt();
        for (int i = 0; i < qntClientes; i++) {
            String nome = stdin.next();
            int SEGUNDO_CHEGADA = stdin.nextInt();
            int NUMERO_PRODUTOS = stdin.nextInt();
            Cliente aux = new Clientes(NOME, SEGUNDO_CHEGADA, NUMERO_PRODUTOS);

        }

    }

    public void main(String[] args) {

        Scanner stdin = new Scanner(System.in);
        int flag = stdin.nextInt();

        if (flag == 1)
            flag1(stdin, 1);
        else {
            int qntCaixas = stdin.nextInt();
            flag1(stdin, qntCaixas);
        }

    }
}