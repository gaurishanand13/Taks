package com.example.codevectorlabs.Database.model;
import android.net.Uri;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "post_details_table")
public class post {

    @NonNull
    @PrimaryKey(autoGenerate = true)
    private int ID;


    private String uploadingTime;
    private String email;
    private String profileImage;
    private String uploadedImage;
    private String name;
    private String caption;


    public post(@NonNull String uploadingTime, String email, String profileImage, String uploadedImage, String name, String caption) {
        this.uploadingTime = uploadingTime;
        this.email = email;
        this.profileImage = profileImage;
        this.uploadedImage = uploadedImage;
        this.name = name;
        this.caption = caption;
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public String getProfileImage() {
        return profileImage;
    }

    public void setProfileImage(String profileImage) {
        this.profileImage = profileImage;
    }

    public String getUploadedImage() {
        return uploadedImage;
    }

    public void setUploadedImage(String uploadedImage) {
        this.uploadedImage = uploadedImage;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUploadingTime() {
        return uploadingTime;
    }

    public void setUploadingTime(String uploadingTime) {
        this.uploadingTime = uploadingTime;
    }
}
