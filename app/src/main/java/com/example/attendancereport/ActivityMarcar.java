package com.example.attendancereport;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class ActivityMarcar extends AppCompatActivity implements OnMapReadyCallback, GoogleMap.OnMapClickListener, GoogleMap.OnMapLongClickListener {

    EditText edtLatitud, edtLogintud, edtNombreT, edtTrabajo;
    GoogleMap mMap;
    Button btnMarcar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_marcar);

        //edtNombreT = findViewById(R.id.edtNombreT);
        //edtTrabajo = findViewById(R.id.edtTrabajo);
        edtLatitud = findViewById(R.id.edtLatitud);
        edtLogintud = findViewById(R.id.edtLongitud);
        //btnMarcar = findViewById(R.id.btnAgregar);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        //mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(@NonNull GoogleMap googleMap) {
        mMap = googleMap;
        this.mMap.setOnMapClickListener(this);
        this.mMap.setOnMapLongClickListener(this);

        LatLng SantaBarbara = new LatLng(14.9223453,-88.2569936);
        mMap.addMarker(new MarkerOptions().position(SantaBarbara).title("Santa Barbara"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(SantaBarbara));
    }

    @Override
    public void onMapClick(@NonNull LatLng latLng) {
        edtLatitud.setText(""+latLng.latitude);
        edtLogintud.setText(""+latLng.latitude);
    }

    @Override
    public void onMapLongClick(@NonNull LatLng latLng) {
        edtLatitud.setText(""+latLng.latitude);
        edtLogintud.setText(""+latLng.latitude);
    }
}