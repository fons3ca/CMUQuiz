package quizdroid.estgf.ipp.pt.quizdroid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class PreferenceActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getFragmentManager().beginTransaction().replace(android.R.id.content, new MyPreferencesFragment()).commit();
    }
}
