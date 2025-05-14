package classes;

import java.util.ArrayList;

public class binaryToASCII{
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
