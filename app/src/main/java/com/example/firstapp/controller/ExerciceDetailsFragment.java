package com.example.firstapp.controller;

import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.firstapp.R;
import com.example.firstapp.model.ExercicesBank;
import com.example.firstapp.model.ViewModel;

/**
 * A simple {@link Fragment} subclass.
 */
public class ExerciceDetailsFragment extends Fragment {

    private ExercicesBank exercicesBank;
    private int exerciceID;
    private TextView exerciceDetails;
    private ImageView exerciceImage;
    private ViewModel model;

    public ExerciceDetailsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.activity_exercice_details, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {

        exerciceDetails = (TextView) getView().findViewById(R.id.activity_exercices_exerciceDetails_text);
        exerciceImage = (ImageView) getView().findViewById(R.id.activity_exercices_exerciceDetails_image);
        setExerciceDetails(exerciceDetails);
        setExerciceImage(exerciceImage);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        model = ViewModelProviders.of(getActivity()).get(ViewModel.class);
        exercicesBank = model.getExerciceBank();
        exerciceID = getArguments().getInt("ExerciceID", 0);
    }

    private void setExerciceDetails(TextView exerciceDetail){
        String exerciceDetailsString = exercicesBank.getExerciceList().get(exerciceID).getType()+"\n"+exercicesBank.getExerciceList().get(exerciceID).getTarget();
        exerciceDetail.setText(exerciceDetailsString);
    }

    private void setExerciceImage(ImageView exerciceImage){
        int resId = exercicesBank.getExerciceList().get(exerciceID).getResId();
        exerciceImage.setImageResource(resId);
    }

}