package practical11;

public class RC4 {
    String strPlainText;
    static char[] cipher;
    RC4(String strPlainText,int []key) {
        this.strPlainText = strPlainText;
        int[] s = new int[255];
        cipher=new char[strPlainText.length()];
        for(int i = 0; i < s.length; i++) {
            s[i] = i;
        }
        int i = 0;
        int j = 0;
        for(int k = 0; k < strPlainText.length(); k++) {
            int modK = (k % key.length);
            int Kc = key[modK];
            j = (s[i] + j + Kc) % 256 + 1;
            int temp = s[j];
            s[j] = temp;
            int Sc = (s[i] + s[j]) % 256;
            int Ck = s[Sc];
            cipher[k] = (char)(Ck^(int)strPlainText.charAt(k));
            i = i + 1;
        }
    }

    public static void main(String[] args) {
        int[] K = {1, 2, 3, 4, 5};
        String strOriginal = "Shridhar Pandey";
        System.out.println("Original String-------> " + strOriginal);
        new RC4(strOriginal,K);
        for (char c : cipher) {
            System.out.print(c);
        }
    }
}