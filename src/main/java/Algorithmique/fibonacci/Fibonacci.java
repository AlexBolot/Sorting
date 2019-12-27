package Algorithmique.fibonacci;

import java.math.BigInteger;

/*................................................................................................................................
 . Copyright (c)
 .
 . The Fibonacci	 Class was Coded by : Alexandre BOLOT
 .
 . Last Modified : 27/12/2019 12:59
 .
 . Contact : bolotalex06@gmail.com
 ...............................................................................................................................*/

public class Fibonacci {
    public static BigInteger algorithmeNaif(int index) {
        if (index == 0) return BigInteger.valueOf(0);
        if (index == 1) return BigInteger.valueOf(1);

        return algorithmeNaif(index - 1).add(algorithmeNaif(index - 2));
    }

    public static BigInteger memoise(int index) {
        BigInteger[] tab = new BigInteger[index];

        for (int i = 0; i < tab.length; i++) {
            tab[i] = BigInteger.valueOf(-1);
        }

        return memoiseRecursif(tab, index);
    }

    private static BigInteger memoiseRecursif(BigInteger[] tab, int index) {
        if (index == 0) return BigInteger.valueOf(0);
        if (index == 1) return BigInteger.valueOf(1);

        BigInteger index_1;
        BigInteger index_2;

        boolean exist = !tab[index - 1].equals(BigInteger.valueOf(-1));
        index_1 = exist ? tab[index - 1] : memoiseRecursif(tab, index - 1);

        exist = !tab[index - 2].equals(BigInteger.valueOf(-1));
        index_2 = exist ? tab[index - 2] : memoiseRecursif(tab, index - 2);

        return index_1.add(index_2);
    }

    public static BigInteger lineaire(int index) {
        BigInteger k = BigInteger.valueOf(0);
        BigInteger l = BigInteger.valueOf(1);
        BigInteger result = BigInteger.valueOf(0);

        if (index == 1) return BigInteger.valueOf(1);

        for (int i = 2; i <= index; i++) {
            result = k.add(l);
            k = l;
            l = result;
        }

        return result;
    }

}