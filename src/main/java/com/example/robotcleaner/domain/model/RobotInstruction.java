package com.example.robotcleaner.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class RobotInstruction {
    private Robot robot;
    private List<Instruction> instructions;
}
