package quizdroid.estgf.ipp.pt.quizdroid;

import java.util.ArrayList;

/**
 * Created by DanyM on 20/12/2016.
 */

public class Pergunta {

    private int id;
    private int idNivel;
    private String pergunta;
    private ArrayList<String> respostas;
    private String respostaCerta;
    private int pontuacao;
    private int idCategoria;

    public Pergunta(int id, int idNivel, String pergunta, String resposta1, String resposta2, String resposta3, String resposta4, String respostaCerta, int pontuacao, int idCategoria) {
        this.id = id;
        this.idNivel = idNivel;
        this.pergunta = pergunta;
        this.respostas = new ArrayList<>();
        this.respostas.add(resposta1);
        this.respostas.add(resposta2);
        this.respostas.add(resposta3);
        this.respostas.add(resposta4);
        this.respostaCerta = respostaCerta;
        this.pontuacao = pontuacao;
        this.idCategoria = idCategoria;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdNivel() {
        return idNivel;
    }

    public void setIdNivel(int idNivel) {
        this.idNivel = idNivel;
    }

    public String getPergunta() {
        return pergunta;
    }

    public void setPergunta(String pergunta) {
        this.pergunta = pergunta;
    }

    public ArrayList<String> getRespostas() {
        return respostas;
    }

    public void setRespostas(ArrayList<String> respostas) {
        this.respostas = respostas;
    }

    public String getRespostaCerta() {
        return respostaCerta;
    }

    public void setRespostaCerta(String respostaCerta) {
        this.respostaCerta = respostaCerta;
    }

    public int getPontuacao() {
        return pontuacao;
    }

    public void setPontuacao(int pontuacao) {
        this.pontuacao = pontuacao;
    }

    public int getCategoria() {
        return idCategoria;
    }

    public void setCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }
}
