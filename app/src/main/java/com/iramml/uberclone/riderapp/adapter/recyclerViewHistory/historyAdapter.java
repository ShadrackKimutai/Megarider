package com.iramml.uberclone.riderapp.adapter.recyclerViewHistory;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.iramml.uberclone.riderapp.Model.firebase.History;
import com.iramml.uberclone.riderapp.R;

import java.util.ArrayList;

public class historyAdapter extends RecyclerView.Adapter<historyAdapter.ViewHolder>{
    Context context;
    ArrayList<History> items;
    ClickListener listener;
    ViewHolder viewHolder;

    public historyAdapter(Context context, ArrayList<History> items, ClickListener listener ){
        this.context=context;
        this.items=items;
        this.listener=listener;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view= LayoutInflater.from(context).inflate(R.layout.history_template,viewGroup,false);
        viewHolder=new ViewHolder(view, listener);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        viewHolder.tvDriverName.setText("Driver Name: "+items.get(i).getName());
        viewHolder.tvTripDate.setText("Date: "+items.get(i).getTripDate());
    }
    @Override
    public int getItemCount() {
        return items.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView tvDriverName, tvTripDate;
        ClickListener listener;
        public ViewHolder(View itemView, ClickListener listener) {
            super(itemView);
            tvDriverName=itemView.findViewById(R.id.tvDriverName);
            tvTripDate=itemView.findViewById(R.id.tvTripDate);
            this.listener=listener;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            this.listener.onClick(view, getAdapterPosition());
        }
    }
}
