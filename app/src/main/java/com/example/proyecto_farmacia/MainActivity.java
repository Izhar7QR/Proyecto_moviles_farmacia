package com.example.proyecto_farmacia;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import com.google.firebase.analytics.FirebaseAnalytics;

public class MainActivity extends AppCompatActivity {
    private FirebaseAnalytics mFirebaseAnalytics;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Obtain the FirebaseAnalytics instance.
        mFirebaseAnalytics = FirebaseAnalytics.getInstance(this);
        Bundle bundle = new Bundle();
        bundle.putString("mesasge", "Integracion de Firebase");
        mFirebaseAnalytics.logEvent("InitScreen", bundle);
    }
}