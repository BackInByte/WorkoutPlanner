package com.example.firstapp.model;

import java.util.List;

public class ViewModel extends androidx.lifecycle.ViewModel {

    private ExercicesBank exercicesBank;
    private WorkoutsList workoutsList;

    public WorkoutsList getWorkoutsList(){ return workoutsList;}
    public ExercicesBank getExerciceBank(){return this.exercicesBank;}

    public void addData(List<Exercice> exerciceList){
        Workout workout1 = Workout.addWorkout1Exercices(exerciceList);
        Workout workout2 = Workout.addWorkout2Exercices(exerciceList);
        Workout workout3 = Workout.addWorkout3Exercices(exerciceList);

        workoutsList = new WorkoutsList("Workout List 1");

        workoutsList.addWorkout(workout1);
        workoutsList.addWorkout(workout2);
        workoutsList.addWorkout(workout3);

        exercicesBank = new ExercicesBank(exerciceList);
    }

}