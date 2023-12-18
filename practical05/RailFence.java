package practical05;

import java.util.Scanner;

public class RailFence {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the plain text: "); // e.g. Shridhar
        String str = sc.nextLine();
        StringBuilder output = new StringBuilder();
        int len = str.length(); // Flag = 0 (if applicable)
        System.out.println("Input String: " + str);
        for(int i = 0; i < len; i += 2) {
            output.append(str.charAt(i));
        }
        for(int i = 1; i < len; i += 2) {
            output.append(str.charAt(i));
        }
        System.out.println("Cipher text: " + output);
        sc.close();
    }
}