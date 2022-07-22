package com.courseproj.CourseProject.Entity;

public class Chipset {
    private int id;
    private String name;

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

    public Chipset() {
    }

    public Chipset(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Chipset(int id) {
        this.id = id;
    }
}
