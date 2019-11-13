package com.shiruka.Clases;

import java.util.ArrayList;

public class Dino {

    private String name;
    private int id;
    private String species;
    private String sex;
    private String color;
    private ArrayList<Marking> markings;

    public Dino()
    {
    }

    public Dino(String name, int id,  String species, String sex, String color, ArrayList<Marking> markings) {
        this.name = name;
        this.id = id;
        this.species = species;
        this.sex = sex;
        this.color = color;
        this.markings = markings;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public ArrayList<Marking> getMarkings() {
        return markings;
    }

    public void setMarkings(ArrayList<Marking> markings) {
        this.markings = markings;
    }

    @Override
    public String toString() {
        return "Dino{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", species='" + species + '\'' +
                ", sex='" + sex + '\'' +
                ", color='" + color + '\'' +
                ", markings=" + markings.toString() +
                '}';
    }
}
