package com.example.newquran2.AllFragment;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.newquran2.R;

public class tasbeehFragment extends Fragment {

    ImageView taspeeh_counter;
    Button tspehaa;
    ImageView reply_icon;
    int count=0;

    public tasbeehFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_tasbeeh, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        taspeeh_counter = view.findViewById(R.id.tasbeeh_icon);
        tspehaa = view.findViewById(R.id.tsbehaa_button);
        reply_icon = view.findViewById(R.id.reply_icon);

        taspeeh_counter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                count=count+1;
                tspehaa.setText(" "+count);
            }
        });
        reply_icon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                count=0;
                tspehaa.setText(" "+count);
            }
        });
    }
}
