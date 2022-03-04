package com.broqnie.jeu.Controllers;

import com.broqnie.jeu.Models.Question;

import java.util.ArrayList;
import java.util.Random;

public class QuestionManager {
    private ArrayList<Question> questionsTirees = new ArrayList<>();

    /**
     * constructeur de question manager
     */
    public QuestionManager() {
        addQuestion();
    }

    /**
     * permet de changer les questions
     *
     * @param questionsTirees questions qui vont remplacer les autres
     */
    public void setMesQuestions(ArrayList<Question> questionsTirees) {
        this.questionsTirees = questionsTirees;
    }

    /**
     * indique l'index d'une question a tirée
     *
     * @return nombre aléatoire
     */
    private int questionIndex() {
        return (int) (Math.random() * questionsTirees.size());
    }

    /**
     * tire une question et la renvoie
     *
     * @return une question
     */
    public Question getRandomQuestion() {
        int rnd = questionIndex();
        Question question = questionsTirees.get(rnd);
        questionsTirees.remove(rnd);
        return question;
    }

    /**
     * liste de questions
     */
    public void addQuestion() {
        questionsTirees.add(new Question("Bilel est beau", 1));
        questionsTirees.add(new Question("Janvier a 31 jours", 1));
        questionsTirees.add(new Question("l'alphabet à 25 lettres", 0));
        questionsTirees.add(new Question("MacOs est un linux", 1));
        questionsTirees.add(new Question("Un  Byte vaut 7 bits", 0));
        questionsTirees.add(new Question("Poutine a 69 ans", 1));
        questionsTirees.add(new Question("il faut l'équivalent à 13 ans d'eau pour un humain afin de créer un jeans", 1));
        questionsTirees.add(new Question("Le HCA est 13ème au classment", 1));
        questionsTirees.add(new Question("OpenSUSE est une distribution de Red Hat ", 0));
        questionsTirees.add(new Question("Le cervin est au Grison", 0));
    }

    /**
     * test si la liste est vide (si tout a été tiré)
     *
     * @return vrai = toutes les questions ont été tirées, faux = reste des questions a tirer
     */
    public boolean etatListeQuestion() {
        return questionsTirees.size() <= 0;
    }
}
