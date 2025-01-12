package com.codurance.training.tasks;

import java.util.LinkedHashMap;
import java.util.Map;

public class Projects extends LinkedHashMap<String, Tasks> {
    long lastId = 0;

    void setDoneByTaskId(String idString, boolean done) throws Exception {
        int id = Integer.parseInt(idString);
        for (Map.Entry<String, Tasks> project : this.entrySet()) {
            for (Task task : project.getValue()) {
                if (task.getId() == id) {
                    task.setDone(done);
                    return;
                }
            }
        }
        throw new Exception(String.format("Could not find a task with an ID of %d.", id));
    }

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

    public long nextId() {
        return ++lastId;
    }
}
