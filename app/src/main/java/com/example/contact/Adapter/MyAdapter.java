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

import com.example.contact.Model.Mymodel;
import com.example.contact.R;
import com.example.contact.SQLiteHelper.SqliteHelper;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
    Context context;
    SqliteHelper db;
    ArrayList<Mymodel>list=new ArrayList<>();

    public MyAdapter(Context context, ArrayList<Mymodel> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public MyAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from( context ).inflate( R.layout.cardview, parent, false );
        return new ViewHolder( itemView );
    }

    @Override
    public void onBindViewHolder(@NonNull MyAdapter.ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.name.setText(list.get(position).getName());
        holder.number.setText(list.get(position).getNumber());

        holder.swap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String uname = list.get(position).getName();
                String uphone = list.get(position).getNumber();
                db=new SqliteHelper(context);;
               db.add(uname,uphone);
            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView name,number;

        LinearLayout swap;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name=itemView.findViewById(R.id.cname);
            number=itemView.findViewById(R.id.cnumber);
            swap=itemView.findViewById(R.id.item_swap);
        }
    }
}
