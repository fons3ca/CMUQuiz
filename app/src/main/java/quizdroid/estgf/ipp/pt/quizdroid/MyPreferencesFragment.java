package quizdroid.estgf.ipp.pt.quizdroid;

import android.content.Context;
import android.os.Bundle;
import android.preference.PreferenceFragment;

/**
 * Created by DanyM on 20/12/2016.
 */

public class MyPreferencesFragment extends PreferenceFragment{

    private Context mContext;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = getActivity();
        addPreferencesFromResource(R.xml.preference);

        //TODO: CODE HERE
    }

}
