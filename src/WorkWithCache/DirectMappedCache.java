package WorkWithCache;


public class DirectMappedCache {
    public Element[] dmc;
    public int hitNum;
    public VictimCache vc;
    private int determination;

    public DirectMappedCache(int determination) {
        dmc = new Element[256];
        hitNum = 0;
        this.determination=determination;
        if(determination==1){
            vc=new VictimCache();
        }
        else vc=null;
    }

    public float getHitRatio(){
        return (float)hitNum/500;
    }

    public void setAddress(Element ad, int index) {
        dmc[index] = ad;
    }

    public static Element bringBlock(int[] address) {
        int[] tmp = new int[32];
        for (int i = 0; i < 28; i++) {
            tmp[i] = address[i];
        }
        tmp[28] = 0;
        tmp[29] = 0;
        tmp[30] = 0;
        tmp[31] = 0;
        Element tmpElement = new Element();
        tmpElement.data.add(tmp);
        tmp[28] = 0;
        tmp[29] = 0;
        tmp[30] = 0;
        tmp[31] = 1;
        tmpElement.data.add(tmp);
        tmp[28] = 0;
        tmp[29] = 0;
        tmp[30] = 1;
        tmp[31] = 0;
        tmpElement.data.add(tmp);
        tmp[28] = 0;
        tmp[29] = 0;
        tmp[30] = 1;
        tmp[31] = 1;
        tmpElement.data.add(tmp);
        tmp[28] = 0;
        tmp[29] = 1;
        tmp[30] = 0;
        tmp[31] = 0;
        tmpElement.data.add(tmp);
        tmp[28] = 0;
        tmp[29] = 1;
        tmp[30] = 0;
        tmp[31] = 1;
        tmpElement.data.add(tmp);
        tmp[28] = 0;
        tmp[29] = 1;
        tmp[30] = 1;
        tmp[31] = 0;
        tmpElement.data.add(tmp);
        tmp[28] = 0;
        tmp[29] = 1;
        tmp[30] = 1;
        tmp[31] = 1;
        tmpElement.data.add(tmp);
        tmp[28] = 1;
        tmp[29] = 0;
        tmp[30] = 0;
        tmp[31] = 0;
        tmpElement.data.add(tmp);
        tmp[28] = 1;
        tmp[29] = 0;
        tmp[30] = 0;
        tmp[31] = 1;
        tmpElement.data.add(tmp);
        tmp[28] = 1;
        tmp[29] = 0;
        tmp[30] = 1;
        tmp[31] = 0;
        tmpElement.data.add(tmp);
        tmp[28] = 1;
        tmp[29] = 0;
        tmp[30] = 1;
        tmp[31] = 1;
        tmpElement.data.add(tmp);
        tmp[28] = 1;
        tmp[29] = 1;
        tmp[30] = 0;
        tmp[31] = 0;
        tmpElement.data.add(tmp);
        tmp[28] = 1;
        tmp[29] = 1;
        tmp[30] = 0;
        tmp[31] = 1;
        tmpElement.data.add(tmp);
        tmp[28] = 1;
        tmp[29] = 1;
        tmp[30] = 1;
        tmp[31] = 0;
        tmpElement.data.add(tmp);
        tmp[28] = 1;
        tmp[29] = 1;
        tmp[30] = 1;
        tmp[31] = 1;
        tmpElement.data.add(tmp);

        return tmpElement;
    }

    public void isValid(int[] address) {
        int blockNum = intForm(address, 20, 27);
        if (dmc[blockNum] == null) {
            setAddress(bringBlock(address), blockNum);
            return ;
        }
        int blockOffset = intForm(address, 28, 32);
        int[] tmp;
        if ((tmp = dmc[blockNum].data.get(blockOffset)) == null) {
            setAddress(bringBlock(address), blockNum);
            return ;
        }
        int tag1 = intForm(address, 0, 19);
        int tag2 = intForm(tmp, 0, 19);
        if (tag1 != tag2) {
            if(determination==1){
                int index;
                if((index=vc.isValid(address,dmc[blockNum]))!=-1)
                dmc[blockNum]=vc.vc.get(index);
                hitNum++;
                return;
            }
            setAddress(bringBlock(address), blockNum);
            return ;
        }
        hitNum++;
    }

    public static int intForm(int[] add, int i, int k) {
        int out = 0;
        for (int j = 0; j < (k-i); j++) {
            if (add[j] == 1) {
                out += Math.pow(2, k-i-j-1);
            }
        }
        return out;
    }
}
