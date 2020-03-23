package com.example.newquran2;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.newquran2.adapters.DetailsSuraRecyclerAdapter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class SuraDetailsActivity extends AppCompatActivity {

    int pos;
    String name;
    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    DetailsSuraRecyclerAdapter adapter;
    TextView title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sura_details);
        recyclerView = findViewById(R.id.recycler_view2);
        title = findViewById(R.id.name);

        pos = getIntent().getIntExtra("position", -1);
        name = getIntent().getStringExtra("title");
        title.setText(name);

        List<String> content = readSuraFromFile((pos+1) + ".txt");
        adapter = new DetailsSuraRecyclerAdapter(content);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(layoutManager);
    }

    public List<String> readSuraFromFile(String filename) {
        List<String> data = new ArrayList();
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(
                    new InputStreamReader(getAssets().open(filename)));

            // do reading, usually loop until end of file reading
            String mLine;
            while ((mLine = reader.readLine()) != null) {
                //process line
                if (!mLine.isEmpty())
                    data.add(mLine);
            }
        }
        catch (IOException e) {
            //log the exception
        }
        finally {
            if (reader != null) {
                try {
                    reader.close();
                }
                catch (IOException e) {
                    //log the exception
                }
            }
        }
        return data;
    }
}

