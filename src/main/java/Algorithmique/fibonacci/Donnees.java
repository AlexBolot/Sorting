package Algorithmique.fibonacci;

import java.util.*;
/*................................................................................................................................
 .
 . The Donnees	 Class was Coded by : Johanna Moulierac
 .
 ...............................................................................................................................*/

/*................................................................................................................................
 . Copyright (c)
 .
 . The Donnees	 Class was Coded by : Alexandre BOLOT
 .
 . Last Modified : 13/04/17 16:13
 .
 . Contact : bolotalex06@gmail.com
 ...............................................................................................................................*/

public class Donnees
{
    
    private static long sum (List<Integer> list)
    {
        long sum = 0;
        for (int i = 0; i < list.size(); i++)
        {
            sum += list.get(i);
            if(i % 100000 == 0)
            {
                //	System.out.println(i);
            }
        }
        return sum;
    }
    
    private static long sumtab (int[] tab)
    {
        long sum = 0;
        for (int i = 0; i < tab.length; i++)
        {
            sum += tab[i];
            if(i % 100000 == 0)
            {
                //	System.out.println(i);
            }
        }
        return sum;
    }
    
    private static long summap (Map<Integer, Integer> hm)
    {
        long sum = 0;
        for (int i = 0; i < hm.size(); i++)
        {
            sum += hm.get(i);
            if(i % 100000 == 0)
            {
                //	System.out.println(i);
            }
        }
        return sum;
    }
    
    private static long sumens (Set<Integer> ens)
    {
        long sum = 0;
        Iterator<Integer> it = ens.iterator();
        while (it.hasNext())
        {
            sum += it.next();
        }
        return sum;
    }
    
    public static void main (String[] args)
    {
        List<Integer> list;
        Random rand = new Random();
        int linkedlist = 1;
        int arraylist = 1;
        int tableau = 1;
        int map = 1;
        int ensemble = 1;
        long somme;
        long debut, fin;
        int[] tab;
        int taille = 100000;
        Map<Integer, Integer> hm;
        Set<Integer> ens;
        
        if(linkedlist == 1)
        {
            debut = System.nanoTime();
            list = new LinkedList<Integer>();
            for (int i = 0; i < taille; i++)
            {
                list.add(rand.nextInt());
            }
            somme = sum(list);
            fin = System.nanoTime();
            System.out.println("LINKEDL = " + somme + "\tTEMPS\t" + (fin - debut) / 1000);
        }
        
        if(tableau == 1)
        {
            debut = System.nanoTime();
            tab = new int[taille];
            for (int i = 0; i < taille; i++)
            {
                tab[i] = rand.nextInt();
            }
            somme = sumtab(tab);
            fin = System.nanoTime();
            System.out.println("TABLEAU = " + somme + "\tTEMPS\t" + (fin - debut) / 1000);
        }
        
        if(map == 1)
        {
            debut = System.nanoTime();
            hm = new HashMap<Integer, Integer>();
            for (int i = 0; i < taille; i++)
            {
                hm.put(i, rand.nextInt());
            }
            somme = summap(hm);
            fin = System.nanoTime();
            System.out.println("HASHMAP = " + somme + "\tTEMPS\t" + (fin - debut) / 1000);
        }
        
        if(ensemble == 1)
        {
            debut = System.nanoTime();
            ens = new TreeSet<Integer>();
            for (int i = 0; i < taille; i++)
            {
                ens.add(rand.nextInt());
            }
            somme = sumens(ens);
            fin = System.nanoTime();
            System.out.println("TREESET = " + somme + "\tTEMPS\t" + (fin - debut) / 1000);
        }
        
        if(arraylist == 1)
        {
            debut = System.nanoTime();
            list = new ArrayList<Integer>(taille);
            for (int i = 0; i < taille; i++)
            {
                list.add(rand.nextInt());
            }
            somme = sum(list);
            fin = System.nanoTime();
            System.out.println("ARRAYLI = " + somme + "\tTEMPS\t" + (fin - debut) / 1000);
            
        }
    }
}
