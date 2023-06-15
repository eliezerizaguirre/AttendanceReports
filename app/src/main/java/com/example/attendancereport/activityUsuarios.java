package com.example.attendancereport;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class activityUsuarios extends AppCompatActivity {

    Connection connect;
    String ConnectionResut="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_usuarios);

        EditText edtContador = (EditText) findViewById(R.id.edtContador);
        EditText edtIdentidad = (EditText) findViewById(R.id.edtIdentidad);
        EditText edtNombre = (EditText) findViewById(R.id.edtNombre);
        EditText edtUsuario = (EditText) findViewById(R.id.edtUsuario);
        EditText edtPassword = (EditText) findViewById(R.id.edtPassword);
        Button btnGuardar = (Button) findViewById(R.id.btnGuardar);

       btnGuardar.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {

               ConnectionHelper connectionHelper = new ConnectionHelper();
               connect = connectionHelper.connection();
               try {
                   if (connect!=null){
                       PreparedStatement stm= connect.prepareStatement("INSERT INTO tbUsuarios Values(?,?,?,?,?)");
                       stm.setString(1,edtContador.getText().toString());
                       stm.setString(2,edtIdentidad.getText().toString());
                       stm.setString(3,edtNombre.getText().toString());
                       stm.setString(4,edtUsuario.getText().toString());
                       stm.setString(5,edtPassword.getText().toString());
                       stm.executeUpdate();
                       Toast.makeText(getApplicationContext(), "GUARDADO CON EXITO", Toast.LENGTH_SHORT).show();
                   }
                   edtContador.setText("");
                   edtIdentidad.setText("");
                   edtNombre.setText("");
                   edtUsuario.setText("");
                   edtPassword.setText("");
               }
               catch (Exception ex){
                   Log.e("Error",ex.getMessage());
               }

           }
       });


    }
}