package by.bsu.approximation.command.impl;

import by.bsu.approximation.command.ActionCommand;
import by.bsu.approximation.command.Router;
import by.bsu.approximation.util.ConfigurationManager;
import by.bsu.approximation.util.encryption.EncryptionAction;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.math.BigInteger;

public class DecryptCommand implements ActionCommand {

    @Override
    public Router execute(HttpServletRequest request) {
        Router router = new Router();
        String page = ConfigurationManager.getProperty("path.page.encryption");

        HttpSession session = request.getSession();

        EncryptionAction encryptionAction =
                (EncryptionAction) session.getAttribute("encryptor");

        String message = request.getParameter("source");
        String encrypted = request.getParameter("encrypted");

        BigInteger result = encryptionAction.decrypt(new BigInteger(encrypted));

        String decrypted = new String(result.toByteArray());

        request.setAttribute("source", message);
        request.setAttribute("encrypted", encrypted);
        request.setAttribute("decrypted", decrypted);

        router.setPage(page);
        router.setType(Router.Type.FORWARD);
        return router;
    }
}
