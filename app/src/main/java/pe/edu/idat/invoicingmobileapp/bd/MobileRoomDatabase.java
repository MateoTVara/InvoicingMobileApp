package pe.edu.idat.invoicingmobileapp.bd;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import pe.edu.idat.invoicingmobileapp.bd.dao.PedidoDao;
import pe.edu.idat.invoicingmobileapp.bd.dao.UsuarioDao;
import pe.edu.idat.invoicingmobileapp.bd.entity.Pedido;
import pe.edu.idat.invoicingmobileapp.bd.entity.Usuario;

@Database(entities = {Pedido.class, Usuario.class}, version=1)
public abstract class MobileRoomDatabase extends RoomDatabase {

    public abstract PedidoDao pedidoDao();
    public abstract UsuarioDao usuarioDao();
    private static volatile MobileRoomDatabase INSTANCIA;
    public static MobileRoomDatabase getDatabase(final Context context){
        if (INSTANCIA == null){
            synchronized (MobileRoomDatabase.class){
                if (INSTANCIA == null){
                    INSTANCIA = Room.databaseBuilder(
                            context.getApplicationContext(),
                            MobileRoomDatabase.class,
                                    "mobilebd")
                            .build();
                }
            }
        }
        return INSTANCIA;
    }

}
