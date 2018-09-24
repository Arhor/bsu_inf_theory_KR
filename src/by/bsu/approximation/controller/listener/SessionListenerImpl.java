package by.bsu.approximation.controller.listener;

import by.bsu.approximation.util.encryption.EncryptionAction;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

@WebListener
public class SessionListenerImpl implements HttpSessionListener {

    private static final Logger LOG = LogManager.getLogger(SessionListenerImpl.class);

    private static final int KEY_BIT_LENGTH = 1024;

    @Override
    public void sessionCreated(HttpSessionEvent httpSessionEvent) {
        HttpSession session = httpSessionEvent.getSession();
        EncryptionAction encryptionAction =
                (EncryptionAction) session.getAttribute("encryptor");
        if (encryptionAction == null) {
            encryptionAction = new EncryptionAction();
            encryptionAction.init(KEY_BIT_LENGTH);
            session.setAttribute("encryptor", encryptionAction);
            LOG.debug("encryptor created");
        }
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {

    }
}
