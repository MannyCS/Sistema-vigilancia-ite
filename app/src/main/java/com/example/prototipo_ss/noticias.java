package com.example.prototipo_ss;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class noticias extends AppCompatActivity {

    private EditText edit;
    private EditText edit2;
    private EditText edit3;
    private EditText edit4;
    private EditText edit5;

    DatabaseReference mRootReference;
    FirebaseStorage storage;
    StorageReference storageReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_noticias);
        setContentView(R.layout.noticias);
    /*Generamos el campo de texto donde se va escribir el mensaje de la noticias que los guarias
      van a mirar y el boton de envio*/
        /*Button enviar = (Button)findViewById(R.id.btnenviar);
        edit = (EditText)findViewById(R.id.noticiasEdit);
        edit2 = (EditText)findViewById(R.id.noticiasEdit2);
        edit3 = (EditText)findViewById(R.id.noticiasEdit3);
        edit4 = (EditText)findViewById(R.id.noticiasEdit4);
        edit5 = (EditText)findViewById(R.id.noticiasEdit5);*/

        Button enviar = (Button)findViewById(R.id.button_registrar_usuario);
        edit = (EditText)findViewById(R.id.Noticia1);
        edit2 = (EditText)findViewById(R.id.Noticia2);
        edit3 = (EditText)findViewById(R.id.Noticia3);
        edit4 = (EditText)findViewById(R.id.Noticia4);
        edit5 = (EditText)findViewById(R.id.Noticia5);


        mRootReference = FirebaseDatabase.getInstance().getReference();
        enviar.setOnClickListener(new View.OnClickListener() {
            /*
             * al momento de presionar el boton, si tiene texto lo va obtener convertitlo en
             * String. Despues generamos una clase java llamada DataHolder y su proposito es
             * obtener la instancia del codigo siendo el texto que se va desplegar en las noticias.
             * */
            @Override
            public void onClick(View v) {
                String rango1 = edit.getText().toString();
                DataHolder.getInstance().setData(rango1);
                String rango2 = edit2.getText().toString();
                DataHolder.getInstance().setData2(rango2);
                String rango3 = edit3.getText().toString();
                DataHolder.getInstance().setData3(rango3);
                String rango4 = edit4.getText().toString();
                DataHolder.getInstance().setData4(rango4);
                String rango5 = edit5.getText().toString();
                DataHolder.getInstance().setData5(rango5);

                Date date= new Date();
                SimpleDateFormat fC= new SimpleDateFormat("d/MMMM/yyyy");
                String fs= fC.format(date);

                if(!rango1.isEmpty()){
                    Map<String,Object> noticia = new HashMap<>();
                    noticia.put("Fecha",fs);
                    noticia.put("Noticia",rango1);
                    noticia.put("Prioridad",1);

                    mRootReference.child("Noticias").push().setValue(noticia);
                }
                if(!rango2.isEmpty()){
                    Map<String,Object> noticia = new HashMap<>();
                    noticia.put("Fecha",fs);
                    noticia.put("Noticia",rango2);
                    noticia.put("Prioridad",2);

                    mRootReference.child("Noticias").push().setValue(noticia);
                }
                if(!rango3.isEmpty()){
                    Map<String,Object> noticia = new HashMap<>();
                    noticia.put("Fecha",fs);
                    noticia.put("Noticia",rango3);
                    noticia.put("Prioridad",3);

                    mRootReference.child("Noticias").push().setValue(noticia);
                }
                if(!rango4.isEmpty()){
                    Map<String,Object> noticia = new HashMap<>();
                    noticia.put("Fecha",fs);
                    noticia.put("Noticia",rango4);
                    noticia.put("Prioridad",4);

                    mRootReference.child("Noticias").push().setValue(noticia);
                }
                if(!rango5.isEmpty()){
                    Map<String,Object> noticia = new HashMap<>();
                    noticia.put("Fecha",fs);
                    noticia.put("Noticia",rango5);
                    noticia.put("Prioridad",5);

                    mRootReference.child("Noticias").push().setValue(noticia);
                }

                finish();
            }
        });

    }
}
