package pe.edu.idat.invoicingmobileapp.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import java.util.List;

import pe.edu.idat.invoicingmobileapp.retrofit.MobileCliente;
import pe.edu.idat.invoicingmobileapp.retrofit.response.ListcliResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ClientesViewModel extends AndroidViewModel {

    private MutableLiveData<List<ListcliResponse>> listcliMutableLiveData
            = new MutableLiveData<>();

    public ClientesViewModel(@NonNull Application application) {
        super(application);
    }

    private void listarClientes(){
        new MobileCliente().getInstance().listadoClientes()
                .enqueue(new Callback<List<ListcliResponse>>() {
                    @Override
                    public void onResponse(Call<List<ListcliResponse>> call, Response<List<ListcliResponse>> response) {
                        if(response.isSuccessful()){
                            listcliMutableLiveData.setValue(response.body());
                        }
                    }

                    @Override
                    public void onFailure(Call<List<ListcliResponse>> call, Throwable t) {

                    }
                });
    }
}
