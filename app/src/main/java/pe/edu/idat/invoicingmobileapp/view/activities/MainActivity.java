package pe.edu.idat.invoicingmobileapp.view.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

import pe.edu.idat.invoicingmobileapp.R;
import pe.edu.idat.invoicingmobileapp.bd.entity.Usuario;
import pe.edu.idat.invoicingmobileapp.databinding.ActivityMainBinding;
import pe.edu.idat.invoicingmobileapp.retrofit.request.LoginRequest;
import pe.edu.idat.invoicingmobileapp.retrofit.response.LoginResponse;
import pe.edu.idat.invoicingmobileapp.viewmodel.LoginViewModel;
import pe.edu.idat.invoicingmobileapp.viewmodel.UsuarioViewModel;

public class MainActivity extends AppCompatActivity
            implements View.OnClickListener{

    private ActivityMainBinding binding;
    private LoginViewModel loginViewModel;
    private UsuarioViewModel usuarioViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        loginViewModel = new ViewModelProvider(this)
                .get(LoginViewModel.class);
        usuarioViewModel = new ViewModelProvider(this)
                .get(UsuarioViewModel.class);
        binding.btnIngresar.setOnClickListener(this);
        binding.btnRegistro.setOnClickListener(this);
        loginViewModel.loginResponseMutableLiveData
                .observe(this, new Observer<LoginResponse>() {
                    @Override
                    public void onChanged(LoginResponse loginResponse) {
                        validarLogin(loginResponse);
                    }
                });
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.btnIngresar){
            invocarLogin();
        }
    }

    public void invocarLogin(){
        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setUsuario(binding.txUsuario.getText().toString());
        loginRequest.setContrasenia(binding.txPassword.getText().toString());
        loginViewModel.autenticarUsuario(loginRequest);
    }

    public void validarLogin(LoginResponse loginResponse) {
        if (loginResponse != null && loginResponse.getIdusu() > 0) {
            startActivity(new Intent(MainActivity.this, HomeActivity.class));
            Usuario usuario = new Usuario();
            usuario.setIdusu(loginResponse.getIdusu());
            usuario.setUsuario(loginResponse.getUsuario());
            usuario.setContrasenia(loginResponse.getContrasenia());
            usuario.setNombre(loginResponse.getNombre());
            usuarioViewModel.insertarUsuario(usuario);
        } else {
            // Mensaje de error usando Snackbar
            Snackbar.make(binding.getRoot(), "Usuario o contraseña incorrectos", Snackbar.LENGTH_SHORT).show();
        }
    }


}