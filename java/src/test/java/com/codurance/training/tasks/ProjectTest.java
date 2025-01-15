package com.codurance.training.tasks;

import org.junit.Assert;
import org.junit.Test;

public class ProjectTest {
    @Test
    public void testGetProjectTaskFormatted(){
        Project project = new Project("DQS");
        project.add(new Task(1,"t1",false));
        project.add(new Task(2,"t2",false));
        String expected = "DQS%n" +
                "[ ] 1: t1%n" +
                "[ ] 2: t2%n";
        Assert.assertEquals(String.format(expected),project.format());

    }
}
