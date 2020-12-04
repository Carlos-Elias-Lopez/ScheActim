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

import com.example.scheactim.Entidades.VerActivades;
import com.example.scheactim.R;
import com.example.scheactim.adaptadores.adaptadoresFragment.AdapterVerActivades;

import java.util.ArrayList;

public class ActividadesFragment extends Fragment {

    AdapterVerActivades adapterActividades;
    RecyclerView recyclerViewActividades;
    ArrayList<VerActivades> listaActividades;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.semanas_fragment,container,false);

        recyclerViewActividades = view.findViewById(R.id.recyclerViewSemana);
        listaActividades = new ArrayList<>();
        cargarLista();
        mostrarData();
        return view;
    }

    public void cargarLista(){
        listaActividades.add(new VerActivades("Terminar tarea de Matemáticas","Cumplir con el mínimo de ejercicios de aritmética","finalizado","2020/12/09","2020/12/09",R.drawable.clock  ));
        listaActividades.add(new VerActivades("Ir al supermercado","Comprar alcohol gel y jabón líquido","finalizado","2020/11/09", "2020/11/09",R.drawable.check_icon));
        listaActividades.add(new VerActivades("Entregar el proyecto de Historia Universal", "Dar los últimos retoques al ensayo", "pendiente", "2020/10/02", "2020/10/05",R.drawable.clock));
        listaActividades.add(new VerActivades("Ir a Metrocentro con mis amigos","Para celebrar el cumpleaños de Juan","pendiente","2020/10/02","2020/10/05",R.drawable.clock));
        listaActividades.add(new VerActivades("Terminar el trabajo de Literatura Antigua","Buscar en la lectura los hitos para la línea de tiempo","retrasado","2020/07/02","2020/07/05",R.drawable.calendar_icon));
        listaActividades.add(new VerActivades("Visitar a mi abuelo","Para regalarle una cesta de jaleas","finalizado","2020/01/02","2020/01/02",R.drawable.check_icon));
        listaActividades.add(new VerActivades("Tener videollamada con mi grupo de ECA","Como ṕractica para la exposición","retrasado","2020/05/02","2020/05/02",R.drawable.calendar_icon));

        }
    private void mostrarData(){
        recyclerViewActividades.setLayoutManager(new LinearLayoutManager(getContext()));
        adapterActividades = new AdapterVerActivades(getContext(), listaActividades);
        recyclerViewActividades.setAdapter(adapterActividades);

    }




    }




