package com.example.attendancereport;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;


public class MainActivity extends AppCompatActivity {

    EditText edtUsuario;
    EditText edtPassword;
    Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtUsuario = findViewById(R.id.edtUsuario);
        edtPassword = findViewById(R.id.edtPassword);
        btnLogin = findViewById(R.id.btnLogin);


        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ConnectionHelper ex = new ConnectionHelper();
                try{
                    String Usuario = String.valueOf(edtUsuario.getText());
                    String Password = String.valueOf(edtPassword.getText());
                    String query =  "SELECT * FROM tbUsuarios WHERE Usuario='"+Usuario+"' AND Password='"+Password+"'";
                    Statement st = ex.connection().createStatement();
                    ResultSet rs = st.executeQuery(query);
                    if(rs.next()){
                        Toast.makeText(getApplicationContext(), "LOGIN EXITOSO!", Toast.LENGTH_SHORT).show();
                        Bundle enviaDatos = new Bundle();
                        enviaDatos.putString("keyDatos", edtUsuario.getText().toString());
                        Intent i = new Intent(MainActivity.this, activityMenu.class);
                        i.putExtras(enviaDatos);
                        startActivity(i);


                    }else{
                        Toast.makeText(getApplicationContext(), "EL USUARIO NO EXISTE EN LA BD!", Toast.LENGTH_SHORT).show();
                    }
                }
                catch (SQLException e) {
                    Logger.getLogger(MainActivity.class.getName()).log(Level.SEVERE, null, e);
                }

            }
        });


    }

}