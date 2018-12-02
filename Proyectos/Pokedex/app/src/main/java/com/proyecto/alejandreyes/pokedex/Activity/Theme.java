package com.proyecto.alejandreyes.pokedex.Activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Switch;
import android.widget.Button;
import com.proyecto.alejandreyes.pokedex.R;

public class Theme extends AppCompatActivity implements View.OnClickListener {
    private Switch tema1,tema2 ;
    private Toolbar toolbar ;
    private Button aceptar  ;
    private  String seleccionado;
    private boolean activoEveeTheme =false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        cargarPreferencias();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_theme);
        tema1 = findViewById(R.id.evee_switch);
        tema1.setChecked(activoEveeTheme);
        tema2 = findViewById(R.id.totodaile_switch);

        tema2.setChecked(!activoEveeTheme);
        tema1.setOnClickListener(this);
        tema2.setOnClickListener(this);
        aceptar = findViewById(R.id.cambiarTema);
        aceptar.setOnClickListener(this);
    }
    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.evee_switch){
            tema2.setChecked(false);
            //tema1.setChecked(true);
            seleccionado = tema1.getText().toString();
            setTheme(R.style.AppThemeNoActionBar);
        }
        if (view.getId() == R.id.totodaile_switch){
            tema1.setChecked(false);
            //tema2.setChecked(true);

            seleccionado = tema2.getText().toString();
            getApplicationContext().setTheme(R.style.AppThemeNoActionBarTotodaile);
        }
        if (view.getId() == R.id.cambiarTema){
            guardarPreferencias();
            Intent intent = new Intent(this,MainActivity.class);
            startActivity(intent);
        }

    }

    private void guardarPreferencias() {
        SharedPreferences preferencias = getSharedPreferences("themes",Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferencias.edit();
        editor.putString("tema",seleccionado);
        editor.commit();
    }
    private void cargarPreferencias() {
        SharedPreferences preferencias = getSharedPreferences("themes",Context.MODE_PRIVATE);
        String predeterminado = preferencias.getString("tema","Evee theme");
        if(predeterminado.equals("Evee theme")){
            activoEveeTheme = true;
            setTheme(R.style.AppThemeNoActionBar);
        }else{
            setTheme(R.style.AppThemeNoActionBarTotodaile);
        }
    }
}
