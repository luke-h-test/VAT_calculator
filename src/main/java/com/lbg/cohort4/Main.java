package com.lbg.cohort4;

import java.text.DecimalFormat;
import java.util.*;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {

        ArrayList<Float> prices = new ArrayList<>();
        float VATrate = 0;
        float itemcost;
        String continueChoice;

        Scanner sc = new Scanner(System.in);

//        System.out.println(prices[0]);

        while(true) {
            continuePrompt();
            continueChoice = sc.nextLine();
            if(prices.size() > 0)
            {
                continueChoice = sc.nextLine();
            }

            if(continueChoice.equalsIgnoreCase("QUIT"))
            {
                if(prices.size() > 0)
                {
                    printOrder(prices);
                }
                break;
            }
            else if(continueChoice.equalsIgnoreCase(""))
            {
                if(prices.size() == 0)
                {
                    VATprompt();
                    VATrate = sc.nextFloat();
                }

                priceprompt();
                prices.add(sc.nextFloat());

                float totalToDisplay = calculateTotalCost(prices, VATrate);

                System.out.println("The total price including VAT is: £" + totalToDisplay);

            }
            else
            {
                System.out.println("command not recognised");
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

    static private float calculateTotalCost(ArrayList<Float> priceList, float vatRate)
    {
        float priceSum = 0;
        for (var price: priceList)
        {
            priceSum += price;
        }

        return priceSum * (1 + (vatRate/100));
    }

    static private void printOrder(ArrayList<Float> priceList)
    {
        Collections.sort(priceList);
        System.out.print("Current prices entered: ");
        for(var price: priceList)
        {
            System.out.print(price + ", ");
        }
        System.out.println("");
    }


}

class PurchasedItem
{
    private float price;
    private float quantity;
    private float VAT_rate;

    PurchasedItem(float price, float quantity, float VAT_rate)
    {
        this.price = price;
        this.quantity = quantity;
        this.VAT_rate = VAT_rate;
    }

    final float totalPrice()
    {
        return quantity * price * (1 + (VAT_rate/100));
    }

}