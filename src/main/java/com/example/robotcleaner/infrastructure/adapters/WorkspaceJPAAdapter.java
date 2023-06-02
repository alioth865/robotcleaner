package com.example.robotcleaner.infrastructure.adapters;

import com.example.robotcleaner.domain.model.Workspace;
import com.example.robotcleaner.domain.ports.outbound.WorkspacePersistencePort;
import com.example.robotcleaner.infrastructure.mapper.EntityMapper;
import com.example.robotcleaner.infrastructure.repository.WorkspaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WorkspaceJPAAdapter implements WorkspacePersistencePort {

    private final WorkspaceRepository workspaceRepository;

    private final EntityMapper entityMapper;

    @Autowired
    public WorkspaceJPAAdapter(WorkspaceRepository workspaceRepository, EntityMapper entityMapper) {
        this.workspaceRepository = workspaceRepository;
        this.entityMapper = entityMapper;
    }

    @Override
    public Workspace save(Workspace workspace) {
        return entityMapper.toWorkspace(workspaceRepository.save(entityMapper.toWorkspaceEntity(workspace)));
    }
}
