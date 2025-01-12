package com.codurance.training.tasks;

import org.junit.Assert;
import org.junit.Test;

public class ProjectsTest {

    @Test
    public void projectsTaskFormatTest() {
        Projects projects = new Projects();
        Tasks tasks = new Tasks();
        tasks.add(new Task(1,"task1",false));
        projects.put("caizin",tasks);
        String expected = "caizin\n[ ] 1: task1%n";
        Assert.assertEquals(
                String.format(expected),
                projects.getProjectsFormatted()
        );
    }
}
