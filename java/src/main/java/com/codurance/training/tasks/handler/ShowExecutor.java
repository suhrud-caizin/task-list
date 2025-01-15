package com.codurance.training.tasks.handler;

import com.codurance.training.tasks.Projects;

import java.io.IOException;
import java.io.Writer;

public class ShowExecutor implements CommandExecutor {
    Projects projects;
    Writer writer;

    public ShowExecutor(Projects projects, Writer writer) {
        this.projects = projects;
        this.writer = writer;
    }

    @Override
    public void execute() throws IOException {
        writer.write(
                projects.format()
        );
    }
}
