package com.example.newquran2.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.newquran2.R;

import java.util.List;

public class DetailsSuraRecyclerAdapter extends RecyclerView.Adapter<DetailsSuraRecyclerAdapter.Viewholder>
{
    List<String> items;

    public DetailsSuraRecyclerAdapter(List<String> items) {
        this.items = items;
    }

    @NonNull
    @Override
    public Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_view_sura,parent,false);

        return new Viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Viewholder holder, final int position) {
        holder.content.setText(items.get(position));

    }

    @Override
    public int getItemCount() {
        if(items==null)
                return 0;
        return items.size();
    }

    public class Viewholder extends RecyclerView.ViewHolder{

        TextView content;
        public Viewholder(@NonNull View itemView) {
            super(itemView);
            content = itemView.findViewById(R.id.conttent);
        }
    }
}
