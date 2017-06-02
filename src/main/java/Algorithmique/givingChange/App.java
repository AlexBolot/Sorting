package Algorithmique.givingChange;

import java.util.Random;

/*................................................................................................................................
 . Copyright (c)
 .
 . The App	 Class was Coded by : Alexandre BOLOT
 .
 . Last Modified : 02/06/17 17:16
 .
 . Contact : bolotalex06@gmail.com
 ...............................................................................................................................*/

public class App
{
    public static void main (String[] args)
    {
        ChangeCalculator calculator = new ChangeCalculator();
        
        int changeToGive = new Random().nextInt(100);
        System.out.println("Change = " + changeToGive);
        
        ChangeCalculator.CoupleValue[] change = calculator.giveChange(changeToGive);
        
        for (int i = change.length - 1; i > 0; i--)
        {
            if(change[i] != null)
            {
                System.out.println(change[i].amount + " x " + change[i].value + "€");
            }
        }
    }
}
