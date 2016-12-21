package quizdroid.estgf.ipp.pt.quizdroid;

import android.content.SharedPreferences;
import android.net.Uri;
import android.os.PersistableBundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;

import java.util.ArrayList;

public class JogoActivity extends AppCompatActivity implements View.OnClickListener {

    private ArrayList<Pergunta> listaPerguntas = new ArrayList<>();
    private int idPerguntaAtual;
    private Utilizador utilizador;
    private int idCategoria;
    private int idNivel;
    private SharedPreferences mSharedPreferences;


    @Override
    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        setContentView(R.layout.activity_main);
        mSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);

    }

    @Override
    public void onClick(View v) {

    }

    private void isCorrect(String resposta){
        if(resposta.equals(listaPerguntas.get(idPerguntaAtual).getRespostaCerta())){
            //TODO: YEAH, ACERTASTE!!!

            //TODO: GUARDAR NA BASE DE DADOS

            //TODO: ATUALIZAR PONTUACAO

            //TODO: REMOVER PERGUNTA RESPONDIDA DO ARRAY

            //TODO: FAZER RANDOM PARA ENCRONTRAR PROXIMA PERGUNTA

            //TODO: FAZER SET AOS TEXT VIEWS
        }else{
            //TODO: U ARE A NOOB!!!

            //TODO: METER JOGO COMO TERMINADO

            //TODO:
        }
    }

}
