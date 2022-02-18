package com.broqnie.jeu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.TextView;

public class JeuActivity extends AppCompatActivity {
        public TextView et_nom_joueur1;
        public TextView et_nom_joueur2;
        Runnable questionRunnable=null;


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
        public void tempsQuestion(){
            Handler handler = new Handler();
            questionRunnable = new Runnable() {
                @Override
                public void run(){
                    if("CONTROL_LAST_QUESTION"){
                        'DO_CODE_LAST_QUESTION
                        '...
                        handler.removeCallbacks(this);
                        'DO_OTHER_EXIT_CODE
                    }else{
                        'DO_CODE_QUESTION_ITERATION
                        handler.postDelayed(this,"TIMER_MILLIS_QUESTION_DELAY");
                    }
                }
            };
            handler.postDelayed(questionRunnable,"TIMER_MILLIS_ITERATION_START");
        }

}

