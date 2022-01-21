package com.example.prototipo_ss;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class EscuelaMapa extends AppCompatActivity {

    RadioGroup radioGroup;
    RadioButton radioButton;
    TextView textView;

    RadioButton rbZona1;
    RadioButton rbZona2;
    RadioButton rbZona3;
    RadioButton rbZona4;
    RadioButton rbZona5;
    RadioButton rbZona6;
    RadioButton rbZona7;
    RadioButton rbZona8;
    RadioButton rbZona9;
    RadioButton rbZona11;
    RadioButton rbZona12;
    RadioButton rbZona13;
    RadioButton rbZona14;
    RadioButton rbZona15;
    RadioButton rbZona16;
    RadioButton rbZona17;
    RadioButton rbZona18;
    RadioButton rbZona19;
    RadioButton rbZona20;
    RadioButton rbZona21;
    RadioButton rbZona22;
    RadioButton rbZona23;
    RadioButton rbZona24;
    RadioButton rbZona25;
    RadioButton rbZona26;
    RadioButton rbZona27;
    RadioButton rbZona28;
    RadioButton rbZona29;
    RadioButton rbZona30;
    RadioButton rbZona31;
    RadioButton rbZona32;
    RadioButton rbZona33;
    RadioButton rbZona34;
    RadioButton rbZona35;


    TextView tvzona1;
    TextView tvzona2;
    TextView tvzona3;
    TextView tvzona4;
    TextView tvzona5;
    TextView tvzona6;
    TextView tvzona7;
    TextView tvzona8;
    TextView tvzona9;
    TextView tvzona11;
    TextView tvzona12;
    TextView tvzona13;
    TextView tvzona14;
    TextView tvzona15;
    TextView tvzona16;
    TextView tvzona17;
    TextView tvzona18;
    TextView tvzona19;
    TextView tvzona20;
    TextView tvzona21;
    TextView tvzona22;
    TextView tvzona23;
    TextView tvzona24;
    TextView tvzona25;
    TextView tvzona26;
    TextView tvzona27;
    TextView tvzona28;
    TextView tvzona29;
    TextView tvzona30;
    TextView tvzona31;
    TextView tvzona32;
    TextView tvzona33;
    TextView tvzona34;
    TextView tvzona35;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_escuela_mapa);

        radioGroup = findViewById(R.id.radioGroup);
        //tvzona1= findViewById(R.id.tvzona1);

        //String dato = getIntent().getStringExtra("dato");
        //tvzona1.setText(" Se registro " + dato);

        Button buttonapply = findViewById(R.id.button_apply);
        buttonapply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int radioId = radioGroup.getCheckedRadioButtonId();

                radioButton = findViewById(radioId);

                //textView.setText("Su eleccion es: "+radioButton.getText());
            }
        });







        //boton para ingresar al formulario
        Button ingresar = (Button)findViewById(R.id.btnregzona);
        ingresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(EscuelaMapa.this, Form.class));
                //Toast.makeText(EscuelaMapa.this,"Se selecciono esta zona",Toast.LENGTH_SHORT);

            }
        });


    }
    public void checkButton(View v){
        int radioId = radioGroup.getCheckedRadioButtonId();

        tvzona1 = findViewById(R.id.tvzona1);
        rbZona1 = findViewById(R.id.rbZona1);

        tvzona2 = findViewById(R.id.tvzona2);
        rbZona2 = findViewById(R.id.rbZona2);

        tvzona3 = findViewById(R.id.tvzona3);
        rbZona3 = findViewById(R.id.rbZona3);

        tvzona4 = findViewById(R.id.tvzona4);
        rbZona4 = findViewById(R.id.rbZona4);

        tvzona5 = findViewById(R.id.tvzona5);
        rbZona5 = findViewById(R.id.rbZona5);

        tvzona6 = findViewById(R.id.tvzona6);
        rbZona6 = findViewById(R.id.rbZona6);

        tvzona7 = findViewById(R.id.tvzona7);
        rbZona7 = findViewById(R.id.rbZona7);

        tvzona8 = findViewById(R.id.tvzona8);
        rbZona8 = findViewById(R.id.rbZona8);

        tvzona9 = findViewById(R.id.tvzona9);
        rbZona9 = findViewById(R.id.rbZona9);

        tvzona11 = findViewById(R.id.tvzona11);
        rbZona11 = findViewById(R.id.rbZona11);

        tvzona12 = findViewById(R.id.tvzona12);
        rbZona12 = findViewById(R.id.rbZona12);

        tvzona13 = findViewById(R.id.tvzona13);
        rbZona13 = findViewById(R.id.rbZona13);

        tvzona14 = findViewById(R.id.tvzona14);
        rbZona14 = findViewById(R.id.rbZona14);

        tvzona15 = findViewById(R.id.tvzona15);
        rbZona15 = findViewById(R.id.rbZona15);

        tvzona16 = findViewById(R.id.tvzona16);
        rbZona16 = findViewById(R.id.rbZona16);

        tvzona17 = findViewById(R.id.tvzona17);
        rbZona17 = findViewById(R.id.rbZona17);

        tvzona18 = findViewById(R.id.tvzona18);
        rbZona18 = findViewById(R.id.rbZona18);

        tvzona19 = findViewById(R.id.tvzona19);
        rbZona19 = findViewById(R.id.rbZona19);

        tvzona20 = findViewById(R.id.tvzona20);
        rbZona20 = findViewById(R.id.rbZona20);

        tvzona21 = findViewById(R.id.tvzona21);
        rbZona21 = findViewById(R.id.rbZona21);

        tvzona22 = findViewById(R.id.tvzona22);
        rbZona22 = findViewById(R.id.rbZona22);

        tvzona23 = findViewById(R.id.tvzona23);
        rbZona23 = findViewById(R.id.rbZona23);

        tvzona24 = findViewById(R.id.tvzona24);
        rbZona24 = findViewById(R.id.rbZona24);

        tvzona25 = findViewById(R.id.tvzona25);
        rbZona25 = findViewById(R.id.rbZona25);

        tvzona26 = findViewById(R.id.tvzona26);
        rbZona26 = findViewById(R.id.rbZona26);

        tvzona27 = findViewById(R.id.tvzona27);
        rbZona27 = findViewById(R.id.rbZona27);

        tvzona28 = findViewById(R.id.tvzona28);
        rbZona28 = findViewById(R.id.rbZona28);

        tvzona29 = findViewById(R.id.tvzona29);
        rbZona29 = findViewById(R.id.rbZona29);

        tvzona30 = findViewById(R.id.tvzona30);
        rbZona30 = findViewById(R.id.rbZona30);

        tvzona31 = findViewById(R.id.tvzona31);
        rbZona31 = findViewById(R.id.rbZona31);

        tvzona32 = findViewById(R.id.tvzona32);
        rbZona32 = findViewById(R.id.rbZona32);

        tvzona33 = findViewById(R.id.tvzona33);
        rbZona33 = findViewById(R.id.rbZona33);

        tvzona34 = findViewById(R.id.tvzona34);
        rbZona34 = findViewById(R.id.rbZona34);

        tvzona35 = findViewById(R.id.tvzona35);
        rbZona35 = findViewById(R.id.rbZona35);



        radioButton = findViewById(radioId);

        Toast.makeText(this, "Selecciono: " + radioButton.getText(),Toast.LENGTH_SHORT).show();


        //radioButton.setText("Zona verificada");
        radioButton.setVisibility(View.INVISIBLE);
        //radioButton.setBackgroundColor(Color.RED);


        Intent i = new Intent(this,Form.class);
        i.putExtra("dato",radioButton.getText().toString());
        startActivity(i);

        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                // Do something after 5s = 5000ms
                if(rbZona1.isChecked()==true)
                {

                    tvzona1.setTextColor(Color.parseColor("#66DC6B"));
                    tvzona1.setText("Zona 1");
                }
                if(rbZona2.isChecked()==true)
                {
                    tvzona2.setTextColor(Color.parseColor("#66DC6B"));
                    tvzona2.setText("Zona 2");
                }
                if(rbZona3.isChecked()==true)
                {

                    tvzona3.setTextColor(Color.parseColor("#66DC6B"));
                    tvzona3.setText("Zona 3");
                }
                if(rbZona4.isChecked()==true)
                {
                    tvzona4.setTextColor(Color.parseColor("#66DC6B"));
                    tvzona4.setText("Zona 4");
                }
                if(rbZona5.isChecked()==true)
                {

                    tvzona5.setTextColor(Color.parseColor("#66DC6B"));
                    tvzona5.setText("Zona 5");
                }
                if(rbZona6.isChecked()==true)
                {
                    tvzona6.setTextColor(Color.parseColor("#66DC6B"));
                    tvzona6.setText("Zona 6");
                }
                if(rbZona7.isChecked()==true)
                {

                    tvzona7.setBackgroundColor(Color.parseColor("#66DC6B"));
                    tvzona7.setText("Zona 7");
                }
                if(rbZona8.isChecked()==true)
                {
                    tvzona8.setBackgroundColor(Color.parseColor("#66DC6B"));
                    tvzona8.setText("Zona 8");
                }
                if(rbZona9.isChecked()==true)
                {

                    tvzona9.setBackgroundColor(Color.parseColor("#66DC6B"));
                    tvzona9.setText("Zona 9");
                }
                if(rbZona11.isChecked()==true)
                {
                    tvzona11.setBackgroundColor(Color.parseColor("#66DC6B"));
                    tvzona11.setText("Zona 10");
                }
                if(rbZona12.isChecked()==true)
                {

                    tvzona12.setBackgroundColor(Color.parseColor("#66DC6B"));
                    tvzona12.setText("Zona 11");
                }
                if(rbZona13.isChecked()==true)
                {
                    tvzona13.setBackgroundColor(Color.parseColor("#66DC6B"));
                    tvzona13.setText("Zona 12");
                }
                if(rbZona14.isChecked()==true)
                {
                    tvzona14.setBackgroundColor(Color.parseColor("#66DC6B"));

                    tvzona14.setText("Zona 13");
                }
                if(rbZona15.isChecked()==true)
                {
                    tvzona15.setBackgroundColor(Color.parseColor("#66DC6B"));
                    tvzona15.setText("Zona 14");
                }
                if(rbZona16.isChecked()==true)
                {

                    tvzona16.setBackgroundColor(Color.parseColor("#66DC6B"));
                    tvzona16.setText("Zona 15");
                }
                if(rbZona17.isChecked()==true)
                {
                    tvzona17.setBackgroundColor(Color.parseColor("#66DC6B"));
                    tvzona17.setText("Zona 16");
                }
                if(rbZona18.isChecked()==true)
                {
                    tvzona18.setBackgroundColor(Color.parseColor("#66DC6B"));
                    tvzona18.setText("Zona 17");
                }
                if(rbZona19.isChecked()==true)
                {
                    tvzona19.setBackgroundColor(Color.parseColor("#66DC6B"));
                    tvzona19.setText("Zona 18");
                }
                if(rbZona20.isChecked()==true)
                {
                    tvzona20.setBackgroundColor(Color.parseColor("#66DC6B"));
                    tvzona20.setText("Zona 19");
                }
                if(rbZona21.isChecked()==true)
                {
                    tvzona21.setBackgroundColor(Color.parseColor("#66DC6B"));
                    tvzona21.setText("Zona 20");
                }
                if(rbZona22.isChecked()==true)
                {
                    tvzona22.setBackgroundColor(Color.parseColor("#66DC6B"));
                    tvzona22.setText("Zona 21");
                }
                if(rbZona23.isChecked()==true)
                {
                    tvzona23.setBackgroundColor(Color.parseColor("#66DC6B"));
                    tvzona23.setText("Zona 22");
                }
                if(rbZona24.isChecked()==true)
                {
                    tvzona24.setBackgroundColor(Color.parseColor("#66DC6B"));
                    tvzona24.setText("Zona 23");
                }
                if(rbZona25.isChecked()==true)
                {
                    tvzona25.setBackgroundColor(Color.parseColor("#66DC6B"));
                    tvzona25.setText("Zona 24");
                }
                if(rbZona26.isChecked()==true)
                {
                    tvzona26.setBackgroundColor(Color.parseColor("#66DC6B"));
                    tvzona26.setText("Zona 25");
                }
                if(rbZona27.isChecked()==true)
                {
                    tvzona27.setBackgroundColor(Color.parseColor("#66DC6B"));
                    tvzona27.setText("Zona 26");
                }
                if(rbZona28.isChecked()==true)
                {
                    tvzona28.setBackgroundColor(Color.parseColor("#66DC6B"));
                    tvzona28.setText("Zona 27");
                }
                if(rbZona29.isChecked()==true)
                {
                    tvzona29.setBackgroundColor(Color.parseColor("#66DC6B"));
                    tvzona29.setText("Zona 28");
                }
                if(rbZona30.isChecked()==true)
                {
                    tvzona30.setBackgroundColor(Color.parseColor("#66DC6B"));
                    tvzona30.setText("Zona 29");
                }
                if(rbZona31.isChecked()==true)
                {
                    tvzona31.setBackgroundColor(Color.parseColor("#66DC6B"));
                    tvzona31.setText("Zona 30");
                }
                if(rbZona32.isChecked()==true)
                {
                    tvzona32.setBackgroundColor(Color.parseColor("#66DC6B"));
                    tvzona32.setText("Zona 31");
                }
                if(rbZona33.isChecked()==true)
                {
                    tvzona33.setBackgroundColor(Color.parseColor("#66DC6B"));
                    tvzona33.setText("Zona 32");
                }
                if(rbZona34.isChecked()==true)
                {
                    tvzona34.setBackgroundColor(Color.parseColor("#66DC6B"));
                    tvzona34.setText("Zona 33");
                }
                if(rbZona35.isChecked()==true)
                {
                    tvzona35.setBackgroundColor(Color.parseColor("#66DC6B"));
                    tvzona35.setText("Zona 34");
                }



            }
        }, 3000);





    }

}