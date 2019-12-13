package com.example.firstapp.controller;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.firstapp.R;
import com.example.firstapp.model.ViewModel;
import com.example.firstapp.model.WorkoutsList;

/**
 * A simple {@link Fragment} subclass.
 */
public class StartWorkoutFragment extends Fragment {

    private int workoutID;
    private int exerciceID;
    private TextView exerciceDetails;
    private ImageView exerciceImage;

    private Button back;
    private Button next;
    private ViewModel model;

    private WorkoutsList workoutsList;



    public StartWorkoutFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_start_workout, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {

        back = (Button) getView().findViewById(R.id.fragment_start_workout_back_btn);
        back.setEnabled(true);
        back.setTag(0);

        next = (Button) getView().findViewById(R.id.fragment_start_workout_next_btn);
        next.setEnabled(true);
        next.setTag(0);

        exerciceDetails = (TextView) getView().findViewById(R.id.fragment_start_workout_exerciceDetails_text);
        exerciceImage = (ImageView) getView().findViewById(R.id.fragment_start_workout_exerciceDetails_image);

        setExerciceDetails();
        setExerciceImage();

        back.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                displayEvent(0);
            }
        });

        next.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                displayEvent(1);
            }
        });

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        exerciceID = 0;
        workoutID = getArguments().getInt("WorkoutID", 0);

        model = ViewModelProviders.of(getActivity()).get(ViewModel.class);
        workoutsList = model.getWorkoutsList();

    }

    private void setExerciceDetails(){
        String exerciceDetailsString = workoutsList.getWorkoutsList().get(workoutID).getExercicesList().get(exerciceID).getType()+"\n"
                                      +workoutsList.getWorkoutsList().get(workoutID).getExercicesList().get(exerciceID).getTarget();
        exerciceDetails.setText(exerciceDetailsString);
    }

    private void setExerciceImage(){
        int resId = workoutsList.getWorkoutsList().get(workoutID).getExercicesList().get(exerciceID).getResId();
        exerciceImage.setImageResource(resId);
    }

    private void displayEvent(int button){
        if(button==0){
            if(exerciceID>0){
                exerciceID--;
                setExerciceDetails();
                setExerciceImage();
            }
        }

        else{
            if(exerciceID<workoutsList.getWorkoutsList().get(workoutID).getExercicesList().size()-1){
                exerciceID++;
                setExerciceDetails();
                setExerciceImage();
            }
            else{
                //workout finished
                //back to workoutsFragment

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
    }

}