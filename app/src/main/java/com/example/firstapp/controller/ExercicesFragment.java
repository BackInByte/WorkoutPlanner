package com.example.firstapp.controller;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.firstapp.R;
import com.example.firstapp.model.Exercice;
import com.example.firstapp.model.ExercicesBank;
import com.example.firstapp.model.ViewModel;
import com.example.firstapp.model.Workout;
import com.example.firstapp.model.WorkoutsList;

import java.util.ArrayList;
import java.util.List;

import static android.view.View.GONE;

/**
 * A simple {@link Fragment} subclass.
 */
public class ExercicesFragment extends Fragment {

    private Button confirm;
    private ExercicesBank exercicesBank;
    private LinearLayout linearLayout;
    private int workoutID;
    private int chooseExercices;
    private WorkoutsList workoutsList;
    private Workout workout;
    private List<Exercice> newExercicelist;
    private ViewModel model;


    public ExercicesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.activity_exercices, container, false);
    }



    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {

        confirm = (Button) getView().findViewById(R.id.activity_exercices_confirm_btn);
        confirm.setEnabled(true);
        confirm.setTag(0);

        confirm.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Toast.makeText(view.getContext(),
                        "New workout added !", Toast.LENGTH_SHORT)
                        .show();

                confirmNewWorkout();
            }
        });

        if(chooseExercices != 1){
            confirm.setVisibility(GONE);
        }

        else{
            TextView textView = getView().findViewById(R.id.activity_exercices_exercicesList_text);
            textView.setText("Click on exercices you would like to add to a new workout");
        }

        linearLayout = getView().findViewById(R.id.activity_exercices_LinearLayout);

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        model = ViewModelProviders.of(getActivity()).get(ViewModel.class);
        exercicesBank = model.getExerciceBank();
        workoutsList = model.getWorkoutsList();
        newExercicelist = new ArrayList<>();
        workoutID = getArguments().getInt("WorkoutID", -1);
        chooseExercices = getArguments().getInt("chooseExercices", 0);

        if(workoutID != -1){
            workout = workoutsList.getWorkoutsList().get(workoutID);
        }
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        addExerciceButtons();
    }

    //méthode déclenchée lors de l'appui sur le bouton permettant de confirmer le choix des exercices à ajouter dans le nouveau workout
    //Un nouveau Workout est créé à patir de la liste newExerciceList
    private void confirmNewWorkout(){
        if(chooseExercices == 1){
            Workout newWorkout = new Workout("Workout", newExercicelist);
            newWorkout.setExercicesList(newExercicelist);
            workoutsList.addWorkout(newWorkout);

            WorkoutsFragment workoutsFragment = new WorkoutsFragment();

            Bundle args = new Bundle();
            args.putInt("chooseWorkoutToStart", 0);
            workoutsFragment.setArguments(args);

            getActivity().getSupportFragmentManager().beginTransaction()
                    .replace(R.id.flContent, workoutsFragment, "findThisFragment")
                    .addToBackStack(null)
                    .commit();

        }
    }

    //méthode pour afficher les exercices
    private void addExerciceButtons(){

        for (int i = 0; i < exercicesBank.getExerciceList().size(); i++) {

            //si aucun workout n'est spécifié (on affiche alors tous les exercices)
            if (workoutID == -1) {

                LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.MATCH_PARENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT);
                Button btn = new Button(getActivity());
                btn.setId(i + 1);
                final int id = btn.getId();
                btn.setText(exercicesBank.getExerciceList().get(i).getName());
                // btn.setBackgroundColor(Color.rgb(70, 80, 90));
                linearLayout.addView(btn, params);
                final Button btn1 = (Button) getView().findViewById(id);
                btn1.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {

                            //si on ne se trouve pas dans le mode de sélection d'exercices, alors cliquer sur un exercice affiche ses détails
                            if(chooseExercices == 0) {

                                ExerciceDetailsFragment exerciceDetailsFragment = new ExerciceDetailsFragment();

                                Bundle args = new Bundle();
                                args.putInt("ExerciceID", id - 1);
                                exerciceDetailsFragment.setArguments(args);

                                getActivity().getSupportFragmentManager().beginTransaction()
                                        .replace(R.id.flContent, exerciceDetailsFragment, "findThisFragment")
                                        .addToBackStack(null)
                                        .commit();

                            }

                            //si on se trouve dans le mode de sélection d'exercices:
                            else{
                                //appuyer sur un exercices l'ajoute à une nouvelle liste d'exercice


                                if(newExercicelist.contains(exercicesBank.getExerciceList().get(id-1))) {
                                    newExercicelist.remove(exercicesBank.getExerciceList().get(id - 1));
                                    btn1.setBackgroundResource(android.R.drawable.btn_default);
                                }

                                else{
                                    newExercicelist.add(exercicesBank.getExerciceList().get(id - 1));
                                    btn1.setBackgroundColor(0xFF00FF00);
                                }
                            }
                    }
                });
            }

            //si un workout est spécifié (on affiche alors uniquement les exercices contenus dans le workout)
            else {

                if (workout.containsExercice(exercicesBank.getExerciceList().get(i).getName())) {

                    LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                            LinearLayout.LayoutParams.MATCH_PARENT,
                            LinearLayout.LayoutParams.WRAP_CONTENT);
                    Button btn = new Button(getActivity());
                    btn.setId(i + 1);
                    final int id = btn.getId();
                    btn.setText(exercicesBank.getExerciceList().get(i).getName());
                    // btn.setBackgroundColor(Color.rgb(70, 80, 90));
                    linearLayout.addView(btn, params);
                    Button btn1 = (Button) getView().findViewById(id);
                    btn1.setOnClickListener(new View.OnClickListener() {
                        public void onClick(View view) {

                                ExerciceDetailsFragment exerciceDetailsFragment = new ExerciceDetailsFragment();

                                Bundle args = new Bundle();
                                args.putInt("ExerciceID", id - 1);
                                exerciceDetailsFragment.setArguments(args);

                                getActivity().getSupportFragmentManager().beginTransaction()
                                        .replace(R.id.flContent, exerciceDetailsFragment, "findThisFragment")
                                        .addToBackStack(null)
                                        .commit();

                        }
                    });
                }

            }

        }

    }

}
