package pe.edu.idat.invoicingmobileapp.bd.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import pe.edu.idat.invoicingmobileapp.bd.entity.Pedido;
import pe.edu.idat.invoicingmobileapp.bd.entity.Usuario;

@Dao
public interface UsuarioDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insertar(Usuario usuario);
    @Update
    void actualizar(Usuario usuario);
    @Query("DELETE FROM usuario")
    void eliminar();
    @Query("SELECT * FROM usuario LIMIT 1")
    LiveData<Usuario> obtener();

}
