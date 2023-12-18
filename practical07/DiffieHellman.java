package practical07;

import java.util.Scanner;
import java.math.BigInteger;

public class DiffieHellman {
    final static BigInteger one=new BigInteger("1");
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BigInteger n;
        System.out.print("Enter the first prime no: "); // e.g. 11
        String ans = sc.next();
        n = getNextPrime(ans);
        System.out.print("Enter the second prime no: "); // 7
        BigInteger g = new BigInteger(sc.next());
        System.out.print("Person A, Enter your number now that is random no x: "); // e.g. 3
        BigInteger a = new BigInteger(sc.next());
        BigInteger resultA = g.modPow(a,n);
        System.out.println("Person A sends " + resultA + " to Person B");
        System.out.print("Person B, Enter your number now that is random no y: "); // e.g. 6
        BigInteger b = new BigInteger(sc.next());
        BigInteger resultB = g.modPow(b,n);
        System.out.println("Person B sends " + resultB + " to Person A");
        BigInteger k1 = resultB.modPow(a,n);
        BigInteger k2 = resultA.modPow(b,n);
        System.out.println("A takes " + resultB + " raises it to power " + a + " mod " + n);
        System.out.println("Key A calculates is " + k1 + ".");
        System.out.println("B takes " + resultA + " raises it to power " + b + " mod " + n);
        System.out.println("Key B calculates is " + k2 + ".");
        sc.close();
    }

    public static BigInteger getNextPrime(String ans) {
        BigInteger test = new BigInteger(ans);
        while(!test.isProbablePrime(99)) {
            test = test.add(one);
        }
        return test;
    }
}