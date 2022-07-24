
import java.math.BigInteger;
import java.util.HashMap;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Saka
 */
public class Convert {
    //function create convertTable 2 to 16 or 16 to 2
    public void putHashMap(HashMap<String, String> convertTable) {
        convertTable.put("0000", "0");
        convertTable.put("0001", "1");
        convertTable.put("0010", "2");
        convertTable.put("0011", "3");
        convertTable.put("0100", "4");
        convertTable.put("0101", "5");
        convertTable.put("0110", "6");
        convertTable.put("0111", "7");
        convertTable.put("1000", "8");
        convertTable.put("1001", "9");
        convertTable.put("1010", "A");
        convertTable.put("1011", "B");
        convertTable.put("1100", "C");
        convertTable.put("1101", "D");
        convertTable.put("1110", "E");
        convertTable.put("1111", "F");
    }
    
    //function convert binary number to other number 
    public String convertBinarytOther(HashMap<String, String> convertTable) {
        GetInput input = new GetInput();
        System.out.println("---- Convert binary number to 10 or 16 ----");
        System.out.println("1. Conver to 10");
        System.out.println("2. Convert to 16");
        int choice = input.getIntLimit("Enter your choice: ", 1, 2);
        String inputBin = input.getInputBinary("Enter binary number: ");
        String result = "";
        switch (choice) {
            case 1:
                BigInteger sumValue = new BigInteger("0");
                BigInteger bin = new BigInteger("2");
                BigInteger temp;
                for (int i = 0; i < inputBin.length(); i++) {
                    if (inputBin.charAt(i) == '1') {
                        temp = bin.pow(inputBin.length() - 1 - i);
                        sumValue = sumValue.add(temp);
                    }
                }
                result = sumValue.toString();
                System.out.print("Decimal number: ");
                System.out.println(result);
                break;
            case 2:
                while (inputBin.length() % 4 != 0) {
                    inputBin = "0" + inputBin;
                }
                for (int i = 0; i < inputBin.length(); i += 4) {
                    String key = inputBin.substring(i, i + 4);
                    result += convertTable.get(key);
                }
                System.out.print("Hexadecimal number: ");
                System.out.println(result);
                break;
        }
        return result;
    }
    //function convert decimal number to other number 
    public String convertDecimaltOther() {
        GetInput input = new GetInput();
        System.out.println("---- Convert decimal number to 2 or 16 ----");
        System.out.println("1. Convert to 2");
        System.out.println("2. Convert to 16");
        int choice = input.getIntLimit("Enter your choice: ", 1, 2);
        String inputDec = input.getInputDecimal("Enter decimal number: ");
        BigInteger number = new BigInteger(inputDec);
        BigInteger temp;
        String sumValue = "";
        String result = "";
        switch (choice) {
            case 1:
                BigInteger bin = new BigInteger("2");
                while (!number.equals(new BigInteger("0"))) {
                    temp = number.mod(bin);
                    sumValue += temp;
                    number = number.divide(bin);
                }
                for (int i = sumValue.length() - 1; i >= 0; i--) {
                    result += sumValue.charAt(i);
                }
                System.out.print("Binary number: ");
                System.out.println(result);
                break;
            case 2:
                BigInteger hex = new BigInteger("16");
                char value;
                while (!number.equals(new BigInteger("0"))) {
                    temp = number.mod(hex);
                    if (temp.compareTo(new BigInteger("10")) < 0) {
                        value = (char) (temp.intValue() + 48);
                        sumValue += value;
                    } else {
                        value = (char) (temp.intValue() + 55);
                        sumValue += value;
                    }
                    number = number.divide(hex);
                }
                for (int i = sumValue.length() - 1; i >= 0; i--) {
                    result += sumValue.charAt(i);
                }
                System.out.print("Hexadecimal number: ");
                System.out.println(result);
                break;
        }
        return result;
    }
    //function convert hexadecimal number to other number
    public String convertHexadecimaltOther(HashMap<String, String> convertTable) {
        GetInput input = new GetInput();
        System.out.println("---- Convert hexadecimal number to 2 or 10 ----");
        System.out.println("1. Convert to 2");
        System.out.println("2. Convert to 10");
        int choice = input.getIntLimit("Enter your choice: ", 1, 2);
        String inputHex = input.getInputHexadecimal("Enter hexadecimal number: ");
        String result = "";
        switch (choice) {
            case 1:
                HashMap<String, String> reversedHashMap = new HashMap<>();
                for (String key : convertTable.keySet()) {
                    reversedHashMap.put(convertTable.get(key), key);
                }
                for (int i = 0; i < inputHex.length(); i++) {
                    String key = Character.toString(inputHex.charAt(i));
                    result += reversedHashMap.get(key);
                }
                System.out.print("Binary number: ");
                System.out.println(result);
                break;
            case 2:
                BigInteger temp;
                BigInteger sumValue = new BigInteger("0");
                BigInteger hex = new BigInteger("16");
                String hstring = "0123456789ABCDEF";
                for (int i = 0; i < inputHex.length(); i++) {
                    int digit = hstring.indexOf(Character.toString(inputHex.charAt(i)));
                    BigInteger stringDigit = new BigInteger(Integer.toString(digit));
                    temp = stringDigit.multiply(hex.pow(inputHex.length() - 1 - i));
                    sumValue = sumValue.add(temp);
                }
                result = sumValue.toString();
                System.out.print("Decimal number: ");
                System.out.println(result);
                break;
        }
        return result;
    }

}
