package com.example.robotcleaner.infrastructure.mapper;

import com.example.robotcleaner.domain.model.Robot;
import com.example.robotcleaner.domain.model.Workspace;
import com.example.robotcleaner.infrastructure.entity.WorkspaceEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

@Mapper
public interface EntityMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(source = "grid", target = "grid", qualifiedByName = "toGridString")
    WorkspaceEntity toWorkspaceEntity(Workspace workspace);

    @Mapping(target = "width", ignore = true)
    @Mapping(source = "grid", target = "grid", qualifiedByName = "toGridArray")
    Workspace toWorkspace(WorkspaceEntity entity);

    @Named("toGridArray")
    default Robot[][] toGridArray(String grid){
        return null;
    }

    @Named("toGridString")
    default String toGridString(Robot[][] robots){
        return "pinturillo";
    }


}
