package com.codurance.training.tasks.handler;

import com.codurance.training.tasks.Projects;
import com.codurance.training.tasks.handler.Handler;

import java.io.IOException;
import java.io.Writer;

public class ShowHandler implements Handler {
    Projects projects;
    Writer writer;

    public ShowHandler(Projects projects, Writer writer) {
        this.projects = projects;
        this.writer = writer;
    }

    @Override
    public void handle() throws IOException {
        writer.write(
                projects.getProjectsFormatted()
        );
    }
}
