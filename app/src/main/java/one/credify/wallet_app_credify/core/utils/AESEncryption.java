package one.credify.wallet_app_credify.core.utils;

import android.media.MediaCodec;
import android.os.Build;

import androidx.annotation.RequiresApi;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.crypto.Cipher;

@RequiresApi(api = Build.VERSION_CODES.N)
public class AESEncryption {
    private static final String ALGORITHM = "AES";
    private static final String TRANSFORMATION = "AES";

    // stub key map
    private static final Map<String, String> encrytedCoins = Stream.of(new String[][] {
            { "Hello", "World" },
            { "John", "Doe" },
    }).collect(Collectors.toMap(data -> data[0], data -> data[1]));

    public static void encrypt(String publicKey, String keyAES)
            throws MediaCodec.CryptoException {
        doCrypto(Cipher.ENCRYPT_MODE, publicKey, keyAES, null);
    }

    public static String decrypt(String publicKey, String keyAES)
            throws MediaCodec.CryptoException {
        // stub function to return decrypted key
        doCrypto(Cipher.DECRYPT_MODE, publicKey, keyAES, null);

        return encrytedCoins.get(publicKey);
    }

    private static void doCrypto(int cipherMode, String publicKey, String keyAES, File file) throws MediaCodec.CryptoException {
        // stub function to do AES encryption
    }
}
