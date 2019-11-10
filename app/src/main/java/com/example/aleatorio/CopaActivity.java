package com.example.aleatorio;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

public class CopaActivity extends AppCompatActivity implements View.OnClickListener {
    ArrayList<String> nAleatorio = new ArrayList<>();
    EditText nombre;
    Button agregar, generar;
    TextView ganador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_copa);
        instancias();
        acciones();
    }

    private void acciones() {
        agregar.setOnClickListener(this);
        generar.setOnClickListener(this);
    }

    private void instancias() {
        nombre = findViewById(R.id.nombre1);
        agregar = findViewById(R.id.agregar);
        generar = findViewById(R.id.generar);
        ganador = findViewById(R.id.ganador);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.agregar:
                if(!nombre.getText().toString().isEmpty()){
                String nom = nombre.getText().toString();
                ganador.setText(ganador.getText() + "\n - " + (nom));
                nAleatorio.add(nom);
                nombre.setText("");}
                break;

            case R.id.generar:
                if(!nAleatorio.isEmpty()){
                double aleatorio = Math.random() * nAleatorio.size();
                ganador.setText(nAleatorio.get((int) aleatorio));}
                break;
        }
    }
}
