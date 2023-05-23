package com.example.robotcleaner;

import com.example.robotcleaner.application.cli.CliRobotCleanerController;
import com.example.robotcleaner.domain.exception.InvalidInstructionException;
import com.example.robotcleaner.domain.model.Instruction;
import com.example.robotcleaner.domain.model.Orientation;
import com.example.robotcleaner.domain.model.Robot;
import com.example.robotcleaner.domain.model.RobotInstruction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class Application implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(Application.class);
        application.run(args);
    }

    @Autowired
    public CliRobotCleanerController robotCleanerController;


    @Override
    public void run(String... args) throws Exception {
        if (args.length < 1) {
            System.out.println("Argumentos incorrectos. Se requiere una cantidad par de argumentos: ancho alto x ");
            return;
        }

        int width = Integer.parseInt(args[0]);
        int height = Integer.parseInt(args[1]);

        List<RobotInstruction> robotInstructions = new ArrayList<>();
        for (int i = 2; i < args.length; i += 4) {
            try {
                int x = Integer.parseInt(args[i]);
                int y = Integer.parseInt(args[i + 1]);
                String orientation = args[i + 2];
                String instructionsString = args[i + 3];
                var robot = new Robot(x, y, Orientation.valueOf(orientation));
                List<Instruction> instructions = parseInstruccion(instructionsString);
                robotInstructions.add(new RobotInstruction(robot, instructions));
            } catch (ArrayIndexOutOfBoundsException exception) {
                System.err.println("Informacion del robot, orientación o instrucciones incompletas");
            }
        }
        robotCleanerController.deployRobots(width, height, robotInstructions);

    }

    private List<Instruction> parseInstruccion(String instructionsString) {
        List<Instruction> instructions = new ArrayList<>();

        for (int i = 0; i < instructionsString.length(); i++) {
            char instructionChar = instructionsString.charAt(i);
            switch (instructionChar) {
                case 'L' -> instructions.add(Instruction.L);
                case 'R' -> instructions.add(Instruction.R);
                case 'M' -> instructions.add(Instruction.M);
                default -> throw new InvalidInstructionException("Invalid instruccion: " + instructionChar);
            }
        }

        return instructions;
    }
}
