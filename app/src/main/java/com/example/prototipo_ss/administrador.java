package com.example.prototipo_ss;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;

public class administrador extends AppCompatActivity {
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_administrador);
        mAuth = FirebaseAuth.getInstance();

        Button registrarUsuario = (Button)findViewById(R.id.btnregusuario) ;
        registrarUsuario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(administrador.this, registrarUsuario.class));
            }
        });

        Button noticias = (Button)findViewById(R.id.btnregusuario2);
        noticias.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(administrador.this, noticias.class));
            }
        });

        Button btnform = (Button)findViewById(R.id.btnformulario) ;
        btnform.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(administrador.this, adminform.class));
            }
        });

        Button cerrar_sesion = (Button)findViewById(R.id.btn_cerrar_sesion_admin);
        cerrar_sesion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mAuth.signOut();
                startActivity(new Intent(administrador.this, MainActivity.class));
                finish();
            }
        });
    }
}