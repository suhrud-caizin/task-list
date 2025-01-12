package com.codurance.training.tasks;

public final class Task {
    private final long id;
    private final String description;
    private boolean done;

    public Task(long id, String description, boolean done) {
        this.id = id;
        this.description = description;
        this.done = done;
    }

    // TODO move to Task class
    String getFormatted() {
        return String.format("[%c] %d: %s%n", (this.isDone() ? 'x' : ' '), this.getId(), this.getDescription());
    }

    public long getId() {
        return id;
    }

    public String getStringId(){
        return String.valueOf(id);
    }

    public String getDescription() {
        return description;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }
}
