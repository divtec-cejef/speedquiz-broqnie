package com.broqnie.jeu.Controllers;

import com.broqnie.jeu.Models.Question;

import java.util.ArrayList;
import java.util.Random;
public class QuestionManager {
    private ArrayList<Question>questionsTirees = new ArrayList<>();

    public QuestionManager(){
        addQuestion();
    }

    public void setMesQuestions(ArrayList<Question> questionsTirees) {
        this.questionsTirees = questionsTirees;
    }

    private int questionIndex(){
         return (int) (Math.random() * questionsTirees.size());
    }

    public Question getRandomQuestion(){
        int rnd = questionIndex();
        Question question = questionsTirees.get(rnd);
        questionsTirees.remove(rnd);
        return question;
    }

    public void addQuestion(){
        questionsTirees.add(new Question("Bilel est beau",1));
        questionsTirees.add(new Question("Janvier a 31 jours",1));
        questionsTirees.add(new Question("l'alphabet à 25 lettres", 0));
        questionsTirees.add(new Question("MacOs est un linux", 1));
        questionsTirees.add(new Question("Un  Byte vaut 7 bits", 0));
        questionsTirees.add(new Question("Poutine a 69 ans",1));
        questionsTirees.add(new Question("il faut l'équivalent à 13 ans d'eau pour un humain afin de créer un jeans",1));
        questionsTirees.add(new Question("Le HCA est 13ème au classment", 1));
        questionsTirees.add(new Question("OpenSUSE est une distribution de Red Hat ", 0));
        questionsTirees.add(new Question("Le cervin est au Grison", 0));
    }

    public boolean etatListeQuestion(){
        return questionsTirees.size() <= 0;
    }
}
