package com.example.robotcleaner.domain.ports.outbound;

import com.example.robotcleaner.domain.model.Robot;
import com.example.robotcleaner.domain.model.RobotInstruction;
import com.example.robotcleaner.domain.model.Workspace;

public interface MakeRobotInstructionPort {

    /**
     * Executes an instruction for a robot in the given workspace.
     *
     * @param workspace        the workspace where the robot operates
     * @param robotInstruction the robot with the instruction will be executed
     * @return the new state of the robot after executing the instruction
     */
    Robot makeInstruction(Workspace workspace, RobotInstruction robotInstruction);


}
