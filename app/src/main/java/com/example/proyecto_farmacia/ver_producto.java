package com.example.proyecto_farmacia;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class ver_producto extends AppCompatActivity {
    private TextView nombreProducto, SirveP, comoUsar, otroUsos, efectos, efectosGraves;
    private Button atras;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ver_producto);

        atras = findViewById(R.id.btn_atras);

        nombreProducto = findViewById(R.id.tv_nombreT);
        SirveP = findViewById(R.id.tv_paraQueSirve);
        comoUsar = findViewById(R.id.tv_comoSeUsa);
        otroUsos = findViewById(R.id.tv_otroUso);
        efectos = findViewById(R.id.tv_efectoSecundario);
        efectosGraves = findViewById(R.id.tv_efectoSecundarioGrave);

        ArrayList<String> lista = (ArrayList<String>) getIntent().getStringArrayListExtra("miLista");

        nombreProducto.setText(lista.get(0));
        SirveP.setText(lista.get(1));
        comoUsar.setText(lista.get(2));
        otroUsos.setText(lista.get(3));
        efectos.setText(lista.get(4));
        efectosGraves.setText(lista.get(5));

    }
    public void atras (View view){
        Intent intent = new Intent(view.getContext(), MainActivity.class);
        startActivity(intent);
    }
}