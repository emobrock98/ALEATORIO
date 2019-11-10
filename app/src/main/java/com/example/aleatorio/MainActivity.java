package com.example.aleatorio;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    ImageButton aleatorio, dados, copa;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        instancias();
        acciones();
    }

    private void acciones() {
        aleatorio.setOnClickListener(this);
        copa.setOnClickListener(this);
        dados.setOnClickListener(this);
    }

    private void instancias() {
        aleatorio = findViewById(R.id.aleat);
        copa = findViewById(R.id.copa);
        dados = findViewById(R.id.dados);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.aleat:
                intent = new Intent(getApplicationContext(), AleatorioActivity.class);
                startActivity(intent);
                break;

            case R.id.copa:
                intent = new Intent(getApplicationContext(), CopaActivity.class);
                startActivity(intent);
                break;

            case R.id.dados:
                intent = new Intent(getApplicationContext(), DadosActivity.class);
                startActivity(intent);
                break;
        }
    }
}
