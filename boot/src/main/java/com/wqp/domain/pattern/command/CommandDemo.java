package com.wqp.domain.pattern.command;

/**
 * @Description client
 * @Author Wang QiuPeng
 * Date 19/4/15 09:31
 **/
public class CommandDemo {
    public static void main(final String[] arguments) {
        Light lamp = new Light();

        Command switchOn = new SwitchOnCommand(lamp);
        Command switchOff = new SwitchOffCommand(lamp);

        Switch mySwitch = new Switch();
        mySwitch.register("on", switchOn);
        mySwitch.register("off", switchOff);

        mySwitch.execute("on");
        mySwitch.execute("off");
    }
}
