package quizdroid.estgf.ipp.pt.quizdroid;

import android.content.Intent;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private Button btn_continue;
    private Button btn_play;
    private Button btn_play_custom;
    private Button btn_stats;
    private Button btn_battle;
    private Button btn_preferences;


    SharedPreferences mSettings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_continue = (Button) findViewById(R.id.btn_continuar);
        btn_continue.setOnClickListener(this);
        btn_play = (Button) findViewById(R.id.btn_play);
        btn_play.setOnClickListener(this);
        btn_play_custom = (Button) findViewById(R.id.btn_custom_play);
        btn_play_custom.setOnClickListener(this);
        btn_stats = (Button) findViewById(R.id.btn_stats);
        btn_stats.setOnClickListener(this);
        btn_battle = (Button) findViewById(R.id.btn_battle);
        btn_battle.setOnClickListener(this);
        btn_preferences = (Button) findViewById(R.id.btn_preferences);
        btn_preferences.setOnClickListener(this);

        //Preferencias

        mSettings = PreferenceManager.getDefaultSharedPreferences(this);

        //Aceder a DB
        MyDbHelper dbHelper = new MyDbHelper(this);
        SQLiteDatabase db = dbHelper.getReadableDatabase();


        dbHelper.close();
        db.close();

    }

    @Override
    protected void onResume() {
        super.onResume();
        mSettings = PreferenceManager.getDefaultSharedPreferences(this);
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.btn_continuar){
            /**TODO: Descobrir qual o tipo de jogo que tem pendente
                            e comecar essa activity mandando no putExtra("CONTINUAR", "SIM");
             */
        }else if(v.getId() == R.id.btn_play){
            Intent mIntent = new Intent(this, JogoActivity.class);
            startActivity(mIntent);
        }else if(v.getId() == R.id.btn_stats){
            Intent mIntent = new Intent(this, StatsActivity.class);
            startActivity(mIntent);
        }
    }
}
