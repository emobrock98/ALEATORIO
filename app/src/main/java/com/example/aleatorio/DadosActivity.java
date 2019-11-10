package com.example.aleatorio;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.Random;

public class DadosActivity extends AppCompatActivity implements View.OnClickListener {

    Button tirada;
    ImageView dadosAleatorios;
    ArrayList imagenesDados;
    Random r;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dados);
        instancias();
        acciones();
        dados();
    }

    private void dados() {
        imagenesDados.add(R.drawable.uno);
        imagenesDados.add(R.drawable.dos);
        imagenesDados.add(R.drawable.tres);
        imagenesDados.add(R.drawable.cuatro);
        imagenesDados.add(R.drawable.cinco);
        imagenesDados.add(R.drawable.seis);
    }

    private void acciones() {
        tirada.setOnClickListener(this);
    }

    private void instancias() {
        tirada = findViewById(R.id.tirada);
        dadosAleatorios = findViewById(R.id.dadosAleatorios);
        imagenesDados = new ArrayList();
        r = new Random();
    }

    @Override
    public void onClick(View v) {
        Integer dadosAle = (Integer) imagenesDados.get(r.nextInt(imagenesDados.size()));
        dadosAleatorios.setImageResource(dadosAle);
    }
}
