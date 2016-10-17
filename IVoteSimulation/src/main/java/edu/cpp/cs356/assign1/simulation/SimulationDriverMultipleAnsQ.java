package edu.cpp.cs356.assign1.simulation;

import edu.cpp.cs356.assign1.answers.Answer;
import edu.cpp.cs356.assign1.answers.MultipleAnswer;
import edu.cpp.cs356.assign1.ivote.IVoteService;
import edu.cpp.cs356.assign1.question.MultipleAnswerQuestion;

import java.util.HashSet;

/**
 * Simulation Driver for Multiple Answer Questions
 *
 * @author Wai Phyo
 */
public class SimulationDriverMultipleAnsQ extends SimulationDriver {
    protected void createQuestion() {
        HashSet<String> sampleAnswers = new HashSet<String>();
        for (String each : listSampleCandidates) {
            if (chanceOfAnswer(chanceOfCorrectAnswer)) {
                sampleAnswers.add(each);
            }
        }
        question = new MultipleAnswerQuestion(sampleQuestion, sampleCandidates, sampleAnswers);

    }

    /**
     * simulating a student randomly choosing an answer.
     *
     * @return MultipleAnswer Object
     */
    protected Answer randomAnswer() {
        HashSet<String> tempAnswer = new HashSet<String>();
        for (String each : question.getCandidates()) {
            if (chanceOfAnswer(chanceOfAnswer)) {
                tempAnswer.add(each);
            }
        }
        return new MultipleAnswer(tempAnswer);
    }

    public void submitInputs() {
        iVote = new IVoteService(allAnswers, new MultipleAnswer());
    }
}
