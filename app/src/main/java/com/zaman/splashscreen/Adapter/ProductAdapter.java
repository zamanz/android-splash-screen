package com.zaman.splashscreen.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.zaman.splashscreen.Model.Product;
import com.zaman.splashscreen.R;

import java.util.List;


public class ProductAdapter extends ArrayAdapter<Product> {

    private Context context;
    private List<Product> products;


    public ProductAdapter(@NonNull Context context, @LayoutRes int resource, @NonNull List<Product> objects) {
        super(context, resource, objects);
        this.context = context;
        this.products = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.data_layout, parent, false);

        TextView name = (TextView) rowView.findViewById(R.id.textViewName);
        TextView price = (TextView) rowView.findViewById(R.id.textViewEmail);

//        name.setText(products.get(position).getName());
//        price.setText(String.valueOf(products.get(position).getPrice()));

        return rowView;
    }
}
