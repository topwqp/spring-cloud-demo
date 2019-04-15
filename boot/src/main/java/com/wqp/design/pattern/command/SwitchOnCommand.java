package com.wqp.design.pattern.command;

/**
 * @Description The Command for turning on the light - ConcreteCommand
 * @Author Wang QiuPeng
 * Date 19/4/15 09:29
 **/
public class SwitchOnCommand implements Command {

    private final Light light;

    public SwitchOnCommand(Light light) {
        this.light = light;
    }

    @Override // Command
    public void execute() {
        light.turnOn();
    }
}
