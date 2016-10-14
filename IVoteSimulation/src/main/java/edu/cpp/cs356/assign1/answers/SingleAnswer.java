package edu.cpp.cs356.assign1.answers;

import org.apache.commons.lang3.StringUtils;

import java.util.HashSet;

/**
 * Calculation Statistics for Single Answer question.
 *
 * @author Wai Phyo
 */
public class SingleAnswer extends Answer {
    private String answer;

    public SingleAnswer() {

    }

    public SingleAnswer(final String answer) {
        this.answer = answer;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(final String answer) {
        this.answer = answer;
    }

    public String toString() {
        return answer;
    }

    public boolean isValidAnswer() {
        return !(StringUtils.isBlank(this.answer));
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
            String tempAnswer = ((SingleAnswer) each).getAnswer();
            answerStatistics.put(tempAnswer, answerStatistics.containsKey(tempAnswer) ? (answerStatistics.get(tempAnswer) + 1) : 1);
        }
    }
}
