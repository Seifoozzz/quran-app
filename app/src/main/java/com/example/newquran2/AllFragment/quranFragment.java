package com.example.newquran2.AllFragment;


import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.newquran2.Constants;
import com.example.newquran2.R;
import com.example.newquran2.SuraDetailsActivity;
import com.example.newquran2.adapters.surRecyclerViewAdpter;


/**
 * A simple {@link Fragment} subclass.
 */
public class quranFragment extends Fragment {

    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    surRecyclerViewAdpter adpter;

    public quranFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_quran, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = view.findViewById(R.id.recycler_view);
        layoutManager = new GridLayoutManager(getContext(),3,RecyclerView.HORIZONTAL,true);
        adpter = new surRecyclerViewAdpter(Constants.ArSuras);

        adpter.setOnItemClickListener(new surRecyclerViewAdpter.onItemClickListener() {
            @Override
            public void onClick(int position, String name) {
                Intent intent = new Intent(getContext(), SuraDetailsActivity.class);
                intent.putExtra("position",position);
                intent.putExtra("title",name);
                startActivity(intent);
            }
        });
        recyclerView.setAdapter(adpter);
        recyclerView.setLayoutManager(layoutManager);
    }
}
