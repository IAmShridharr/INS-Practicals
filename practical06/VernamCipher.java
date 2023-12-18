package practical06;

import java.util.Scanner;

public class VernamCipher {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter The PL Text: "); // Deepak
        String text = input.nextLine();
        int k = text.length();
        char[] arText = text.toCharArray();
        System.out.println("--------------Note-------------");
        System.out.println("Chose Rand");
        System.out.print("Enter The Vernam Cipher: "); // zwpjaq
        String cipher = input.nextLine();
        if(cipher.length()==text.length()) {
            char[] arCipher = cipher.toCharArray();
            char[] encoded = new char[k];
            System.out.print("\nYour PL is: " + text + "\nAfter Encoded: ");
            for(int i = 0; i < arText.length; i++) {
                encoded[i] = (char)(arText[i]^arCipher[i]);
                System.out.print(encoded[i]);
            }
            System.out.print("\nAfter: ");
            for(int i = 0; i < encoded.length; i++) {
                char temp = (char)(encoded[i]^arCipher[i]);
                System.out.print(temp);
            }
        }
        else {
            System.out.print("------INVALID Cipher------\nPlease Check");
        }
        input.close();
    }
}