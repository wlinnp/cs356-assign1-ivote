package edu.cpp.cs356.assign1.ivote;

import edu.cpp.cs356.assign1.answers.Answer;
import edu.cpp.cs356.assign1.student.Student;
import org.apache.commons.lang3.tuple.Pair;

import java.util.List;

/**
 * Constants and general methods required by IVote Systems
 *
 * @author Wai Phyo
 */
public interface IVote {
    public static final String LINE_SEPARATOR = "\n=================================\n";
    public static final String TAB_SEPARATOR = " ==>\t";
    public static final String NEXT_LINE = "\n";
    public static final String SIMPLE_TAB = "\t";

    public void submitAnswer(Pair<Student, Answer> studentAnswerPair);

    public void submitAllAnswers(List<Pair<Student, Answer>> studentAnswerPairList);

    public String displayStatistics();

}
