package edu.cpp.cs356.assign1.question;

import java.util.HashSet;

/**
 * This class inherits the abstract class 'Question'.
 * This class will have one correct answer.
 *
 * @author Wai Phyo
 */
public class SingleAnswerQuestion extends Question {
    private String correctAnswer;

    public SingleAnswerQuestion(final String question, final HashSet<String> candidates, final String correctAnswer) {
        super(question, candidates);
        setCorrectAnswer(correctAnswer);
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }

    public void setCorrectAnswer(final String correctAnswer) {
        if (isValidAnswer(correctAnswer)) {
            this.correctAnswer = correctAnswer;
        } else {
            throw new RuntimeException("Invalid edu.cpp.cs356.assign1.answers.Answer.");
        }
    }

    public String printCorrectAnswer() {
        return correctAnswer;
    }

}
