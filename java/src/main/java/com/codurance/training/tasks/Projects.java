package com.codurance.training.tasks;

import java.util.LinkedHashMap;

public class Projects extends LinkedHashMap<String, Project> {
    long lastId = 0;

    public void setDoneByTaskId(String idString, boolean done) throws Exception {
        int id = Integer.parseInt(idString);

        for (Project project : values()) {
            if (project.setDone(id,done)) return;
        }
        throw new Exception(String.format("Could not find a task with an ID of %d.", id));
    }

    public String getProjectsFormatted() {
         StringBuilder formatted = new StringBuilder();

        for (Project project : values()) {
            formatted.append(
                project.getTasksForProjectFormatted()
            );
        }

        return formatted.toString();
    }

    public long nextId() {
        return ++lastId;
    }
}
