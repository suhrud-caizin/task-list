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

    @Test
    public void testTaskDoneByTaskId() throws Exception {
        Projects projects = new Projects();
        Tasks tasks = new Tasks();
        Task task = new Task(1,"task1",false);
        tasks.add(task);
        projects.put("caizin",tasks);

        projects.setDoneByTaskId(task.getStringId(),true);

        Assert.assertTrue(task.isDone());

    }

    @Test
    public void testTaskNotDoneByTaskId() throws Exception {
        Tasks tasks = new Tasks();
        Task task = new Task(1,"task1",true);
        tasks.add(task);
        Projects projects = new Projects();
        projects.put("caizin",tasks);

        projects.setDoneByTaskId(task.getStringId(),false);

        Assert.assertFalse(task.isDone());

    }
}
