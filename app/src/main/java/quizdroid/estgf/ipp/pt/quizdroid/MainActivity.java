package quizdroid.estgf.ipp.pt.quizdroid;

import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    SharedPreferences mSettings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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
}
