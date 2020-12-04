package com.example.scheactim;

import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.scheactim.adaptadores.AdaptadorActividades;
import com.example.scheactim.data.ActividadesRepo;
import com.example.scheactim.data.ScheActimEntriesDao;
import com.example.scheactim.helpers.eventos.ItemTapListener;
import com.example.scheactim.modelos.ModeloActividades;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;


import static android.content.ContentValues.TAG;

public class MainActivity extends AppCompatActivity implements ItemTapListener {

    private static final String TAG = MainActivity.class.getName();
    public static final String FULLNAME_KEY = "FULLNAME";
    public static final String EMAIL_KEY = "EMAIL";

    private ActividadesRepo mPointsRepository;
    private List<ModeloActividades> mModelList;
    private AdaptadorActividades mPointsAdapter;

    private ViewGroup rootView;

    //esta parte hace referencia a los de guardar actividad
    private static final int SAVE_REQUEST_CODE = 10;
   // private TextView tvContent;
    //private ScheActimEntriesDao entriesDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        setup();

    }


    private void setup() {

        mPointsRepository = new ActividadesRepo(getBaseContext());
        mModelList = new ArrayList<>();

        Intent startIntent = getIntent();
        if(startIntent == null) {
            Toast.makeText(
                    this,
                    "Algo salió mal al obtener los datos :(",
                    Toast.LENGTH_SHORT
            ).show();
            return;
        }

        String fullname = startIntent.getStringExtra(FULLNAME_KEY);
        if(TextUtils.isEmpty(fullname)) {
            fullname = "Usuario";
        }
        if(getSupportActionBar() != null) {
            getSupportActionBar().setTitle(getString(R.string.welcome_user_title, fullname));
        }

        rootView = findViewById(R.id.ly_root);
        setupPointListView();

        findViewById(R.id.fab_add).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //navigateToSaveScreen();
            }
        });


    }
    @Override
    protected void onResume() {
        super.onResume();
        loadData();
    }

    private void setupPointListView() {


        RecyclerView rvPoints = findViewById(R.id.rv_actividades);
        mPointsAdapter = new AdaptadorActividades(mModelList, this);
        rvPoints.setAdapter(mPointsAdapter);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getBaseContext());
        rvPoints.setLayoutManager(layoutManager);
        rvPoints.setHasFixedSize(true);
    }

    private void loadData() {

        if(!mModelList.isEmpty()) {
            Log.d(TAG, "Ya existen valores en la lista");
            return;
        }
        if(mPointsRepository == null) {
            Log.e(TAG, "mPointsRepository no debería ser null");
            return;
        }
        mModelList = mPointsRepository.getAll();
        mPointsAdapter.updateList(mModelList);
    }

    @Override
    public void onItemTap(View view, int position) {
        showMessageWithSelectedItem(position);
    }

    private void showMessageWithSelectedItem(int position) {
        if(mModelList == null) {
            Log.e(TAG, "invalid mModelList");
            return;
        }
        if(position > mModelList.size()) {
            Log.e(TAG, "invalid position");
            return;
        }

        ModeloActividades selectedItemModel = mModelList.get(position);
        Snackbar.make(rootView,
                String.format(Locale.getDefault(),
                        "Has seleccionado %s", selectedItemModel.getNombre()
                ),
                Snackbar.LENGTH_LONG
        ).show();
    }



}





