package com.example.rodri.rantiklogin;

import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LoginMain extends AppCompatActivity {

    private EditText user;
    private EditText password;

    private Button ingresar;
    private TextView crear;


    private SQLiteHelper sqLiteHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_main);
        sqLiteHelper = new SQLiteHelper(this);

        user = (EditText) findViewById(R.id.txtUsuario);
        password = (EditText) findViewById(R.id.txtPassword);
        crear = (TextView) findViewById(R.id.txtRegistrar);
        ingresar = (Button) findViewById(R.id.btnIngresar);


        ingresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (validar()) {
                    String usuario = user.getText().toString();
                    String contraseña = password.getText().toString();

                    Usuario currentUser = sqLiteHelper.Authenticate(new Usuario(null, null, null, usuario, contraseña));


                    if(currentUser != null){
                        Toast.makeText(LoginMain.this, "Validado correctamente", Toast.LENGTH_LONG).show();
                        Intent intent = new Intent(LoginMain.this, LoginActivity.class);
                        startActivity(intent);

                    }else{
                        Toast.makeText(LoginMain.this, "Fallo en ingresar", Toast.LENGTH_LONG).show();
                    }
                }
            }
        });

        crear.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(getApplicationContext(), CrearActivity.class);
                    startActivity(intent);
                }
        });
    }



    private boolean validar(){
        boolean valido = false;

        String Usuario = user.getText().toString();
        String Password = password.getText().toString();

        if(Usuario.isEmpty()){
            valido = true;
            Toast.makeText(getApplicationContext(), "Ingrese usuario valido", Toast.LENGTH_SHORT).show();
        }else{
            if(Password.length()>5){
                valido = true;
            }else{
                valido = false;
            }
        }
        return valido;
    }


    /*private boolean validar() {
        boolean exito = false;

        if (user.getText().length() >= 7 && password.getText().length() <= 8) {
            if (user.getText().length() >= 8 && isValidPassword(password.getText().toString())) {
                exito = true;
            }
        }
        return exito;
    }
    */


}