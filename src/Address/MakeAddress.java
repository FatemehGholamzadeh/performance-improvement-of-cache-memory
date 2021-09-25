package Address;
import java.util.ArrayList;
import java.util.Random;

public class MakeAddress {

    private ArrayList<String> numbers;
    private ArrayList<String> addresses;
    private int randomNum;
    private String string;


    public MakeAddress() {
        numbers = new ArrayList();
        addresses = new ArrayList();
    }

    public ArrayList produce() {
        Random random = new Random();
        String binary_number = new String();

        for (int j = 0; j < 100; j++) {
            binary_number = "";
            for (int i = 0; i < 32; i++) {
                randomNum = random.nextInt(10);
                if (randomNum < 5)
                    binary_number += "0";
                else binary_number += "1";
            }
            numbers.add(binary_number);
        }


        for (int j = 0; j < numbers.size(); j++) {

            string = numbers.get(j);
            addresses.add(string);
            for (int i = 0; i < 4; i++) {

                randomNum = random.nextInt(4);

                string = numbers.get(j);

                if (randomNum == 0) {
                    addresses.add(string);
                } else if (randomNum == 1) {
                    if (string.charAt(31) == '0')
                        string = string.substring(0, 31) + '1';
                    else
                        string = string.substring(0, 31) + '0';
                    addresses.add(string);
                } else if (randomNum == 2) {
                    if (string.charAt(30) == '0')
                        string = string.substring(0, 30) + '1' + string.substring(31);
                    else
                        string = string.substring(0, 30) + '0' + string.substring(31);
                    addresses.add(string);
                } else if (randomNum == 3) {
                    if (string.charAt(29) == '0')
                        string = string.substring(0, 29) + '1' + string.substring(30);
                    else
                        string = string.substring(0, 29) + '0' + string.substring(30);
                    addresses.add(string);
                }
            }


        }

        for (int i = 0; i < 100; i++) {
            int j = random.nextInt(498);
            int k = random.nextInt(498);
            for (int l = 0; l < 3; l++) {

                String strtemp = addresses.get(j + l);
                addresses.set((j + l), addresses.get(k + l));
                addresses.set((k + l), strtemp);

            }

        }
        return addresses;

    }


}