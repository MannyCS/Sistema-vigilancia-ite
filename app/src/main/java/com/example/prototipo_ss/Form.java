package com.example.prototipo_ss;

import android.Manifest;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.core.content.ContextCompat;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.OnProgressListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class Form extends AppCompatActivity {
    TextView fCompleta;
    TextView hora;
    TextView textView2;
    ImageView ImgView;
    //--------------
    Uri filePath;
   //---------------
    EditText TxT;
    TextView ubicacion;
    Spinner problema;
    Button pdf;
    Button Back;
    Bitmap header, scale ;
    int pageWidth = 720;
    Date dateObj;
    DateFormat dateFormat;

    DatabaseReference mRootReference;
    private final static String CHANNEL_ID="NOTIFICACION";
    private final static int NOTIFICACION_ID=0;
    private final int PICK_IMAGE_REQUEST = 22;
    //---------
    FirebaseStorage storage;
    StorageReference storageReference;
    //-----------


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);

        ImgView = findViewById(R.id.camara);
        TxT = findViewById(R.id.Edit);
        pdf = findViewById(R.id.pdf);
        problema = findViewById(R.id.problema);
        fCompleta=(TextView)findViewById(R.id.txtfecha);
        hora=(TextView)findViewById(R.id.txthora);
        textView2= findViewById(R.id.ubicacion2);
        //------------
        storage = FirebaseStorage.getInstance();
        storageReference = storage.getReference();
        //------------

        // encabezado del pdf
        header = BitmapFactory.decodeResource(getResources(),R.drawable.encabezado);
        scale = Bitmap.createScaledBitmap(header,720, 99,false);



        String dato = getIntent().getStringExtra("dato");
        textView2.setText(" Se eligio: " + dato);

        Back = findViewById(R.id.Back);
        Back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();  //Para regresar a la vista anterior

                //Intent i = new Intent(DosActivity.this, SplashActivity.class);  //Para ir a una vista específica
                //startActivity(i);
            }
        });


        Date date= new Date();
        SimpleDateFormat fC= new SimpleDateFormat("d/MMMM/yyyy");
        String fs= fC.format(date);
        fCompleta.setText(fs);


        SimpleDateFormat h= new SimpleDateFormat("h:mm a");
        String shora = h.format(date);
        hora.setText(shora);


        //spinner donde se puede elegir el lugar que el guardia va esatr (temporal)
        /*ubicacion = findViewById(R.id.ubicacion);
        String[] itemsU = new String[]{"Edif.100","Edif.200", "Edif.300","Edif.400","Estacionamiento","Biblioteca"};
        ArrayAdapter<String> adapterU = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, itemsU);
        ubicacion.setAdapter(adapterU);*/

        //spinner donde se puede elegir el problema

        String[] itemsP = new String[]{"Animales","Daño de priopiedad","Robo","Incendio","Servicios agua/luz","Otros"};
        ArrayAdapter<String> adapterP = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, itemsP);
        problema.setAdapter(adapterP);

        ImageButton Camera = findViewById(R.id.ButtonCm);
        //permisos para poder activar el camara
        if(ContextCompat.checkSelfPermission(Form.this,
                Manifest.permission.CAMERA)!= PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(Form.this,
                    new String[]{
                            Manifest.permission.CAMERA
                    },100);
        }
        // permismos para poder guardar informacion dentro del telefono
        ActivityCompat.requestPermissions(Form.this,
                new String[]{ Manifest.permission.WRITE_EXTERNAL_STORAGE},
                PackageManager.PERMISSION_GRANTED);
        createPDF();

        Camera.setOnClickListener(v -> {
            Intent intent = new Intent();
            intent.setType("image/*");
            intent.setAction(Intent.ACTION_GET_CONTENT);
            startActivityForResult(
                    Intent.createChooser(
                            intent,
                            "Select Image from here..."),
                    PICK_IMAGE_REQUEST);
        });
    }
    /*--------------------------------------------------------------------------------------------------------------*/
    //creacion del pdf

    private void createPDF() {

        // base de datos
        mRootReference = FirebaseDatabase.getInstance().getReference("Formulario");

       pdf.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {

               String ubi = textView2.getText().toString();
               String problem = problema.getSelectedItem().toString();
               String fecha = fCompleta.getText().toString();
               String horaa = hora.getText().toString();
               String observ = TxT.getText().toString();

               if(ubi != null && problem != null && fecha != null && horaa != null && observ != null){
                   Map<String,Object> datosformualrio = new HashMap<>();
                   datosformualrio.put("Ubicacion",ubi);
                   datosformualrio.put("Problema",problem);
                   datosformualrio.put("Fecha",fecha);
                   datosformualrio.put("Hora",horaa);
                   datosformualrio.put("Observaciones",observ);

                   mRootReference.child("Formulario").push().setValue(datosformualrio);
                   //startActivity(new Intent(Form.this, EscuelaMapa.class));

                   Toast.makeText(getApplicationContext(), "Incidencia registrada con éxito", Toast.LENGTH_SHORT).show();
                   //startActivity(new Intent(Form.this, EscuelaMapa.class));
                   finish();

               }else {
                   System.out.println("Faltan datos por llenar.");
               }
           }
       });
    }



    private void createNotificationChannel() {
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.P){
            CharSequence name = "Notificacion";
            NotificationChannel notificationChannel = new NotificationChannel(CHANNEL_ID,name, NotificationManager.IMPORTANCE_DEFAULT);
            NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
            notificationManager.createNotificationChannel(notificationChannel);
        }
    }

    private void createNotification() {
        NotificationCompat.Builder builder = new NotificationCompat.Builder(getApplicationContext(),CHANNEL_ID);
        builder.setSmallIcon(R.drawable.ic_baseline_warning_24);
        builder.setContentTitle("Rondin");
        builder.setContentText("Peligro en "+ ubicacion.getText().toString() + " siendo "+ problema.getSelectedItem().toString());
        builder.setColor(Color.BLUE);
        builder.setPriority(NotificationCompat.PRIORITY_DEFAULT);
        builder.setLights(Color.MAGENTA,1000,1000);
        builder.setVibrate(new long[]{1000,1000,1000,1000,1000,1000});
        builder.setDefaults(Notification.DEFAULT_SOUND);

        NotificationManagerCompat notificationManagerCompat = NotificationManagerCompat.from(getApplicationContext());
        notificationManagerCompat.notify(NOTIFICACION_ID,builder.build());
    }

    protected void onActivityResult(int requestCode,int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == PICK_IMAGE_REQUEST
                && resultCode == RESULT_OK
                && data != null
                && data.getData() != null) {

            //Bitmap captureImage = (Bitmap) data.getExtras().get("data");
            //ImgView.setImageBitmap(captureImage);

            filePath = data.getData();
            try {

                // Setting image on image view using Bitmap
                Bitmap bitmap = MediaStore
                        .Images
                        .Media
                        .getBitmap(
                                getContentResolver(),
                                filePath);
                ImgView.setImageBitmap(bitmap);
            }

            catch (IOException e) {
                // Log the exception
                e.printStackTrace();
            }

            if (filePath != null) {

                // Code for showing progressDialog while uploading
                ProgressDialog progressDialog
                        = new ProgressDialog(this);
                progressDialog.setTitle("Uploading...");
                progressDialog.show();

                // Defining the child of storageReference
                StorageReference ref
                        = storageReference
                        .child(
                                "images/"
                                        + UUID.randomUUID().toString());

                // adding listeners on upload
                // or failure of image
                ref.putFile(filePath)
                        .addOnSuccessListener(
                                new OnSuccessListener<UploadTask.TaskSnapshot>() {

                                    @Override
                                    public void onSuccess(
                                            UploadTask.TaskSnapshot taskSnapshot)
                                    {

                                        // Image uploaded successfully
                                        // Dismiss dialog
                                        progressDialog.dismiss();
                                        Toast
                                                .makeText(Form.this,
                                                        "Image Uploaded!!",
                                                        Toast.LENGTH_SHORT)
                                                .show();
                                    }
                                })

                        .addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e)
                            {

                                // Error, Image not uploaded
                                progressDialog.dismiss();
                                Toast
                                        .makeText(Form.this,
                                                "Failed " + e.getMessage(),
                                                Toast.LENGTH_SHORT)
                                        .show();
                            }
                        })
                        .addOnProgressListener(
                                new OnProgressListener<UploadTask.TaskSnapshot>() {

                                    // Progress Listener for loading
                                    // percentage on the dialog box
                                    @Override
                                    public void onProgress(
                                            UploadTask.TaskSnapshot taskSnapshot)
                                    {
                                        double progress
                                                = (100.0
                                                * taskSnapshot.getBytesTransferred()
                                                / taskSnapshot.getTotalByteCount());
                                        progressDialog.setMessage(
                                                "Uploaded "
                                                        + (int)progress + "%");
                                    }
                                });
            }
        }
        }
    }


