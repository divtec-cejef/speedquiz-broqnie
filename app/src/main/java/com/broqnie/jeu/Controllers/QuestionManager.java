package com.broqnie.jeu.Controllers;

import com.broqnie.jeu.Models.Question;

import java.util.ArrayList;
import java.util.Random;
public class QuestionManager {
    private ArrayList<Question>mesQuestions = new ArrayList<>();


    public void setMesQuestions(ArrayList<Question> mesQuestions) {
        this.mesQuestions = mesQuestions;
    }

    public int questionChoisi(){
         return (int) (Math.random() * mesQuestions.size());
    }

    public Question getQuestion(){
        int rnd = questionChoisi();
        ArrayList<Question>questionsTirees = new ArrayList<>();
        questionsTirees.add(mesQuestions.get(rnd));
        mesQuestions.remove(rnd);
        return questionsTirees.get(questionsTirees.size()-1);

    }

    public void addQuestion(){
        mesQuestions.add(new Question("Bilel est beau",1));
        mesQuestions.add(new Question("Janvier a 31 jours",1));
        mesQuestions.add(new Question("l'alphabet à 25 lettres", 0));
    }

}
