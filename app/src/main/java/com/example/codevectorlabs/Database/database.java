package com.example.codevectorlabs.Database;
import android.content.Context;
import android.os.AsyncTask;
import androidx.annotation.NonNull;
import androidx.room.Dao;
import androidx.room.Database;
import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import com.example.codevectorlabs.Database.Dao.personDetailsDao;
import com.example.codevectorlabs.Database.Dao.postDao;
import com.example.codevectorlabs.Database.model.personDetails;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import com.example.codevectorlabs.Database.model.post;


@Database(entities =  {personDetails.class,post.class} , version = 2 , exportSchema = false)
public abstract class database extends RoomDatabase {

    //Write all Dao's here
    public abstract personDetailsDao personDao();
    public abstract postDao postsDao();


    private static volatile database INSTANCE;

    public static final ExecutorService databaseWriteExecutor = Executors.newFixedThreadPool(4);

    public static database getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (database.class) {
                if (INSTANCE == null) {
                    synchronized (database.class) {
                        if (INSTANCE == null) {
                            INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                                    database.class, "myDatabase")
                                    .addCallback(sRoomDatabaseCallback)
                                    .allowMainThreadQueries()
                                    .build();
                        }
                    }
                }
            }
        }
        return INSTANCE;
    }


    private static RoomDatabase.Callback sRoomDatabaseCallback = new RoomDatabase.Callback() {
        @Override
        public void onOpen(@NonNull SupportSQLiteDatabase db) {
            super.onOpen(db);
            databaseWriteExecutor.execute(() -> {
//
//                WordDao dao = INSTANCE.wordDao();
//                dao.deleteAll();
//
//                Word word = new Word("Hello");
//                dao.insert(word);
//                word = new Word("World");
//                dao.insert(word);
            });
        }
    };

}
