package com.example.subsidieradar.domain;

import java.io.Serializable;

public class ProjectMatcher implements Serializable {
    Project project;

    public ProjectMatcher(Project project) {
        this.project = project;
    }
}
