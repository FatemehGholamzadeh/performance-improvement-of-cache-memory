package WorkWithCache;

import java.util.ArrayList;

/**
 * Created by mahdis on 4/13/2018.
 */
public class Element {
    public ArrayList<int[]> data;
    public Element(){
        data=new ArrayList<>();
    }
    public void fillData(String line){
      String[] tmp=line.split("");
      int[] address=new int[32];
        for (int i = 0; i < 32; i++) {
            address[i]=Integer.parseInt(tmp[i]);
        }
        data.add(address);
    }
}

