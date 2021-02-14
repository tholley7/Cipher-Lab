/**
 * Jason Cipher based on Cipher interface
 * @author Tyler Holley
 * @version November 20, 2020
 */
public class JasonCipher implements Cipher {

    /**
     * Empty constructor
     */
    public JasonCipher() {

    }

    /**
     * Encrypts given text using the Jason Cipher
     * @param plainText text to be encrypted
     * @return encrypted string
     */
    @Override
    public String encrypt(String plainText) {
        StringBuilder result = new StringBuilder();

        String firstHalf, secondHalf;

        if (plainText.length() % 2 == 0) {
            firstHalf = plainText.substring(0, plainText.length() / 2);
            secondHalf = plainText.substring(plainText.length());
        }
        else {
            firstHalf = plainText.substring(0, (plainText.length() / 2) + 1);
            secondHalf = plainText.substring((plainText.length() / 2) + 1);
        }

        firstHalf = new StringBuffer(firstHalf).reverse().toString();
        secondHalf = new CaesarCipher(5).encrypt(secondHalf);
        result.append(firstHalf);
        result.append(secondHalf);

        return result.toString().toUpperCase();
    }

    /**
     * Decrypts text which was encrypted with the Jason cipher
     * @param encryptedText text to be decrypted
     * @return decrypted (english) text
     */
    @Override
    public String decrypt(String encryptedText) {
        StringBuilder result = new StringBuilder();

        String firstHalf, secondHalf;

        if (encryptedText.length() % 2 == 0) {
            firstHalf = encryptedText.substring(0, encryptedText.length() / 2);
            secondHalf = encryptedText.substring(encryptedText.length());
        }
        else {
            firstHalf = encryptedText.substring(0, (encryptedText.length() / 2) + 1);
            secondHalf = encryptedText.substring((encryptedText.length() / 2) + 1);
        }

        firstHalf = new StringBuffer(firstHalf).reverse().toString();
        secondHalf = new CaesarCipher(5).decrypt(secondHalf);
        result.append(firstHalf);
        result.append(secondHalf);

        return result.toString().toUpperCase();
    }
}
