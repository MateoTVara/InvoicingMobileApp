package pe.edu.idat.invoicingmobileapp.util;

import android.content.SharedPreferences;

public class SharedPreferencesManager {

    private static final String APP_SETTINGS_FILE ="APP_SETTINGS";
    public SharedPreferencesManager(){
    }
    public static SharedPreferences getSharedPreferences(){
        return InvoicingApp.getContext().getSharedPreferences(APP_SETTINGS_FILE,
                InvoicingApp.MODE_PRIVATE);
    }
    public static void setStringValue(String clave, String valor){
        SharedPreferences.Editor editor = getSharedPreferences().edit();
        editor.putString(clave, valor);
        editor.commit();
    }
    public static void setBooleanValue(String clave, Boolean valor){
        SharedPreferences.Editor editor = getSharedPreferences().edit();
        editor.putBoolean(clave, valor);
        editor.commit();
    }
    public static String getStringValue(String clave){
        return getSharedPreferences().getString(clave, "");
    }
    public static Boolean getBooleaValue(String clave){
        return getSharedPreferences().getBoolean(clave, false);
    }
}
