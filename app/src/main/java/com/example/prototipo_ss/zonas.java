package com.example.prototipo_ss;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.tabs.TabLayout;
import com.google.firebase.auth.FirebaseAuth;

import java.util.ArrayList;
import java.util.List;
import java.util.TimerTask;

public class zonas extends AppCompatActivity {

    private List<Slide_Item> listItems;
    private ViewPager page;
    private TabLayout tabLayout;
    private TextView noticias;
    private TextView noticias2;
    private TextView noticias3;
    private TextView noticias4;
    private TextView noticias5;

    private Button logout;
    private Button zonaSur;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zonas);
        page = findViewById(R.id.viewpage) ;
        tabLayout = findViewById(R.id.my_tablayout);
        noticias = findViewById(R.id.noticiasSlide);
        noticias2 = findViewById(R.id.noticiasSlide2);
        noticias3 = findViewById(R.id.noticiasSlide3);
        noticias4 = findViewById(R.id.noticiasSlide4);
        noticias5 = findViewById(R.id.noticiasSlide5);
        logout = findViewById(R.id.btn_cerrar_sesion_usuario);
        zonaSur = findViewById(R.id.btnzonaS);
        mAuth = FirebaseAuth.getInstance();

        Button ingresar = (Button)findViewById(R.id.btnzonaN);
        ingresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(zonas.this, EscuelaMapa.class));
            }
        });
        //TextView rules = (TextView)findViewById(R.id.Reglas2);
        TextView rules = (TextView)findViewById(R.id.Reglas);
        rules.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDialog();
            }
        });

        //---Aparado del slider-----
        listItems = new ArrayList<>() ;
        noticias.setText(DataHolder.getInstance().getData());
        noticias2.setText(DataHolder.getInstance().getData2());
        noticias3.setText(DataHolder.getInstance().getData3());
        noticias4.setText(DataHolder.getInstance().getData4());
        noticias5.setText(DataHolder.getInstance().getData5());


        String str = noticias.getText().toString();
        if(str.isEmpty())
        { listItems.remove(new Slide_Item(str)); }
        else{ listItems.add(new Slide_Item(str)); }

        String str2 = noticias2.getText().toString();
        if(str2.isEmpty())
        { listItems.remove(new Slide_Item(str2)); }
        else{ listItems.add(new Slide_Item(str2)); }

        String str3 = noticias3.getText().toString();
        if(str3.isEmpty())
        { listItems.remove(new Slide_Item(str3));}
        else{ listItems.add(new Slide_Item(str3)); }

        String str4 = noticias4.getText().toString();
        if(str4.isEmpty())
        { listItems.remove(new Slide_Item(str4));}
        else{ listItems.add(new Slide_Item(str4)); }

        String str5 = noticias5.getText().toString();
        if(str5.isEmpty())
        { listItems.remove(new Slide_Item(str5));}
        else{ listItems.add(new Slide_Item(str5)); }

        if(str.isEmpty() && str2.isEmpty() && str3.isEmpty() && str4.isEmpty() && str5.isEmpty())
        { listItems.add(new Slide_Item("NO HAY NUEVAS NOTICIAS, HASTA NUEVO AVISO")); }

        SliderAdapter itemsPager_adapter = new SliderAdapter(this, listItems);
        page.setAdapter(itemsPager_adapter);
        // The_slide_timer
        java.util.Timer timer = new java.util.Timer();
        timer.scheduleAtFixedRate(new The_slide_timer(),2000,3000);
        tabLayout.setupWithViewPager(page,true);

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mAuth.signOut();
                startActivity(new Intent(zonas.this, MainActivity.class));
                finish();
            }
        });

        zonaSur.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "Zona inaccesible por el momento", Toast.LENGTH_SHORT).show();
            }
        });
    }
    public class The_slide_timer extends TimerTask {
        @Override
        public void run() {

            zonas.this.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    if (page.getCurrentItem()< listItems.size()-1) {
                        page.setCurrentItem(page.getCurrentItem()+1);
                    }
                    else
                        page.setCurrentItem(0);
                }
            });
        }
    }


    private void openDialog() {
        ReglasDialog reglasDialog = new ReglasDialog();
        reglasDialog.show(getSupportFragmentManager(),"Regalas que deben seguir");
    }
}