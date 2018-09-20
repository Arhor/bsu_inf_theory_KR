package by.bsu.approximation.command.impl;

import by.bsu.approximation.command.ActionCommand;
import by.bsu.approximation.command.Router;
import by.bsu.approximation.util.ConfigurationManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Enumeration;

public class SetProbCommand implements ActionCommand {

    private static final Logger LOG = LogManager.getLogger(SetProbCommand.class);

    private static final String PARAM_PROB = "prob";

    @Override
    public Router execute(HttpServletRequest request) {
        Router router = new Router();
        String page;

        ArrayList<Double> probs = new ArrayList<>();

        String[] values = request.getParameterValues(PARAM_PROB);
        for (String value : values) {
            if (value.matches("(1\\.0)|(0\\.[0-9]{1,2})")) {
                probs.add(Double.parseDouble(value));
            }
        }

        double sum = probs.stream().mapToDouble(f -> f).sum();

        if (sum == 1.0) {
            page = ConfigurationManager.getProperty("path.page.entropy"); // STUB
        } else {
            page = ConfigurationManager.getProperty("path.page.entropy");
            request.setAttribute("wrongInput", "sum of values must be equal 1.0");
        }

        router.setPage(page);
        router.setType(Router.Type.FORWARD);
        return router;
    }
}
