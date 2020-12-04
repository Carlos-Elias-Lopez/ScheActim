package com.example.scheactim;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.scheactim.Fragments.ActividadesFragment;
import com.example.scheactim.Fragments.DiasFragment;
import com.example.scheactim.Fragments.MainFragment;
import com.example.scheactim.Fragments.SemanasFragment;
import com.google.android.material.navigation.NavigationView;

public class MenuPrincipal extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    //Agrega los componentes de UI
    DrawerLayout drawerLayout;
    ActionBarDrawerToggle actionBarDrawerToggle;
    Toolbar toolbar;
    NavigationView navigationView;

    //Agregar los el fragment principal
    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_principal);

        //manda a llamr a todos los layouts con sus menu
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        drawerLayout = findViewById(R.id.drawer);
        navigationView = findViewById(R.id.navigationView);

        //lo sgt se implementa luego de haber implementado NavigationView.OnNavigationItemSelectedListener
        navigationView.setNavigationItemSelectedListener(this);

        //aqui los une y sincroniza
        actionBarDrawerToggle = new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.open,R.string.close);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.setDrawerIndicatorEnabled(true);
        actionBarDrawerToggle.syncState();

       //cargar fragment principal en la actividad
        fragmentManager = getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.container_fragment,new MainFragment());
        fragmentTransaction.commit();




    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

        //para cerrar automaticamente el menu
        drawerLayout.closeDrawer(GravityCompat.START);

        if(menuItem.getItemId() == R.id.home){
            fragmentManager = getSupportFragmentManager();
            fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.container_fragment,new MainFragment());
            fragmentTransaction.commit();
        }
        if(menuItem.getItemId() == R.id.ver_actividad){
            fragmentManager = getSupportFragmentManager();
            fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.container_fragment,new ActividadesFragment());
            fragmentTransaction.commit();
        }
        if(menuItem.getItemId() == R.id.vista_semanal){
            fragmentManager = getSupportFragmentManager();
            fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.container_fragment,new SemanasFragment());
            fragmentTransaction.commit();
        }
        if(menuItem.getItemId() == R.id.vista_diaria){
            fragmentManager = getSupportFragmentManager();
            fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.container_fragment,new DiasFragment());
            fragmentTransaction.commit();
        }


        return false;

    }
}