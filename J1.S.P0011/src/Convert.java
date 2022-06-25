
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

    public void putHashMap(HashMap<String, String> valueHex) {
        valueHex.put("0000", "0");
        valueHex.put("0001", "1");
        valueHex.put("0010", "2");
        valueHex.put("0011", "3");
        valueHex.put("0100", "4");
        valueHex.put("0101", "5");
        valueHex.put("0110", "6");
        valueHex.put("0111", "7");
        valueHex.put("1000", "8");
        valueHex.put("1001", "9");
        valueHex.put("1010", "A");
        valueHex.put("1011", "B");
        valueHex.put("1100", "C");
        valueHex.put("1101", "D");
        valueHex.put("1110", "E");
        valueHex.put("1111", "F");
    }

    public String convertBinarytOther(HashMap<String, String> valueHex) {
        GetInput input = new GetInput();
        System.out.println("---- Convert binary number to 10 or 16 ----");
        System.out.println("1. Conver to 10");
        System.out.println("2. Convert to 16");
        int choice = input.getIntLimit("Enter your choice: ", 1, 2);
        String inputBin = input.getInputBinary("Enter binary number: ");
        BigInteger sum = new BigInteger("0");
        BigInteger bin = new BigInteger("2");
        String result = "";
        switch (choice) {
            case 1:
                BigInteger value;
                for (int i = 0; i < inputBin.length(); i++) {
                    if (inputBin.charAt(i) == '1') {
                        value = bin.pow(inputBin.length() - 1 - i);
                        sum = sum.add(value);
                    }
                }
                result = sum.toString();
                System.out.print("Decimal number: ");
                System.out.println(result);
                break;
            case 2:
                while (inputBin.length() % 4 != 0) {
                    inputBin = "0" + inputBin;
                }
                for (int i = 0; i < inputBin.length(); i += 4) {
                    String key = inputBin.substring(i, i + 4);
                    result += valueHex.get(key);
                }
                System.out.print("Hexadecimal number: ");
                System.out.println(result);
                break;
//                String decNumber;
//                BigInteger value1;
//                for (int i = 0; i < inputBin.length(); i++) {
//                    if (inputBin.charAt(i) == '1') {
//                        value1 = bin.pow(inputBin.length() - 1 - i);
//                        sum = sum.add(value1);
//                    }
//                }
//                decNumber = sum.toString();
//                BigInteger number = new BigInteger(decNumber);
//                BigInteger hex = new BigInteger("16");
//                BigInteger temp = new BigInteger("0");
//                String count = "";
//                char c;
//                while (!number.equals(new BigInteger("0"))) {
//                    temp = number.mod(hex);
//                    if (temp.compareTo(new BigInteger("10")) < 0) {
//                        c = (char) (temp.intValue() + 48);
//                        count += c;
//                    } else {
//                        c = (char) (temp.intValue() + 55);
//                        count += c;
//                    }
//                    number = number.divide(hex);
//                }
//                for (int i = count.length() - 1; i >= 0; i--) {
//                    result += count.charAt(i);
//                }
//                System.out.print("Hexadecimal number: ");
//                System.out.println(result);
//                break;

        }
        return result;
    }

    public String convertDecimaltOther() {
        GetInput input = new GetInput();
        System.out.println("---- Convert decimal number to 2 or 16 ----");
        System.out.println("1. Convert to 2");
        System.out.println("2. Convert to 16");
        int choice = input.getIntLimit("Enter your choice: ", 1, 2);
        String inputDec = input.getInputDecimal("Enter decimal number: ");
        BigInteger number = new BigInteger(inputDec);
        BigInteger temp = new BigInteger("0");
        String result = "";
        switch (choice) {
            case 1:
                BigInteger bin = new BigInteger("2");
                String cnt = "";
                while (!number.equals(new BigInteger("0"))) {
                    temp = number.mod(bin);
                    cnt += temp;
                    number = number.divide(bin);
                }
                for (int i = cnt.length() - 1; i >= 0; i--) {
                    result += cnt.charAt(i);
                }
                System.out.print("Binary number: ");
                System.out.println(result);
                break;
            case 2:
                BigInteger hex = new BigInteger("16");
                String count = "";
                char c;
                while (!number.equals(new BigInteger("0"))) {
                    temp = number.mod(hex);
                    if (temp.compareTo(new BigInteger("10")) < 0) {
                        c = (char) (temp.intValue() + 48);
                        count += c;
                    } else {
                        c = (char) (temp.intValue() + 55);
                        count += c;
                    }
                    number = number.divide(hex);
                }
                for (int i = count.length() - 1; i >= 0; i--) {
                    result += count.charAt(i);
                }
                System.out.print("Hexadecimal number: ");
                System.out.println(result);
                break;
        }
        return result;
    }

    public String convertHexadecimaltOther(HashMap<String, String> valueHex) {
        GetInput input = new GetInput();
        String hstring = "0123456789ABCDEF";
        System.out.println("---- Convert hexadecimal number to 2 or 10 ----");
        System.out.println("1. Convert to 2");
        System.out.println("2. Convert to 10");
        int choice = input.getIntLimit("Enter your choice: ", 1, 2);
        String inputHex = input.getInputHexadecimal("Enter hexadecimal number: ");
        BigInteger num = new BigInteger("0");
        BigInteger hex = new BigInteger("16");
        BigInteger temp;
        String result = "";
        switch (choice) {
            case 1:
                HashMap<String, String> reversedHashMap = new HashMap<>();
                for (String key : valueHex.keySet()) {
                    reversedHashMap.put(valueHex.get(key), key);
                }
                for (int i = 0; i < inputHex.length(); i++) {
                    String key = Character.toString(inputHex.charAt(i));
                    result += reversedHashMap.get(key);
                }
//                String decNumber;
//                for (int i = 0; i < inputHex.length(); i++) {
//                    int digit = hstring.indexOf(Character.toString(inputHex.charAt(i)));
//                    BigInteger c = new BigInteger(Integer.toString(digit));
//                    temp = c.multiply(hex.pow(inputHex.length() - 1 - i));
//                    num = num.add(temp);
//                }
//                decNumber = num.toString();
//                BigInteger number = new BigInteger(decNumber);
//                BigInteger dec = new BigInteger("2");
//                BigInteger md = new BigInteger("0");
//                String cnt = "";
//                while (!number.equals(new BigInteger("0"))) {
//                    md = number.mod(dec);
//                    cnt += md;
//                    number = number.divide(dec);
//                }
//                for (int i = cnt.length() - 1; i >= 0; i--) {
//                    result += cnt.charAt(i);
//                }
                System.out.print("Binary number: ");
                System.out.println(result);
                break;
            case 2:
                for (int i = 0; i < inputHex.length(); i++) {
                    int digit = hstring.indexOf(Character.toString(inputHex.charAt(i)));
                    BigInteger c = new BigInteger(Integer.toString(digit));
                    temp = c.multiply(hex.pow(inputHex.length() - 1 - i));
                    num = num.add(temp);
                }
                result = num.toString();
                System.out.print("Decimal number: ");
                System.out.println(result);
                break;
        }
        return result;
    }

}
