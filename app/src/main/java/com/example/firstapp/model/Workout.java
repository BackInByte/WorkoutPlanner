package com.example.firstapp.model;

import java.util.Arrays;
import java.util.List;

public class Workout {

    private String name;
    private List<Exercice> exercicesList;

    public Workout(String name, List<Exercice> exercicesList){
        this.name = name;
        this.exercicesList = exercicesList;
    }

    public String getName() {
        return name;
    }
    public List<Exercice> getExercicesList() {
        return exercicesList;
    }
    public void setExercicesList(List<Exercice> exercicesList){ this.exercicesList = exercicesList;}

    //fonctions pour la lecture d'un Workout :

    public static Workout addWorkout1Exercices(List<Exercice> exercicelist){

        Exercice exercice1 = exercicelist.get(0);
        Exercice exercice2 = exercicelist.get(1);
        Exercice exercice3 = exercicelist.get(2);
        Exercice exercice4 = exercicelist.get(3);
        Exercice exercice5 = exercicelist.get(4);
        Exercice exercice6 = exercicelist.get(5);
        Exercice exercice7 = exercicelist.get(6);
        Exercice exercice8 = exercicelist.get(7);
        Exercice exercice9 = exercicelist.get(8);
        Exercice exercice10 = exercicelist.get(9);
        Exercice exercice11 = exercicelist.get(10);
        Exercice exercice12 = exercicelist.get(11);
        Exercice exercice13 = exercicelist.get(12);
        Exercice exercice14 = exercicelist.get(13);

        List<Exercice> exerciceList1 = Arrays.asList(exercice1, exercice2, exercice3, exercice4, exercice5, exercice6, exercice7, exercice8, exercice9, exercice10, exercice11, exercice12, exercice13, exercice14);

        return new Workout("workout1", exerciceList1);

    }

    public static Workout addWorkout2Exercices(List<Exercice> exercicelist){

        Exercice exercice7 = exercicelist.get(6);
        Exercice exercice8 = exercicelist.get(7);
        Exercice exercice9 = exercicelist.get(8);
        Exercice exercice10 = exercicelist.get(9);
        Exercice exercice11 = exercicelist.get(10);
        Exercice exercice12 = exercicelist.get(11);
        Exercice exercice13 = exercicelist.get(12);
        Exercice exercice14 = exercicelist.get(13);

        List<Exercice> exerciceList2 = Arrays.asList(exercice7, exercice8, exercice9, exercice10, exercice11, exercice12, exercice13, exercice14);

        return new Workout("workout2", exerciceList2);

    }

    public static Workout addWorkout3Exercices(List<Exercice> exercicelist){

        Exercice exercice1 = exercicelist.get(0);
        Exercice exercice2 = exercicelist.get(1);
        Exercice exercice3 = exercicelist.get(2);

        Exercice exercice11 = exercicelist.get(10);
        Exercice exercice12 = exercicelist.get(11);
        Exercice exercice13 = exercicelist.get(12);
        Exercice exercice14 = exercicelist.get(13);

        List<Exercice> exerciceList3 = Arrays.asList(exercice1, exercice2, exercice3, exercice11, exercice12, exercice13, exercice14);

        return new Workout("workout3", exerciceList3);
    }

    public boolean containsExercice(String exerciceName){

        boolean result = false;

        for(int i=0; i<this.getExercicesList().size();i++){
            if(this.getExercicesList().get(i).getName().equals(exerciceName)){
                result = true;
            }
        }
        return result;
    }

}