package com.proyecto.alejandreyes.proyecto02;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button agregar ;
    private Button enviar ;
    private EditText texto ;

    ArrayList<String> notas ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        notas = new ArrayList<>();
        agregar = findViewById(R.id.agregar);
        enviar = findViewById(R.id.mostrar) ;
        agregar.setOnClickListener(this);
        enviar.setOnClickListener(this);
        texto = findViewById(R.id.texto);
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.agregar:
                String aux = texto.getText().toString();
                texto.setText("");
                notas.add(aux);
                break;
            case  R.id.mostrar:
                Intent intento = new Intent(this, Main2Activity.class);
                intento.putStringArrayListExtra("notas",notas);
                startActivity(intento);
                break;
        }
    }
}
