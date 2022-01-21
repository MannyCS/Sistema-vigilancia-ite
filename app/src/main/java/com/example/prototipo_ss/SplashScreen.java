package com.example.prototipo_ss;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SplashScreen extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_HIDE_NAVIGATION | View.SYSTEM_UI_FLAG_FULLSCREEN);
        setContentView(R.layout.splash_screen);

        //Agregar animacion a pantalla de inicio
        Animation animationLogo = AnimationUtils.loadAnimation(this,R.anim.desplazamiento_arriba);
        Animation animationText = AnimationUtils.loadAnimation(this,R.anim.desplazamiento_abajo);

        //Logotipo y su nombre
        TextView nameLogo = findViewById(R.id.textView);
        ImageView logo = findViewById(R.id.logo);

        //estableciendo los animaciones
        nameLogo.setAnimation(animationText);
        logo.setAnimation(animationLogo);

        //ejecutando
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashScreen.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        }, 4000);
    }
}
