package com.example.robotcleaner.domain.ports.outbound;

import com.example.robotcleaner.domain.model.Workspace;

public interface WorkspacePersistencePort {
    Workspace save(Workspace workspace);
}
