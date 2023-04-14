package com.example.proyecto_farmacia;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.jeevandeshmukh.glidetoastlib.GlideToast;

public class Glide extends AppCompatActivity {

    private Button btnGlide, btnCentrado, btnAbajo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_glide);

        btnGlide = findViewById(R.id.btn_toast);
        btnCentrado = findViewById(R.id.btn_toastCenter);
        btnAbajo = findViewById(R.id.btn_toastBottom);

        btnGlide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new GlideToast.makeToast(Glide.this,"Este es un mensaje flotante con Glide", 2000, GlideToast.CUSTOMTOAST, GlideToast.TOP,R.drawable.baseline_warning_24, "#EC407A").show();

            }
        });

        btnCentrado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new GlideToast.makeToast(Glide.this,"Este es un mensaje flotante con Glide", 2000, GlideToast.CUSTOMTOAST, GlideToast.CENTER,R.drawable.baseline_warning_24, "#EC407A").show();

            }
        });

        btnAbajo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new GlideToast.makeToast(Glide.this,"Este es un mensaje flotante con Glide", 2000, GlideToast.CUSTOMTOAST, GlideToast.BOTTOM,R.drawable.baseline_warning_24, "#EC407A").show();

            }
        });
    }
}