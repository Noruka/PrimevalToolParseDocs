package com.shiruka.Clases;

public class Marking implements Comparable<Marking>{

    private Integer id;
    private String name;
    private String att;
    private int chance;
    private String event;
    private String type;

    public Marking(Integer id, String name, String att, int chance, String event, String type) {
        this.id = id;
        this.name = name;
        this.att = att;
        this.chance = chance;
        this.event = event;
        this.type = type;
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

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Marking{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", att='" + att + '\'' +
                ", chance=" + chance +
                ", event='" + event + '\'' +
                ", type='" + type + '\'' +
                '}';
    }

    @Override
    public int compareTo(Marking o) {
        return this.id.compareTo(o.getId());
    }
}
