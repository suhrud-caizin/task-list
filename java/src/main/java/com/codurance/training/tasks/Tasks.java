package com.codurance.training.tasks;


import java.util.ArrayList;

public class Tasks extends ArrayList<Task> {

    String getFormatted(){
        StringBuilder formatted = new StringBuilder();

        for (Task task : this) {
            formatted.append(task.getFormatted());
        }

        return formatted.toString();
    }
}
