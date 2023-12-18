package pe.edu.idat.invoicingmobileapp.repository;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import pe.edu.idat.invoicingmobileapp.bd.MobileRoomDatabase;
import pe.edu.idat.invoicingmobileapp.bd.dao.UsuarioDao;
import pe.edu.idat.invoicingmobileapp.bd.dao.UsuarioDao;
import pe.edu.idat.invoicingmobileapp.bd.entity.Usuario;

public class UsuarioRepository {

    private UsuarioDao usuarioDao;

    public UsuarioRepository(Application application){
        MobileRoomDatabase db = MobileRoomDatabase.getDatabase(application);
        usuarioDao = db.usuarioDao();
    }

    public LiveData<Usuario> obtenerUsuario(){return usuarioDao.obtener();}

    public void registrarUsuario(Usuario usuario){
        new UsuarioRepository.registrarAsyncTask(usuarioDao).execute(usuario);
    }

    private static class registrarAsyncTask
            extends AsyncTask<Usuario,Void, Void> {
        private UsuarioDao usuarioDao;
        registrarAsyncTask(UsuarioDao _usuarioDao){usuarioDao = _usuarioDao;}
        @Override
        protected Void doInBackground(Usuario... usuarios){
            usuarioDao.insertar(usuarios[0]);
            return null;
        }
    }

    public void actualizarUsuario(Usuario usuario){
        new UsuarioRepository.actualizarAsyncTask(usuarioDao).execute(usuario);
    }
    private static class actualizarAsyncTask
            extends AsyncTask<Usuario, Void, Void>{
        private UsuarioDao usuarioDao;
        actualizarAsyncTask(UsuarioDao _usuarioDao){
            usuarioDao = _usuarioDao;
        }
        @Override
        protected Void doInBackground(Usuario... usuarios) {
            usuarioDao.actualizar(usuarios[0]);
            return null;
        }
    }

    public void eliminarUsuario(){
        new UsuarioRepository.eliminarAsyncTask(usuarioDao).execute();
    }
    private static class eliminarAsyncTask
            extends AsyncTask<Void, Void, Void>{
        private UsuarioDao usuarioDao;
        eliminarAsyncTask(UsuarioDao _usuarioDao){
            usuarioDao = _usuarioDao;
        }
        @Override
        protected Void doInBackground(Void... voids) {
            usuarioDao.eliminar();
            return null;
        }
    }

}
