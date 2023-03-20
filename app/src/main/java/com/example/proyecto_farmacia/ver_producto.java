package com.example.proyecto_farmacia;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;

public class ver_producto extends AppCompatActivity {
    public static final String stringNombres="names";
    public static final String stringSirve="names";
    public static final String stringefectos="names";
    public static final String stringGraves="names";
    public static final String stringUso="names";
    public static final String stringUsar="names";
    //Bundle stringUser = getIntent().getExtras();
    private TextView nombreProducto, SirveP, comoUsar, otroUsos, efectos, efectosGraves;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ver_producto);

        nombreProducto = findViewById(R.id.tv_nombreT);
        SirveP = findViewById(R.id.tv_paraQueSirve);
        comoUsar = findViewById(R.id.tv_comoSeUsa);
        otroUsos = findViewById(R.id.tv_otroUso);
        efectos = findViewById(R.id.tv_efectoSecundario);
        efectosGraves = findViewById(R.id.tv_efectoSecundarioGrave);

        ArrayList<String> lista = (ArrayList<String>) getIntent().getStringArrayListExtra("miLista");
/*
        String datos1 = getIntent().getStringExtra(stringNombres);
        String datos2 = getIntent().getStringExtra(stringSirve);
        String datos3 = getIntent().getStringExtra(stringefectos);
        String datos4 = getIntent().getStringExtra(stringGraves);
        String datos5 = getIntent().getStringExtra(stringUso);
        String datos6 = getIntent().getStringExtra(stringUsar);*/

        nombreProducto.setText(lista.get(0));
        SirveP.setText(lista.get(1));
        comoUsar.setText(lista.get(2));
        otroUsos.setText(lista.get(3));
        efectos.setText(lista.get(4));
        efectosGraves.setText(lista.get(5));

    }
}