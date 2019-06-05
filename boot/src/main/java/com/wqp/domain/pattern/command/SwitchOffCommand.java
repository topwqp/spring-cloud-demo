package com.wqp.domain.pattern.command;

/**
 * @Description The Command for turning off the light - ConcreteCommand
 * @Author Wang QiuPeng
 * Date 19/4/15 09:31
 **/
public class SwitchOffCommand implements Command {
    private final Light light;

    public SwitchOffCommand(Light light) {
        this.light = light;
    }

    @Override // Command
    public void execute() {
        light.turnOff();
    }
}
