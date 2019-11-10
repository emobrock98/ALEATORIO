package com.example.aleatorio;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.TextView;

import java.util.ArrayList;

public class AleatorioActivity extends AppCompatActivity implements View.OnClickListener,
        RadioGroup.OnCheckedChangeListener, CompoundButton.OnCheckedChangeListener {

    RadioGroup radioGroup;
    RadioButton radio1, radio2;
    EditText minimo, maximo, decimales, totales;
    CheckBox checkBox1;
    Switch switch1;
    ImageButton nave;
    TextView lista;
    boolean rango = true, decimas = true;
    ArrayList<Double> aleatorio = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aleatorio);
        instancias();
        acciones();
    }

    private void acciones() {
        radioGroup.setOnCheckedChangeListener(this);
        checkBox1.setOnCheckedChangeListener(this);
        nave.setOnClickListener(this);
        radio2.setOnClickListener(this);
    }

    private void instancias() {
        radioGroup = findViewById(R.id.grupoRadio);
        radio1 = findViewById(R.id.radio1);
        radio2 = findViewById(R.id.radio2);
        minimo = findViewById(R.id.minimo);
        maximo = findViewById(R.id.maximo);
        decimales = findViewById(R.id.decimales);
        totales = findViewById(R.id.totales);
        checkBox1 = findViewById(R.id.checkbox1);
        switch1 = findViewById(R.id.switch1);
        nave = findViewById(R.id.nave);
        lista = findViewById(R.id.lista);
    }

    public static double fijarNumero(double numero, int digitos) {
        double resultado;
        resultado = (Math.round(numero * Math.pow(10, digitos))) / Math.pow(10, digitos);
        return resultado;
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {

        if (group.getId() == R.id.grupoRadio) {
            switch (checkedId) {
                case R.id.radio1:
                    rango = false;
                    minimo.setEnabled(false);
                    maximo.setEnabled(false);
                    break;

                case R.id.radio2:
                    rango = true;
                    minimo.setEnabled(true);
                    maximo.setEnabled(true);
                    break;
            }
        }
    }

    @Override
    public void onCheckedChanged(CompoundButton a, boolean b) {
        if (a.getId() == R.id.checkbox1) {
            if (b) {
                decimas = true;
                decimales.setEnabled(true);
            } else {
                decimas = false;
                decimales.setEnabled(false);
            }
        }
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.nave) {
            lista.setText("");
            int d = Integer.valueOf(totales.getText().toString());
            if (rango) {
                if (!minimo.getText().toString().isEmpty() && !maximo.getText().toString().isEmpty()) {
                    double o1 = Double.valueOf(minimo.getText().toString());
                    double o2 = Double.valueOf(maximo.getText().toString());
                    //for(int i=0;i<5;i++)
                    if (decimas) {
                        if (!decimales.getText().toString().isEmpty()) {
                            for (int i = 0; i < d; i++) {
                                int op = Integer.valueOf(decimales.getText().toString());
                                double alN = (Math.random() * ((o2 + 1) - o1) + o1);
                                double numAleatori = fijarNumero(alN, op);
                                lista.setText(lista.getText() + "\n" + Double.toString(numAleatori));
                            }
                        }
                    } else if (!decimas) {
                        for (int i = 0; i < d; i++) {
                            double alN = (Math.random() * ((o2 + 1) - o1) + o1);
                            lista.setText(lista.getText() + "\n" + (int) (alN));
                        }
                    }
                }
            } else if (!rango) {
                if (decimas) {
                    if (!decimales.getText().toString().isEmpty()) {
                        for (int i = 0; i < d; i++) {
                            int op = Integer.valueOf(decimales.getText().toString());
                            double alN = Math.random() * 500 + 1;
                            double numAleatori = fijarNumero(alN, op);
                            lista.setText(lista.getText() + "\n" + Double.toString(numAleatori));
                        }
                    }
                } else if (!decimas) {
                    if (!totales.getText().toString().isEmpty()) {
                        for (int i = 0; i < d; i++) {
                            double alN = Math.random() * 500 + 1;
                            aleatorio.add(alN);
                        }
                        for (Double item : aleatorio) {
                            lista.setText(lista.getText() + "\n" + Double.toString(item));
                        }
                    } else {
                        double alN = Math.random() * 500 + 1;
                        lista.setText(lista.getText() + "\n" + Double.toString(alN));
                    }
                }
            }
        }
    }
}
