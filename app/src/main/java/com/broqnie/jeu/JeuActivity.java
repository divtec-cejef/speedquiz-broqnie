package com.broqnie.jeu;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.TextView;

import com.broqnie.jeu.Controllers.QuestionManager;
import com.broqnie.jeu.Models.Question;

public class JeuActivity extends AppCompatActivity {
        public TextView et_nom_joueur1;
        public TextView et_nom_joueur2;
        public ConstraintLayout jeu;
        public ConstraintLayout param_finJeu;
        Runnable questionRunnable=null;
        public int pointJoueur1 = 0;
        public int pointJoueur2 = 0;


        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            Intent intent = getIntent();
            setContentView(R.layout.activity_jeu);

            et_nom_joueur1 = findViewById(R.id.nom_joueur1);
            et_nom_joueur2 = findViewById(R.id.nom_joueur2);
            jeu = findViewById(R.id.jeu);
            param_finJeu = findViewById(R.id.param_finjeu);
        }

        @Override
        protected void onStart() {
            super.onStart();
            Intent intent = getIntent();
            et_nom_joueur1.setText(intent.getStringExtra("joueur1"));
            et_nom_joueur2.setText(intent.getStringExtra("joueur2"));

        }
        public void tempsQuestion(){
            QuestionManager i = new QuestionManager();
            Question e = new Question();
            Handler handler = new Handler();
            questionRunnable = new Runnable() {
                @Override
                public void run(){
                    if(QuestionManager.etatListeQuestion()){
                        'DO_CODE_LAST_QUESTION
                        '...
                        handler.removeCallbacks(this);
                        jeu.setVisibility(View.GONE);
                        param_finJeu.setVisibility(View.VISIBLE);
                        pointJoueur1=0;
                        pointJoueur2=0;
                    }else{

                        et_nom_joueur1.setText(QuestionManager.);
                        handler.postDelayed(this,2000);
                    }
                }
            };
            handler.postDelayed(questionRunnable,2000);
        }

}

