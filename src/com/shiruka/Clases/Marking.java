package com.shiruka.Clases;

public class Marking implements Comparable<Marking>{

    private Integer id;
    private String name;
    private String att;
    private int chance;

    public Marking(int id, String name, String att, int chance) {
        this.id = id;
        this.name = name;
        this.att = att;
        this.chance = chance;
    }

    public Marking() {
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

    public String getAtt() {
        return att;
    }

    public void setAtt(String att) {
        this.att = att;
    }

    public int getChance() {
        return chance;
    }

    public void setChance(int chance) {
        this.chance = chance;
    }

    @Override
    public String toString() {
        return "Marking{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", att='" + att + '\'' +
                ", chance=" + chance +
                '}';
    }

    @Override
    public int compareTo(Marking o) {
        return this.id.compareTo(o.getId());
    }
}
