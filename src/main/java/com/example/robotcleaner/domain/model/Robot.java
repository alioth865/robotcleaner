package com.example.robotcleaner.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Robot {
    private int x;
    private int y;
    private Orientation orientation;

}
