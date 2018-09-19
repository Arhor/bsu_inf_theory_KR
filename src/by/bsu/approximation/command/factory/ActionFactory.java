package by.bsu.approximation.command.factory;

import by.bsu.approximation.command.ActionCommand;
import by.bsu.approximation.command.CommandEnum;
import by.bsu.approximation.command.impl.EmptyCommand;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;

public class ActionFactory {

    private static final Logger LOG = LogManager.getLogger(ActionFactory.class);

    public ActionCommand defineCommand(HttpServletRequest request) {

        ActionCommand currentCommand = new EmptyCommand();

        String action = request.getParameter("command")
                .replace(" ", "_")
                .toUpperCase();

        if (action == null || action.isEmpty()) {
            return currentCommand;
        }

        try {
            CommandEnum currentEnum = CommandEnum.valueOf(action);
            currentCommand = currentEnum.getCurrentCommand();
        } catch (IllegalArgumentException e) {
            LOG.error("Unknown command: " + action, e);
        }

        return currentCommand;
    }

}
