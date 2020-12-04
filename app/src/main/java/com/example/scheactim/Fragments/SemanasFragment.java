package com.example.scheactim.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import com.example.scheactim.Entidades.Semanas;
import com.example.scheactim.Entidades.VerActivades;
import com.example.scheactim.R;
import com.example.scheactim.adaptadores.adaptadoresFragment.AdapterSemana;
import com.example.scheactim.adaptadores.adaptadoresFragment.AdapterVerActivades;

import java.util.ArrayList;

public class SemanasFragment extends Fragment {
    AdapterSemana adapterSemana;
    RecyclerView recyclerViewSemanas;
    ArrayList<Semanas> listaSemanas;
    @Nullable
    @Override

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.actividades_fragment,container,false);

        recyclerViewSemanas = view.findViewById(R.id.recyclerView);
        listaSemanas = new ArrayList<>();
        cargarLista();
        mostrarData();
        return view;
    }

    public void cargarLista(){
        listaSemanas.add(new Semanas("04/12/2020",R.drawable.proximamente));
        listaSemanas.add(new Semanas("06/12/2020",R.drawable.computer));
        listaSemanas.add(new Semanas("13/12/2020",R.drawable.computer));
        listaSemanas.add(new Semanas("20/12/2020",R.drawable.proximamente));
        listaSemanas.add(new Semanas("27/12/2020",R.drawable.proximamente));

    }
    private void mostrarData(){
        recyclerViewSemanas.setLayoutManager(new LinearLayoutManager(getContext()));
        adapterSemana = new AdapterSemana(getContext(), listaSemanas);
        recyclerViewSemanas.setAdapter(adapterSemana);

    }

}
