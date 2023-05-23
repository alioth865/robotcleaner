package com.example.robotcleaner.domain.service;


import com.example.robotcleaner.domain.exception.InvalidInstructionException;
import com.example.robotcleaner.domain.exception.InvalidPositionException;
import com.example.robotcleaner.domain.model.Robot;
import com.example.robotcleaner.domain.model.RobotInstruction;
import com.example.robotcleaner.domain.model.Workspace;
import com.example.robotcleaner.domain.ports.inbounds.DeployRobotUseCase;
import com.example.robotcleaner.domain.ports.outbound.MakeRobotInstructionPort;

import java.util.ArrayList;
import java.util.List;

public class DeployRobotService implements DeployRobotUseCase {

    private final MakeRobotInstructionPort makeRobotInstructionPort;

    public DeployRobotService(MakeRobotInstructionPort makeRobotInstructionPort) {
        this.makeRobotInstructionPort = makeRobotInstructionPort;
    }

    @Override
    public List<Robot> deployRobot(Workspace workspace,
                                   List<RobotInstruction> robotInstructions) throws InvalidInstructionException, InvalidPositionException {
        List<Robot> statusRobot = new ArrayList<>();
        for (var robotInstruction : robotInstructions) {
            statusRobot.add(makeRobotInstructionPort.makeInstruction(workspace, robotInstruction));
        }
        return statusRobot;
    }
}
