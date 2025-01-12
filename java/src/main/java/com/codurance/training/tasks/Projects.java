package com.codurance.training.tasks;

import java.util.LinkedHashMap;
import java.util.Map;

public class Projects extends LinkedHashMap<String, Tasks> {

     public String getProjectsFormatted() {
         StringBuilder formatted = new StringBuilder();

        for (Map.Entry<String, Tasks> project : entrySet()) {
            formatted.append(project.getKey());
            formatted.append("\n");
            formatted.append(
                project.getValue().getFormatted()
            );
        }

        return formatted.toString();
    }
}
