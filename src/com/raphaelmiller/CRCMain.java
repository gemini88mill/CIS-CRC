/**
 * Program Description and Copyright
 * CIS3360 - Security in Computing Spring 2016
 * CRC Calculator:
 *      Program Description:
 *      Write a program that calculates the CRC-16 of a given file and appends it to the end of the same file.
 *      Your program must also be able to verify the correctness of a given file that already has CRC appended
 *      at the end. Use the CRC polynomial x^16 + x^10 + x^8 + x^7 + x^3 + 1.
 *
 *      By: Raphael Miller and a dangerous amount of coffee コーヒー！！！
 */

package com.raphaelmiller;


import java.io.*;
import java.nio.ByteBuffer;
import java.util.Scanner;

public class CRCMain {

    public static final String POLYNOMIAL_BIN_VALUE = "10000010110001001";
    public static final int POLY_LENGTH = 17;
    public static final int PAD = 16;

    // CRC polynomial = "x16 + x10 + x8 + x7 + x3 + 1"
    //CRC polynomial conversion = 1000 0010 1100 0100 1

    private File CRCFileHex;
    private StringBuilder bin4bitString;
    private String binString;





    public static void main(String[] args) {
	// write your code here

        int mainMenuChoice = 0;

        CRCMain crcMain = new CRCMain();



        //calculator.enter(new StringBuilder());


        //accept file and file existence checker.
        File CRCFile = crcMain.acceptFileName();
        crcMain.setCRCFileHex(CRCFile);

        //menu generator
        crcMain.generateMenu(); //menu generator. Only prints to screen :)

        //System.in input for menu choice.
        mainMenuChoice = crcMain.acceptMenuInput(); //accepts menu input

        //starts the file output (hex and bin) thread
        StringBuilder CRCHex = crcMain.printCRCFileHex();
        String binString = crcMain.printCRCFileBin(CRCHex);
        crcMain.setBinString(binString);

        //System.out.println("\n" + crcMain.getBinString());


        //choice switch
        crcMain.crcMenuSwitch(mainMenuChoice); //switch method for main menu

        //utilities testers.




        //System.out.println(mainMenuChoice);

    }

    /**
     * crcMenuSwitch
     * @param mainMenuChoice
     */
    private void crcMenuSwitch(int mainMenuChoice) {



        //System.out.println(mainMenuChoice); //verified menu option.
        switch (mainMenuChoice){
            case 1:
                //calculate CRC selected
                CRCCalculate();
                break;
            case 2:
                //Verify CRC selected

                break;
            case 3:
                //Exit selected 
                exitFunction();
                break;
            case 4:
                //easter egg (if enough time)
                break;
            default:
                //invalid number go to menu
                System.out.println("Invalid Choice...");
                generateMenu();
                break;
        }

    }

    /**
     * 
     */
    private void CRCCalculate() {
        //calculates CRC
        String binString = getBinString();
        String poly = POLYNOMIAL_BIN_VALUE;
        String register = "0000000000000000";

        //binString = binString + register;

        int binVal = Integer.parseInt(binString, 2);
        int polyVal = Integer.parseInt(poly, 2);
        int emptyRegister = Integer.parseInt(register, 2);

        binVal = binVal << 16;

        byte[] CRCArray = ByteBuffer.allocate(binString.length()).putInt(binVal).array();
        byte[] polyArray = ByteBuffer.allocate(POLY_LENGTH).putInt(polyVal).array();
        byte[] registerBytes = {0, 0};
        byte pop;

        int top = 0;

        while (top < CRCArray.length - 1) {
            CRCArray[top] = registerBytes[1];
            registerBytes[0] = registerBytes[1];
            pop = registerBytes[0];

            if (pop != 0) {
                registerBytes[0] = (byte) (registerBytes[0] ^ polyArray[0]);
                registerBytes[1] = (byte) (registerBytes[1] ^ polyArray[1]);
            }
            top++;
            //System.out.println(CRCArray[top]);
        }
        StringBuilder hexResult;
        for (int i = 0; i < CRCArray.length; i++){
            System.out.println(CRCArray[i]);
        }

        //System.out.println((String.format("%016d", binVal)));


    }

    /**
     * printCRCFileHex() - method that returns a StringBuilder of the hex value from a file
     *
     *
     * @return StringBuilder
     */
    private StringBuilder printCRCFileHex() {
        //prints out the CRC file onto output.

        //getfile
        File CRCFile = getCRCFileHex();
        String line = null;
        StringBuilder CRCblock = new StringBuilder();
        int c;

        try {
            FileReader CRCReader = new FileReader(CRCFile.getName());
            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(CRCFile)));

            while((line = br.readLine()) != null){
                System.out.print("The Input File (Hex): ");
                System.out.println(line);
                //prints out the entire file (original)
                CRCblock.append(line);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return CRCblock;
    }

    /**
     * printCRCFileBin() - takes a hex String and converts to binary, and prints out binary representation.
     * returns String of binary.
     *
     * @param CRCHex
     * @return String
     */
    private String printCRCFileBin(StringBuilder CRCHex){
        //accepts a hex string and turns it into a bin string
//        BigInteger hexvalue = new BigInteger(CRCHex.toString(), 16);
//        System.out.println(hexvalue.toString(2));
        StringBuilder binString = new StringBuilder();


        System.out.println("The Input File(Bin): ");
        char[] hexSplitter = CRCHex.toString().toCharArray();
        for(int i = 0; i < hexSplitter.length; i++) {

            if((i % 8) == 0 && i != 0){
                System.out.println();

            }
            int binHold = Integer.parseInt(Character.toString(hexSplitter[i]),16);
            binString.append(String.format("%04d", Integer.parseInt(Integer.toBinaryString(binHold))));
            //binString.append(" ");
            System.out.print(String.format("%04d", Integer.parseInt(Integer.toBinaryString(binHold))) + " ");
            //System.out.print(binString + " ");

        }

        System.out.println();



        //System.out.println(binString + "done");
        return binString.toString();
    }





    /**
     * exitFunction - Safe program exit
     */
    private void exitFunction() {
        System.out.println("cleaning up...");
        //todo clean up functions go here.
        System.out.println("shutting down...");
        //todo any other safe exit functions go here.
        System.exit(0);
    }

    /**
     * acceptMenuInput() - Input for menu select
     * @return
     */
    private int acceptMenuInput() {
        int menuSelect = 0;

        Scanner scan = new Scanner(System.in);

        while(!scan.hasNextInt()){
            System.out.println("Not a valid option please choose from menu above");
            scan.next();
        }
        return scan.nextInt();
    }


    /**
     * generateMenu() - generates the menu for program.
     *      program functions include
     *      1. Calculate CRC
     *      2. Verify CRC
     *      3. Exit
     */
    private void generateMenu() {

        System.out.println("------------Menu------------------");
        System.out.println("1. Calculate CRC");
        System.out.println("2. Verify CRC");
        System.out.println("3. Exit");
        System.out.println("Choose from the above menu");
    }

    private File acceptFileName(){
        String CRCFileName = null;
        boolean fileIsValid = false;

        System.out.println("Enter the name of the file you want to check:");
        Scanner scan = new Scanner(System.in);
        File CRCFile = null;
        FileReader CRCFileReader = null;


            CRCFileName = scan.next();
            //System.out.println(CRCFileName);
            CRCFile = new File(CRCFileName);
            try {
                CRCFileReader = new FileReader(CRCFile);
                CRCFileReader.read();
            } catch (IOException e) {
                System.err.println("Error: Incorrect file path or file cannot be read");
                acceptFileName();
            }
        //return file
        return CRCFile;
    }

    //--------------------------getters and setters-------------------------------------------------------


    public File getCRCFileHex() {
        return CRCFileHex;
    }

    public void setCRCFileHex(File CRCFileHex) {
        this.CRCFileHex = CRCFileHex;
    }

    public StringBuilder getBin4bitString() {
        return bin4bitString;
    }

    public void setBin4bitString(StringBuilder bin4bitString) {
        this.bin4bitString = bin4bitString;
    }

    public String getBinString() {
        return binString;
    }

    public void setBinString(String binString) {
        this.binString = binString;
    }
}
