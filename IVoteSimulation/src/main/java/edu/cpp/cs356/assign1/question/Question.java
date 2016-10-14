package edu.cpp.cs356.assign1.question;

import java.util.HashSet;

/**
 * The general Question which has a question an multiple candidates for answers.
 * This general class will split into multiple answer and single answer questions.
 * However, if a new type of question (for example, short answers),
 * This hierarchy is not suitable, and have to be updated.
 *
 * @author Wai Phyo
 */
public abstract class Question {
    private String question;
    private HashSet<String> candidates;

    public Question(String question, HashSet<String> candidates) {
        this.question = question;
        setCandidates(candidates);
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(final String question) {
        this.question = question;
    }


    public HashSet<String> getCandidates() {
        return candidates;
    }

    public void setCandidates(final HashSet<String> candidates) {
        if (candidates.isEmpty()) {
            throw new RuntimeException("There must be at least one candidates.");
        }
        this.candidates = candidates;
    }

    public abstract String printCorrectAnswer();

    /**
     * This method is used to validate when the users create the candidates and answers separately,
     * and answers are not part of the candidates.
     *
     * @param String: single answer
     * @return boolean: checks answer is amongst the candidates.
     */
    protected boolean isValidAnswer(final String answer) {
        return candidates.contains(answer);
    }
}
