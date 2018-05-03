package org.nuhadif.emunogu;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by adifdermawan on 28/04/2018.
 */

public class PrefManager {
    private Context mContext;

    private SharedPreferences pref;
    private SharedPreferences.Editor editor ;
    public static final String FLAG_BAB = "lastBabCompleted";
    public PrefManager(Context mContext) {
        this.mContext = mContext;
        pref = mContext.getSharedPreferences("MyPref", 0); // 0 - for private mode
        editor = pref.edit();
    }

    public void setLastBab(int bab){
        editor.putInt(FLAG_BAB,bab);
        editor.apply();
    }

    public int getLastBab(){
        return pref.getInt(FLAG_BAB,1);
    }
}
