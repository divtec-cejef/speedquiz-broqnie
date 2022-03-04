package com.broqnie.jeu;

import static java.lang.Integer.parseInt;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.view.WindowInsetsControllerCompat;

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
    Runnable questionRunnable = null;
    public Integer pointJoueur1 = 0;
    public Integer pointJoueur2 = 0;
    public TextView et_question_joueur1;
    public TextView et_question_joueur2;
    public Button restart;
    public Button menu;
    public Button bt_vrai1;
    public Button bt_vrai2;
    public TextView et_joueur1;
    public TextView et_joueur2;
    public TextView et_pointJoueur1;
    public TextView et_pointJoueur2;
    public Question questionAffichee;
    public TextView gagnant;


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
        et_pointJoueur1 = findViewById(R.id.point_joueur1);
        et_pointJoueur2 = findViewById(R.id.point_joueur2);
        bt_vrai1 = findViewById(R.id.buttonVraiPlayer1);
        bt_vrai2 = findViewById(R.id.buttonVraiPlayer2);
        gagnant = findViewById(R.id.joueurGagnant);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Intent intent = getIntent();
        et_nom_joueur1.setText(intent.getStringExtra("joueur1"));
        et_nom_joueur2.setText(intent.getStringExtra("joueur2"));
        hideSystemBars();
        tempsQuestion();
        bt_vrai1.setEnabled(false);
        bt_vrai2.setEnabled(false);

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

        bt_vrai1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (questionAffichee.getReponse() == 1) {
                    bt_vrai1.setEnabled(false);
                    bt_vrai2.setEnabled(false);
                    pointJoueur1++;
                    et_pointJoueur1.setText(pointJoueur1.toString());
                } else if(pointJoueur1 > 0){
                    pointJoueur1--;
                    et_pointJoueur1.setText(pointJoueur1.toString());
                }
            }
        });

        bt_vrai2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (questionAffichee.getReponse() == 1) {
                    bt_vrai1.setEnabled(false);
                    bt_vrai2.setEnabled(false);
                    pointJoueur2++;
                    et_pointJoueur2.setText(pointJoueur2.toString());
                } else {
                    if(pointJoueur2 > 0){
                        pointJoueur2--;
                        et_pointJoueur2.setText(pointJoueur2.toString());
                    }
                }
            }
        });
    }

    public void tempsQuestion() {
        QuestionManager qm = new QuestionManager();
        Handler handler = new Handler();
        questionRunnable = new Runnable() {
            @Override
            public void run() {
                if (qm.etatListeQuestion()) {

                    handler.removeCallbacks(this);
                    jeu.setVisibility(View.GONE);
                    param_finJeu.setVisibility(View.VISIBLE);
                    gagnant();
                    pointJoueur1 = 0;
                    pointJoueur2 = 0;

                } else {
                    questionAffichee = qm.getRandomQuestion();
                    et_question_joueur2.setText(questionAffichee.getQuestionText());
                    et_question_joueur1.setText(questionAffichee.getQuestionText());
                    bt_vrai1.setEnabled(true);
                    bt_vrai2.setEnabled(true);

                    handler.postDelayed(this, 2000);
                }
            }
        };
        handler.postDelayed(questionRunnable, 2000);
    }

    private void gagnant(){
        if(pointJoueur1 > pointJoueur2){
            gagnant.setText(et_nom_joueur1.getText().toString());
        }else if (pointJoueur1 < pointJoueur2){
            gagnant.setText(et_nom_joueur2.getText().toString().substring(0, et_nom_joueur2.getText().toString().length()-3));
        }else {
            gagnant.setText("Egalité, bien joué !");
        }
    }

    private void hideSystemBars() {
        WindowInsetsControllerCompat windowInsetsController =
                ViewCompat.getWindowInsetsController(getWindow().getDecorView());
        if (windowInsetsController == null) {
            return;
        }
        // Configure the behavior of the hidden system bars
        windowInsetsController.setSystemBarsBehavior(
                WindowInsetsControllerCompat.BEHAVIOR_SHOW_TRANSIENT_BARS_BY_SWIPE
        );
        // Hide both the status bar and the navigation bar
        windowInsetsController.hide(WindowInsetsCompat.Type.systemBars());
    }
}

