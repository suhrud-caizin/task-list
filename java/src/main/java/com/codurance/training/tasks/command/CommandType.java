package com.codurance.training.tasks.command;

public enum CommandType {
    SHOW,
    ADD,
    CHECK,
    UNCHECK;

    public static CommandType fromString(String value) {
        try {
            return CommandType.valueOf(value.toUpperCase());
        } catch (IllegalArgumentException e) {
            System.err.println("Invalid entity: " + value);
            return null;
        }
    }
}
