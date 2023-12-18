package pe.edu.idat.invoicingmobileapp.viewmodel;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import java.util.List;

import pe.edu.idat.invoicingmobileapp.retrofit.MobileCliente;
import pe.edu.idat.invoicingmobileapp.retrofit.response.ListpedResponse;
import pe.edu.idat.invoicingmobileapp.retrofit.response.ListpeddetailedResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ListpedViewModel extends AndroidViewModel {

    public MutableLiveData<List<ListpedResponse>> listMutableLiveData
            = new MutableLiveData<>();

    public MutableLiveData<ListpeddetailedResponse> listpeddetailedResponseMutableLiveData
            = new MutableLiveData<>();

    public ListpedViewModel(@NonNull Application application) {
        super(application);
    }

    public void listarPedidos(){
        new MobileCliente().getInstance().listarPedidos()
                .enqueue(new Callback<List<ListpedResponse>>() {
                    @Override
                    public void onResponse(Call<List<ListpedResponse>> call, Response<List<ListpedResponse>> response) {
                        if (response.isSuccessful()) {
                            listMutableLiveData.setValue(response.body());
                        } else {
                            handleErrorResponse(response);
                        }
                    }

                    @Override
                    public void onFailure(Call<List<ListpedResponse>> call, Throwable t) {
                        handleFailure(t);
                    }
                });
    }

    // Método para manejar errores de respuesta
    private void handleErrorResponse(Response<List<ListpedResponse>> response) {
        Log.e("ListpedViewModel", "Error en la respuesta: " + response.code());
    }

    // Método para manejar errores de conexión
    private void handleFailure(Throwable t) {
        Log.e("ListpedViewModel", "Error en la conexión", t);
    }

    public void eliminarPedido(int idPedido){
        new MobileCliente().getInstance().eliminacionPedido(idPedido)
                .enqueue(new Callback<String>() {
                    @Override
                    public void onResponse(Call<String> call, Response<String> response) {

                    }

                    @Override
                    public void onFailure(Call<String> call, Throwable t) {

                    }
                });
    }

    public void buscarPedidoDetallado(int idPedido){
        new MobileCliente().getInstance().buscarPedidoDetallado(idPedido)
                .enqueue(new Callback<ListpeddetailedResponse>() {
                    @Override
                    public void onResponse(Call<ListpeddetailedResponse> call, Response<ListpeddetailedResponse> response) {
                        listpeddetailedResponseMutableLiveData.setValue(response.body());
                    }

                    @Override
                    public void onFailure(Call<ListpeddetailedResponse> call, Throwable t) {

                    }
                });
    }

}
