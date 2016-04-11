package com.raphaelmiller;

import java.math.BigInteger;
import java.util.BitSet;

/**
 * Created by raphael on 4/6/16.
 *
 * Utilities Class
 *
 * Class that holds misc functions that that program can use.
 */
public class Utilities {

    BitSet bits = new BitSet(16);

    /**
     * convertHextoBin() - Converts a hexadecimal value into a binary representation of that value.
     * @param hexVal
     * @return
     */
    public String convertHextoBin(String hexVal){
        //convert String hex to bin String
        Integer hexRep = Integer.decode("0x" + hexVal);
        hexVal = Integer.toBinaryString(hexRep);
        return hexVal;
    }

    /**
     * convertBinToHex() - Converts binary value into its hexadecimal representation.
     * @param binVal
     * @return
     */
    public String convertBinToHex(String binVal){
        int decimal = Integer.parseInt(binVal, 2);
        return Integer.toString(decimal, 16);
    }

    public String exclusiveOr(String bin1, String bin2){
        String xorResult = null;
        BigInteger firstVal = new BigInteger(bin1, 2);
        BigInteger secondVal = new BigInteger(bin2, 2);

        BigInteger finalVal = firstVal.xor(secondVal);
        System.out.println(finalVal.toString(2));

        return finalVal.toString(2);
    }

    public char[] StringBreaker(String line){
        return line.toCharArray();
    }

    public String leftpad(String s, int n){
        return String.format("%1$" + n + "s", s).replace(' ', '0');
    }

    public String rightpad(String s, String regex){
        return String.format(regex, s).replace(" ", "0");
    }

}
