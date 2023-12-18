package practical12;

import java.util.Scanner;
import java.math.BigInteger;

public class RSA {
        public static void main(String[] args) {
            BigInteger p, q, E, D, n, P, Q; // one is deleted
            Scanner s = new Scanner(System.in);
            Scanner t = new Scanner(System.in);
            System.out.print("Enter A's prime number: "); // e.g. 7
            p = s.nextBigInteger();
            System.out.print("Enter B's prime number: "); // e.g. 17
            q = s.nextBigInteger();
            n = p.multiply(q);
            P = p.subtract(BigInteger.ONE);
            Q = q.subtract(BigInteger.ONE);
            int x = 0;
            do {
                System.out.print("Enter Public key: "); // e.g. 5
                E = s.nextBigInteger();
                if(((P.gcd(E)).equals(BigInteger.ONE))&&((Q.gcd(E)).equals(BigInteger.ONE))) {
                    x++;
                }
            } while(x == 0);
            for(int i = 1; ; i++) {
                D = new BigInteger(String.valueOf(i));
                if(((D.multiply(E)).mod(P.multiply(Q))).equals(BigInteger.ONE)) {
                    break;
                }
            }
            System.out.print("Enter Plain text: "); // e.g. Shridhar
            StringBuilder in = new StringBuilder();
            StringBuilder out = new StringBuilder();
            String text = t.nextLine();
            for(int i = 0; i < text.length(); i++){
                BigInteger T = new BigInteger(String.valueOf((int)(text.charAt(i)))), O, TF;
                O = T.modPow(E,n);
                out.append((char) O.intValue());
                TF = O.modPow(D,n);
                in.append((char) TF.intValue());
            }
            System.out.println("Encrypted text: " + out);
            System.out.println("Decrypted text: " + in);
            s.close();
            t.close();
        }
}