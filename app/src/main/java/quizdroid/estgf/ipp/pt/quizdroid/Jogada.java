package quizdroid.estgf.ipp.pt.quizdroid;

/**
 * Created by DanyM on 20/12/2016.
 */

public class Jogada {

    private int id;
    private int idJogo;
    private int idPergunta;

    public Jogada(int id, int idJogo, int idPergunta) {
        this.id = id;
        this.idJogo = idJogo;
        this.idPergunta = idPergunta;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdJogo() {
        return idJogo;
    }

    public void setIdJogo(int idJogo) {
        this.idJogo = idJogo;
    }

    public int getIdPergunta() {
        return idPergunta;
    }

    public void setIdPergunta(int idPergunta) {
        this.idPergunta = idPergunta;
    }
}
