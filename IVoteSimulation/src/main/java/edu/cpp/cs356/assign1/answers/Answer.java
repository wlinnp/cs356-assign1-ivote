package edu.cpp.cs356.assign1.answers;

import edu.cpp.cs356.assign1.ivote.IVote;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * This is an abstract Answer class which contains the logic to calculate the statistics of submitted answers.
 * The detail implementation of logic will be different
 * depends on single or multiple answer.
 *
 * @author Wai Phyo
 */
public abstract class Answer {
    /**
     * This map contains "Answer" and "number of times chosen".
     */
    protected HashMap<String, Integer> answerStatistics = new HashMap<String, Integer>();

    /**
     * @return String: containing each answer candidate and how many students chose them.
     */
    public String printStatistics() {
        StringBuilder result = new StringBuilder(IVote.LINE_SEPARATOR);
        result.append("Answers by statistics");
        result.append(IVote.LINE_SEPARATOR);
        for (Map.Entry<String, Integer> each : answerStatistics.entrySet()) {
            result.append(each.getKey()).append(IVote.TAB_SEPARATOR).append(each.getValue() == null ? "0" : each.getValue()).append(IVote.NEXT_LINE);
        }
        result.append(IVote.LINE_SEPARATOR);
        return result.toString();
    }

    public abstract boolean isValidAnswer();

    public abstract String toString();

    public abstract void setStatistics(final HashSet<Answer> answerSet);
}
