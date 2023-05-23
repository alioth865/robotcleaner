package com.example.robotcleaner.domain.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import com.example.robotcleaner.domain.model.Workspace;
import org.junit.jupiter.api.Test;

class CreateWorkspaceServiceTest {
    /**
     * Method under test: {@link CreateWorkspaceService#createWorkspace(int, int)}
     */
    @Test
    void shouldCreateWorkspace() throws IllegalArgumentException {
        Workspace actualCreateWorkspaceResult = (new CreateWorkspaceService()).createWorkspace(1, 1);
        assertEquals(2, actualCreateWorkspaceResult.getGrid().length);
        assertEquals(2, actualCreateWorkspaceResult.getWidth());
        assertEquals(2, actualCreateWorkspaceResult.getHeight());
    }

    /**
     * Method under test: {@link CreateWorkspaceService#createWorkspace(int, int)}
     */
    @Test
    void shouldTrowExceptionWhenWidthIsNegative() throws IllegalArgumentException {
        assertThrows(IllegalArgumentException.class, () -> (new CreateWorkspaceService()).createWorkspace(-1, 1));
    }

    /**
     * Method under test: {@link CreateWorkspaceService#createWorkspace(int, int)}
     */
    @Test
    void shouldTrowExceptionWhenHeightIsNegative() throws IllegalArgumentException {
        assertThrows(IllegalArgumentException.class, () -> (new CreateWorkspaceService()).createWorkspace(1, -1));
    }
}

