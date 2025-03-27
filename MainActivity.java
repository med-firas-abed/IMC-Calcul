package com.example.calculimc;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity{

    EditText nom, poids, taille;
    RadioButton estFemme;
    TextView resultat, eval;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nom = (EditText) findViewById(R.id.et_nom);
        poids = (EditText) findViewById(R.id.et_poids);
        taille = (EditText) findViewById(R.id.et_taille);
        estFemme = (RadioButton) findViewById(R.id.et_femme);
        resultat = (TextView) findViewById(R.id.txt_res_cal);
        eval = (TextView) findViewById(R.id.txt_res_eval);
    }
    public void calculer(View v) {
        double monPoids = Double.valueOf(poids.getText().toString());
        double maTaille = Double.valueOf(taille.getText().toString());
        double imc = monPoids / (maTaille * maTaille);

        String nomComplet = (estFemme.isChecked() ? "Mme " : "M. ") + nom.getText().toString();

        resultat.setText(nomComplet + ", votre IMC est de " + String.valueOf(imc));

        if (imc<16.5){
            eval.setTextColor(getResources().getColor(R.color.orange,getTheme()));
            eval.setText("Vous êtes en état de Dénutrition!");
        }else if (imc<18.5){
            eval.setTextColor(getResources().getColor(R.color.orange,getTheme()));
            eval.setText("Vous êtes en état de Maigreur!");
        }
        else if (imc<25){
            eval.setTextColor(getResources().getColor(R.color.green,getTheme()));
            eval.setText("Vous avez une corpulence normale!");
        }
        else if (imc<30){
            eval.setTextColor(getResources().getColor(R.color.red,getTheme()));
            eval.setText("Vous êtes en état de Surpoids!");
        }
        else if (imc<35){
            eval.setTextColor(getResources().getColor(R.color.red,getTheme()));
            eval.setText("Vous êtes en état d'Obésité Modérée!");
        }
        else if (imc<40){
            eval.setTextColor(getResources().getColor(R.color.red,getTheme()));
            eval.setText("Vous êtes en état d'Obésité Sévère!");
        }
        else{
            eval.setTextColor(getResources().getColor(R.color.red,getTheme()));
            eval.setText("Vous êtes en état d'Obésité Morbide ou Massive!");
        }
    }
}