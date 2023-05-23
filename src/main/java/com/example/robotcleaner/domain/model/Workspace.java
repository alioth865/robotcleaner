package com.example.robotcleaner.domain.model;

import com.example.robotcleaner.domain.exception.InvalidPositionException;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Data
@Slf4j
public class Workspace {
    private int width;
    private int height;
    private Robot[][] grid;

    public Workspace(int width, int height) {
        this.width = width + 1;
        this.height = height + 1;
        this.grid = new Robot[width + 1][height + 1];
    }

    public void updateGrid(Robot robot, int previousPositionX, int previousPositionY) {
        grid[robot.getX()][robot.getY()] = robot;
        grid[previousPositionX][previousPositionY] = null;
        printGrid();
    }

    public void updateGrid(Robot robot) {
        grid[robot.getX()][robot.getY()] = robot;
        printGrid();
    }


    private void printGrid() {
        StringBuilder gridBuilder = new StringBuilder();

        for (int y = height - 1; y >= 0; y--) {
            for (int x = 0; x < width; x++) {
                if (grid[x][y] != null) {
                    switch (grid[x][y].getOrientation()) {
                        case S -> gridBuilder.append("[↧] ");
                        case N -> gridBuilder.append("[↥] ");
                        case W -> gridBuilder.append("[↤] ");
                        case E -> gridBuilder.append("[↦] ");
                    }

                } else {
                    gridBuilder.append("[ ] ");
                }
            }
            gridBuilder.append("\n");
        }
        log.info("Grid:\n{}", gridBuilder.toString());
    }

    public boolean isMovementValid(int newPositionX, int newPositionY) {
        if (newPositionX < 0 ||
                newPositionY < 0 ||
                newPositionY > this.height ||
                newPositionX > this.width) {
            throw new InvalidPositionException(newPositionX, newPositionY, "Out of bounds");
        }
        if (this.grid[newPositionX][newPositionY] != null) {
            throw new InvalidPositionException(newPositionX, newPositionY, "The current position is occupied by another robot");
        }
        return true;
    }
}
