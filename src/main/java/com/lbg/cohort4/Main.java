package com.lbg.cohort4;

import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {

        float itemcost;
        float VATrate;

        Scanner sc = new Scanner(System.in);

        priceprompt();
        itemcost = sc.nextFloat();
        VATprompt();
        VATrate = sc.nextFloat();


    }

    static private void priceprompt()
    {
        System.out.println("Please enter cost of item before VAT: ");
    }

    static private void VATprompt()
    {
        System.out.println("Please enter the VAT rate %: ");
    }
}