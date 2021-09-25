package WorkWithCache;

import java.util.ArrayList;

import static WorkWithCache.DirectMappedCache.bringBlock;
import static WorkWithCache.DirectMappedCache.intForm;

/**
 * Created by mahdis on 4/14/2018.
 */
public class VictimCache {
    public ArrayList<Element> vc;


    public VictimCache() {
        vc = new ArrayList<>();
    }

    public void setAddress(Element ad) {
        if(vc.size()>=16){
            vc.remove(0);
        }
        vc.add(ad);
    }

    public int isValid(int[] address,Element addressBlock) {

        if (vc.size() == 0) {
            setAddress(addressBlock);
            return -1;
        }
        int tag1 = intForm(address, 0, 19);
        int tag2;
        for (int i = 0; i < vc.size(); i++) {
            tag2=intForm(vc.get(i).data.get(0), 0, 19);
            if(tag2==tag1){
                vc.remove(i);
                vc.add(addressBlock);
                return i;
            }
        }
        setAddress(addressBlock);
        return -1;
    }
}
