package com.example.proyecto_farmacia;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.analytics.FirebaseAnalytics;

public class MainActivity extends AppCompatActivity {
    private FirebaseAnalytics mFirebaseAnalytics;

    Home home = new Home();
    Catalog catalog = new Catalog();
    ShopBask shopBask = new ShopBask();
    Favorites favorites = new Favorites();
    Profile profile = new Profile();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Obtain the FirebaseAnalytics instance.
        mFirebaseAnalytics = FirebaseAnalytics.getInstance(this);
        Bundle bundle = new Bundle();
        bundle.putString("mesasge", "Integracion de Firebase");
        mFirebaseAnalytics.logEvent("InitScreen", bundle);

        // Bottom Navigation
        BottomNavigationView navigation = findViewById(R.id.bottom_navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        loadFragment(home);
    }

    private final BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.home:
                    loadFragment(home);
                    return true;
                case R.id.catalog:
                    loadFragment(catalog);
                    return true;
                case R.id.shopBask:
                    loadFragment(shopBask);
                    return true;
                case R.id.favorites:
                    loadFragment(favorites);
                    return true;
                case R.id.profile:
                    loadFragment(profile);
                    return true;
            }
            return false;
        }
    };

    public void loadFragment(Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frame_container, fragment);
        transaction.commit();
    }

}