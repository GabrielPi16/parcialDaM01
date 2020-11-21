package com.example.parcial01dam;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Switch;

public class MainActivity extends AppCompatActivity {

    EditText txtNombre;
    EditText txtSubName;
    EditText txtUser;
    EditText txtPassw;
    RadioButton radioOpcionA;
    RadioButton radioOpcionB;
    Switch switNotifi;
    CheckBox checkBoxTerminos;
    Button btnAceptar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Obtenemos una referencia a los controles de la interfaz
        txtNombre = findViewById(R.id.txtNombre);
        txtSubName = findViewById(R.id.txtSubName);
        txtUser = findViewById(R.id.txtUser);
        txtPassw = findViewById(R.id.txtPassw);
        radioOpcionA = findViewById(R.id.radioOpcionA);
        radioOpcionB = findViewById(R.id.radioOpcionB);
        switNotifi = findViewById(R.id.switNotifi);
        checkBoxTerminos = findViewById(R.id.checkBoxTerminos);
        btnAceptar = findViewById(R.id.btnAceptar);


    }
}