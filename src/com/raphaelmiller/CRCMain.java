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


import java.util.Scanner;

public class CRCMain {

    public static void main(String[] args) {
	// write your code here

        int mainMenuChoice = 0;

        CRCMain crcMain = new CRCMain();

        crcMain.generateMenu(); //menu generator. Only prints to screen :) 
        mainMenuChoice = crcMain.acceptMenuInput(); //accepts menu input
        crcMain.crcMenuSwitch(mainMenuChoice); //switch method for main menu

        //System.out.println(mainMenuChoice);

    }

    /**
     * crcMenuSwitch
     * @param mainMenuChoice
     */
    private void crcMenuSwitch(int mainMenuChoice) {
        System.out.println(mainMenuChoice); //verified menu option.
        switch (mainMenuChoice){
            case 1:
                //calculate CRC selected
                break;
            case 2:
                //Verify CRC selected
                break;
            case 3:
                //Exit selected 
                exitFunction();
                break;
            case 4:
                break;
            default:
                //invalid number go to menu
                System.out.println("Invalid Choice...");
                generateMenu();
                break;
        }

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
        System.out.println("Enter the name of the file you want to check:");
        System.out.println("------------Menu------------------");
        System.out.println("1. Calculate CRC");
        System.out.println("2. Verify CRC");
        System.out.println("3. Exit");
        System.out.println("Choose from the above menu");
    }
}
