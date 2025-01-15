package com.codurance.training.tasks.handler;

import com.codurance.training.tasks.Project;
import com.codurance.training.tasks.Projects;
import com.codurance.training.tasks.Task;
import com.codurance.training.tasks.command.Arguments;
import java.io.Writer;

public class AddExecutor implements CommandExecutor {
    Projects projects;
    Writer writer;
    Arguments args;

    public AddExecutor(Projects projects, Writer writer, Arguments args) {
        this.projects = projects;
        this.writer = writer;
        this.args = args;
    }

    @Override
    public void execute() throws Exception {
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
