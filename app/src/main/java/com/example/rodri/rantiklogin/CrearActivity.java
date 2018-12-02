package com.example.rodri.rantiklogin;

import android.content.Intent;
import android.os.Handler;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class CrearActivity extends AppCompatActivity {
    private EditText etNombre;
    private EditText etApellido;
    private EditText user;
    private EditText pw, confirmar;
    private ImageView imagen;
    private Button btnRegistrar;
    private SQLiteHelper sqLiteHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear);
        sqLiteHelper = new SQLiteHelper(this);

        etNombre = (EditText) findViewById(R.id.etNombre);
        etApellido = (EditText) findViewById(R.id.etApellido);
        user = (EditText) findViewById(R.id.etUsuario);
        pw = (EditText) findViewById(R.id.etPW);
        imagen = (ImageView) findViewById(R.id.imgUser);
        btnRegistrar = (Button) findViewById(R.id.btnRegistrar);

        btnRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (validar()) {
                    String Nombre = etNombre.getText().toString();
                    String Apellido = etApellido.getText().toString();
                    String usuario = user.getText().toString();
                    String password = pw.getText().toString();

                    if (!sqLiteHelper.UserExiste(usuario)) {
                        sqLiteHelper.addUser(new Usuario(null, Nombre, Apellido, usuario, password));
                        volver();
                    } else {
                        Snackbar.make(btnRegistrar, "Usuario ya existe", Snackbar.LENGTH_LONG).show();
                    }
                }
            }
        });
    }

        private void volver(){
            Intent intent = new Intent(this, LoginMain.class);
            startActivity(intent);
        }
        private boolean validar () {
            boolean valido = false;

            String nombre = etNombre.getText().toString();
            String apellido = etApellido.getText().toString();
            String usuario = user.getText().toString();
            String contraseña = pw.getText().toString();

            if (nombre.isEmpty()) {
                valido = false;
                Toast.makeText(this, "Ingrese un nombre", Toast.LENGTH_SHORT).show();
            } else {
                if (nombre.length() > 5) {
                    valido = true;
                } else {
                    valido = false;
                }
            }

            if (apellido.isEmpty()) {
                valido = false;
                Toast.makeText(this, "Ingrese un apellido", Toast.LENGTH_SHORT).show();
            } else {
                if (apellido.length() > 5) {
                    valido = true;
                } else {
                    valido = false;
                }
            }

            if (usuario.isEmpty()) {
                valido = false;
                Toast.makeText(this, "Ingrese un usuario valido", Toast.LENGTH_SHORT).show();
            } else {
                if (usuario.length() > 5) {
                    valido = true;
                } else {
                    valido = false;
                }
            }

            if (contraseña.isEmpty()) {
                valido = false;
                Toast.makeText(this, "Ingrese una contraseña valida", Toast.LENGTH_SHORT).show();
            } else {
                if (contraseña.length() > 5) {
                    valido = true;
                } else {
                    valido = false;
                    Toast.makeText(this, "Contraseña demasiado pequeña", Toast.LENGTH_SHORT).show();
                }
            }
            return valido;
        }
    }




