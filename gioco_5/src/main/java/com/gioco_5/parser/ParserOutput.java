
package com.gioco_5.parser;

import com.gioco_5.type.Command;

public class ParserOutput {

    private Command command;

    public ParserOutput(Command command) {
        this.command = command;
    }

    public Command getCommand() {
        return command;
    }

    public void setCommand(Command command) {
        this.command = command;
    }
}
