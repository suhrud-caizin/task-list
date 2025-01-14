package com.codurance.training.tasks.command;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CommandParser {
    public static Command.CommandBuilder parse(String command){
        String[] query =  command.split(" ",2);
        List<String> args;

        if(query.length > 1){
            args = Arrays.asList(query[1].split(" "));
        }else {
            args = new ArrayList<>();
        }

        CommandType type = CommandType.fromString(query[0]);
        return new Command.CommandBuilder(type,args);
    }

}
