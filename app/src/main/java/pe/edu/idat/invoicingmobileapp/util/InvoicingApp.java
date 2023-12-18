package pe.edu.idat.invoicingmobileapp.util;

import android.app.Application;
import android.content.Context;

public class InvoicingApp extends Application {
    private static InvoicingApp instancia;
    public static InvoicingApp getInstancia(){
        return instancia;
    }
    public static Context getContext(){
        return instancia;
    }
    @Override
    public void onCreate() {
        instancia = this;
        super.onCreate();
    }
}
