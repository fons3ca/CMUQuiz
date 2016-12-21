package quizdroid.estgf.ipp.pt.quizdroid;

/**
 * Created by DanyM on 20/12/2016.
 */

public class Jogo {

    private int id;
    private int idNivel;
    private int idCategoria;
    private int idUtilizador;
    private int ajudaPublico;
    private int ajudaTelefone;
    private int ajuda50_50;
    private int jogoTerminado;
    private int pontuacao;

    public Jogo(int id, int idNivel, int idCategoria, int idUtilizador, int ajudaPublico, int ajudaTelefone, int ajuda50_50, int jogoTerminado, int pontuacao) {
        this.id = id;
        this.idNivel = idNivel;
        this.idCategoria = idCategoria;
        this.idUtilizador = idUtilizador;
        this.ajudaPublico = ajudaPublico;
        this.ajudaTelefone = ajudaTelefone;
        this.ajuda50_50 = ajuda50_50;
        this.jogoTerminado = jogoTerminado;
        this.pontuacao = pontuacao;
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

    public int getIdUtilizador() {
        return idUtilizador;
    }

    public void setIdUtilizador(int idUtilizador) {
        this.idUtilizador = idUtilizador;
    }

    public int getAjudaPublico() {
        return ajudaPublico;
    }

    public void setAjudaPublico(boolean ajudaPublico) {
        this.ajudaPublico = castBoolToInt(ajudaPublico);
    }

    public int getAjudaTelefone() {
        return ajudaTelefone;
    }

    public void setAjudaTelefone(boolean ajudaTelefone) {
        this.ajudaTelefone = castBoolToInt(ajudaTelefone);
    }

    public int getAjuda50_50() {
        return ajuda50_50;
    }

    public void setAjuda50_50(boolean ajuda50_50) {
        this.ajuda50_50 = castBoolToInt(ajuda50_50);
    }

    public int getJogoTerminado() {
        return jogoTerminado;
    }

    public void setJogoTerminado(boolean jogoTerminado) {
        this.jogoTerminado = castBoolToInt(jogoTerminado);
    }

    public int getPontuacao() {
        return pontuacao;
    }

    public void setPontuacao(int pontuacao) {
        this.pontuacao = pontuacao;
    }

    // Metodos Booleans

    public boolean getJogoTerminadoBool() {
        return castIntToBool(jogoTerminado);
    }

    public boolean getAjuda50_50Bool() {
        return castIntToBool(ajuda50_50);
    }

    public boolean getAjudaTelefoneBool() {
        return castIntToBool(ajudaTelefone);
    }

    public boolean getAjudaPublicoBool() {
        return castIntToBool(ajudaPublico);
    }

    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

    //Metodos Casts

    private int castBoolToInt(boolean input){
        if(input){
            return 1;
        }else{
            return 0;
        }
    }

    private boolean castIntToBool(int input){
        if(input == 1){
            return true;
        }else if(input == 0){
            return false;
        }
        System.err.println("ERROR: CAST INT TO BOOL");
        return false;
    }

}
