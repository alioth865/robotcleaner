package com.example.robotcleaner.infrastructure.adapters;

import com.example.robotcleaner.domain.model.*;
import com.example.robotcleaner.domain.ports.outbound.MakeRobotInstructionPort;
import org.springframework.stereotype.Component;

@Component
public class MakeRobotInstructionAdapter implements MakeRobotInstructionPort {
    // TODO: 1/6/23 Igual lo correcto de esto sería moverlo a la {@link DeployRobotService}
    @Override
    public Robot makeInstruction(Workspace workspace, RobotInstruction robotInstruction) {
        var robot = robotInstruction.getRobot();

        if (robotInstruction.getInstructions() != null) {
            for (Instruction instruction : robotInstruction.getInstructions()) {

                switch (instruction) {
                    case L -> {
                        var orientation = turnLeft(robot.getOrientation());
                        robot.setOrientation(orientation);
                        workspace.updateGrid(robot);
                    }
                    case R -> {
                        var orientation = turnRight(robot.getOrientation());
                        robot.setOrientation(orientation);
                        workspace.updateGrid(robot);
                    }
                    case M -> robot = moveForward(workspace, robot);
                }

            }
        }

        return robot;
    }

    public Orientation turnRight(Orientation orientation) {
        return switch (orientation) {
            case N -> Orientation.E;
            case E -> Orientation.S;
            case S -> Orientation.W;
            case W -> Orientation.N;
        };
    }

    public Orientation turnLeft(Orientation orientation) {
        return switch (orientation) {
            case N -> Orientation.W;
            case W -> Orientation.S;
            case S -> Orientation.E;
            case E -> Orientation.N;
        };
    }

    public Robot moveForward(Workspace workspace, Robot robot) {
        int newPositionX = robot.getX();
        int newPositionY = robot.getY();
        switch (robot.getOrientation()) {
            case N -> newPositionY = robot.getY() + 1;
            case S -> newPositionY = robot.getY() - 1;
            case E -> newPositionX = robot.getX() + 1;
            case W -> newPositionX = robot.getX() - 1;
        }
        if (workspace.isMovementValid(newPositionX, newPositionY)) {
            int previousPositionX = robot.getX();
            robot.setX(newPositionX);
            int previousPositionY = robot.getY();
            robot.setY(newPositionY);
            workspace.updateGrid(robot, previousPositionX, previousPositionY);
        }
        return robot;
    }
}
