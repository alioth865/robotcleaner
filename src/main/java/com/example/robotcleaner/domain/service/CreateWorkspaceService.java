package com.example.robotcleaner.domain.service;


import com.example.robotcleaner.domain.model.Workspace;
import com.example.robotcleaner.domain.ports.inbounds.CreateWorkspaceUseCase;

public class CreateWorkspaceService implements CreateWorkspaceUseCase {

    @Override
    public Workspace createWorkspace(int width, int height) throws IllegalArgumentException {
        if (width < 0 || height < 0) {
            throw new IllegalArgumentException("Width and Height should be greater than 0");
        }
        return new Workspace(width, height);
    }
}
