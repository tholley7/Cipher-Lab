/**
 * Trithemius Cipher based on Cipher interface
 * @author Tyler Holley
 * @version November 20, 2020
 */
public class TrithemiusCipher implements Cipher {
    private char[] alpha = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H',
            'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V',
            'W', 'X', 'Y', 'Z'};

    /**
     * Encrypts given text using the Trithemius Cipher
     * @param plainText text to be encrypted
     * @return encrypted string
     */
    @Override
    public String encrypt(String plainText) {
        StringBuilder result = new StringBuilder();
        String[] words = plainText.split("\\s+");

        for (String word : words) {
            for (int i = 0; i < word.length(); i++) {
                int index = charToIndex(word.charAt(i));
                int alphaIndex = index + i;

                if ((alphaIndex) > 25) {
                    alphaIndex -= 26;
                }

                result.append(alpha[alphaIndex]);
            }
            result.append(" ");
        }

        return result.toString();
    }

    /**
     * Decrypts text which was encrypted with the Trithemius cipher
     * @param encryptedText text to be decrypted
     * @return decrypted (english) text
     */
    @Override
    public String decrypt(String encryptedText) {
        StringBuilder result = new StringBuilder();
        String[] words = encryptedText.split("\\s+");

        for (String word : words) {
            for (int i = 0; i < word.length(); i++) {
                int index = charToIndex(word.charAt(i));
                int alphaIndex = index - i;

                if ((alphaIndex) < 0) {
                    alphaIndex += 26;
                }

                result.append(alpha[alphaIndex]);
            }
            result.append(" ");
        }

        return result.toString();
    }

    public int charToIndex(char c) {
        int result = (int)c;
        int lowerCase = 97;
        int upperCase = 65;

        if(result <= 122 && result >= 97)
        {
            result -= lowerCase;
        }
        else if(result >= 65 && result <= 90)
        {
            result -= upperCase;
        }

        return result;
    }
}
