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


import com.example.scheactim.Entidades.Dias;
import com.example.scheactim.Entidades.Semanas;
import com.example.scheactim.R;
import com.example.scheactim.adaptadores.adaptadoresFragment.AdapterDia;
import com.example.scheactim.adaptadores.adaptadoresFragment.AdapterSemana;

import java.util.ArrayList;

public class DiasFragment extends Fragment {
    AdapterDia adapterDia;
    RecyclerView recyclerViewDia;
    ArrayList<Dias> listaDia;

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.dias_fragment,container,false);

        recyclerViewDia = view.findViewById(R.id.recyclerViewDias);
        listaDia = new ArrayList<>();
        cargarLista();
        mostrarData();
        return view;
    }
    public void cargarLista(){
        listaDia.add(new Dias("07:00 a.m","Selecciona todo lo agendado para esta hora",R.drawable.notescell));
        listaDia.add(new Dias("08:00 a.m","Selecciona todo lo agendado para esta hora",R.drawable.computer));
        listaDia.add(new Dias("09:00 a.m","Selecciona todo lo agendado para esta hora",R.drawable.computer));
        listaDia.add(new Dias("10:00 a.m","Selecciona todo lo agendado para esta hora",R.drawable.notescell));
        listaDia.add(new Dias("11:00 a.m","Selecciona todo lo agendado para esta hora",R.drawable.computer));
        listaDia.add(new Dias("12:00 p.m","Selecciona todo lo agendado para esta hora",R.drawable.notescell));
        listaDia.add(new Dias("01:00 p.m","Selecciona todo lo agendado para esta hora",R.drawable.proximamente));
        listaDia.add(new Dias("02:00 p.m","Selecciona todo lo agendado para esta hora",R.drawable.proximamente));
        listaDia.add(new Dias("03:00 p.m","Selecciona todo lo agendado para esta hora",R.drawable.notescell));
        listaDia.add(new Dias("04:00 p.m","Selecciona todo lo agendado para esta hora",R.drawable.notescell));
        listaDia.add(new Dias("05:00 p.m","Selecciona todo lo agendado para esta hora",R.drawable.proximamente));
        listaDia.add(new Dias("06:00 p.m","Selecciona todo lo agendado para esta hora",R.drawable.notescell));
        listaDia.add(new Dias("07:00 p.m","Selecciona todo lo agendado para esta hora",R.drawable.computer));
    }
    private void mostrarData(){
        recyclerViewDia.setLayoutManager(new LinearLayoutManager(getContext()));
        adapterDia = new AdapterDia(getContext(), listaDia);
        recyclerViewDia.setAdapter(adapterDia);

    }


}
