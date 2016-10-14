package edu.cpp.cs356.assign1.answers;

import edu.cpp.cs356.assign1.ivote.IVote;

import java.util.HashSet;

/**
 * Calculation statistics for multiple answer question.
 *
 * @author Wai Phyo
 */
public class MultipleAnswer extends Answer {
    private HashSet<String> answers;

    public MultipleAnswer() {

    }

    public MultipleAnswer(final HashSet<String> answers) {
        this.answers = answers;
    }

    public HashSet<String> getAnswers() {
        return answers;
    }

    public void setAnswers(final HashSet<String> answers) {
        this.answers = answers;
    }

    public boolean isValidAnswer() {
        return !(answers.isEmpty());
    }

    /**
     * @return String: return chosen answers in a tab separated format.
     */
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (String each : answers) {
            result.append(each).append(IVote.SIMPLE_TAB);
        }
        return result.toString();
    }

    /**
     * Count number of times each candidate is chosen as an answer.
     * Result is a hash map with (candidate answers, and number of times chosen).
     *
     * @param answerSet: a set with all submitted answers.
     */
    public void setStatistics(final HashSet<Answer> answerSet) {
        answerStatistics.clear();
        for (Answer each : answerSet) {
            for (String eachString : ((MultipleAnswer) each).getAnswers()) {
                answerStatistics.put(eachString, answerStatistics.containsKey(eachString) ? (answerStatistics.get(eachString) + 1) : 1);
            }
        }
    }


}
