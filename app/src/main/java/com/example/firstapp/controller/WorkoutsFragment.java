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

import com.example.firstapp.R;
import com.example.firstapp.model.ViewModel;
import com.example.firstapp.model.WorkoutsList;

/**
 * A simple {@link Fragment} subclass.
 */
public class WorkoutsFragment extends Fragment {

    private Button AddWorkout;
    private Button StartWorkout;
    private WorkoutsList workoutsList;
    private LinearLayout linearLayout;
    private ViewModel model;
    private int chooseWorkoutToStart;

    public WorkoutsFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        model = ViewModelProviders.of(getActivity()).get(ViewModel.class);
        workoutsList = model.getWorkoutsList();
        chooseWorkoutToStart = getArguments().getInt("chooseWorkoutToStart", 0);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_workouts, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {

        AddWorkout = (Button) getView().findViewById(R.id.activity_exercices_addworkout_btn);
        AddWorkout.setEnabled(true);
        AddWorkout.setTag(0);

        StartWorkout = (Button) getView().findViewById(R.id.activity_exercices_startworkout_btn);
        StartWorkout.setEnabled(true);
        StartWorkout.setTag(0);

        if(chooseWorkoutToStart==1){
            AddWorkout.setVisibility(View.GONE);
            StartWorkout.setVisibility(View.GONE);
            TextView textView = getView().findViewById(R.id.activity_exercices_Workout_text);
            textView.setText("Click on a workout to start it");
        }

        linearLayout = getView().findViewById(R.id.activity_exercices_LinearLayout);

    }


    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        addExerciceButtons();
    }

    private void addExerciceButtons() {

        for (int i = 0; i < workoutsList.getWorkoutsList().size(); i++) {
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT);
            Button btn = new Button(getActivity());
            btn.setId(i + 1);
            final int id = btn.getId();
            btn.setText(workoutsList.getWorkoutsList().get(i).getName());
            // btn.setBackgroundColor(Color.rgb(70, 80, 90));
            linearLayout.addView(btn, params);
            Button btn1 = (Button) getView().findViewById(id);


            btn1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {

                    if(chooseWorkoutToStart == 0) {

                        ExercicesFragment exercicesFragment = new ExercicesFragment();

                        Bundle args = new Bundle();
                        args.putInt("WorkoutID", id - 1);
                        args.putInt("chooseExercices", 0);
                        exercicesFragment.setArguments(args);

                        getActivity().getSupportFragmentManager().beginTransaction()
                                .replace(R.id.flContent, exercicesFragment, "findThisFragment")
                                .addToBackStack(null)
                                .commit();

                    }

                    else{

                        StartWorkoutFragment startWorkoutFragment = new StartWorkoutFragment();

                        Bundle args = new Bundle();
                        args.putInt("WorkoutID", id - 1);
                        startWorkoutFragment.setArguments(args);

                        getActivity().getSupportFragmentManager().beginTransaction()
                                .replace(R.id.flContent, startWorkoutFragment, "findThisFragment")
                                .addToBackStack(null)
                                .commit();

                    }

                }
            });
        }


        AddWorkout.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {

                ExercicesFragment exercicesFragment = new ExercicesFragment();

                Bundle args = new Bundle();
                args.putInt("chooseExercices", 1);
                exercicesFragment.setArguments(args);

                getActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.flContent, exercicesFragment, "findThisFragment")
                        .addToBackStack(null)
                        .commit();

            }
        });


        StartWorkout.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {

                WorkoutsFragment workoutsFragment = new WorkoutsFragment();

                Bundle args = new Bundle();
                args.putInt("chooseWorkoutToStart", 1);
                workoutsFragment.setArguments(args);

                getActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.flContent, workoutsFragment, "findThisFragment")
                        .addToBackStack(null)
                        .commit();

            }
        });

    }
}