package edu.cpp.cs356.assign1.question;

import java.util.HashSet;

/**
 * This class inherits the abstract class 'Question'.
 * This class will have correct answers which may be more than one.
 *
 * @author Wai Phyo
 */
public class MultipleAnswerQuestion extends Question {
    private HashSet<String> correctAnswers;

    public MultipleAnswerQuestion(final String question, final HashSet<String> candidates, final HashSet<String> correctAnswers) {
        super(question, candidates);
        setCorrectAnswers(correctAnswers);
    }

    public HashSet<String> getCorrectAnswers() {
        return correctAnswers;
    }

    public void setCorrectAnswers(final HashSet<String> correctAnswers) {
        this.correctAnswers = checkAnswers(correctAnswers);
        if (correctAnswers.isEmpty()) {
            throw new RuntimeException("All answers are invalid. edu.cpp.cs356.assign1.question.Question must have at least one answer.");
        }
    }

    private HashSet<String> checkAnswers(HashSet<String> possibleAnswers) {
        for (String possibleAnswer : possibleAnswers) {
            if (!isValidAnswer(possibleAnswer)) {
                //log it
                possibleAnswers.remove(possibleAnswer);
            }
        }
        return possibleAnswers;
    }

    public String printCorrectAnswer() {
        return correctAnswers.toString();
    }
}
