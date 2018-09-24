package by.bsu.approximation.util.encryption;

import java.math.BigInteger;
import java.security.SecureRandom;

public class EncryptionAction {

    public static final BigInteger publicKey = new BigInteger("65537");;

    private BigInteger modulus;
    private BigInteger privateKey;

    public void init(int bitLength) {

        SecureRandom random = new SecureRandom();

        BigInteger p = BigInteger.probablePrime(bitLength >> 1, random);
        BigInteger q = BigInteger.probablePrime(bitLength >> 1, random);

        modulus = p.multiply(q);

        BigInteger totient = p.subtract(BigInteger.ONE).multiply(q.subtract(BigInteger.ONE));

        privateKey = publicKey.modInverse(totient);
    }

    public BigInteger encrypt(BigInteger message) {
        return message.modPow(publicKey, modulus);
    }

    public BigInteger decrypt(BigInteger cipher) {
        return cipher.modPow(privateKey, modulus);
    }

    public BigInteger getModulus() {
        return modulus;
    }

    public BigInteger getPrivateKey() {
        return privateKey;
    }
}
