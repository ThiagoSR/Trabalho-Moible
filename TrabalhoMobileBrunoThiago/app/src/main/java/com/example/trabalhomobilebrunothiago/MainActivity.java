package com.example.trabalhomobilebrunothiago;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity{

    private Button botao;
    private EditText altura, peso;
    private TextView resultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        altura = findViewById(R.id.valAltura);
        peso = findViewById(R.id.valPeso);
        botao = findViewById(R.id.btnCalcular);
        resultado = findViewById(R.id.txtResultado);
        botao.setOnClickListener( new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                resultado.setText(
                        calculaIMC(
                                Double.parseDouble(
                                        altura.getText().toString()
                                ),
                                Double.parseDouble(
                                        peso.getText().toString()
                                )
                        )
                );
            }
        });

    }

    String calculaIMC(Double altura, Double peso){
        Double resultado = (peso/(altura*altura));
        if(resultado < 18.5) {
            return "Seu IMC é " + String.format("%.2f",resultado) + ", você está no estado de magreza.";
        }else if(resultado < 24.9) {
            return "Seu IMC é " + String.format("%.2f",resultado) + ", você está no estado saudável.";
        }else if(resultado < 29.9) {
            return "Seu IMC é " + String.format("%.2f",resultado) + ", você está no estado de sobrepeso(Obesidade Grau I).";
        }else if(resultado < 39.9) {
            return "Seu IMC é " + String.format("%.2f",resultado) + ", você está no estado de obesidade(Obesidade Grau II).";
        }else if(resultado > 40){
            return "Seu IMC é " + String.format("%.2f",resultado) + ", você está no estado de obesidade grave(Obesidade Grau III).";
        }
        return "Não foi possível calcular o IMC";
    }

}