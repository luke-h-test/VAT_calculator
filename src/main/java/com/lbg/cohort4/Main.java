package com.lbg.cohort4;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {

        ArrayList<Float> prices = new ArrayList<>();
        float VATrate;
        float itemcost;
        String continueChoice;

        Scanner sc = new Scanner(System.in);

        while(true) {
            continuePrompt();
            continueChoice = sc.next();

            if(continueChoice.compareToIgnoreCase("QUIT") == 0)
            {
                break;
            }
            else if(prices.size() == 0)
            {
                VATprompt();
                VATrate = sc.nextFloat();
            }

            priceprompt();
            prices.add(sc.nextFloat());

            for(var item: prices)
            {
                System.out.println(item);
            }

        }


    }

    static public float VATcalculate(float a, float b){
        return a * ((100 + b)/100);
    }

    static private void priceprompt()
    {
        System.out.println("Please enter cost of item before VAT: ");
    }

    static private void VATprompt()
    {
        System.out.println("Please enter the VAT rate %: ");
    }
    static private void results(float cost, float vatRate, float totalPrice) {
        DecimalFormat df = new DecimalFormat("#.##");

        System.out.println("cost of the item: $" + df.format(cost));
        System.out.println("VAT Rate: " + vatRate + "%");
        System.out.println("Total Price: $" + df.format(totalPrice));
    }

    static private void continuePrompt(){
        System.out.println("Press enter to continue entering prices or type QUIT to close the program.");
    }


}