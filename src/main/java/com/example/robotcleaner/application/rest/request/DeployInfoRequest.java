package com.example.robotcleaner.application.rest.request;

import lombok.Data;

import java.util.List;

@Data
public class DeployInfoRequest {

    private int workspaceWidth;
    private int workspaceHeight;
    private List<RobotInstructionRequest> robotInstructionsRequest;

}
