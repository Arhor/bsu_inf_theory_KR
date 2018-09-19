package by.bsu.approximation.controller;

import by.bsu.approximation.command.ActionCommand;
import by.bsu.approximation.command.Router;
import by.bsu.approximation.command.factory.ActionFactory;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(
        name = "Controller",
        urlPatterns = "/controller"
)
public class Controller extends HttpServlet {
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    private void processRequest(HttpServletRequest request,
                                HttpServletResponse response)
            throws ServletException, IOException {

        Router router;

        ActionFactory client = new ActionFactory();
        ActionCommand command = client.defineCommand(request);

        router = command.execute(request);

        switch (router.getType()) {
            case FORWARD:
                RequestDispatcher dispatcher =
                        getServletContext().getRequestDispatcher(router.getPage());
                dispatcher.forward(request, response);
                break;
            case REDIRECT:
                response.sendRedirect(request.getContextPath() + router.getPage());
                break;
        }
    }
}
