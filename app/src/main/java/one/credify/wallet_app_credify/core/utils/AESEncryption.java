package one.credify.wallet_app_credify.core.utils;

import android.media.MediaCodec;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class AESEncryption {
    private static final String ALGORITHM = "AES";
    private static final String TRANSFORMATION = "AES";

    // a mock map to store encrypted private keys of coins
    private static final Map<String, String> encrytedCoins = new HashMap<String, String>() {{
        put("7QI8+lv6BMWS0M08kq51ufOh1DspwdBSWzlQyK/3oZhavPzkbwmg0QndptDHomL5", "7117251d12dd28c5e02f5bd90ef813fd2e4e7c7b42563790ea459d5e6a62761c");
        put("HHiRrPH0JAVTjrzV5FYlOMVgBZe7bX1NUJQ1OgZqTFdWSWU+ad1otfyg8uMF7bD7", "688545041FBBEF6AAEB380D57963C4329A56ED264E124731F05911C2F1062108");
    }};

    public static void encrypt(String publicKey, String keyAES)
            throws MediaCodec.CryptoException {
    }

    public static String decrypt(String publicKey, String keyAES)
            throws MediaCodec.CryptoException {
        // mock function to return decrypted key
        return encrytedCoins.get(keyAES);
    }

    private static void doCrypto(int cipherMode, String publicKey, String keyAES, File file) throws MediaCodec.CryptoException {
        // mock function to do AES encryption
    }
}
