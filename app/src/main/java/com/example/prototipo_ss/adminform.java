package com.example.prototipo_ss;

import android.text.method.ScrollingMovementMethod;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.os.Bundle;
import android.widget.TextView;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class adminform extends AppCompatActivity {

    public String user="";
    public String date;
    public String hour;
    public String notes;
    public String problem;
    public String zone;
    private String campo;
    private String valor;

    private TextView txtViewData;
    private DatabaseReference nDataBase;
    Button buscar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adminform);
        buscar = (findViewById(R.id.btnbuscar));

        txtViewData = (TextView) findViewById(R.id.txtinf1);
        txtViewData.setMovementMethod(new ScrollingMovementMethod());
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        nDataBase = FirebaseDatabase.getInstance().getReference();


        buscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                DatabaseReference report = database.getReference("Formulario");
                report.orderByChild("Fecha").addChildEventListener(new ChildEventListener() {
                    @Override
                    public void onChildAdded(@NonNull DataSnapshot datasnapshot, @Nullable String previousChildName) {
                        Long count = (datasnapshot.getChildrenCount());
                        String texto = txtViewData.getText().toString();
                        System.out.println("Numero de campos: "+ count);
                        for(DataSnapshot snapshot : datasnapshot.getChildren()){
                            Log.e("BD",snapshot.getKey()+": "+snapshot.getValue());
                            campo = snapshot.getKey();
                            valor = snapshot.getValue().toString();
                            //System.out.println(datasnapshot.getKey()+ "was" + );
                            //Log.e("Observaciones",""+ snapshot.child("Observaciones").getValue());
                            switch (campo){
                                case "Fecha":
                                    date= valor;
                                    break;
                                case "Hora":
                                    hour= valor;
                                    break;
                                case "Observaciones":
                                    notes= valor;
                                    break;
                                case "Problema":
                                    problem= valor;
                                    break;
                                case "Ubicacion":
                                    zone= valor;
                                    break;
                                case "User":
                                    user= valor;
                                    break;
                            }
                        }
                        txtViewData.setText(texto+"Usuario: "+ user +"\n"+ "Fecha: "+ date+"\n"+ "Hora: "+ hour +"\n" +"Ubicacion: "+ zone+"\n" +"Problema: "+ problem+"\n" +"Observacion: "+notes+"\n\n");


                        //txtViewData.setText(datasnapshot.getValue().toString());
                    }

                    @Override
                    public void onChildChanged(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

                    }

                    @Override
                    public void onChildRemoved(@NonNull DataSnapshot snapshot) {

                    }

                    @Override
                    public void onChildMoved(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });
            }
        });

    }
}