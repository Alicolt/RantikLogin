package com.example.rodri.rantiklogin;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class HomeActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
    }

    public void entrarSubastas(View view) {
        Intent intent = new Intent(this, SubastasActivity.class);
        startActivity(intent);
    }

    public void entrarTrueques(View view) {
        Intent intent = new Intent(this, SubastasActivity.class);
        startActivity(intent);
    }
}
