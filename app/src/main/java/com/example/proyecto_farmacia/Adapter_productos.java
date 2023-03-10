package com.example.proyecto_farmacia;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Adapter_productos extends RecyclerView.Adapter<Adapter_productos.MyViewHolder> {

    Context context;
    ArrayList<Productos> productosArrayList;

    public Adapter_productos(Context context, ArrayList<Productos> productosArrayList) {
        this.context = context;
        this.productosArrayList = productosArrayList;
    }

    @NonNull
    @Override
    public Adapter_productos.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(context).inflate(R.layout.item_productos, parent, false);

        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull Adapter_productos.MyViewHolder holder, int position) {

        Productos productos = productosArrayList.get(position);

        holder.nombre.setText(productos.Nombre);
        holder.descripcion.setText(productos.Descripcion);
        holder.precio.setText(productos.Precio);

    }

    @Override
    public int getItemCount() {
        return productosArrayList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        TextView nombre, descripcion, precio;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            nombre = itemView.findViewById(R.id.tv_Nombre);
            descripcion = itemView.findViewById(R.id.tv_Descripcion);
            precio = itemView.findViewById(R.id.tv_Precio);
        }
    }
}
