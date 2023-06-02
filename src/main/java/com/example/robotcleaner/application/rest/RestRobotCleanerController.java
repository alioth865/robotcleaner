package com.example.robotcleaner.application.rest;

import com.example.robotcleaner.application.rest.mapper.RobotMapper;
import com.example.robotcleaner.application.rest.request.DeployInfoRequest;
import com.example.robotcleaner.application.rest.response.RobotStatusResponse;
import com.example.robotcleaner.domain.ports.inbounds.CreateWorkspaceUseCase;
import com.example.robotcleaner.domain.ports.inbounds.DeployRobotUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("robotcleaner")
public class RestRobotCleanerController {

    private final CreateWorkspaceUseCase createWorkspaceUseCase;
    private final DeployRobotUseCase deployRobotUseCase;
    private final RobotMapper mapper;

    @Autowired
    public RestRobotCleanerController(CreateWorkspaceUseCase createWorkspaceUseCase,
                                      DeployRobotUseCase deployRobotUseCase,
                                      RobotMapper mapper) {
        this.createWorkspaceUseCase = createWorkspaceUseCase;
        this.deployRobotUseCase = deployRobotUseCase;
        this.mapper = mapper;
    }

    @PostMapping("/deployrobot")
    public ResponseEntity<List<RobotStatusResponse>> deployRobots(@RequestBody DeployInfoRequest deployInfo) {
        var workspace = createWorkspaceUseCase.createWorkspace(deployInfo.getWorkspaceWidth(),
                deployInfo.getWorkspaceHeight());

        var deployRobotResult = deployRobotUseCase.deployRobot(workspace,
                mapper.toRobotInstructionList(deployInfo.getRobotInstructionsRequest()));


        return ResponseEntity.ok().body(mapper.toRobotStatusResponses(deployRobotResult));
    }
}
