package com.example.robotcleaner.application.rest.request;

import lombok.Data;

@Data
public class RobotLocationRequest {
    private int x;
    private int y;
    private String orientation;

}
