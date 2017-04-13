package Algorithmique.majority;

import java.util.Random;

/*................................................................................................................................
 . Copyright (c)
 .
 . The App	 Class was Coded by : Alexandre BOLOT
 .
 . Last Modified : 13/04/17 16:53
 .
 . Contact : bolotalex06@gmail.com
 ...............................................................................................................................*/

public class App
{
    public static void main (String[] args)
    {
        Random random = new Random();
        FindMajority<Integer> findMajority = new FindMajority<Integer>();
        
        for (Integer i = 1000; i <= 1000000; i *= 10)
        {
            long oldt;
            Integer result;
            Integer[] tab = new Integer[]{1,
                                          2,
                                          5,
                                          3,
                                          2,
                                          6,
                                          2,
                                          6,
                                          3,
                                          5,
                                          2,
                                          6,
                                          2,
                                          6,
                                          10,
                                          10,
                                          10,
                                          10,
                                          10,
                                          10,
                                          10,
                                          10,
                                          10,
                                          10,
                                          10,
                                          10,
                                          10,
                                          10,
                                          10,
                                          10,
                                          10,
                                          10,
                                          10};
    
            //            for (Integer j = 0; j <= tab.length - 1; j++)
            //            {
            //                tab[j] = random.nextInt();
            //            }
            //
            //            oldt = System.nanoTime();
            //            result = findMajority.AlgorithmeNaif(tab);
            //            System.out.println(i + "\tNaif :\t\t" + (System.nanoTime() - oldt) + "\t" + result);
            //
            //            for (Integer j = 0; j <= tab.length - 1; j++)
            //            {
            //                tab[j] = random.nextInt();
            //            }
            //
            //            oldt = System.nanoTime();
            //            result = findMajority.TableauCompteur(tab);
            //            System.out.println(i + "\tHashMap :\t" + (System.nanoTime() - oldt) + "\t" + result);
            //
            //            for (Integer j = 0; j <= tab.length - 1; j++)
            //            {
            //                tab[j] = random.nextInt();
            //            }
            
            oldt = System.nanoTime();
            result = findMajority.DiviserPourMieuxRegner(tab);
            System.out.println(i + "\tDiviser :\t" + (System.nanoTime() - oldt) + "\t" + result);
            
            System.out.println("");
        }
    }
}