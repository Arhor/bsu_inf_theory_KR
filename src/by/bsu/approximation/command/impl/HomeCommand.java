package by.bsu.approximation.command.impl;

import by.bsu.approximation.command.ActionCommand;
import by.bsu.approximation.command.Router;
import by.bsu.approximation.util.ConfigurationManager;

import javax.servlet.http.HttpServletRequest;

public class HomeCommand implements ActionCommand {

    @Override
    public Router execute(HttpServletRequest request) {
        Router router = new Router();
        String page = ConfigurationManager.getProperty("path.page.main");
        router.setPage(page);
        router.setType(Router.Type.FORWARD);
        return router;
    }
}
