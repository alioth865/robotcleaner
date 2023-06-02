package com.example.robotcleaner.application.rest.response;

import lombok.Data;

@Data
public class RobotStatusResponse {
    private final int x;
    private final int y;
    private final String orientation;
}
