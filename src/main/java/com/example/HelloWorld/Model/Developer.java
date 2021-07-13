package com.example.HelloWorld.Model;

public class Developer {

    private int id;
    private String name;
    private String nickname;
    private int age;
    private String email;

    @Override
    public String toString() {
        return "Developer : " +
                "id=" + id +
                ", name=" + name +
                ", nickname=" + nickname +
                ", age=" + age +
                ", email=" + email +
                " <br>";
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

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
