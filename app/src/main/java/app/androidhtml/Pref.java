package app.androidhtml;

import android.content.Context;
import android.content.SharedPreferences;

public class Pref {
    public static final String PREF_ID = "settings";

    public static void setBoolean(Context context, String key, boolean value) {
        SharedPreferences pref = context.getSharedPreferences(PREF_ID, 0);
        SharedPreferences.Editor editor = pref.edit();
        editor.putBoolean(key, value);
        editor.commit();
    }

    public static boolean getBoolean(Context context, String key) {
        SharedPreferences pref = context.getSharedPreferences(PREF_ID, 0);
        return pref.getBoolean(key, false);
    }

    public static void setInteger(Context context, String key, int value) {
        SharedPreferences pref = context.getSharedPreferences(PREF_ID, 0);
        SharedPreferences.Editor editor = pref.edit();
        editor.putInt(key, value);
        editor.commit();
    }

    public static int getInteger(Context context, String key) {
        SharedPreferences pref = context.getSharedPreferences(PREF_ID, 0);
        return pref.getInt(key, 0);
    }

    public static void setString(Context context, String key, String value) {
        SharedPreferences pref = context.getSharedPreferences(PREF_ID, 0);
        SharedPreferences.Editor editor = pref.edit();
        editor.putString(key, value);
        editor.commit();
    }

    public static String getString(Context context, String key) {
        SharedPreferences pref = context.getSharedPreferences(PREF_ID, 0);
        return pref.getString(key, "");
    }
}
