package com.example.robotcleaner.infrastructure.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class WorkspaceEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;

    private int width;
    private int height;
    private String grid;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


}
