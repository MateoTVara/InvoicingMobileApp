package pe.edu.idat.invoicingmobileapp.view.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import pe.edu.idat.invoicingmobileapp.R;
import pe.edu.idat.invoicingmobileapp.databinding.FragmentPromocionesBinding;
import pe.edu.idat.invoicingmobileapp.retrofit.response.PromocionesResponse;
import pe.edu.idat.invoicingmobileapp.view.adapters.PromocionesAdapter;
import pe.edu.idat.invoicingmobileapp.viewmodel.PromocionesViewModel;

public class PromocionesFragment extends Fragment {

    private FragmentPromocionesBinding binding;
    private PromocionesViewModel promocionesViewModel;
    private PromocionesAdapter promocionesAdapter = new PromocionesAdapter();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentPromocionesBinding.inflate(inflater,
                container, false);
        promocionesViewModel= new ViewModelProvider(requireActivity())
                .get(PromocionesViewModel.class);
        binding.rvpromociones.setLayoutManager(
                new LinearLayoutManager(requireActivity())
        );
        binding.rvpromociones.setAdapter(promocionesAdapter);
        promocionesViewModel.listarPromociones();
        promocionesViewModel.listpromocionesMutableLiveData.observe(
                getViewLifecycleOwner(),
                new Observer<List<PromocionesResponse>>() {
                    @Override
                    public void onChanged(List<PromocionesResponse> promocionesResponses) {
                        promocionesAdapter.setPromociones(promocionesResponses);
                    }
                }
        );
        // Inflate the layout for this fragment
        return binding.getRoot();
    }
}