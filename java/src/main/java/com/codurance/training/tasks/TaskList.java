package com.codurance.training.tasks;

import java.io.*;

public final class TaskList {

    private final Projects projects = new Projects();
    private final Writer writer;

    public TaskList(Writer writer) {
        this.writer = writer;
    }

    public void execute(String commandLine) throws Exception {
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
         writer.write(
                 projects.getProjectsFormatted()
         );
    }

    private void add(String commandLine) throws Exception {
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
        projects.put(name, new Project(name));
    }

    private void addTask(String projectName, String description) throws Exception {
        Project project = projects.get(projectName);
        if (project == null) {
            throw new Exception(String.format("Could not find a project with the name \"%s\".", projectName));
        }
        project.add(new Task( projects.nextId(), description, false));
    }

    private void check(String idString) throws Exception {
        projects.setDoneByTaskId(idString, true);
    }

    private void uncheck(String idString) throws Exception {
        projects.setDoneByTaskId(idString, false);
    }
}
