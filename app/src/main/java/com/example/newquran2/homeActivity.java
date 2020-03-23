package com.example.newquran2;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.example.newquran2.AllFragment.RadioFragment;
import com.example.newquran2.AllFragment.quranFragment;
import com.example.newquran2.AllFragment.tasbeehFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class homeActivity extends AppCompatActivity {

    TextView title;

    BottomNavigationView.OnNavigationItemSelectedListener onNavigationItemSelectedListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                    int id = menuItem.getItemId();
                    Fragment fragment = null;
                    switch (id) {
                        case R.id.navigation_quran: {
                            fragment = new quranFragment();
                            title.setText("المصحف قراءه", TextView.BufferType.NORMAL);
                            break;
                        }
                        case R.id.navigation_taspeeh: {
                            fragment = new tasbeehFragment();
                            title.setText("المسبحه الالكترونيه", TextView.BufferType.NORMAL);
                            break;
                        }
                        case R.id.navigation_radio: {
                            fragment = new RadioFragment();
                            title.setText("الراديو",TextView.BufferType.NORMAL);
                            break;
                        }
                    }
                    getSupportFragmentManager()
                            .beginTransaction()
                            .replace(R.id.fragment_contaner,fragment)
                            .commit();
                    return true;
                }
            };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        title = findViewById(R.id.elmos7f_read);
        BottomNavigationView navView = findViewById(R.id.nav_view);
        navView.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener);
        navView.setSelectedItemId(R.id.navigation_quran);
    }
}