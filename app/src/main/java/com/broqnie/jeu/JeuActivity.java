package com.broqnie.jeu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class JeuActivity extends AppCompatActivity {
        public TextView et_nom_joueur1;
        public TextView et_nom_joueur2;


        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            Intent intent = getIntent();
            setContentView(R.layout.activity_jeu);

            et_nom_joueur1 = findViewById(R.id.nom_joueur1);
            et_nom_joueur2 = findViewById(R.id.nom_joueur2);
        }

        @Override
        protected void onStart() {
            super.onStart();
            Intent intent = getIntent();
            et_nom_joueur1.setText(intent.getStringExtra("joueur1"));
            et_nom_joueur2.setText(intent.getStringExtra("joueur2"));

        }
}

