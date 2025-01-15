package com.codurance.training.tasks;

import org.junit.Assert;
import org.junit.Test;

public class ProjectsTest {

    @Test
    public void projectsTaskFormatTest() {
        Projects projects = new Projects();

        Project project = new Project("caizin");
        project.add(new Task(1,"task1",false));

        projects.put("caizin",project);
        String expected = "caizin\r\n[ ] 1: task1%n";
        Assert.assertEquals(
                String.format(expected),
                projects.format()
        );
    }

    @Test
    public void testTaskDoneByTaskId() throws Exception {
        Projects projects = new Projects();

        Project project = new Project("caizin");

        Task task = new Task(1,"task1",false);
        project.add(task);

        projects.put("caizin",project);

        projects.setDoneByTaskId(task.getStringId(),true);

        Assert.assertTrue(task.isDone());

    }

    @Test
    public void testTaskNotDoneByTaskId() throws Exception {
        Projects projects = new Projects();

        Project project = new Project("caizin");

        Task task = new Task(1,"task1",true);
        project.add(task);

        projects.put("caizin",project);

        projects.setDoneByTaskId(task.getStringId(),false);

        Assert.assertFalse(task.isDone());

    }

    @Test
    public void testProjectCreated(){
        Projects projects = new Projects();
        Project project = new Project("caizin");
        projects.put("caizin",project);

        Project actual = projects.get("caizin");
        Assert.assertEquals(actual, project);

    }
}
