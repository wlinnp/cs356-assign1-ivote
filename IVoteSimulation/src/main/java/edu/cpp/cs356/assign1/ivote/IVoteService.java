package edu.cpp.cs356.assign1.ivote;

import edu.cpp.cs356.assign1.answers.Answer;
import edu.cpp.cs356.assign1.student.Student;
import org.apache.commons.lang3.tuple.Pair;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;


/**
 * Accept single or multiple submissions.
 * Delegate statistics calculation to Answer class.
 * Display statistics.
 *
 * @author Wai Phyo
 */
public class IVoteService implements IVote {
    private HashMap<Student, Answer> answerDb = new HashMap<Student, Answer>();
    private Answer calculateAnswer;

    public IVoteService(final List<Pair<Student, Answer>> studentAnswerPairList, final Answer calculateAnswer) {
        submitAllAnswers(studentAnswerPairList);
        this.calculateAnswer = calculateAnswer;
    }

    public void submitAnswer(final Pair<Student, Answer> studentAnswerPair) {
        if (studentAnswerPair.getRight().isValidAnswer()) {
            answerDb.put(studentAnswerPair.getLeft(), studentAnswerPair.getRight());
        }
    }

    public void submitAllAnswers(final List<Pair<Student, Answer>> studentAnswerPairList) {
        for (Pair<Student, Answer> each : studentAnswerPairList) {
            submitAnswer(each);
        }
    }

    private String printMap() {
        StringBuilder result = new StringBuilder(LINE_SEPARATOR);
        result.append("Answers Database");
        result.append(IVote.LINE_SEPARATOR);
        for (Map.Entry<Student, Answer> each : answerDb.entrySet()) {
            result.append(each.getKey().getId()).append(TAB_SEPARATOR).append(each.getValue().toString()).append(NEXT_LINE);
        }
        result.append(LINE_SEPARATOR);
        return result.toString();
    }

    public String displayStatistics() {
        calculateAnswer.setStatistics(new HashSet<Answer>(answerDb.values()));
        return printMap() + calculateAnswer.printStatistics();

    }
}
