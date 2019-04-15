package com.wqp.design.pattern.command;

import java.util.HashMap;

/**
 * @Description The Invoker class
 * @Author Wang QiuPeng
 * Date 19/4/15 09:28
 **/
public class Switch {
    private final HashMap<String, Command> commandMap = new HashMap<>();

    public void register(String commandName, Command command) {
        commandMap.put(commandName, command);
    }

    public void execute(String commandName) {
        Command command = commandMap.get(commandName);
        if (command == null) {
            throw new IllegalStateException("no command registered for " + commandName);
        }
        command.execute();
    }
}
