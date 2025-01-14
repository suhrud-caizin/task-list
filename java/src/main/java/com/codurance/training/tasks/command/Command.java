package com.codurance.training.tasks.command;

import com.codurance.training.tasks.Projects;
import com.codurance.training.tasks.handler.AddHandler;
import com.codurance.training.tasks.handler.CheckHandler;
import com.codurance.training.tasks.handler.Handler;
import com.codurance.training.tasks.handler.ShowHandler;

import java.io.Writer;
import java.util.List;

public class Command {
            CommandType type;
            List<String> args;
            Projects projects;
            Handler handler;
            Writer writer;

            public Command(CommandBuilder builder){
                this.type = builder.type;
                this.args =  builder.args;
                this.projects = builder.projects;
                this.handler = builder.handler;
                this.writer = builder.writer;
            }

            public void execute() throws Exception {
                // execute
                handler.handle();
            }

    public static class CommandBuilder{
        CommandType type;
        List<String> args;

        Projects projects;
        Handler handler;

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
            this.handler = getHandler(type);

            if(projects == null){
                throw new Exception("projects not set");
            }

            if(writer == null){
                throw new Exception("writer not provided");
            }
            return new Command(this);
        }

        private Handler getHandler(CommandType type) throws Exception {
            switch (type){
                case SHOW:
                    return new ShowHandler(projects,writer);
                case ADD:
                    return new AddHandler(projects,writer,args);
                case CHECK:
                    return new CheckHandler(projects,args,true);
                case UNCHECK:
                    return new CheckHandler(projects,args,false);
                default:
                    throw new Exception("Unsupported command.");
            }
        }
    }
}
