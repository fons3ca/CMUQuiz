package quizdroid.estgf.ipp.pt.quizdroid;

/**
 * Created by DanyM on 20/12/2016.
 */

public class Utilizador {

    private int id;
    private String nome;
    private String password;
    private int perguntasRespondidas;
    private int respostasCorretas;
    private int jogosTerminados;

    public Utilizador(int id, String nome, String password, int perguntasRespondidas, int respostasCorretas, int jogosTerminados) {
        this.id = id;
        this.nome = nome;
        this.password = password;
        this.perguntasRespondidas = perguntasRespondidas;
        this.respostasCorretas = respostasCorretas;
        this.jogosTerminados = jogosTerminados;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getPerguntasRespondidas() {
        return perguntasRespondidas;
    }

    public void setPerguntasRespondidas(int perguntasRespondidas) {
        this.perguntasRespondidas = perguntasRespondidas;
    }

    public int getRespostasCorretas() {
        return respostasCorretas;
    }

    public void setRespostasCorretas(int respostasCorretas) {
        this.respostasCorretas = respostasCorretas;
    }

    public int getJogosTerminados() {
        return jogosTerminados;
    }

    public void setJogosTerminados(int jogosTerminados) {
        this.jogosTerminados = jogosTerminados;
    }
}
