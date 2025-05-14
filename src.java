
import static javax.swing.JOptionPane.showInputDialog;

import java.util.ArrayList;

import classes.OneTimePad;
import classes.binaryToASCII;
import classes.stringToBinary;

class EncCiph{
    private ArrayList<String> binStr = new ArrayList<>();
    ArrayList<String> EncBinStr = new ArrayList<>();
    private String Encr_String = "";
    private OneTimePad PrivateKey;
    public EncCiph(String s) {
        this.PrivateKey = new OneTimePad(s.length());
        this.EncBinStr = this.PrivateKey.Cipher(new stringToBinary().getBinary(s));
        this.Encr_String = new binaryToASCII().getASCII(this.EncBinStr);
        this.binStr = this.PrivateKey.getKey();
    }
    public ArrayList<String> getPrivateKey() {
        return this.binStr;
    }
    public String getEncr_String(){
        return Encr_String;
    }
    public String Decrypt(){
        this.Encr_String = new binaryToASCII().getASCII((this.PrivateKey.Cipher(this.EncBinStr)));
        return Encr_String;
    }
}

class run {
    public static void main(String[] args) {
        String msg = showInputDialog("Enter a Message to Encrypt");
        EncCiph ec = new EncCiph(msg);
        System.out.println("MESSAGE BEFORE ENCRYPTION :\n"+msg+"\n");
        System.out.println("PLAINTEXT CONVERTED TO BINARY :\n"+new stringToBinary().getBinary(msg)+"\n");
        System.out.println("PRIVATE KEY : \n"+ec.getPrivateKey()+"\n");
        System.out.println("CIPHERED BINARY : \n"+ec.EncBinStr+"\n");
        System.out.println("CIPHERTEXT CONVERTED TO ASCII : \n"+ec.getEncr_String()+"\n");
        System.out.println("CIPHERTEXT CONVERTED BACK TO PLAINTEXT : \n"+ec.Decrypt()+"\n");
    }
}
