package com.example.codevectorlabs.Database.model;
import android.net.Uri;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;


@Entity(tableName = "person_details_table")
public class personDetails {

    @NonNull
    @PrimaryKey
    private String email;

    private String username;
    private String password;
    private String name;
    private String profilePhoto;


    public personDetails(String username, String password, String name, String profilePhoto,String email) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.profilePhoto = profilePhoto;
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setProfilePhoto(String profilePhoto) {
        this.profilePhoto = profilePhoto;
    }

    public String getProfilePhoto() {
        return profilePhoto;
    }



//    public void setProfilePhoto(Uri profilePhoto) {
//        this.profilePhoto = profilePhoto.toString();
//    }
}


