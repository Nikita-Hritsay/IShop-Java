package com.courseproj.CourseProject.Entity;

public class User {
    private int idUser;
    private String Login;
    private String User_password;
    private String Firstname;
    private String Lastname;
    private String Patronymic;
    private String telephone;
    private int idRole;

    @Override
    public String toString() {
        return "User{" +
                "idUser=" + idUser +
                ", Login=" + Login +
                ", User_password=" + User_password +
                ", Firstname='" + Firstname + '\'' +
                ", Lastname='" + Lastname + '\'' +
                ", Patronymic='" + Patronymic + '\'' +
                ", telephone='" + telephone + '\'' +
                ", idRole=" + idRole +
                '}';
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public User() {
    }

    public String getLogin() {
        return Login;
    }

    public void setLogin(String login) {
        Login = login;
    }

    public String getUser_password() {
        return User_password;
    }

    public void setUser_password(String user_password) {
        User_password = user_password;
    }

    public String getFirstname() {
        return Firstname;
    }

    public void setFirstname(String firstname) {
        Firstname = firstname;
    }

    public String getLastname() {
        return Lastname;
    }

    public void setLastname(String lastname) {
        Lastname = lastname;
    }

    public String getPatronymic() {
        return Patronymic;
    }

    public void setPatronymic(String patronymic) {
        Patronymic = patronymic;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public int getIdRole() {
        return idRole;
    }

    public void setIdRole(int idRole) {
        this.idRole = idRole;
    }

    public User(String login, String user_password, String firstname, String lastname, String patronymic, String telephone, int idRole) {
        Login = login;
        User_password = user_password;
        Firstname = firstname;
        Lastname = lastname;
        Patronymic = patronymic;
        this.telephone = telephone;
        this.idRole = idRole;
    }

    public User(int idUser, String login, String user_password, String firstname, String lastname, String patronymic, String telephone, int idRole) {
        this.idUser = idUser;
        Login = login;
        User_password = user_password;
        Firstname = firstname;
        Lastname = lastname;
        Patronymic = patronymic;
        this.telephone = telephone;
        this.idRole = idRole;
    }
}
