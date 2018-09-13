package com.proyecto.alejandreyes.practica02;

import android.content.Context;
import android.os.Debug;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.logging.Logger;

public class MainActivity  extends AppCompatActivity  implements View.OnClickListener {
    private TextView nombre ;
    private ImageView imagen;
    private Button numCuenta;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.w("onCreate:"," Ejecucion desde el metodo OnCreate()");

        setContentView(R.layout.activity_main);
        nombre = (TextView) findViewById(R.id.nombre);
        numCuenta = (Button) findViewById(R.id.numCuenta);
        imagen = (ImageView) findViewById(R.id.imagen);

        numCuenta.setOnClickListener(this);
        nombre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context context = getApplicationContext();
                CharSequence text = "setOnclickListener funcion Anonima ";
                int duration = Toast.LENGTH_SHORT;
                Toast toast = Toast.makeText(context, text, duration);
                toast.show();
            }
        });
    }

    @Override
    public void onClick(View v) {
        Toast.makeText(this, "Numero de cuenta 310090034", Toast.LENGTH_SHORT).show();
    }
    public void Click(View v){
        Toast.makeText(this, "Imagen de GNOME", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        Log.w("onDestroy:"," Ejecucion desde el metodo OnDestroy() la aplicacion se cerrara en breve ADIOS");
        super.onDestroy();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.w("onRestart:"," Ejecucion desde el metodo OnRestart()");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.w("onResume:"," Ejecucion desde el metodo OnResume()");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.w("onStart:"," Ejecucion desde el metodo OnStart()");
    }

    @Override
    protected void onStop() {
        Log.w("onStop:"," Ejecucion desde el metodo OnStop()");
        super.onStop();
    }

    @Override
    protected void onPause() {
        Log.w("onPause:"," Ejecucion desde el metodo OnPause()");
        super.onPause();
    }
}
