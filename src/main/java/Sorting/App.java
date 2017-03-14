package Sorting;

import java.util.Random;

/**
 Hello world!
 */
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
        
            oldt = System.nanoTime();
            Sorting.MaxTriSelection(tab);
            System.out.println(i + "\tMaxSelection :\t" + (System.nanoTime() - oldt));
        
            oldt = System.nanoTime();
            Sorting.MaxTriFusion(tab);
            System.out.println(i + "\tMaxFusion :\t\t" + (System.nanoTime() - oldt) + "\n");
        }
    }
}