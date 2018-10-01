package com.proyecto.alejandreyes.tarea02;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    MediaPlayer reproductor;
    private int cancionINT = 0 ;
    private Button regresar;
    private Button pausa;
    private Button siguiente;
    private TextView artista;
    private ImageView album;
    private TextView cancion;
    private final String[] canciones = {"Carter Vail_melatonin","Artisticos_Mooth Attitude", "Carter Vail_Silent Movies" } ;
    private int[] cancionID = {R.raw.carter_vail_melatonin,R.raw.artisticos_mooth_attitude, R.raw.carter_vail_silent_movies};

    /**
     * Inicializacion de la aplicacion
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        regresar = findViewById(R.id.buttonA);
        pausa = findViewById(R.id.buttonB);
        siguiente = findViewById(R.id.buttonC) ;
        regresar.setOnClickListener(this);
        pausa.setOnClickListener(this);
        siguiente.setOnClickListener(this);
        album = findViewById(R.id.album);
        artista = findViewById(R.id.nom_artista);
        artista.setText(canciones[cancionINT].substring(0,canciones[cancionINT].indexOf("_")));
        String imagen = canciones[cancionINT].toLowerCase().replace(" ","_").toLowerCase();
        int id = getResources().getIdentifier(imagen, "drawable", getPackageName());
        cancion = findViewById(R.id.nom_cancion)  ;
        cancion.setText((canciones[cancionINT].substring(canciones[cancionINT].indexOf("_")+1)).toUpperCase());
        album.setImageResource(id);
        reproductor = MediaPlayer.create(this,cancionID[cancionINT]);

    }
    @Override
    protected void onStart() {
        super.onStart();
        reproductor.start();

    }

    /**
     * Metodo para guardar informacion de la aplicacion para evitar perdida de datos al cambiar de portrait a landscape
     * @param outState
     */
    protected void onSaveInstanceState(Bundle outState){
        super.onSaveInstanceState(outState);
        int cont= reproductor.getCurrentPosition();
        outState.putInt("CONTI", cont);
        outState.putInt("CANCION", cancionINT);
    }

    /**
     * Metodo para regresar a la aplicacion al estado anterior en caso de ser destruida
     * @param savedInstanceState
     */
    protected void onRestoreInstanceState(Bundle savedInstanceState){
        super.onRestoreInstanceState(savedInstanceState);
        int cont = savedInstanceState.getInt("CONTI");
        cancionINT = savedInstanceState.getInt("CANCION");
        reproductor.stop();
        reproductor = MediaPlayer.create(this,cancionID[cancionINT]);
        String imagen = canciones[cancionINT].toLowerCase().replace(" ","_").toLowerCase();
        int id = getResources().getIdentifier(imagen, "drawable", getPackageName());
        album.setImageResource(id);

        cancion.setText((canciones[cancionINT].substring(canciones[cancionINT].indexOf("_")+1)).toUpperCase());
        reproductor.start();
        reproductor.seekTo(cont);
    }
    @Override
    protected void onResume() {
        super.onStart();
        super.onResume();
    }

    @Override
    protected void onStop() {
        reproductor.pause();
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    /**
     * Metodo que gestiona el comportamiento de los botones de la vista
     * @param v
     */
    @Override
    public void onClick(View v) {
        String imagen;
        int id;
        switch (v.getId()){
            case R.id.buttonA:
                cancionINT = ((cancionINT - 1) % cancionID.length)<0?(cancionINT - 1)+cancionID.length: (cancionINT - 1) % cancionID.length ;
                reproductor.stop();
                pausa.setText("Pausa");
                reproductor = MediaPlayer.create(this,cancionID[cancionINT]);
                artista.setText(canciones[cancionINT].substring(0,canciones[cancionINT].indexOf("_")));
                imagen = canciones[cancionINT].toLowerCase().replace(" ","_").toLowerCase();
                id= getResources().getIdentifier(imagen, "drawable", getPackageName());
                album.setImageResource(id);

                cancion.setText((canciones[cancionINT].substring(canciones[cancionINT].indexOf("_")+1)).toUpperCase());
                reproductor.start();
                break;
            case R.id.buttonB:
                if(reproductor.isPlaying()){
                    reproductor.pause();
                    pausa.setText("REANUDAR");
                }else{
                    reproductor.start();
                    pausa.setText("Pausa");
                }

                break;
            case R.id.buttonC:
                cancionINT = (cancionINT + 1) % (cancionID.length);
                reproductor.stop();
                pausa.setText("Pausa");
                artista .setText(canciones[cancionINT]);
                reproductor = MediaPlayer.create(this,cancionID[cancionINT]);
                artista.setText(canciones[cancionINT].substring(0,canciones[cancionINT].indexOf("_")));
                imagen = canciones[cancionINT].toLowerCase().replace(" ","_").toLowerCase();
                id = getResources().getIdentifier(imagen, "drawable", getPackageName());

                cancion.setText((canciones[cancionINT].substring(canciones[cancionINT].indexOf("_")+1)).toUpperCase());
                album.setImageResource(id);
                reproductor.start();
                break;
        }
    }
}
