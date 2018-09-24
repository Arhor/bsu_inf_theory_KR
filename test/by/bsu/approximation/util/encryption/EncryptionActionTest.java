package by.bsu.approximation.util.encryption;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.math.BigInteger;

public class EncryptionActionTest {

    private static final Logger LOG = LogManager.getLogger(EncryptionAction.class);
    
    private static EncryptionAction encryptor;

    @Test
    public void testEncryption() {
        String message =
                "This is a test string, should be encrypted and decrypted";
        BigInteger cipher =
                encryptor.encrypt(new BigInteger(message.getBytes()));
        LOG.info(cipher);
        BigInteger decrypted =
                encryptor.decrypt(cipher);
        LOG.info(decrypted);
        String actual = new String(decrypted.toByteArray());
        Assert.assertEquals(actual, message);
    }

    @BeforeMethod
    public void setUp() {
        encryptor = new EncryptionAction();
        int bitLength = 1024;
        encryptor.init(bitLength);
    }

    @AfterMethod
    public void tearDown() {
        encryptor = null;
    }
}