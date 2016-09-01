package ifpb.pos.android;

/**
 * Created by job on 30/08/16.
 */
public class Usuario {
    private String nome;
    private int idade;


    public Usuario() {

    }
    public Usuario(String nome, int idade){
        this.nome= nome;
        this.idade = idade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    @Override
    public String toString() {
        return String.format("nome:%s, idade:%d",nome,idade);
    }

    public static Usuario empty() {
        return new Usuario("NULL", -1);
    }
}
