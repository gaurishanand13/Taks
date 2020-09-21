package com.example.codevectorlabs.Repositary;
import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;
import com.example.codevectorlabs.Database.model.post;
import com.example.codevectorlabs.Database.Dao.postDao;
import com.example.codevectorlabs.Database.Dao.personDetailsDao;
import com.example.codevectorlabs.Database.model.personDetails;
import com.example.codevectorlabs.Database.database;
import java.util.List;

public class RegisterLoginRepositary {

    private postDao mPostDao;
    private personDetailsDao  mPersonDetailsDao;
    private LiveData<List<post>> allPosts;

    public RegisterLoginRepositary(Application application) {
        database db = database.getDatabase(application);
        mPostDao = db.postsDao();
        mPersonDetailsDao = db.personDao();
        allPosts = mPostDao.getAllPosts();
    }


    public LiveData<List<post>> getAllPosts() {
        return allPosts;
    }

    public List<personDetails> isUniqueUsername(String s){
        return mPersonDetailsDao.isUniqueUsername(s);
    }

    public List<personDetails> isUserExists(String email,String password){
        return mPersonDetailsDao.isUserExists(email,password);
    }

    public List<personDetails> isUniqueEmail(String s) {
        return mPersonDetailsDao.isUniqueEmail(s);
    }

    public void insertPosts(post p) {
        database.databaseWriteExecutor.execute(() -> {
            mPostDao.insert(p);
        });
    }

    public void insertUser(personDetails p){
        database.databaseWriteExecutor.execute(() -> {
            mPersonDetailsDao.insert(p);
        });
    }
}
