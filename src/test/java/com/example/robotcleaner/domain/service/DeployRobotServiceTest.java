package com.example.robotcleaner.domain.service;

import com.example.robotcleaner.domain.exception.InvalidInstructionException;
import com.example.robotcleaner.domain.exception.InvalidPositionException;
import com.example.robotcleaner.domain.model.Orientation;
import com.example.robotcleaner.domain.model.Robot;
import com.example.robotcleaner.domain.model.RobotInstruction;
import com.example.robotcleaner.domain.model.Workspace;
import com.example.robotcleaner.domain.ports.outbound.MakeRobotInstructionPort;
import com.example.robotcleaner.domain.ports.outbound.WorkspacePersistencePort;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class DeployRobotServiceTest {


    /**
     * Method under test: {@link DeployRobotService#deployRobot(Workspace, List)}
     */
    @Test
    void shouldDoNothingWhenDoNotHaveInstructions() throws InvalidInstructionException, InvalidPositionException {
        DeployRobotService deployRobotService = new DeployRobotService(mock(MakeRobotInstructionPort.class), mock(WorkspacePersistencePort.class));
        Workspace workspace = new Workspace(1, 1);

        assertTrue(deployRobotService.deployRobot(workspace, new ArrayList<>()).isEmpty());
    }

    /**
     * Method under test: {@link DeployRobotService#deployRobot(Workspace, List)}
     */
    @Test
    void shouldMakeAnInstruction() throws InvalidInstructionException, InvalidPositionException {
        MakeRobotInstructionPort makeRobotInstructionPort = mock(MakeRobotInstructionPort.class);
        var workspacePersistencePort = mock(WorkspacePersistencePort.class);
        when(makeRobotInstructionPort.makeInstruction(Mockito.<Workspace>any(), Mockito.<RobotInstruction>any()))
                .thenReturn(new Robot(2, 3, Orientation.N));
        DeployRobotService deployRobotService = new DeployRobotService(makeRobotInstructionPort, workspacePersistencePort);
        Workspace workspace = new Workspace(1, 1);

        ArrayList<RobotInstruction> robotInstructions = new ArrayList<>();
        Robot robot = new Robot(2, 3, Orientation.N);

        robotInstructions.add(new RobotInstruction(robot, new ArrayList<>()));
        assertEquals(1, deployRobotService.deployRobot(workspace, robotInstructions).size());
        verify(makeRobotInstructionPort).makeInstruction(Mockito.<Workspace>any(), Mockito.<RobotInstruction>any());
    }

    /**
     * Method under test: {@link DeployRobotService#deployRobot(Workspace, List)}
     */
    @Test
    void shouldThrowExceptionWhenAnErrorIsOcurred() throws InvalidInstructionException, InvalidPositionException {
        MakeRobotInstructionPort makeRobotInstructionPort = mock(MakeRobotInstructionPort.class);
        var workspacePersistencePort = mock(WorkspacePersistencePort.class);
        when(makeRobotInstructionPort.makeInstruction(Mockito.<Workspace>any(), Mockito.<RobotInstruction>any()))
                .thenThrow(new InvalidInstructionException("An error occurred"));
        DeployRobotService deployRobotService = new DeployRobotService(makeRobotInstructionPort, workspacePersistencePort);
        Workspace workspace = new Workspace(1, 1);

        ArrayList<RobotInstruction> robotInstructions = new ArrayList<>();
        Robot robot = new Robot(2, 3, Orientation.N);

        robotInstructions.add(new RobotInstruction(robot, new ArrayList<>()));
        assertThrows(InvalidInstructionException.class,
                () -> deployRobotService.deployRobot(workspace, robotInstructions));
        verify(makeRobotInstructionPort).makeInstruction(Mockito.<Workspace>any(), Mockito.<RobotInstruction>any());
    }
}

