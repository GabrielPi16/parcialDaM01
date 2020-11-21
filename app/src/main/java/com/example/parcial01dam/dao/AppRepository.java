package com.example.parcial01dam.dao;

import android.app.Application;
import android.util.Log;

import com.example.parcial01dam.model.Usuario;

import java.util.List;

public class AppRepository implements OnUsuarioResultCallback {
    private UsuarioDao usuarioDao;
    private OnResultCallback callback;

    public AppRepository(Application application, OnResultCallback context){
        AppDatabase db = AppDatabase.getInstance(application);
        usuarioDao = db.usuarioDao();
        callback = context;
    }

    public void insertar(final Usuario usuario){
        AppDatabase.databaseWriteExecutor.execute(new Runnable() {
            @Override
            public void run() {
                usuarioDao.insert(usuario);
            }
        });
    }

    public void borrar(final Usuario usuario){
        AppDatabase.databaseWriteExecutor.execute(new Runnable() {
            @Override
            public void run() {
                usuarioDao.delete(usuario);
            }
        });
    }

    public void actualizar(final Usuario usuario){
        AppDatabase.databaseWriteExecutor.execute(new Runnable() {
            @Override
            public void run() {
                usuarioDao.uptate(usuario);
            }
        });
    }

    @Override
    public void onResult(List<Usuario> usuarioList) {
        Log.d("DEBUG", "Usuario found");
        callback.onResult(usuarioList);
    }

    public interface OnResultCallback<T> {
        void onResult(List<T> result);
    }
}
