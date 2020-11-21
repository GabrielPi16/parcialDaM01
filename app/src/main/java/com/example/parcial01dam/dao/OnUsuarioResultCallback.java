package com.example.parcial01dam.dao;

import com.example.parcial01dam.model.Usuario;

import java.util.List;

interface OnUsuarioResultCallback {
    void onResult(List<Usuario> usuarioList);
}
