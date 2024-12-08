import java.util.Scanner;

public class Main {
    //Array 'alphabetC' Store the Uppercase letters of English alphabet
    private static char[] cAlphabet = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};

    //Array 'alphabetC' Store the Uppercase letters of English alphabet
    private static char[] sAlphabet = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};

    private static char getEncryptedLetter(char character) {
        //Iterate through the alphabet to find characters are uppercase or lowercase
        char encryptedLetter = character;
        for (int j = 0; j < 26; j++) {
            //check whether each character is uppercase
            if (character==cAlphabet[j]) {
                encryptedLetter = cAlphabet[((j + 3) % 26)];
                break;
            } else if (character == sAlphabet[j]) {
                encryptedLetter = sAlphabet[((j + 3) % 26)];
                break;
            }
        }
        return encryptedLetter;
    }

    public static void main(String[] args) {
        System.out.println("-------------------Caeser Cipher Encryption Algorithm------------------------");

        String encryptedMessage = "";

        System.out.print("Enter a message:");
        Scanner input = new Scanner(System.in);
        String message = input.nextLine();

        if (!message.isEmpty()) {
            //Going through each character in the message
            for (int i = 0; i < message.length(); i++) {
                String encryptrdLetter = String.valueOf(getEncryptedLetter(message.charAt(i)));
                encryptedMessage=encryptedMessage.concat(encryptrdLetter);
            }

            System.out.println("Encrypted Message: " + encryptedMessage);
        } else {
            System.out.println("Your message is empty!");
        }

    }

}