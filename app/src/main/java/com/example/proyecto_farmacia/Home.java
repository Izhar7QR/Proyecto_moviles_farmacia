package com.example.proyecto_farmacia;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Home#
 * newInstance} factory method to
 * create an instance of this fragment.
 */
public class Home extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private SearchView searchView;
    private ListView listView;
    private ArrayAdapter<String> adapter;

    private String[] items = {"Manzana", "Banana", "Cereza", "Durazno", "Fresa", "Grosella", "Higo", "Kiwi", "Limón", "Mango"};


    public Home() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Home.
     */
    // TODO: Rename and change types and number of parameters
    public static Home newInstance(String param1, String param2) {
        Home fragment = new Home();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }

        }


    public void search(View view){
        //Intent catalog = new Intent(getContext(), Catalog.class);
        //startActivity(catalog);
        /*Catalog catalog = new Catalog();
        FragmentManager manager = getParentFragmentManager();

        manager.beginTransaction()
                .replace(R.id.frame_container, catalog)
                .commit();*/

        // Crear fragmento de tu clase
        Fragment fragment = new Catalog();
// Obtener el administrador de fragmentos a través de la actividad
        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
// Definir una transacción
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
// Remplazar el contenido principal por el fragmento
        fragmentTransaction.replace(R.id.home, fragment);
        fragmentTransaction.addToBackStack(null);
// Cambiar
        fragmentTransaction.commit();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View vist = inflater.inflate(R.layout.fragment_home, container, false);

        //searchView = vist.findViewById(R.id.search_view);
        //listView = vist.findViewById(R.id.list_view);

        //adapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_list_item_1, items);
        //listView.setAdapter(adapter);

        //searchView.setOnQueryTextListener(this);


        return vist;
    }
}