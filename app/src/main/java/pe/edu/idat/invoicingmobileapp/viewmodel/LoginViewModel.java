package pe.edu.idat.invoicingmobileapp.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import pe.edu.idat.invoicingmobileapp.retrofit.MobileCliente;
import pe.edu.idat.invoicingmobileapp.retrofit.request.LoginRequest;
import pe.edu.idat.invoicingmobileapp.retrofit.response.LoginResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginViewModel extends AndroidViewModel {
    public MutableLiveData<LoginResponse> loginResponseMutableLiveData
            = new MutableLiveData<>();

    public LoginViewModel(@NonNull Application application) {
        super(application);
    }

    public void autenticarUsuario(LoginRequest loginRequest){
        new MobileCliente().getInstance().autenticarUsuario(loginRequest)
                .enqueue(new Callback<LoginResponse>() {
                    @Override
                    public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                        loginResponseMutableLiveData.setValue(
                                response.body()
                        );
                    }

                    @Override
                    public void onFailure(Call<LoginResponse> call, Throwable t) {

                    }
                });
    }
}
