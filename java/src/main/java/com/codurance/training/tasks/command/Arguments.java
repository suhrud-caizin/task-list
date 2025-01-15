package com.codurance.training.tasks.command;

import java.util.ArrayList;
import java.util.List;

public final class Arguments {
    private final List<String> args;

    public Arguments(List<String> args){
        this.args = args;
    }

    public Arguments(){
        args = new ArrayList<>();
    }

    public String get(int index){
        return args.get(index);
    }
}
