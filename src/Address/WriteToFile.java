package Address;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;


public class WriteToFile {

    public void write() throws IOException {
        for (int i = 0; i < 5; i++) {
            MakeAddress make_address = new MakeAddress();
            ArrayList<String> addresses = make_address.produce();

            BufferedWriter writer = new BufferedWriter(new FileWriter("out" + i + ".txt"));
            for (String str : addresses) {
                writer.write(str);
                writer.newLine();
            }
            writer.close();
        }

    }
}
