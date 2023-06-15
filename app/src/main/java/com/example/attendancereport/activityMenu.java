package com.example.attendancereport;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

public class activityMenu extends AppCompatActivity {

    Button btnCrear, btnReport, btnMarcar, btnPerfil, btnInfo;
    TextView txtUsuario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        btnCrear = findViewById(R.id.btnCrear);
        btnReport = findViewById(R.id.btnReporte);
        btnMarcar = findViewById(R.id.btnMarcar);
        btnPerfil = findViewById(R.id.btnPerfil);
        btnInfo = findViewById(R.id.btnInformacion);
        txtUsuario = findViewById(R.id.txtUsuario);

        Bundle recibeDatos = getIntent().getExtras();
        String info = recibeDatos.getString("keyDatos");

        txtUsuario.setText(info);

        btnCrear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(activityMenu.this, activityUsuarios.class);
                startActivity(i);
            }
        });

        btnMarcar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(activityMenu.this, ActivityMarcar.class);//cambiar a actvityReport.
                startActivity(i);
            }
        });

        btnReport.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(activityMenu.this, ActivityReport.class);//cambiar a actvityReport.
                startActivity(i);
            }
        });

        btnPerfil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(activityMenu.this, ActivityPerfil.class);//cambiar a activityPerfil.
                startActivity(i);
            }
        });

        btnInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(activityMenu.this, ActivityInformacion.class);//cambiar a activityInformacion.
                startActivity(i);
            }
        });
    }
}