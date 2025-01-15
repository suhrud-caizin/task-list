package com.codurance.training.tasks.handler;

import com.codurance.training.tasks.Projects;

import java.util.List;

public class CheckExecutor implements CommandExecutor {

    Projects projects;
    List<String> args;
    boolean isDone;

    public CheckExecutor(Projects projects, List<String> args, boolean isDone) {
        this.projects = projects;
        this.args = args;
        this.isDone = isDone;
    }

    @Override
    public void execute() throws Exception {
        String id = args.get(0);
        projects.setDoneByTaskId(id, isDone);
    }
}
