package quizdroid.estgf.ipp.pt.quizdroid;

import android.content.SharedPreferences;
import android.net.Uri;
import android.os.PersistableBundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class JogoActivity extends AppCompatActivity implements View.OnClickListener {

    private ArrayList<Pergunta> listaPerguntas = new ArrayList<>();
    private int idPerguntaAtual;
    private Utilizador utilizador;
    private int idCategoria;
    private int idNivel;

    private SharedPreferences mSharedPreferences;

    private TextView pergunta;
    private TextView pontos;
    private Button btn1;
    private Button btn2;
    private Button btn3;
    private Button btn4;
    private ImageView btnAjudaHalf;
    private ImageView btnAjudaPublic;
    private ImageView btnAjudaPhone;




    @Override
    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        setContentView(R.layout.activity_main);

        initData();

        pergunta = (TextView)findViewById(R.id.txt_pergunta); // Bind Perguntas
        pontos = (TextView)findViewById(R.id.txt_pontos); // Bind Pontos

        //Bind Ajudas
        btnAjudaHalf = (ImageView)findViewById(R.id.half_help);
        btnAjudaPublic = (ImageView)findViewById(R.id.public_help);
        btnAjudaPhone = (ImageView)findViewById(R.id.phone_help);
        btnAjudaHalf.setOnClickListener(this);
        btnAjudaPublic.setOnClickListener(this);
        btnAjudaPhone.setOnClickListener(this);

        //Bind Respostas
        btn1 = (Button)findViewById(R.id.txt_resposta1);
        btn2 = (Button)findViewById(R.id.txt_resposta2);
        btn3 = (Button)findViewById(R.id.txt_resposta3);
        btn4 = (Button)findViewById(R.id.txt_resposta4);
        btn1.setOnClickListener(this);
        btn1.setOnClickListener(this);
        btn1.setOnClickListener(this);
        btn1.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {

    }

    private void initData(){

        mSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);

        idCategoria = mSharedPreferences.getInt("pref_categoria", 0);
        idNivel = mSharedPreferences.getInt("pref_nivel", 0);

        MyDbHelper dbHelper = new MyDbHelper(this);

        if(idCategoria == 0 && idNivel == 0 ){
            listaPerguntas = dbHelper.getPerguntasTodas(this);
        }else if(idCategoria != 0 && idNivel == 0){
            listaPerguntas = dbHelper.getPerguntasByCategoria(this, idCategoria);
        }else if(idCategoria == 0 && idNivel != 0){
            listaPerguntas = dbHelper.getPerguntasByNivel(this,idNivel);
        }else{
            listaPerguntas = dbHelper.getPerguntasByNivelAndCategoria(this,idNivel,idCategoria);
        }
        dbHelper.close();
    }

    private void setPergunta(String pergunta, String resposta1, String resposta2, String resposta3, String resposta4){
        this.pergunta.setText(pergunta);
        this.btn1.setText(resposta1);
        this.btn2.setText(resposta2);
        this.btn3.setText(resposta3);
        this.btn4.setText(resposta4);
    }

    private void isCorrect(String resposta){
        if(resposta.equals(listaPerguntas.get(idPerguntaAtual).getRespostaCerta())){
            //TODO: DIALOG: YEAH, ACERTASTE!!! Deseja continuar? (Botao SIM, Botao NAO)

            //TODO: GUARDAR NA BASE DE DADOS

            //TODO: ATUALIZAR PONTUACAO
            this.pontos.setText(Integer.parseInt(this.pontos.getText().toString()) + listaPerguntas.get(idPerguntaAtual).getPontuacao());

            //TODO: REMOVER PERGUNTA RESPONDIDA DO ARRAY
            listaPerguntas.remove(idPerguntaAtual);

            //TODO: FAZER RANDOM PARA ENCRONTRAR PROXIMA PERGUNTA
            Random random = new Random();
            idPerguntaAtual = random.nextInt(listaPerguntas.size() + 1);
            Pergunta proximaPergunta = listaPerguntas.get(idPerguntaAtual);


            //TODO: FAZER SET AOS TEXT VIEWS
            ArrayList<String> respostas = proximaPergunta.getRespostas();
            Collections.shuffle(respostas);
            setPergunta(proximaPergunta.getPergunta(),respostas.get(0),respostas.get(1),respostas.get(2), respostas.get(3));

        }else{
            //TODO: DIALOG: RESPOSTA ERRADA... (Botao "Ok")

            //TODO: METER JOGO COMO TERMINADO

        }
    }

}
