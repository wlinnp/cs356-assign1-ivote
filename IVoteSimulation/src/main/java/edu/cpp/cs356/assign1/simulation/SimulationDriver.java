package edu.cpp.cs356.assign1.simulation;

import edu.cpp.cs356.assign1.answers.Answer;
import edu.cpp.cs356.assign1.ivote.IVote;
import edu.cpp.cs356.assign1.question.Question;
import edu.cpp.cs356.assign1.student.Student;
import org.apache.commons.lang3.tuple.Pair;

import java.util.*;

/**
 * Abstract Simulation Driver class.
 * Have common methods utilized by both simlations.
 *
 * Simulation Steps
 *
 * 1. Create a question and some candidates. It already has which answer is correct.
 * 2. Create a class of students. Example 10 students.
 * 3. Let them answer the questions repeatedly. There are 30 answers by random students choosing random answers.
 * 4. Submit all Answers to IVote.
 * 5. View the results.
 *
 * @author Wai Phyo
 */
public abstract class SimulationDriver {
    protected final int chanceOfAnswer = 4; // 25% chance of being each answer.
    protected final int chanceOfCorrectAnswer = 2; // 50% chance of being a correct answer.
    protected final List<String> listSampleCandidates = new ArrayList<String>(Arrays.asList("A", "B", "C", "D", "E", "F", "G"));
    protected final String sampleQuestion = "What do you think my answer is?";
    protected final HashSet<String> sampleCandidates = new HashSet<String>(listSampleCandidates);
    private final int totalStudents = 10;
    private final int totalAnswers = 30;
    protected Question question;
    protected List<Pair<Student, Answer>> allAnswers = new ArrayList<Pair<Student, Answer>>();
    protected Random random = new Random();
    protected IVote iVote;
    private Student[] studentGroup = new Student[totalStudents];

    protected abstract void createQuestion();

    /**
     * Create all students who will answer the question.
     */
    private void createStudentGroup() {
        for (int a = 0; a < studentGroup.length; a++) {
            studentGroup[a] = new Student("cpp-cs356-" + String.format("%03d", (a + 1)));
        }
    }

    /**
     * Creating all answers.
     * There are 10 student in the group.
     * There are 30 possible answers. There will be students answering twice.
     */
    private void createAllAnswers() {
        for (int a = 0; a < totalAnswers; a++) {
            allAnswers.add(Pair.of(randomStudent(), randomAnswer()));
        }
    }

    /**
     * each candidate has some chance chance to become an answer.
     * example. 50% = 2, 25% = 5, 33% = 3 ...
     * if the random int is even, it is the answer.
     */
    protected boolean chanceOfAnswer(final int chance) {
        return random.nextInt() % chance == 0;
    }

    /**
     * Choose random edu.cpp.cs356.assign1.Student from the group
     *
     * @return randomStudent
     */
    private Student randomStudent() {
        return studentGroup[Math.abs((random.nextInt() % studentGroup.length))];
    }

    protected abstract Answer randomAnswer();

    /**
     * @return String: Students' submission history
     */
    private String printAllInputs() {
        StringBuilder result = new StringBuilder(IVote.LINE_SEPARATOR);
        result.append("Students' submission history");
        result.append(IVote.LINE_SEPARATOR);
        for (Pair<Student, Answer> each : allAnswers) {
            result.append(each.getKey().getId() + IVote.TAB_SEPARATOR + each.getValue().toString() + IVote.NEXT_LINE);
        }
        result.append(IVote.LINE_SEPARATOR);
        return result.toString();
    }

    public void createInputs() {
        createQuestion();
        createStudentGroup();
        createAllAnswers();
    }

    public abstract void submitInputs();

    public void viewResults() {
        System.out.println("Question: "
                + question.getQuestion()
                + IVote.NEXT_LINE
                + "Candidates: "
                + question.getCandidates().toString()
                + IVote.LINE_SEPARATOR
                + printAllInputs()
                + iVote.displayStatistics()
                + "Correct Answer(s): "
                + question.printCorrectAnswer()
                + IVote.LINE_SEPARATOR);
    }
}
