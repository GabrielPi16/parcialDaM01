package com.example.parcial01dam.dao;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import com.example.parcial01dam.model.Usuario;

import java.util.concurrent.Executor;

@Database(entities = {Usuario.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {

    public static final String DATABASE_NAME = "AppDatabase";
    public static Executor databaseWriteExecutor;

    public abstract UsuarioDao usuarioDao();
    private static volatile AppDatabase instance;
    private static final Object Lock = new Object();

    public static AppDatabase getInstance(Context context){
        if(instance==null){
            synchronized (Lock){
                if(instance==null){
                    instance= Room.databaseBuilder(context.getApplicationContext(),
                            AppDatabase.class, DATABASE_NAME).build();
                }
            }
        }
        return instance;
    }
}
