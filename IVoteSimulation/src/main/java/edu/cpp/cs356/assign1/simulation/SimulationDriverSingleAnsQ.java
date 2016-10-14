package edu.cpp.cs356.assign1.simulation;

import edu.cpp.cs356.assign1.answers.Answer;
import edu.cpp.cs356.assign1.answers.SingleAnswer;
import edu.cpp.cs356.assign1.ivote.IVoteService;
import edu.cpp.cs356.assign1.question.SingleAnswerQuestion;

/**
 * Simulation Driver for Single Answer Question.
 *
 * @author Wai Phyo
 */
public class SimulationDriverSingleAnsQ extends SimulationDriver {
    protected void createQuestion() {
        question = new SingleAnswerQuestion(sampleQuestion, sampleCandidates, listSampleCandidates.get(Math.abs((random.nextInt() % listSampleCandidates.size()))));
    }

    private String getRandomSingleAnswer() {
        return listSampleCandidates.get(Math.abs((random.nextInt() % listSampleCandidates.size())));
    }

    /**
     * simulating a student randomly choosing an answer.
     *
     * @return Single Answer object
     */
    protected Answer randomAnswer() {
        return new SingleAnswer(getRandomSingleAnswer());
    }

    public void submitInputs() {
        myService = new IVoteService(allAnswers, new SingleAnswer());
    }
}
