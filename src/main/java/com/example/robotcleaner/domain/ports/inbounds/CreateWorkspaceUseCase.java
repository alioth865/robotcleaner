package com.example.robotcleaner.domain.ports.inbounds;

import com.example.robotcleaner.domain.model.Workspace;

public interface CreateWorkspaceUseCase {
    Workspace createWorkspace(int width, int height) throws IllegalArgumentException;
}
