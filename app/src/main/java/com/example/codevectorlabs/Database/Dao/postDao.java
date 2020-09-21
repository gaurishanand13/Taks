package com.example.codevectorlabs.Database.Dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import com.example.codevectorlabs.Database.model.post;

import java.util.List;

@Dao
public interface postDao {

    @Query("SELECT * FROM post_details_table ORDER BY ID DESC")
    LiveData<List<post> > getAllPosts();

    @Insert
    void insert(post p);


}
