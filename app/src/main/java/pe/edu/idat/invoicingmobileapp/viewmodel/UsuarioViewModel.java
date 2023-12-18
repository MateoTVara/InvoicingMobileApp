package pe.edu.idat.invoicingmobileapp.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import pe.edu.idat.invoicingmobileapp.bd.entity.Usuario;
import pe.edu.idat.invoicingmobileapp.repository.UsuarioRepository;

public class UsuarioViewModel extends AndroidViewModel {

    private LiveData<Usuario> usuarioLiveData;
    private MutableLiveData<Usuario> usuarioSeleccionado = new MutableLiveData<>();
    private UsuarioRepository usuarioRepository;
    public UsuarioViewModel(@NonNull Application application) {
        super(application);
        usuarioRepository =  new UsuarioRepository(application);
    }

    public LiveData<Usuario> obtenerUsuario(){
        return usuarioRepository.obtenerUsuario();
    }
    public void insertarUsuario(Usuario usuario){usuarioRepository.registrarUsuario(usuario);}
    public void actualizarUsuario(Usuario usuario){usuarioRepository.actualizarUsuario(usuario);}
    public void eliminarUsuario(){usuarioRepository.eliminarUsuario();}

    public void setUsuarioSeleccionado(Usuario usuario) {
        usuarioSeleccionado.setValue(usuario);
    }

    public LiveData<Usuario> getUsuarioSeleccionado() {
        return usuarioSeleccionado;
    }

}
