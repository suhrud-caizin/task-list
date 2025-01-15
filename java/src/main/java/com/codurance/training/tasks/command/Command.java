package com.codurance.training.tasks.command;

import com.codurance.training.tasks.Projects;
import com.codurance.training.tasks.handler.AddExecutor;
import com.codurance.training.tasks.handler.CheckExecutor;
import com.codurance.training.tasks.handler.CommandExecutor;
import com.codurance.training.tasks.handler.ShowExecutor;

import java.io.Writer;
import java.util.List;

public class Command {
            CommandType type;
            List<String> args;
            Projects projects;
            CommandExecutor commandExecutor;
            Writer writer;

            public Command(CommandBuilder builder){
                this.type = builder.type;
                this.args =  builder.args;
                this.projects = builder.projects;
                this.commandExecutor = builder.commandExecutor;
                this.writer = builder.writer;
            }

            public void execute() throws Exception {
                commandExecutor.execute();
            }

    public static class CommandBuilder{
        CommandType type;
        List<String> args;

        Projects projects;
        CommandExecutor commandExecutor;

        Writer writer;

        public CommandBuilder(CommandType type, List<String> args){
            this.type = type;
            this.args = args;
        }

        public CommandBuilder setProjects(Projects projects){
            this.projects = projects;
            return this;
        }

        public CommandBuilder setWriter(Writer writer){
            this.writer = writer;
            return this;
        }

        public Command build() throws Exception {
            this.commandExecutor = getHandler(type);

            if(projects == null){
                throw new Exception("projects not set");
            }

            if(writer == null){
                throw new Exception("writer not provided");
            }
            return new Command(this);
        }

        private CommandExecutor getHandler(CommandType type) throws Exception {
            switch (type){
                case SHOW:
                    return new ShowExecutor(projects,writer);
                case ADD:
                    return new AddExecutor(projects,writer,args);
                case CHECK:
                    return new CheckExecutor(projects,args,true);
                case UNCHECK:
                    return new CheckExecutor(projects,args,false);
                default:
                    throw new Exception("Unsupported command.");
            }
        }
    }
}
