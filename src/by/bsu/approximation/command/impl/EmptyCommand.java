package by.bsu.approximation.command.impl;

import by.bsu.approximation.command.ActionCommand;
import by.bsu.approximation.command.Router;
import by.bsu.approximation.util.ConfigurationManager;

import javax.servlet.http.HttpServletRequest;

public class EmptyCommand implements ActionCommand {

    @Override
    public Router execute(HttpServletRequest request) {
        String page = ConfigurationManager.getProperty("path.page.index");
        Router router = new Router();
        router.setPage(page);
        router.setType(Router.Type.FORWARD);
        return router;
    }
}
