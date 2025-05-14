
import java.util.ArrayList;

class stringToBinary{
    ArrayList<String> bin = new ArrayList<>();
    public ArrayList getBinary(String s){
        byte[] b_arr = s.getBytes();
        for(byte b : b_arr){
            this.bin.add(Integer.toBinaryString(b & 255 | 256).substring(1, 9));
        }
        return this.bin;
    }
}
class binaryToASCII{
    int[] binaryIntForm = {128,64,32,16,8,4,2,1};
    public String getASCII(ArrayList<String> binS){
        String binString = "";
        try {
            for (String b : binS) {
                int binSum = 0;
                for(int i=0;i<8;i++){
                    if(b.charAt(i)=='1'){
                        binSum += binaryIntForm[i];
                    }
                }
                binString += (char) binSum;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return binString;
    }
}
class OneTimePad{
    private ArrayList<String> OTpad = new ArrayList();
    public OneTimePad(int length) {
        for(int i=0;i<length;i++){
            String bin = "";
            for(int j=0;j<8;j++){
                if(Math.floor(Math.random()*(100-1)+1) % 2 == 0){
                    bin += "1";
                } else {
                    bin += "0";
                }
            }
            this.OTpad.add(bin);
        }
    }
    public ArrayList<String> Cipher(ArrayList<String> binS){
        for (int i=0;i<binS.size();i++) {
            String bin = "";
            for(int j=0;j<8;j++){
                if(OTpad.get(i).charAt(j) == '1'){
                    if(binS.get(i).charAt(j) == '1'){
                        bin+="0";
                    } else {
                        bin+="1";
                    }
                } else {
                    bin += binS.get(i).charAt(j);
                }
            }
            binS.set(i, bin);
        }
        return binS;
    }
    public ArrayList<String> getKey() {
        return OTpad;
    }
}


class tst{
    public static void main(String[] args) {
        String msg = "";
        java.util.Scanner sc = new java.util.Scanner(System.in);
        System.out.println("Please Enter a Message to Encrypt :");
        msg = sc.nextLine();
                System.out.println("Before Encryption : "+msg);
        stringToBinary stb = new stringToBinary();
        binaryToASCII bta = new binaryToASCII();
        OneTimePad otp = new OneTimePad(msg.length());
        ArrayList binStr = stb.getBinary(msg);
        binStr = otp.Cipher(binStr);
        msg = bta.getASCII(binStr);
                System.err.println("After Encryption : "+msg);
        System.out.println("Press 0 to print the private key :");
        int n = sc.nextInt();
        if(n != 0){
            System.exit(0);
        }
        binStr = otp.getKey();
        System.out.println(binStr);
    }
}