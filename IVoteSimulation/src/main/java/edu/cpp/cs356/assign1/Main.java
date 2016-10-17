package edu.cpp.cs356.assign1;

import edu.cpp.cs356.assign1.ivote.IVote;
import edu.cpp.cs356.assign1.simulation.SimulationDriver;
import edu.cpp.cs356.assign1.simulation.SimulationDriverMultipleAnsQ;
import edu.cpp.cs356.assign1.simulation.SimulationDriverSingleAnsQ;

/**
 * This main class will ideally hold a menu to manage IVote Systems.
 * In this scenario, Simulation Driver is pseudo managing the system.
 * So This main class will call simulation drivers.
 *
 * @author Wai Phyo
 */
public class Main {
    public static void main(String[] args) {
        SimulationDriver singleQuestionTest = new SimulationDriverSingleAnsQ();
        System.out.println("Single Answer Question Test" + IVote.LINE_SEPARATOR);
        singleQuestionTest.createInputs();
        singleQuestionTest.submitInputs();
        singleQuestionTest.viewResults();

        SimulationDriver multipleQuestionTest = new SimulationDriverMultipleAnsQ();
        System.out.println("Multiple Answer Question Test" + IVote.LINE_SEPARATOR);
        multipleQuestionTest.createInputs();
        multipleQuestionTest.submitInputs();
        multipleQuestionTest.viewResults();
    }
}
