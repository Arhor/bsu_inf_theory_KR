package by.bsu.approximation.command;

import by.bsu.approximation.command.impl.*;

public enum CommandEnum {

    START {
        {
            this.command = new StartCommand();
        }
    },
    FIRST {
        {
            this.command = new FirstCommand();
        }
    },
    SECOND {
        {
            this.command = new SecondCommand();
        }
    },
    THIRD {
        {
            this.command = new ThirdCommand();
        }
    };

    ActionCommand command;

    public ActionCommand getCurrentCommand() {
        return command;
    }
}