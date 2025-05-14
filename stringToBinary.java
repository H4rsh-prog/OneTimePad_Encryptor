package classes;

import java.util.ArrayList;

public class stringToBinary{
    ArrayList<String> bin = new ArrayList<>();
    public ArrayList getBinary(String s){
        byte[] b_arr = s.getBytes();
        for(byte b : b_arr){
            this.bin.add(Integer.toBinaryString(b & 255 | 256).substring(1, 9));
        }
        return this.bin;
    }
}
