package com.codurance.training.tasks.handler;

import com.codurance.training.tasks.Project;
import com.codurance.training.tasks.Projects;
import com.codurance.training.tasks.Task;
import java.io.Writer;
import java.util.List;

public class AddHandler implements Handler {
    Projects projects;
    Writer writer;
    List<String> args;

    public AddHandler(Projects projects, Writer writer, List<String> args) {
        this.projects = projects;
        this.writer = writer;
        this.args = args;
    }

    @Override
    public void handle() throws Exception {
        String subcommand = args.get(0);
        String projectName = args.get(1);
        if (subcommand.equals("project")) {
            addProject(projectName);
        } else if (subcommand.equals("task")) {
            String taskName = args.get(2);
            addTask(projectName, taskName);
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
        project.add(new Task(projects.nextId(), description, false));
    }

}
