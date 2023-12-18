package pe.edu.idat.invoicingmobileapp.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import java.util.List;

import pe.edu.idat.invoicingmobileapp.retrofit.MobileCliente;
import pe.edu.idat.invoicingmobileapp.retrofit.response.PromocionesResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PromocionesViewModel extends AndroidViewModel {
    public MutableLiveData<List<PromocionesResponse>> listpromocionesMutableLiveData
            = new MutableLiveData<>();

    public PromocionesViewModel(@NonNull Application application) {
        super(application);
    }

    public void listarPromociones(){
        new MobileCliente().getInstance().listarPromociones()
                .enqueue(new Callback<List<PromocionesResponse>>() {
                    @Override
                    public void onResponse(Call<List<PromocionesResponse>> call, Response<List<PromocionesResponse>> response) {
                        if(response.isSuccessful()){
                            listpromocionesMutableLiveData.setValue(response.body());
                        }
                    }

                    @Override
                    public void onFailure(Call<List<PromocionesResponse>> call, Throwable t) {

                    }
                });
    }
}
