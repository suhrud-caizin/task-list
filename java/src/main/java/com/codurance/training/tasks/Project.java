package com.codurance.training.tasks;

public class Project {
    String name;
    Tasks tasks;

    public Project(String name){
        this.name = name;
        this.tasks = new Tasks();
    }

     boolean setDone(int id, boolean done) {
        for (Task task : tasks) {
            if (task.getId() == id) {
                task.setDone(done);
                return true;
            }
        }
        return false;
    }

    public String format(){
        return getName() + "\r\n" +
                tasks.format();
    }

    public String getName(){
        return name;
    }

    public void add(Task task){
        tasks.add(task);
    }

}
