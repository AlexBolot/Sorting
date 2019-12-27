package Algorithmique.fibonacci;

import java.util.*;

/*................................................................................................................................
 . Copyright (c)
 .
 . The Donnees	 Class was Coded by : Alexandre BOLOT
 .
 . Last Modified : 27/12/2019 12:59
 .
 . Contact : bolotalex06@gmail.com
 ...............................................................................................................................*/

public class Donnees {

    private static long sum(List<Integer> list) {
        long sum = 0;
        for (int i = 0; i < list.size(); i++) {
            sum += list.get(i);
        }
        return sum;
    }

    private static long sumArray(int[] tab) {
        long sum = 0;
        for (int i = 0; i < tab.length; i++) {
            sum += tab[i];
        }
        return sum;
    }

    private static long sumMap(Map<Integer, Integer> hm) {
        long sum = 0;
        for (int i = 0; i < hm.size(); i++) {
            sum += hm.get(i);
        }
        return sum;
    }

    private static long sumSet(Set<Integer> ens) {
        long sum = 0;
        Iterator<Integer> it = ens.iterator();
        while (it.hasNext()) {
            sum += it.next();
        }
        return sum;
    }

    public static void main(String[] args) {
        List<Integer> list;
        Random rand = new Random();
        boolean linkedlist = true;
        boolean arraylist = true;
        boolean tableau = true;
        boolean map = true;
        boolean ensemble = true;
        long somme;
        long debut, fin;
        int[] tab;
        int taille = 100000;
        Map<Integer, Integer> hm;
        Set<Integer> ens;

        if (linkedlist) {
            debut = System.nanoTime();
            list = new LinkedList<>();
            for (int i = 0; i < taille; i++) {
                list.add(rand.nextInt());
            }
            somme = sum(list);
            fin = System.nanoTime();
            System.out.println("LINKEDL = " + somme + "\tTEMPS\t" + (fin - debut) / 1000);
        }

        if (tableau) {
            debut = System.nanoTime();
            tab = new int[taille];
            for (int i = 0; i < taille; i++) {
                tab[i] = rand.nextInt();
            }
            somme = sumArray(tab);
            fin = System.nanoTime();
            System.out.println("TABLEAU = " + somme + "\tTEMPS\t" + (fin - debut) / 1000);
        }

        if (map) {
            debut = System.nanoTime();
            hm = new HashMap<>();
            for (int i = 0; i < taille; i++) {
                hm.put(i, rand.nextInt());
            }
            somme = sumMap(hm);
            fin = System.nanoTime();
            System.out.println("HASHMAP = " + somme + "\tTEMPS\t" + (fin - debut) / 1000);
        }

        if (ensemble) {
            debut = System.nanoTime();
            ens = new TreeSet<>();
            for (int i = 0; i < taille; i++) {
                ens.add(rand.nextInt());
            }
            somme = sumSet(ens);
            fin = System.nanoTime();
            System.out.println("TREESET = " + somme + "\tTEMPS\t" + (fin - debut) / 1000);
        }

        if (arraylist) {
            debut = System.nanoTime();
            list = new ArrayList<>(taille);
            for (int i = 0; i < taille; i++) {
                list.add(rand.nextInt());
            }
            somme = sum(list);
            fin = System.nanoTime();
            System.out.println("ARRAYLI = " + somme + "\tTEMPS\t" + (fin - debut) / 1000);

        }
    }
}
