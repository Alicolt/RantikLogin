package com.example.rodri.rantiklogin;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class SubastasActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subastas);
    }

    public void entrarMisProductos(View view) {
        Intent intent = new Intent(this, AgregarProductoActivity.class);
        startActivity(intent);
    }

    public void verMisProductos(View view){
        Intent ver = new Intent(this, ProductoList.class);
        startActivity(ver);
    }

    public void regresarHome(View view) {
        Intent intent = new Intent(this,HomeActivity.class);
        startActivity(intent);
    }
}
