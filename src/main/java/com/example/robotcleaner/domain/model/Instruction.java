package com.example.robotcleaner.domain.model;

import lombok.Getter;

@Getter
public enum Instruction {
    L("Spin 90 degrees left"),
    R("Spin 90 degrees right"),
    M("Move forward one grid");

    private String order;

    private Instruction(String order) {
        this.order = order;
    }
}
