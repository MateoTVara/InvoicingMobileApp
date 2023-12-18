package pe.edu.idat.invoicingmobileapp.view.adapters;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

import pe.edu.idat.invoicingmobileapp.retrofit.response.ListproResponse;

public class ProductoAutoCompleteAdapter extends ArrayAdapter<ListproResponse> {

    public ProductoAutoCompleteAdapter(Context context, List<ListproResponse> listproResponses) {
        super(context, android.R.layout.simple_dropdown_item_1line, listproResponses);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        TextView textView = (TextView) super.getView(position, convertView, parent);
        ListproResponse item = getItem(position);
        if (item != null) {
            textView.setText(item.getDesproduc());
        }
        return textView;
    }

    @Override
    public View getDropDownView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        TextView textView = (TextView) super.getDropDownView(position, convertView, parent);
        ListproResponse item = getItem(position);
        if (item != null) {
            textView.setText(item.getDesproduc());
        }
        return textView;
    }
}
