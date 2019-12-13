package com.example.firstapp.model;

import com.example.firstapp.R;
import com.google.gson.Gson;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

public class ExercicesBank {

    private List<Exercice> exerciceList;

    public ExercicesBank(List<Exercice> exericeList) {
        this.exerciceList = exericeList;
    }

    public List<Exercice> getExerciceList() {
        return exerciceList;
    }

    /*
    public static ExercicesBank addExercices(){

        Exercice exercice1 = new Exercice("Développé couché", "Musculation", Arrays.asList("Pectoraux", "Triceps"), R.mipmap.devellope_couche,1);
        Exercice exercice2 = new Exercice("Développé militaire", "Musculation", Arrays.asList("Dos", "Epaules"), R.mipmap.developpe_militaire,2);
        Exercice exercice3 = new Exercice("Traction", "Musculation", Arrays.asList("Bras", "Dos"), R.mipmap.tractions,3);
        Exercice exercice4 = new Exercice("Squat", "Musculation", Arrays.asList("Cuisses", "Mollets"), R.mipmap.squatts,4);
        Exercice exercice5 = new Exercice("Squat1", "Musculation", Arrays.asList("Cuisses", "Mollets"), R.mipmap.squatts,5);
        Exercice exercice6 = new Exercice("Squat2", "Musculation", Arrays.asList("Cuisses", "Mollets"), R.mipmap.squatts,6);
        Exercice exercice7 = new Exercice("Squat3", "Musculation", Arrays.asList("Cuisses", "Mollets"), R.mipmap.squatts,7);
        Exercice exercice8 = new Exercice("Squat4", "Musculation", Arrays.asList("Cuisses", "Mollets"), R.mipmap.squatts,8);
        Exercice exercice9 = new Exercice("Squat5", "Musculation", Arrays.asList("Cuisses", "Mollets"), R.mipmap.squatts,9);
        Exercice exercice10 = new Exercice("Squat6", "Musculation", Arrays.asList("Cuisses", "Mollets"), R.mipmap.squatts,10);
        Exercice exercice11 = new Exercice("Squat7", "Musculation", Arrays.asList("Cuisses", "Mollets"), R.mipmap.squatts,11);
        Exercice exercice12 = new Exercice("Squat7", "Musculation", Arrays.asList("Cuisses", "Mollets"), R.mipmap.squatts,12);
        Exercice exercice13 = new Exercice("Squat7", "Musculation", Arrays.asList("Cuisses", "Mollets"), R.mipmap.squatts,13);
        Exercice exercice14 = new Exercice("Squat7", "Musculation", Arrays.asList("Cuisses", "Mollets"), R.mipmap.squatts,14);
        Exercice exercice15 = new Exercice("Squat8", "Musculation", Arrays.asList("Cuisses", "Mollets"), R.mipmap.squatts,15);

        List<Exercice> exerciceList = Arrays.asList(exercice1, exercice2, exercice3, exercice4, exercice5, exercice6, exercice7, exercice8, exercice9, exercice10, exercice11, exercice12, exercice13, exercice14, exercice15);

        //String json = new Gson().toJson(exerciceList);

        // gson.toJson(list);
        //données et gson à écrire une seule fois pour envoyer sur internet, ensuite tout effacer et juste écrire commande pour le récupérer

        return new ExercicesBank(exerciceList);

    }*/


    //GSON ou méthode pour aller chercher les données d'un JSON hébergé
}
