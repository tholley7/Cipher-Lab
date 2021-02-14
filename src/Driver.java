/**
 * Main driver class for ciphers
 * @author Tyler Holley
 * @version November 20, 2020
 */
public class Driver {
    public static void main(String[] args) {
        // Caesar Cipher Test
        CaesarCipher caesar = new CaesarCipher(4);
        String caesarText = "xyz";

        System.out.println("\n===== ===== CAESAR CIPHER TEST ===== =====");
        System.out.println("Original:  " + caesarText);
        String caesarEncrypted = caesar.encrypt(caesarText);

        System.out.println("Encrypted: " + caesarEncrypted);
        System.out.println("Decrypted: " + caesar.decrypt(caesarEncrypted));


        // Trithemius Cipher Test
        TrithemiusCipher tri = new TrithemiusCipher();
        String triText = "Tyler Holley";

        System.out.println("\n===== ===== TRITHEMIUS CIPHER TEST ===== =====");
        System.out.println("Original:  " + triText);
        String triEncrypted = tri.encrypt(triText);

        System.out.println("Encrypted: " + triEncrypted);
        System.out.println("Decrypted: " + tri.decrypt(triEncrypted));


        //  Jason Cipher Test
        JasonCipher jason = new JasonCipher();
        String jasonText = "Tyler";

        System.out.println("\n===== ===== JASON CIPHER TEST ===== =====");
        System.out.println("Original:  " + jasonText);
        String jasonEncrypted = jason.encrypt(jasonText);

        System.out.println("Encrypted: " + jasonEncrypted);
        System.out.println("Decrypted: " + jason.decrypt(jasonEncrypted));
    }
}
