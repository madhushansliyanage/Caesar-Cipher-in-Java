import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    //Array 'alphabetC' Store the Uppercase letters of English alphabet
    private static char[] cAlphabet = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};

    //Array 'alphabetC' Store the Uppercase letters of English alphabet
    private static char[] sAlphabet = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};

    private static String getEncryptedMessage(String message) {
        StringBuilder encryptedText = new StringBuilder();

        for (int i = 0; i < message.length(); i++) {
            char encryptedLetter = message.charAt(i);
            //Iterate through the alphabet to find characters are uppercase or lowercase
            for (int j = 0; j < 26; j++) {
                //check character is uppercase
                if (message.charAt(i) == cAlphabet[j]) {
                    encryptedLetter = cAlphabet[((j + 3) % 26)];
                    break;
                    //check character is lowercase
                } else if (message.charAt(i) == sAlphabet[j]) {
                    encryptedLetter = sAlphabet[((j + 3) % 26)];
                    break;
                }
            }
            encryptedText.append(encryptedLetter);
        }

        return encryptedText.toString();
    }

    private static String getDecryptedLetter(String encryptedMessage) {
        StringBuilder decryptedText = new StringBuilder();

        for (int i = 0; i < encryptedMessage.length(); i++) {
            char decryptedLetter = encryptedMessage.charAt(i);
            for (int j = 0; j < 26; j++) {
                if (encryptedMessage.charAt(i) == cAlphabet[j]) {
                    decryptedLetter = cAlphabet[(j - 3 + 26) % 26];
                    break;
                } else if (encryptedMessage.charAt(i) == sAlphabet[j]) {
                    decryptedLetter = sAlphabet[((j - 3 + 26) % 26)];
                    break;
                }
            }
            decryptedText.append(decryptedLetter);
        }
        return decryptedText.toString();
    }

    public static void main(String[] args) {
        System.out.println("-------------------Caeser Cipher Encryption Algorithm------------------------");
        Scanner input = new Scanner(System.in);
        String encryptedMessage = "";

        System.out.print("SELECT OPTION\n1.ENCRYPT\n2.DECRYPT :");
        try {
            int option = input.nextInt();
            input.nextLine();


            switch (option) {
                case 1:
                    System.out.print("Enter a message:");
                    String message = input.nextLine();

                    System.out.println("Encrypted Message: " + getEncryptedMessage(message));

                    break;
                case 2:
                    System.out.print("Enter decrypted message:");
                    String cipherText = input.nextLine();

                    System.out.println("Decripted Message: " + getDecryptedLetter(cipherText));
                    break;
                case 0:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid Option");
            }

        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please try again.");
        }
    }

}