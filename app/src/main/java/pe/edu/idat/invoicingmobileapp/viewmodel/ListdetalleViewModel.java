package pe.edu.idat.invoicingmobileapp.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.util.List;

import pe.edu.idat.invoicingmobileapp.retrofit.MobileCliente;
import pe.edu.idat.invoicingmobileapp.retrofit.response.ListdetalleResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ListdetalleViewModel extends AndroidViewModel {

    private MutableLiveData<List<ListdetalleResponse>> listMutableLiveData
            = new MutableLiveData<>();

    public LiveData<List<ListdetalleResponse>> getListLiveData() {
        return listMutableLiveData;
    }

    public ListdetalleViewModel(@NonNull Application application) {
        super(application);
    }

    public void listarDetallesNoAsignados(){
        new MobileCliente().getInstance().listarDetallesNoAsignados()
                .enqueue(new Callback<List<ListdetalleResponse>>() {
                    @Override
                    public void onResponse(Call<List<ListdetalleResponse>> call, Response<List<ListdetalleResponse>> response) {
                        if (response.isSuccessful()) {
                            listMutableLiveData.setValue(response.body());
                        }
                    }

                    @Override
                    public void onFailure(Call<List<ListdetalleResponse>> call, Throwable t) {

                    }
                });
    }
}
