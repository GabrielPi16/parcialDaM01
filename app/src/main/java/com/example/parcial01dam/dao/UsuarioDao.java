package com.example.parcial01dam.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.example.parcial01dam.model.Usuario;

import java.util.List;

@Dao
public interface UsuarioDao {
    @Insert
    void insert(Usuario usuario);

    @Delete
    void delete(Usuario usuario);

    @Update
    void uptate(Usuario usuario);

    @Query("SELECT * FROM users WHERE id = :id LIMIT 1")
    Usuario search(String id);
}