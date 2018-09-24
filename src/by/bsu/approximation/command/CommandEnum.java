package by.bsu.approximation.command;

import by.bsu.approximation.command.impl.*;

public enum CommandEnum {

    START {
        {
            this.command = new StartCommand();
        }
    },
    HOME {
        {
            this.command = new HomeCommand();
        }
    },
    ENTROPY {
        {
            this.command = new EntropyCommand();
        }
    },
    SETPROB {
        {
            this.command = new SetProbCommand();
        }
    },
    APPROXIMATION {
        {
            this.command = new ApproximationCommand();
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
    },
    ENCRYPTION {
        {
            this.command = new EncryptionCommand();
        }
    },
    ENCRYPT {
        {
            this.command = new EncryptCommand();
        }
    },
    DECRYPT {
        {
            this.command = new DecryptCommand();
        }
    };

    ActionCommand command;

    public ActionCommand getCurrentCommand() {
        return command;
    }
}
