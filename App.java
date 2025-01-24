import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Bem vindo ao programa Separa Fila!");
        System.out.println("\n*Para encerrar o programa, ao invés de um nome e operação, digite: S");
        System.out.println("\nInforme uma sequência de nome e letra correspondente a uma opção válida (A, B ou X) em seguida, separados por espaço para definir as filas.");
        System.err.println("Exemplo de sequência com uma entrada por linha: \nLuis B \nPedro A \nLuisa A \nJoao X \nJose X \nMiguel B");

        // String op = "";

        Fila<Usuario> q = new Fila<>();

        String nomeOp = "";

        while (!nomeOp.equals("S") && !nomeOp.equals("s")) {
            System.out.println("\nNome e operação:");
            nomeOp = teclado.nextLine();

            if (nomeOp.split(" ").length > 1) {
                String nome = nomeOp.split(" ")[0];
                String op = nomeOp.split(" ")[1];
                q.enfileirar(new Usuario(nome, op));
            }

        }

        Fila<Usuario> filaA = new Fila<>();
        Fila<Usuario> filaB = new Fila<>();

        int tamanhoQ = q.getTamanho();

        System.out.println("\nOrdem de entrada nas filas:");

        for (int i = 0; i < tamanhoQ; i++) {
            Usuario u = q.desenfileirar();
            switch (u.operacao) {
                case "A":
                    filaA.enfileirar(u);
                    System.out.println(u.nome + " entrou na fila A.");
                    break;

                case "B":
                    filaB.enfileirar(u);
                    System.out.println(u.nome + " entrou na fila B.");
                    break;

                case "X":
                    if (filaA.getTamanho() == filaB.getTamanho()) {
                        System.out.println(u.nome + " descartado.");
                    } else if (filaA.getTamanho() > filaB.getTamanho()) {
                        filaB.enfileirar(u);
                        System.out.println(u.nome + " entrou na fila B.");
                    } else if (filaA.getTamanho() < filaB.getTamanho()) {
                        filaA.enfileirar(u);
                        System.out.println(u.nome + " entrou na fila A.");
                    }
                    break;
                default:
                    System.out.println("Operação inválida para " + u.nome + ".");
                    break;
            }
        }
    }
}
