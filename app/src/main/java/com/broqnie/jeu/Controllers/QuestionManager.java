package com.broqnie.jeu.Controllers;

import com.broqnie.jeu.Models.Question;

import java.util.ArrayList;
import java.util.Random;
public class QuestionManager {
    private ArrayList<Question>mesQuestions = new ArrayList<>();
    private ArrayList<Question>questionsTirees = new ArrayList<>();

    public QuestionManager(){}

    public void setMesQuestions(ArrayList<Question> mesQuestions) {
        this.mesQuestions = mesQuestions;
    }

    public int questionIndex(){
         return (int) (Math.random() * questionsTirees.size());
    }

    public Question getQuestion(){
        int rnd = questionIndex();
        Question a = questionsTirees.get(rnd);
        questionsTirees.remove(rnd);
        return a;


    }

    public void addQuestion(){
        mesQuestions.add(new Question("Bilel est beau",1));
        mesQuestions.add(new Question("Janvier a 31 jours",1));
        mesQuestions.add(new Question("l'alphabet à 25 lettres", 0));
        mesQuestions.add(new Question("MacOs est un linux", 1));
        mesQuestions.add(new Question("Un  Byte vaut 7 bits", 0));
        questionsTirees = mesQuestions;
    }

    public boolean etatListeQuestion(){
        return questionsTirees.size() <= 0;
    }
}
