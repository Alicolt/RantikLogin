package com.example.rodri.rantiklogin;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText etUser;
    private EditText etPW;
    private Button btnIngresar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etUser = (EditText) findViewById(R.id.etUser);
        etPW = (EditText) findViewById(R.id.etPW);
        btnIngresar = (Button) findViewById(R.id.btnIngresar);

        btnIngresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validar(etUser.getText().toString(), etPW.getText().toString());
            }
        });
    }

    public void validar(String etUser, String etPW){

        if(etUser.equals("admin") && etPW.equals("1234")){
            Intent intent = new Intent(this, HomeActivity.class);
            startActivity(intent);
            Toast.makeText(this, "Credenciales validas", Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(this, "Credenciales invalidas", Toast.LENGTH_SHORT).show();
        }
    }
}
