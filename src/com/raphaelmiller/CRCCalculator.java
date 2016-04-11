package com.raphaelmiller;

/**
 * Created by raphael on 4/6/16.
 */
public class CRCCalculator {

    public void enter(StringBuilder bin4bitString) {

//        String[] builderToken = bin4bitString.toString().split("\\s+");
//
//        String[] merge32 = new String[500];
//        StringBuilder mergeBuilder = new StringBuilder();
//
//        char[] bitTokens = bin4bitString.toString().toCharArray();
//
//        int mergePosition = 0;
//        for(int i = 0; i < bitTokens.length; i++){
//            if(bitTokens[i] == ' '){
//                i++;
//            }
//            if(merge32[mergePosition].length() == 32){
//                mergePosition++;
//            }
//            mergeBuilder.append(bitTokens[i]);
//            merge32[mergePosition] = mergeBuilder.toString();
//        }
//        for(int i = 0; i < merge32.length; i++){
//            System.out.println(merge32[i]);
//        }
//todo fix this problem to merge the string into 32 bit segments
    }

    private void merge32bit() {
    }

    private void calculate(String messagebit32, String polynomialBits){
        //messagebit32 = 32 bits, polynomialbits = 17 bits

        //messagebit32 is padded by 16 bits

        //tester variable
        messagebit32 = "1111 1111 1111 1111 1111 1111 1111 1111";


    }
}
