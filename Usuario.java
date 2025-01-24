public class Usuario extends FilaBase {
    Usuario prox;
    String nome;
    String operacao;

    Usuario(String nome, String operacao){
        this.nome = nome;
        this.operacao = operacao;
        this.prox = null;
    }

    public void setProximo(FilaBase el){
        this.prox = (Usuario)el;
    }
    public FilaBase getProximo(){
        return this.prox;
    }
}
