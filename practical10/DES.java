package practical10;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.swing.JOptionPane;

public class DES {
    public static void main(String[] args)throws Exception {
        KeyGenerator keygen = KeyGenerator.getInstance("DES");
        SecretKey secretkey=keygen.generateKey();
        Cipher cip = Cipher.getInstance("DES");
        cip.init(Cipher.ENCRYPT_MODE,secretkey);
        String inputText = JOptionPane.showInputDialog("Give Input:"); // e.g. Shridhar
        byte[] encrypted = cip.doFinal(inputText.getBytes());
        cip.init(Cipher.DECRYPT_MODE,secretkey);
        byte[] decrypted = cip.doFinal(encrypted);
        JOptionPane.showMessageDialog(JOptionPane.getRootFrame(),"Encrypted: " + new String(encrypted) + "\n" + "Decrypted: " + new String(decrypted));
        System.exit(0);
    }
}