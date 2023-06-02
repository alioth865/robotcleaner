package com.example.robotcleaner.application.cli;

import com.example.robotcleaner.application.rest.mapper.RobotMapper;
import com.example.robotcleaner.domain.model.Robot;
import com.example.robotcleaner.domain.model.RobotInstruction;
import com.example.robotcleaner.domain.ports.inbounds.CreateWorkspaceUseCase;
import com.example.robotcleaner.domain.ports.inbounds.DeployRobotUseCase;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;


@Slf4j
@AllArgsConstructor
@Component
public class CliRobotCleanerController {

    private final CreateWorkspaceUseCase createWorkspaceUseCase;
    private final DeployRobotUseCase deployRobotUseCase;

    public void deployRobots(int width, int height, List<RobotInstruction> robotInstructions) {
        var workspace = createWorkspaceUseCase.createWorkspace(width, height);
        var robots = deployRobotUseCase.deployRobot(workspace, robotInstructions);
        for (Robot robot : robots) {
            log.info("X: {} Y: {} Orientattion: {}", robot.getX(), robot.getY(), robot.getOrientation());
        }
    }


}


