package com.example.firstapp.controller;

import android.os.Bundle;

import com.example.firstapp.R;
import com.example.firstapp.model.Exercice;
import com.example.firstapp.model.ViewModel;

import com.google.android.material.navigation.NavigationView;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import android.view.MenuItem;
import androidx.core.view.GravityCompat;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.ViewModelProviders;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Main2Activity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private DrawerLayout drawer;
    private ViewModel model;
    static final String BASE_URL = "https://backinbyte.github.io/Data/";

    public void start() {

        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        WorkoutAPI workoutAPI = retrofit.create(WorkoutAPI.class);

        Call<List<Exercice>> call = workoutAPI.loadExercices("status:open");
        call.enqueue(new Callback<List<Exercice>>() {
            @Override
            public void onResponse(Call<List<Exercice>> call, Response<List<Exercice>> response) {
                if(response.isSuccessful()) {
                    List<Exercice> exerciceList;
                    exerciceList = response.body();
                    System.out.println("SUCCESS!");
                    exerciceList.forEach(exercice -> System.out.println(exercice.getName()+exercice.getType()+exercice.getTarget()));
                    model.addData(exerciceList);
                } else {
                    System.out.println("FAIL!");
                    System.out.println(response.code());
                    System.out.println(response.body());
                    System.out.println(response.errorBody());
                }
            }

            @Override
            public void onFailure(Call<List<Exercice>> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        //pour récupérer variable stockée dans ViewModel
        model = ViewModelProviders.of(this).get(ViewModel.class);

        this.start();

        setTitle("Workout Planner");
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        selectDrawerItem(item);
        return true;
    }

    public void selectDrawerItem(MenuItem menuItem) {
        // Create a new fragment and specify the fragment to show based on nav item clicked
        Fragment fragment = null;
        Class fragmentClass;

        Bundle args = new Bundle();

        switch (menuItem.getItemId()) {

        case R.id.nav_home:
            fragmentClass = ExercicesFragment.class;
            args.putBoolean("chooseExercices", false);
            break;
        case R.id.nav_gallery:
            fragmentClass = WorkoutsFragment.class;
            break;
        default:
            fragmentClass = ExercicesFragment.class;
        }

        try {
            fragment = (Fragment) fragmentClass.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }

        fragment.setArguments(args);

        // Insert the fragment by replacing any existing fragment
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.flContent, fragment).commit();

        // Highlight the selected item has been done by NavigationView
        menuItem.setChecked(true);
        // Set action bar title
        setTitle(menuItem.getTitle());
        // Close the navigation drawer
        drawer.closeDrawers();
    }
}