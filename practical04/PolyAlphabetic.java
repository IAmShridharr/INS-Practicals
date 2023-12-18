package practical04;

import java.util.Scanner;

public class PolyAlphabetic {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        String p;
        StringBuilder c = new StringBuilder();
        StringBuilder k;
        String l = "abcdefghijklmnopqrstuvwxyz";
        System.out.print("Give the plain text: "); // abcdefghijklmnopqrstuvwxyz
        p = sc.nextLine();
        System.out.print("Give the Key: "); // e.g. d
        k = new StringBuilder(sc.nextLine());
        int ky = k.length();
        int pln = p.length();
        String y = k.toString();
        int m = pln % ky;
        k.append(y.repeat(Math.max(0, pln / ky - 1)));
        k.append(k.substring(0, m));
        for(int j = 0; j < pln; j++) {
            c.append(l.charAt((l.indexOf(k.charAt(j)) + l.indexOf(p.charAt(j))) % 26));
        }
        c = new StringBuilder(c.toString().toUpperCase());
        System.out.println("Cipher text: " + c);
        c = new StringBuilder(c.toString().toLowerCase());
        StringBuilder pl = new StringBuilder();
        for(int r = 0; r < pln; r++) {
            pl.append(l.charAt(((l.indexOf(c.charAt(r)) - l.indexOf(k.charAt(r))) + 26) % 26));
        }
        System.out.print("DeCiphertext: " + pl);
        sc.close();
    }
}
