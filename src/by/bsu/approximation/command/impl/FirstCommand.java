package by.bsu.approximation.command.impl;

import by.bsu.approximation.command.ActionCommand;
import by.bsu.approximation.command.Router;
import by.bsu.approximation.util.AppEnum;
import by.bsu.approximation.util.AppFactory;
import by.bsu.approximation.util.Approximator;
import by.bsu.approximation.util.ConfigurationManager;

import javax.servlet.http.HttpServletRequest;

public class FirstCommand implements ActionCommand {

    @Override
    public Router execute(HttpServletRequest request) {

        Router router = new Router();
        String page;

        String source = request.getParameter("source");

        AppFactory factory = new AppFactory();
        Approximator approximator = factory.getApproximator(AppEnum.FIRST, source);

        String result = approximator.approximate();

        request.setAttribute("source", source);
        request.setAttribute("result", result);

        page = ConfigurationManager.getProperty("path.page.main");

        router.setPage(page);
        router.setType(Router.Type.FORWARD);

        return router;
    }
}
