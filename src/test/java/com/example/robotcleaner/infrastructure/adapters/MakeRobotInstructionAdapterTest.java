package com.example.robotcleaner.infrastructure.adapters;

import com.example.robotcleaner.domain.model.*;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.*;

@ContextConfiguration(classes = {MakeRobotInstructionAdapter.class})
@ExtendWith(SpringExtension.class)
class MakeRobotInstructionAdapterTest {
    @Autowired
    private MakeRobotInstructionAdapter makeRobotInstructionAdapter;

    /**
     * Method under test: {@link MakeRobotInstructionAdapter#makeInstruction(Workspace, RobotInstruction)}
     */
    @Test
    void shouldDoNotMakeNothingWhenInstructionIsEmpty() {
        Workspace workspace = new Workspace(3, 3);
        Robot robot = new Robot(2, 3, Orientation.N);
        var actualRobot = makeRobotInstructionAdapter.makeInstruction(workspace, new RobotInstruction(robot, new ArrayList<>()));
        assertEquals(robot, actualRobot);
    }



    /**
     * Method under test: {@link MakeRobotInstructionAdapter#makeInstruction(Workspace, RobotInstruction)}
     */
    @Test
    void shouldTurnLeft() {
        Workspace workspace = mock(Workspace.class);
        doNothing().when(workspace).updateGrid(Mockito.<Robot>any());

        ArrayList<Instruction> instructions = new ArrayList<>();
        instructions.add(Instruction.L);
        Robot robot = new Robot(2, 3, Orientation.N);

        Robot actualMakeInstructionResult = makeRobotInstructionAdapter.makeInstruction(workspace,
                new RobotInstruction(robot, instructions));
        assertSame(robot, actualMakeInstructionResult);
        assertEquals(Orientation.W, actualMakeInstructionResult.getOrientation());

    }

    /**
     * Method under test: {@link MakeRobotInstructionAdapter#makeInstruction(Workspace, RobotInstruction)}
     */
    @Test
    void shouldTurnRight() {
        Workspace workspace = mock(Workspace.class);
        doNothing().when(workspace).updateGrid(Mockito.<Robot>any());

        ArrayList<Instruction> instructions = new ArrayList<>();
        instructions.add(Instruction.R);
        Robot robot = new Robot(2, 3, Orientation.N);

        Robot actualMakeInstructionResult = makeRobotInstructionAdapter.makeInstruction(workspace,
                new RobotInstruction(robot, instructions));
        assertSame(robot, actualMakeInstructionResult);
        assertEquals(Orientation.E, actualMakeInstructionResult.getOrientation());
    }


    @Test
    void shouldMove() {
        Workspace workspace = mock(Workspace.class);
        doNothing().when(workspace).updateGrid(Mockito.<Robot>any(), anyInt(), anyInt());
        when(workspace.isMovementValid(anyInt(), anyInt())).thenReturn(true);
        doNothing().when(workspace).updateGrid(Mockito.<Robot>any());

        ArrayList<Instruction> instructions = new ArrayList<>();
        instructions.add(Instruction.M);
        Robot robot = new Robot(2, 3, Orientation.N);

        Robot actualMakeInstructionResult = makeRobotInstructionAdapter.makeInstruction(workspace,
                new RobotInstruction(robot, instructions));
        assertSame(robot, actualMakeInstructionResult);
        assertEquals(Orientation.N, actualMakeInstructionResult.getOrientation());
        assertEquals(4, actualMakeInstructionResult.getY());
        assertEquals(2, actualMakeInstructionResult.getX());

    }


}

