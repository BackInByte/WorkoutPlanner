package com.example.firstapp.model;

import java.util.ArrayList;
import java.util.List;

public class WorkoutsList {

    private String name;
    private List<Workout> workoutsList;

    public WorkoutsList(String name){
        this.name = name;
        List<Workout> WorkoutsList = new ArrayList<>();
        this.workoutsList = WorkoutsList;
    }

    public String getName() {
        return name;
    }
    public List<Workout> getWorkoutsList() {
        return workoutsList;
    }

    public void addWorkout(Workout workout){
        this.workoutsList.add(workout);
    }

}