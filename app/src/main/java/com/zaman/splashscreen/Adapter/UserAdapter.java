package com.zaman.splashscreen.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;

import com.zaman.splashscreen.Model.User;
import com.zaman.splashscreen.UserProfileActivity;
import com.zaman.splashscreen.R;

import java.util.List;

public class UserAdapter extends ArrayAdapter<User> {
    private Context context;
    private List<User> users;

    public UserAdapter(@NonNull Context context, @LayoutRes int resource, @NonNull List<User> objects) {
        super(context, resource, objects);
        this.context = context;
        this.users = objects;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent){
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.data_layout, parent, false);

        TextView name = (TextView) rowView.findViewById(R.id.textViewName);
        TextView email = (TextView) rowView.findViewById(R.id.textViewEmail);

        name.setText(users.get(position).getName());
        email.setText(users.get(position).getEmail());

        rowView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //start Activity User Form
                Intent intent = new Intent(context, UserProfileActivity.class);
                intent.putExtra("user_id", String.valueOf(users.get(position).getId()));
                Toast.makeText(context,String.valueOf(users.get(position).getName()),Toast.LENGTH_LONG).show();
                context.startActivity(intent);
            }
        });
        return rowView;
    }

}
