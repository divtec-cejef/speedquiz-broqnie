package com.broqnie.jeu.Models;

public class Question {
    private String question;
    private int reponse;

    /**
     * constructeur de question
     */
    public Question() {
    }

    /**
     * constructeur de question
     */
    public Question(String question, int reponse) {
        this.question = question;
        this.reponse = reponse;
    }

    /**
     * donne le texte d'une question
     *
     * @return le texte d'une question
     */
    public String getQuestionText() {
        return question;
    }

    /**
     * donne la réponse de la question
     *
     * @return la reponse de la question( 0 = faux, 1 = vrai)
     */
    public int getReponse() {
        return reponse;
    }
}
