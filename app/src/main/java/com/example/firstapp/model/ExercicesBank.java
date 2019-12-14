package com.example.firstapp.model;
import java.util.List;

public class ExercicesBank {

    private List<Exercice> exerciceList;

    public ExercicesBank(List<Exercice> exericeList) {
        this.exerciceList = exericeList;
    }

    public List<Exercice> getExerciceList() {
        return exerciceList;
    }

}