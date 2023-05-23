package com.example.robotcleaner.infrastructure.config;

import com.example.robotcleaner.domain.ports.inbounds.CreateWorkspaceUseCase;
import com.example.robotcleaner.domain.ports.inbounds.DeployRobotUseCase;
import com.example.robotcleaner.domain.ports.outbound.MakeRobotInstructionPort;
import com.example.robotcleaner.domain.service.CreateWorkspaceService;
import com.example.robotcleaner.domain.service.DeployRobotService;
import com.example.robotcleaner.Application;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackageClasses = Application.class)
public class BeanConfiguration {

    @Bean
    DeployRobotUseCase deployRobotService(final MakeRobotInstructionPort makeRobotInstructionPort) {
        return new DeployRobotService(makeRobotInstructionPort);
    }

    @Bean
    CreateWorkspaceUseCase createWorkspaceUseCase(){
        return new CreateWorkspaceService();
    }
}
