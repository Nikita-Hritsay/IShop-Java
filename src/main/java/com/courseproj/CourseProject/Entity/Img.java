package com.courseproj.CourseProject.Entity;

public class Img {
    private int idImg;
    private String name;
    private String path_to_file;

    public Img() {
    }

    public Img(int idImg, String name, String path_to_file) {
        this.idImg = idImg;
        this.name = name;
        this.path_to_file = path_to_file;
    }

    @Override
    public String toString() {
        return "Img{" +
                "idImg=" + idImg +
                ", name='" + name + '\'' +
                ", path_to_file='" + path_to_file + '\'' +
                '}';
    }

    public int getIdImg() {
        return idImg;
    }

    public void setIdImg(int idImg) {
        this.idImg = idImg;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPath_to_file() {
        return path_to_file;
    }

    public void setPath_to_file(String path_to_file) {
        this.path_to_file = path_to_file;
    }
}
