package pe.edu.idat.invoicingmobileapp.view.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import pe.edu.idat.invoicingmobileapp.databinding.ItemPromocionesBinding;
import pe.edu.idat.invoicingmobileapp.retrofit.response.PromocionesResponse;

public class PromocionesAdapter extends RecyclerView.Adapter<PromocionesAdapter.ViewHolder> {

    List<PromocionesResponse> promocionesResponseList = new ArrayList<>();

    @NonNull
    @Override
    public PromocionesAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(ItemPromocionesBinding.inflate(
                LayoutInflater.from(parent.getContext()),
                parent,false
        ));
    }

    @Override
    public void onBindViewHolder(@NonNull PromocionesAdapter.ViewHolder holder, int position) {
        final PromocionesResponse promocionesResponse = promocionesResponseList.get(position);

        holder.binding.tvpromodes.setText(promocionesResponse.getDespromo());
        holder.binding.tvfchainicio.setText(promocionesResponse.getFchaini());
        holder.binding.tvfchafin.setText(promocionesResponse.getFchafin());
        Glide.with(holder.binding.getRoot())
                .load(promocionesResponse.getImagen())
                .into(holder.binding.ivpromocion);
    }

    @Override
    public int getItemCount() {
        return promocionesResponseList.size();
    }

    public void setPromociones(List<PromocionesResponse> promociones){
        promocionesResponseList.clear();
        promocionesResponseList.addAll(promociones);
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ItemPromocionesBinding binding;
        public ViewHolder(ItemPromocionesBinding view) {
            super(view.getRoot());
            binding=view;
        }

    }
}
