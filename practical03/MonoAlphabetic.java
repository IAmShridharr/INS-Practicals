package practical03;

import java.util.Scanner;

public class MonoAlphabetic {
    public static void main(String[] args) throws IndexOutOfBoundsException {
        char ch, ch1;
        int i, pos;
        String input;
        StringBuilder output = new StringBuilder();
        Scanner sc = new Scanner(System.in);
        String plainText = "abcdefghijklmnopqrstuvwxyz";
        String cipherText = "GHDWVFJEBDHVYUCD";
        System.out.println("PlainText: " + plainText);
        System.out.println("CipherText: " + cipherText);
        System.out.println("Using MonoAlphabetic: ");
        System.out.print("Enter Data To Send: "); // college
        input = sc.nextLine();
        for(i = 0; i < input.length(); i++) {
            ch = input.charAt(i);
            pos = plainText.indexOf(ch);
            ch1 = cipherText.charAt(pos);
            output.append(ch1);
        }
        System.out.println("Output: " + output);
        sc.close();
    }
}
