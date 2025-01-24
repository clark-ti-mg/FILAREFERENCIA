import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Bem vindo ao programa Separa Fila!");
        System.out.println("Informe uma sequência de nome e letra correspondente a uma opção válida (A, B ou X) em seguida, separados por espaço para definir as filas.");
        System.err.println("Exemplo: \nLuis B Pedro A Luisa A Joao X Jose X Miguel B");

        //String op = "";

        Fila<Usuario> q = new Fila<>();

        String nomeOp = "";

        while(!nomeOp.equals("S") && !nomeOp.equals("s")){
            System.out.println("Nome e operação:");
            nomeOp = teclado.nextLine();

            if(nomeOp.split(" ").length>1){
                String nome = nomeOp.split(" ")[0];
                String op = nomeOp.split(" ")[1];
                q.enfileirar(new Usuario(nome, op));
            }
            
        }

        Fila<Usuario> filaA = new Fila<>();
        Fila<Usuario> filaB = new Fila<>();

        int tamanhoQ = q.getTamanho();

        for(int i = 0; i < tamanhoQ; i++){
            Usuario u = q.desenfileirar();
            if(u.operacao.equals("A")){
                filaA.enfileirar(u);
                System.out.println(u.nome + " entrou na fila A.");
            }
            if(u.operacao.equals("B")){
                filaB.enfileirar(u);
                System.out.println(u.nome + " entrou na fila B.");
            }
            if(u.operacao.equals("X")){
                if(filaA.getTamanho() == filaB.getTamanho()){
                    System.out.println(u.nome + " descartado.");
                }else if(filaA.getTamanho() > filaB.getTamanho()) {
                    filaB.enfileirar(u);
                    System.out.println(u.nome + " entrou na fila B.");
                }else if(filaA.getTamanho() < filaB.getTamanho()){
                    filaA.enfileirar(u);
                    System.out.println(u.nome + " entrou na fila A.");
                }
            }
        }

        
    }
}
