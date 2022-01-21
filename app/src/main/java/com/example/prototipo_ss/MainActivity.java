package com.example.prototipo_ss;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.FirebaseFirestore;

public class MainActivity extends AppCompatActivity {
    private FirebaseAuth mAuth;
    private FirebaseFirestore db;
    private EditText correo;
    private EditText contrasena;
    private Button login;


    String email = "";
    String password = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
        setContentView(R.layout.inicio_sesion);
        mAuth = FirebaseAuth.getInstance();
        db = FirebaseFirestore.getInstance();

        /*correo=findViewById(R.id.etxtusuario);
        contrasena=findViewById(R.id.etxtcontrasena);*/
        correo=findViewById(R.id.Noticia4);
        contrasena=findViewById(R.id.contraseña_nuevo_usuario);
        login = findViewById(R.id.button_registrar_usuario);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                email = correo.getText().toString();
                password = contrasena.getText().toString();

                if(!email.isEmpty() && !password.isEmpty()) {
                    iniciarSesion();
                } else {
                    Toast.makeText(getApplicationContext(), "Ingrese correo y contraseña", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();

        //updateUI(currentUser);
    }


    //public void iniciarSesion(View view ){
    public void iniciarSesion(){

        mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            if(correo.getText().toString().equals("administrador@ite.edu.mx") &&  contrasena.getText().toString().equals("Tecnologic0")){
                                FirebaseUser user = mAuth.getCurrentUser();
                                startActivity(new Intent(MainActivity.this, administrador.class));
                            }
                            else{
                                FirebaseUser user = mAuth.getCurrentUser();
                                startActivity(new Intent(MainActivity.this, zonas.class));

                            }

                        } else {
                            // If sign in fails, display a message to the user.
                            Toast.makeText(getApplicationContext(), "Correo o contraseña incorrecto", Toast.LENGTH_SHORT).show();
                            //updateUI(null);
                        }
                    }
                });

        /*if(correo.getText().toString().isEmpty() && contrasena.getText().toString().isEmpty())
        {
            Toast.makeText(getApplicationContext(), "Ingrese correo y contraseña",Toast.LENGTH_SHORT).show();
        }else{
            mAuth.signInWithEmailAndPassword(correo.getText().toString(),contrasena.getText().toString())
                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                if(correo.getText().toString().equals("administrador@ite.edu.mx") &&  contrasena.getText().toString().equals("Tecnologic0")){
                                    FirebaseUser user = mAuth.getCurrentUser();
                                    startActivity(new Intent(MainActivity.this, administrador.class));
                                }
                                else{
                                        FirebaseUser user = mAuth.getCurrentUser();
                                        startActivity(new Intent(MainActivity.this, zonas.class));

                                }

                            } else {
                                // If sign in fails, display a message to the user.
                                Toast.makeText(getApplicationContext(), "Correo o contraseña incorrecto", Toast.LENGTH_SHORT).show();
                                //updateUI(null);
                            }
                        }
                    });
        }*/
    }
    //#143874
}



