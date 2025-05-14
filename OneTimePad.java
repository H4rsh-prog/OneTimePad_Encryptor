package classes;

import java.util.ArrayList;

public class OneTimePad{
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
