package Algorithmique.sorting;

import java.util.Random;

/*................................................................................................................................
 . Copyright (c)
 .
 . The App	 Class was Coded by : Alexandre BOLOT
 .
 . Last Modified : 13/04/17 14:37
 .
 . Contact : bolotalex06@gmail.com
 ...............................................................................................................................*/

public class App
{
    public static void main (String[] args)
    {
        Random random = new Random();
    
        for (int i = 1000; i <= 1000000; i *= 10)
        {
            int[] tab = new int[i];
    
            for (int j = 0; j <= tab.length - 1; j++)
            {
                tab[j] = random.nextInt();
            }
    
            long oldt = System.nanoTime();
            Sorting.MaxLin(tab);
            System.out.println(i + "\tMaxLin :\t\t" + (System.nanoTime() - oldt));
    
            for (int j = 0; j <= tab.length - 1; j++)
            {
                tab[j] = random.nextInt();
            }
            
            oldt = System.nanoTime();
            Sorting.MaxTriSelection(tab);
            System.out.println(i + "\tMaxSelection :\t" + (System.nanoTime() - oldt));
    
            for (int j = 0; j <= tab.length - 1; j++)
            {
                tab[j] = random.nextInt();
            }
            
            oldt = System.nanoTime();
            Sorting.MaxTriFusion(tab);
            System.out.println(i + "\tMaxFusion :\t\t" + (System.nanoTime() - oldt) + "\n");
        }
    }
}