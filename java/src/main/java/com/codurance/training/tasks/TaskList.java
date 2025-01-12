package com.codurance.training.tasks;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public final class TaskList {

    private final Map<String, List<Task>> tasks = new LinkedHashMap<>();


    private long lastId = 0;
    private final Writer writer;

    public TaskList(Writer writer) {
        this.writer = writer;
    }

    public void execute(String commandLine) throws IOException {
        String[] commandRest = commandLine.split(" ", 2);
        String command = commandRest[0];
        switch (command) {
            case "show":
                show();
                break;
            case "add":
                add(commandRest[1]);
                break;
            case "check":
                check(commandRest[1]);
                break;
            case "uncheck":
                uncheck(commandRest[1]);
                break;
        }
    }

    private void show() throws IOException {
        for (Map.Entry<String, List<Task>> project : tasks.entrySet()) {
            writer.write(project.getKey());
            writer.write("\n");
            for (Task task : project.getValue()) {
                writer.write(
                        getFormat(task)
                );
            }
        }
    }

    // TODO move to Task class
    private static String getFormat(Task task) {
        return String.format("[%c] %d: %s%n", (task.isDone() ? 'x' : ' '), task.getId(), task.getDescription());
    }

    private void add(String commandLine) throws IOException {
        String[] subcommandRest = commandLine.split(" ", 2);
        String subcommand = subcommandRest[0];
        if (subcommand.equals("project")) {
            addProject(subcommandRest[1]);
        } else if (subcommand.equals("task")) {
            String[] projectTask = subcommandRest[1].split(" ", 2);
            addTask(projectTask[0], projectTask[1]);
        }
    }

    private void addProject(String name) {
        tasks.put(name, new ArrayList<Task>());
    }

    private void addTask(String project, String description) throws IOException {
        List<Task> projectTasks = tasks.get(project);
        if (projectTasks == null) {
            writer.write(String.format("Could not find a project with the name \"%s\".", project));
            return;
        }
        projectTasks.add(new Task(nextId(), description, false));
    }

    private void check(String idString) throws IOException {
        setDone(idString, true);
    }

    private void uncheck(String idString) throws IOException {
        setDone(idString, false);
    }

    private void setDone(String idString, boolean done) throws IOException {
        int id = Integer.parseInt(idString);
        for (Map.Entry<String, List<Task>> project : tasks.entrySet()) {
            for (Task task : project.getValue()) {
                if (task.getId() == id) {
                    task.setDone(done);
                    return;
                }
            }
        }
        writer.write(String.format("Could not find a task with an ID of %d.", id));
    }

    private long nextId() {
        return ++lastId;
    }
}
