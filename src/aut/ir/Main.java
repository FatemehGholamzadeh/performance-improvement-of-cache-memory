package aut.ir;
import WorkWithCache.*;
import Address.WriteToFile;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        int determination=0;
        float justDMCacheHR=0;
        float twoCacheHR=0;

        WriteToFile write_to_file = new WriteToFile();
        write_to_file.write();

        DirectMappedCache dmc;
        determination =0;
        dmc = new DirectMappedCache(determination);
        for (int i = 0; i < 5; i++) {
            ReadFile rf = new ReadFile("out"+i+".txt");
            for (int j = 0; j < rf.addressInfo.data.size(); j++) {
                dmc.isValid(rf.addressInfo.data.get(j));
            }
            if(determination==1) {
                twoCacheHR += dmc.getHitRatio();
            }
            else if(determination==0) {
                justDMCacheHR += dmc.getHitRatio();
                if(i==4){
                    determination++;
                    i=-1;
                }
            }
            dmc=new DirectMappedCache(determination);

        }
        System.out.println();
        System.out.println("average hit ratio for direct mapped cache : " + justDMCacheHR/5);
        System.out.println("average hit ratio for direct mapped cache and victim cache : " + twoCacheHR/5);

    }

}

