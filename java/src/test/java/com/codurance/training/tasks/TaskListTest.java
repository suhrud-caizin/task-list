package com.codurance.training.tasks;

import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;

public class TaskListTest {

    @Test
    public void testExecuteWithAdditionOfAProjectContainingOneTask() throws IOException {
        Writer writer = new StringWriter();
        TaskList taskList = new TaskList(writer);

        taskList.execute("add project caizin");
        taskList.execute("add task caizin task1");
        taskList.execute("show");


        String expected = "caizin\n"+"[ ] 1: task1" + "\r\n";
        String actual = writer.toString();

        Assert.assertEquals(expected,actual);

    }

    @Test
    public void testExecuteWithAdditionOfAProjectContainingCoupleOfTask() throws IOException {
        Writer writer = new StringWriter();
        TaskList taskList = new TaskList(writer);

        taskList.execute("add project caizin");
        taskList.execute("add task caizin task1");
        taskList.execute("add task caizin task2");
        taskList.execute("show");


        String expected = "caizin\n"+"[ ] 1: task1" + "\r\n" + "[ ] 2: task2" + "\r\n";
        String actual = writer.toString();

        Assert.assertEquals(expected,actual);
    }

}
