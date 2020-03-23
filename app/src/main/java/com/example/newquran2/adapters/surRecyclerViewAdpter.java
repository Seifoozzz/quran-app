package com.example.newquran2.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.newquran2.R;

public class surRecyclerViewAdpter extends RecyclerView.Adapter<surRecyclerViewAdpter.Viewholder>
{
    String [] items;

    public surRecyclerViewAdpter(String[] items) {
        this.items = items;
    }

    @NonNull
    @Override
    public Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_sura_button,parent,false);

        return new Viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Viewholder holder, final int position) {
        holder.title.setText(items[position]);
        if (onItemClickListener != null){
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    onItemClickListener.onClick(position,items[position]);
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        if(items==null)
                return 0;
        return items.length;
    }

    public void setOnItemClickListener(surRecyclerViewAdpter.onItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    onItemClickListener onItemClickListener;
    public interface onItemClickListener{
        void onClick(int position, String name);
    }

    public class Viewholder extends RecyclerView.ViewHolder{

        TextView title;
        public Viewholder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.titleee);
        }
    }
}
