package com.broqnie.jeu;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Switch;

import com.google.android.material.switchmaterial.SwitchMaterial;

public class MainActivity extends AppCompatActivity {
    public ConstraintLayout main;
    public ConstraintLayout page_question;
    public ConstraintLayout page_parametres;
    public Button bt_quitte_question;
    public Button bt_quitte_param;
    public Button bt_ajouter_player;
    public EditText et_joueur1;
    public EditText et_joueur2;
    public Button bt_appliquer;
    public Button bt_cancel;
    public SwitchMaterial sw_mode;
    public EditText et_question_txt;
    public RadioButton rb_vrai;
    public RadioButton rb_faux;
    public Button bt_valider;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar mainToolBar = findViewById(R.id.toolAppBar);
        setSupportActionBar(mainToolBar);
        main = findViewById(R.id.main);
        page_question = findViewById(R.id.param_question);
        bt_quitte_question = findViewById(R.id.button_quitte_question);
        bt_quitte_param = findViewById(R.id.button_quitte_parametre);
        page_parametres = findViewById(R.id.param_parametre);
        bt_ajouter_player = findViewById(R.id.buttonAdd);
        et_joueur1 = findViewById(R.id.et_player1);
        et_joueur2 = findViewById(R.id.et_player2);
        bt_appliquer= findViewById(R.id.buttonApply);
        sw_mode= findViewById(R.id.switch_mode);
        bt_cancel=findViewById(R.id.button_cancel);
        bt_valider=findViewById(R.id.button_create);
        et_question_txt=findViewById(R.id.question_creation_txt);
        rb_vrai=findViewById(R.id.radio_button_Vrai);
        rb_faux=findViewById(R.id.radio_button_Faux);


    }

    @Override
    protected void onStart() {
        super.onStart();

        bt_ajouter_player.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                et_joueur1.setVisibility(View.VISIBLE);
            }
        });

        bt_appliquer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), JeuActivity.class);
                intent.putExtra("joueur1", et_joueur1.getText().toString()+" : ");
                intent.putExtra("joueur2", et_joueur2.getText().toString()+" : ");
                startActivity(intent);
            }
        });

        bt_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                et_question_txt.setText("");
                rb_faux.setChecked(false);
                rb_vrai.setChecked(false);
            }
        });

        et_joueur1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                et_joueur2.setVisibility(View.VISIBLE);
            }

            @Override
            public void afterTextChanged(Editable editable) {
                et_joueur2.setVisibility(View.VISIBLE);
                if (et_joueur1.getText().toString().matches("") && et_joueur2.getText().toString().matches("")) {
                    bt_appliquer.setVisibility(View.GONE);
                }else if(et_joueur1.getText().toString().matches("")|| et_joueur2.getText().toString().matches("")) {
                    bt_appliquer.setVisibility(View.GONE);
                }else {
                    bt_appliquer.setVisibility(View.VISIBLE);
                }
            }
        });

        et_question_txt.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (!et_question_txt.getText().toString().matches("")){
                    if(!rb_faux.isChecked() && rb_vrai.isChecked()) {
                        bt_valider.setEnabled(true);
                        bt_valider.setText("valider");
                    }else if (rb_faux.isChecked() && !rb_vrai.isChecked()){
                        bt_valider.setEnabled(true);
                        bt_valider.setText("valider");
                    }else{
                        bt_valider.setEnabled(false);
                        bt_valider.setText("Validation pas possible");
                    }
                }else{
                    bt_valider.setEnabled(false);
                    bt_valider.setText("Validation pas possible");
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {
                if (!et_question_txt.getText().toString().matches("")){
                    if(!rb_faux.isChecked() && rb_vrai.isChecked()) {
                        bt_valider.setEnabled(true);
                        bt_valider.setText("valider");
                    }else if (rb_faux.isChecked() && !rb_vrai.isChecked()){
                        bt_valider.setEnabled(true);
                        bt_valider.setText("valider");
                    }else{
                        bt_valider.setEnabled(false);
                        bt_valider.setText("Validation pas possible");
                    }
                }else{
                    bt_valider.setEnabled(false);
                    bt_valider.setText("Validation pas possible");
                }
            }
        });

        et_joueur2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                bt_appliquer.setVisibility(View.VISIBLE);
            }

            @Override
            public void afterTextChanged(Editable editable) {
                bt_appliquer.setVisibility(View.VISIBLE);
                if (et_joueur1.getText().toString().matches("") && et_joueur2.getText().toString().matches("")) {
                    bt_appliquer.setVisibility(View.GONE);
                }else if(et_joueur1.getText().toString().matches("")|| et_joueur2.getText().toString().matches("")) {
                    bt_appliquer.setVisibility(View.GONE);
                }else {
                    bt_appliquer.setVisibility(View.VISIBLE);
                }
            }
        });

        bt_quitte_question.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                page_parametres.setVisibility(View.GONE);
                page_question.setVisibility(View.GONE);
                main.setVisibility(View.VISIBLE);
                et_question_txt.setText("");
                rb_faux.setChecked(false);
                rb_vrai.setChecked(false);
            }
        });

        rb_faux.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b){
                    if(!et_question_txt.getText().toString().matches("")){
                        bt_valider.setEnabled(true);
                        bt_valider.setText("valider");
                    }else if(rb_vrai.isChecked()&&!et_question_txt.getText().toString().matches("")){
                        bt_valider.setEnabled(true);
                        bt_valider.setText("valider");
                    }else{
                        bt_valider.setEnabled(false);
                        bt_valider.setText("Validation pas possible");
                    }
                }
            }
        });

        rb_vrai.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b){
                    if(!et_question_txt.getText().toString().matches("")){
                        bt_valider.setEnabled(true);
                        bt_valider.setText("valider");
                    }else if(rb_vrai.isChecked()&&!et_question_txt.getText().toString().matches("")){
                        bt_valider.setEnabled(true);
                        bt_valider.setText("valider");
                    }else{
                        bt_valider.setEnabled(false);
                        bt_valider.setText("Validation pas possible");
                    }
                }
            }
        });

        sw_mode.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                }else{
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                }
            }
        });

        bt_quitte_param.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                page_parametres.setVisibility(View.GONE);
                page_question.setVisibility(View.GONE);
                main.setVisibility(View.VISIBLE);
            }
        });

    }
    public boolean onCreateOptionsMenu (Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected (MenuItem item){
        switch (item.getItemId()) {
            case R.id.action_param:
                main.setVisibility(View.GONE);
                page_parametres.setVisibility(View.VISIBLE);
                page_question.setVisibility(View.GONE);
                break;
            case R.id.action_question:
                main.setVisibility(View.GONE);
                page_parametres.setVisibility(View.GONE);
                page_question.setVisibility(View.VISIBLE);
                break;
            default:
                return super.onOptionsItemSelected(item);
        }
        return true;
    }
}

