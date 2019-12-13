package com.example.firstapp.model;
import java.util.List;

public class Exercice {

    private String name;
    private String type; //muscu, cardio, etirement
    private List<String> target;
    private int index;
    private int resId;

    public Exercice(String name, String type, List<String> target, int resId, int index) {
        this.name = name;
        this.type = type;
        this.target = target;
        this.resId = resId;
        this.index = index;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public List<String> getTarget() {
        return target;
    }

    public int getResId() { return resId;}

}
