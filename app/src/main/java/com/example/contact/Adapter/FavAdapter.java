package com.example.contact.Adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.contact.Model.FavModel;
import com.example.contact.Model.Mymodel;
import com.example.contact.R;

import java.util.ArrayList;

public class FavAdapter extends RecyclerView.Adapter<FavAdapter.ViewHolder> {
    Context context;
    ArrayList<FavModel> list=new ArrayList<>();

    public FavAdapter(Context context, ArrayList<FavModel> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public FavAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from( context ).inflate( R.layout.fav_cardview, parent, false );
        return new FavAdapter.ViewHolder( itemView );
    }

    @Override
    public void onBindViewHolder(@NonNull FavAdapter.ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.name.setText(list.get(position).getName());
        holder.number.setText(list.get(position).getNumber());


    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView name,number;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name=itemView.findViewById(R.id.fav_name);
            number=itemView.findViewById(R.id.fav_number);

        }
    }
}
