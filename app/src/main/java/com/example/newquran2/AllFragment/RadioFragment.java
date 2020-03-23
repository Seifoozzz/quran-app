package com.example.newquran2.AllFragment;


import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.PagerSnapHelper;
import androidx.recyclerview.widget.RecyclerView;

import com.example.newquran2.APIs.APIManager;
import com.example.newquran2.R;
import com.example.newquran2.adapters.RadioChannelsAdapter;
import com.example.newquran2.model.RadiosItem;
import com.example.newquran2.model.RadiosResponse;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RadioFragment extends Fragment {

    View rootView;
    TextView radioText;

    RecyclerView recyclerView;
    ProgressBar progressBar;
    RadioChannelsAdapter adapter;
    RecyclerView.LayoutManager layoutManager;

    public RadioFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_radio, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = view.findViewById(R.id.recycler_view);
        progressBar = view.findViewById(R.id.progress_bar);
        initRecyclerView();
        getRadioChannels();
    }

    private void initRecyclerView() {
        adapter = new RadioChannelsAdapter(null);
        adapter.setOnPlayClickListener(new RadioChannelsAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int pos, RadiosItem item) {
                playRadioChannel(item.getRadioUrl());
            }
        });
        adapter.setOnStopClickListener(new RadioChannelsAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int pos, RadiosItem item) {
                stopRadio();
            }
        });
        layoutManager = new LinearLayoutManager(getContext(), RecyclerView.HORIZONTAL, false);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(layoutManager);
        PagerSnapHelper pagerSnapHelper = new PagerSnapHelper();
        pagerSnapHelper.attachToRecyclerView(recyclerView);
    }

    MediaPlayer mediaPlayer;
    public void stopRadio() {
        if (mediaPlayer != null && mediaPlayer.isPlaying()) {
            mediaPlayer.stop();
            mediaPlayer = null;
        }
    }

    public void playRadioChannel(String url) {
        stopRadio();
        mediaPlayer = new MediaPlayer();
        try {
            mediaPlayer.setDataSource(getContext(), Uri.parse(url));
            mediaPlayer.prepareAsync();
            mediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                @Override
                public void onPrepared(MediaPlayer mp) {
                    mp.start();
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void getRadioChannels() {
        APIManager.getAPIs().getRediosChannel()
                .enqueue(new Callback<RadiosResponse>() {
                    @Override
                    public void onResponse(Call<RadiosResponse> call,
                                           Response<RadiosResponse> response) {
                        progressBar.setVisibility(View.GONE);
                        adapter.changeData(response.body().getRadios());
                    }

                    @Override
                    public void onFailure(Call<RadiosResponse> call, Throwable t) {
                        progressBar.setVisibility(View.GONE);
                        Toast.makeText(getContext(), t.getLocalizedMessage(),
                                Toast.LENGTH_LONG).show();
                    }
                });
    }
}
