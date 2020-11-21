package com.example.parcial01dam;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Switch;
import android.widget.Toast;

import com.example.parcial01dam.model.Usuario;

public class MainActivity extends AppCompatActivity {

    EditText txtNombre;
    EditText txtSubName;
    EditText txtUser;
    EditText txtPassw;
    EditText txtNTarjeta;
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
        txtNTarjeta = findViewById(R.id.txtNTarjeta);
        radioOpcionA = findViewById(R.id.radioOpcionA);
        radioOpcionB = findViewById(R.id.radioOpcionB);
        switNotifi = findViewById(R.id.switNotifi);
        checkBoxTerminos = findViewById(R.id.checkBoxTerminos);
        btnAceptar = findViewById(R.id.btnAceptar);

        if(txtNombre.getText().toString().isEmpty()) {
            txtNombre.setError("El campo Nombre esta vacio.");
        }

        if(txtUser.getText().toString().isEmpty()) {
            txtUser.setError("El campo Usuario esta vacio.");
        }

        if(txtPassw.getText().toString().isEmpty()) {
            txtPassw.setError("El campo Contraseña esta vacio.");
        }

        //los radiobutton seleccionado alguno de los dos
        if(!(radioOpcionA.isChecked()) && !(radioOpcionB.isChecked())){
            Toast.makeText(MainActivity.this, "Ingresar un tipo de tarjeta", Toast.LENGTH_LONG).show();
        }

        checkBoxTerminos.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                //si el checkbox esta activado, el boton registrar tambien y entra a la validacion
                if(checkBoxTerminos.isChecked()){
                    btnAceptar.setEnabled(true);
                    btnAceptar.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            //lo que haga el boton registrar
                            if(validacion()) {
                                safeUsuario();
                                Toast.makeText(MainActivity.this, "Registro Exitoso", Toast.LENGTH_LONG).show();
                            }
                            else{
                                Toast.makeText(MainActivity.this, "ERROR: Verifique los datos ingresados. Puede faltar campos por completar.", Toast.LENGTH_LONG).show();
                            }
                        }
                    });
                }
                else { // si no se desctiva el boton registrar
                    Toast.makeText(MainActivity.this,"No acepto terminos y condiciones",Toast.LENGTH_LONG).show();
                    btnAceptar.setEnabled(false);
                }
            }
        });
    }

    public boolean validacion() {

        if(!(radioOpcionA.isChecked()) && !(radioOpcionB.isChecked())){
            radioOpcionA.setError("Ingresar un tipo de tarjeta");
            Toast.makeText(MainActivity.this, "Ingresar un tipo de tarjeta", Toast.LENGTH_LONG).show();
            return false;
        }

        if(txtNombre.getText().toString().isEmpty()) {
            txtNombre.setError("El campo Nombre esta vacio.");
            return false;
        }

        if(txtUser.getText().toString().isEmpty()) {
            txtUser.setError("El campo Usuario esta vacio.");
            return false;
        }

        if(txtPassw.getText().toString().isEmpty()) {
            txtPassw.setError("El campo Contraseña esta vacio.");
            return false;
        }

        if(txtNTarjeta.getText().toString().isEmpty()){
            txtNTarjeta.setError("El numero de tarjeta es obligatorio ");
            return false;
        }

        return true;
    }

    private void safeUsuario() {

        Usuario usuario = new Usuario();

        usuario.setTxtNombre(txtNombre.getText().toString());
        usuario.setTxtSubName(txtSubName.getText().toString());
        usuario.setTxtUser(txtUser.getText().toString());
        usuario.setTxtPassw(txtPassw.getText().toString());
        usuario.setCheckBoxTerminos(checkBoxTerminos.isChecked());
        usuario.setRadioOpcionA(radioOpcionA.isChecked());
        usuario.setRadioOpcionB(radioOpcionB.isChecked());
        usuario.getSwitNotifi(switNotifi.isChecked());

    }
}