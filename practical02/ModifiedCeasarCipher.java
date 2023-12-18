package practical02;

import java.util.Scanner;

public class ModifiedCeasarCipher {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Type Your Plain Text: "); // e.g. Shridhar
        String plainText = input.nextLine();
        System.out.print("Type Your ShiftKey Length: "); // e.g. 3
        int shiftKey = input.nextInt();
        CeasarCipher cc = new CeasarCipher();
        String cipherText = cc.encrypt(plainText, shiftKey);
        System.out.println("Your PlainText: " + plainText);
        System.out.println("Your cipherText: " + cipherText);
        String cPlainText = cc.decrypt(cipherText, shiftKey);
        System.out.println("Your Plain Text: " + cPlainText);
        input.close();
    }

    static class CeasarCipher {
        private final String ALPHABET = "abcdefghijklmnopqrstuvwxyz";

        public String encrypt(String plainText, int shiftKey) {
            StringBuilder cipherText = new StringBuilder();
            for (int i = 0; i < plainText.length(); i++) {
                char currentChar = plainText.charAt(i);
                if (Character.isLetter(currentChar)) {
                    int charPosition = ALPHABET.indexOf(Character.toLowerCase(currentChar));
                    int keyVal = (shiftKey + charPosition) % 26;
                    if (keyVal < 0) {
                        keyVal += 26;
                    }
                    char replaceVal = Character.isUpperCase(currentChar) ?
                            Character.toUpperCase(ALPHABET.charAt(keyVal)) :
                            ALPHABET.charAt(keyVal);
                    cipherText.append(replaceVal);
                } else {
                    cipherText.append(currentChar); // Non-alphabetic character, keep unchanged
                }
            }
            return cipherText.toString();
        }

        public String decrypt(String cipherText, int shiftKey) {
            StringBuilder plainText = new StringBuilder();
            for (int i = 0; i < cipherText.length(); i++) {
                char currentChar = cipherText.charAt(i);
                if (Character.isLetter(currentChar)) {
                    int charPosition = ALPHABET.indexOf(Character.toLowerCase(currentChar));
                    int keyVal = (charPosition - shiftKey) % 26;
                    if (keyVal < 0) {
                        keyVal += 26;
                    }
                    char replaceVal = Character.isUpperCase(currentChar) ?
                            Character.toUpperCase(ALPHABET.charAt(keyVal)) :
                            ALPHABET.charAt(keyVal);
                    plainText.append(replaceVal);
                } else {
                    plainText.append(currentChar); // Non-alphabetic character, keep unchanged
                }
            }
            return plainText.toString();
        }
    }
}
