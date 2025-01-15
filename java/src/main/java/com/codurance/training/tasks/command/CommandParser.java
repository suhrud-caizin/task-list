package com.codurance.training.tasks.command;

import java.util.Arrays;

public class CommandParser {
    public static Command.CommandBuilder parse(String command){
        String[] query =  command.split(" ",2);
        Arguments args;      //TODO: create an immutable abstraction for the arguments

        if(query.length > 1){
            args = new Arguments(Arrays.asList(query[1].split(" ")));
        }else {
            args = new Arguments();
        }

        CommandType type = CommandType.fromString(query[0]);
        return new Command.CommandBuilder(type,args);
    }

}
