package com.example.robotcleaner.application.rest.mapper;

import com.example.robotcleaner.application.rest.request.RobotInstructionRequest;
import com.example.robotcleaner.application.rest.request.RobotLocationRequest;
import com.example.robotcleaner.application.rest.response.RobotStatusResponse;
import com.example.robotcleaner.domain.model.Instruction;
import com.example.robotcleaner.domain.model.Robot;
import com.example.robotcleaner.domain.model.RobotInstruction;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper
public interface RobotMapper {


    @Mapping(target = "robot", source = "robotRequest")
    @Mapping(target = "instructions", source = "instructionsRequest")
    RobotInstruction toRobotInstruction(RobotInstructionRequest request);

    List<Instruction> mapInstructions(List<String> instructions);

    Robot toRobot(RobotLocationRequest robotLocationRequest);


    List<RobotInstruction> toRobotInstructionList(List<RobotInstructionRequest> robotInstructionRequestList);


    List<RobotStatusResponse> toRobotStatusResponses(List<Robot> deployRobotResult);
    RobotStatusResponse toRobotStatusResponse(Robot robot);

}
