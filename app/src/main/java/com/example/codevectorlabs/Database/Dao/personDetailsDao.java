package com.example.codevectorlabs.Database.Dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.codevectorlabs.Database.model.personDetails;
import com.example.codevectorlabs.Database.model.post;

import java.util.List;



@Dao
public interface personDetailsDao {

    @Insert
    void insert(personDetails p);

    @Query("SELECT * FROM person_details_table")
    LiveData<List<personDetails> > getAllUsers();

    @Update
    void update(personDetails p);

    @Delete
    void delete(personDetails p);

    @Query("DELETE FROM person_details_table")
    void deleteAllPersons();

    @Query("SELECT * FROM person_details_table ORDER BY name DESC")
    LiveData<List<personDetails> > getAllPersons();


    @Query("SELECT * FROM person_details_table WHERE username=:usName")
    List<personDetails> isUniqueUsername(String usName);


    @Query("SELECT * FROM person_details_table WHERE email=:email")
    List<personDetails> isUniqueEmail(String email);


    @Query("SELECT * FROM person_details_table WHERE email=:email AND password=:password")
    List<personDetails> isUserExists(String email, String password);
}
