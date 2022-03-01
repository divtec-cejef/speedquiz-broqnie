package com.broqnie.jeu;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
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
        public TextView et_question_joueur1;
        public TextView et_question_joueur2;
        public Button restart;
        public Button menu;

        public EditText et_joueur1;
        public EditText et_joueur2;



        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            Intent intent = getIntent();
            setContentView(R.layout.activity_jeu);

            et_nom_joueur1 = findViewById(R.id.nom_joueur1);
            et_nom_joueur2 = findViewById(R.id.nom_joueur2);
            jeu = findViewById(R.id.jeu);
            param_finJeu = findViewById(R.id.param_finjeu);
            et_question_joueur2 = findViewById(R.id.question2);
            et_question_joueur1 = findViewById(R.id.question1);
            menu = findViewById(R.id.buttonMenu);
            restart = findViewById(R.id.buttonRestart);

            et_joueur1 = findViewById(R.id.et_player1);
            et_joueur2 = findViewById(R.id.et_player2);
        }

        @Override
        protected void onStart() {
            super.onStart();
            Intent intent = getIntent();
            et_nom_joueur1.setText(intent.getStringExtra("joueur1"));
            et_nom_joueur2.setText(intent.getStringExtra("joueur2"));
            tempsQuestion();

            menu.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                    et_nom_joueur1.setVisibility(View.VISIBLE);
                    et_nom_joueur2.setVisibility(View.VISIBLE);
                    startActivity(intent);
                }
            });

            restart.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(getApplicationContext(), JeuActivity.class);
                    intent.putExtra("joueur1", et_nom_joueur1.getText().toString());
                    intent.putExtra("joueur2", et_nom_joueur2.getText().toString());
                    startActivity(intent);
                }
            });

        }
        public void tempsQuestion(){
            QuestionManager i = new QuestionManager();
            i.addQuestion();
            Handler handler = new Handler();
            questionRunnable = new Runnable() {
                @Override
                public void run(){
                    i.questionIndex();
                    if(i.etatListeQuestion()){

                        handler.removeCallbacks(this);
                        jeu.setVisibility(View.GONE);
                        param_finJeu.setVisibility(View.VISIBLE);
                        pointJoueur1=0;
                        pointJoueur2=0;
                    }else{
                        et_question_joueur2.setText(i.getQuestion().getQuestion());
                        et_question_joueur1.setText(et_question_joueur2.getText().toString());

                        handler.postDelayed(this,2000);
                    }
                }
            };
            handler.postDelayed(questionRunnable,2000);
        }

}

