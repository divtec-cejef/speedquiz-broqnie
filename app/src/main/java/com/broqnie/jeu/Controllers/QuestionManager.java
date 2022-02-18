package com.broqnie.jeu.Controllers;

import com.broqnie.jeu.Models.Question;

import java.util.ArrayList;
import java.util.Random;
public class QuestionManager {
    private ArrayList<Question>mesQuestions = new ArrayList<>();
    private int index = 0;
    ArrayList<Question>questionsTirees = new ArrayList<>();

    public void setMesQuestions(ArrayList<Question> mesQuestions) {
        this.mesQuestions = mesQuestions;
    }

    public int questionChoisi(){
         return (int) (Math.random() * mesQuestions.size());
    }

    public ArrayList<Question> getQuestion(){
        index++;
        questionsTirees.add(mesQuestions.get(questionChoisi()));
        return questionsTirees.get(index);

    }

    public void addQuestion(){
        mesQuestions.add(new Question("Bilel est beau",1));
        mesQuestions.add(new Question("Janvier a 31 jours",1));
        mesQuestions.add(new Question("l'alphabet à 25 lettres", 0));
    }

    public void resetQuestion(){
        if (index.equals(mesQuestions.size()-1)){
            questionsTirees.removeAll(questionsTirees);
        }

    }

            question tiré tant que liste.lenght pas égale a question passé

}
