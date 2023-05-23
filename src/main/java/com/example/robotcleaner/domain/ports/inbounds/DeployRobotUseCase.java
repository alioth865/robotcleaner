package com.example.robotcleaner.domain.ports.inbounds;

import com.example.robotcleaner.domain.exception.InvalidInstructionException;
import com.example.robotcleaner.domain.exception.InvalidPositionException;
import com.example.robotcleaner.domain.model.Robot;
import com.example.robotcleaner.domain.model.RobotInstruction;
import com.example.robotcleaner.domain.model.Workspace;

import java.util.List;

public interface DeployRobotUseCase {
    List<Robot> deployRobot(Workspace workspace,
                            List<RobotInstruction> robotInstructions)
            throws InvalidInstructionException, InvalidPositionException;
}
