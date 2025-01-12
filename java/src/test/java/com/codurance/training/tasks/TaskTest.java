package com.codurance.training.tasks;

import org.junit.Assert;
import org.junit.Test;

public class TaskTest {
    @Test
    public void TaskFormatTest(){
        Task task = new Task(12,"test task", false);
        Assert.assertEquals(String.format("[ ] 12: test task%n"), task.getFormatted());
    }
}
