package com.example.codevectorlabs.ViewModel;
import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.codevectorlabs.Repositary.RegisterLoginRepositary;
import com.example.codevectorlabs.Database.model.post;
import com.example.codevectorlabs.Database.model.personDetails;
import java.util.List;

public class LoginViewModel extends ViewModel {

    private RegisterLoginRepositary mRepository;
    private LiveData<List<post>> mAllPosts;

    public void initialize(Application application){
        mRepository = new RegisterLoginRepositary(application);
        mAllPosts = mRepository.getAllPosts();
    }




    public LiveData<List<post>> getAllPosts() {
        return mAllPosts;
    }

    public void insertPost(post p) {
        mRepository.insertPosts(p);
    }



    public void insertUser(personDetails p) {
        mRepository.insertUser(p);
    }

    public boolean isUnqiueEmail(String s){
        if(mRepository.isUniqueEmail(s).size()!=0){
            return false;
        }
        else{
            return true;
        }
    }

    public List<personDetails> isUserExists(String email,String password){
        return mRepository.isUserExists(email,password);
    }

    public boolean isUniqueUsername(String s){
        if(mRepository.isUniqueUsername(s).size()!=0){
            return false;
        }
        else{
            return true;
        }
    }

}
