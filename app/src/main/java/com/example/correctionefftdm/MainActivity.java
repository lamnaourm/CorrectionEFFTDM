package com.example.correctionefftdm;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    ImageView im;
    float Currentang = 0;
    EditText e1, e2, e3, e4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        im = findViewById(R.id.img);

        e1 = findViewById(R.id.edebit);
        e2 = findViewById(R.id.edownload);
        e3 = findViewById(R.id.eupload);
        e4 = findViewById(R.id.ers);
    }


    public void rotate(float ang1, float ang2) {

        RotateAnimation an = new RotateAnimation(ang1, ang2, Animation.RELATIVE_TO_SELF, 0.7f, Animation.RELATIVE_TO_SELF, 0.5f);
        an.setDuration(3000);
        an.setFillAfter(true);

        im.startAnimation(an);
        Currentang = ang2;
    }

    public void Calculer(int debit) {
        if (debit < 0) {
            Toast.makeText(this, "Erreur! la vitesse de la connexion doit etre entre 0 et 100", Toast.LENGTH_SHORT).show();
            rotate(Currentang, 0);
            return;
        }

        if (debit > 100) {
            Toast.makeText(this, "Erreur! la vitesse de la connexion doit etre entre 0 et 100", Toast.LENGTH_SHORT).show();
            rotate(Currentang, 180);
            return;
        }

        e2.setText(String.format("%.2f", debit * 0.75));
        e3.setText(String.format("%.2f", debit * 0.15));
        e4.setText(String.format("%.2f", debit * 0.1));

        rotate(Currentang, debit * 1.8f);
    }

    public void effacer() {
        e1.getText().clear();
        e2.getText().clear();
        e3.getText().clear();
        e4.getText().clear();
        rotate(Currentang, 0);
    }

    public void calc(View view) {
        int debit = Integer.valueOf(e1.getText().toString());
        Calculer(debit);
    }

    public void init(View view) {
        effacer();
    }
}