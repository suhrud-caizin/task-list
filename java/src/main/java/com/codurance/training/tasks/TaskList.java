package com.codurance.training.tasks;

import com.codurance.training.tasks.command.Command;
import com.codurance.training.tasks.command.CommandParser;

import java.io.*;

public final class TaskList {

    private final Projects projects = new Projects();
    private final Writer writer;

    public TaskList(Writer writer) {
        this.writer = writer;
    }

    public void execute(String commandLine) throws Exception {

        Command command = CommandParser.parse(commandLine)
                .setProjects(projects)
                .setWriter(writer)
                .build();

        command.execute();

    }

}
