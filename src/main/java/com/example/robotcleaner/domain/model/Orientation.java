package com.example.robotcleaner.domain.model;

public enum Orientation {
    N("North"),
    S("South"),
    W("West"),
    E("East");

    private String name;

    private Orientation(String name) {
        this.name = name;
    }


}
