package com.company.entity;


import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class User {
    private int id;
    private String name;
    private String surname;
    private String email;
    private String password;
    private boolean gender;
    private String imgurl;

    public User(String name, String surname, String email, String password, boolean gender, String imgurl) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.password = password;
        this.gender = gender;
        this.imgurl = imgurl;
    }

    public boolean getGender() {
        return gender;
    }
}
