package com.codurance.training.tasks.handler;

import com.codurance.training.tasks.Projects;
import com.codurance.training.tasks.command.Arguments;

public class CheckExecutor implements CommandExecutor {

    Projects projects;
    Arguments args;
    boolean isDone;

    public CheckExecutor(Projects projects,Arguments args, boolean isDone) {
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
