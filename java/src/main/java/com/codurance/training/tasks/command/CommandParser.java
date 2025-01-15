package com.codurance.training.tasks.command;

import com.codurance.training.tasks.command.Command.CommandBuilder;

import java.util.Arrays;

public class CommandParser {
    public static CommandBuilder parse(String command){
        String[] query =  command.split(" ",2);
        Arguments args;

        if(query.length > 1){
            args = new Arguments(Arrays.asList(query[1].split(" ")));
        }else {
            args = new Arguments();
        }

        CommandType type = CommandType.fromString(query[0]);
        return new CommandBuilder(type,args);
    }

}
