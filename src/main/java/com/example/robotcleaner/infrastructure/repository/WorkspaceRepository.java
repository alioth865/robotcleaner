package com.example.robotcleaner.infrastructure.repository;

import com.example.robotcleaner.infrastructure.entity.WorkspaceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkspaceRepository extends JpaRepository<WorkspaceEntity, Integer> {
}
