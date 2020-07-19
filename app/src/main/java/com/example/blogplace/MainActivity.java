package com.example.blogplace;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView bottomnav  = findViewById(R.id.bottom_navigation);
        bottomnav.setOnNavigationItemSelectedListener(navlistener);
    }
    private BottomNavigationView.OnNavigationItemSelectedListener navlistener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment selectedfragment = null;
            switch (item.getItemId()){
                case R.id.nav_chat:
                    selectedfragment = new ChatFragment();
                    break;

                case R.id.nav_recent:
                    selectedfragment = new RecentFragment();
                    break;

                case R.id.nav_myworld:
                    selectedfragment = new WorkFragment();
                    break;
            }

            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,selectedfragment).commit();
            return true;
        }
    };
}
