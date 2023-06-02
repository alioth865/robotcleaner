package com.example.robotcleaner.application.rest.request;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class RobotInstructionRequest {
    private RobotLocationRequest robotRequest;
    private List<String> instructionsRequest;
}
