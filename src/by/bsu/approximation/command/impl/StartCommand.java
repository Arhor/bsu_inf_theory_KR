package by.bsu.approximation.command.impl;

import by.bsu.approximation.command.ActionCommand;
import by.bsu.approximation.command.Router;
import by.bsu.approximation.util.ConfigurationManager;

import javax.servlet.http.HttpServletRequest;

public class StartCommand implements ActionCommand {

    @Override
    public Router execute(HttpServletRequest request) {
        Router router = new Router();
        router.setPage(ConfigurationManager.getProperty("path.page.main"));
        router.setType(Router.Type.FORWARD);
        return router;
    }
}
