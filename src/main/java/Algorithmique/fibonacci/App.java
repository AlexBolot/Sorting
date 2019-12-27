package Algorithmique.fibonacci;

/*................................................................................................................................
 . Copyright (c)
 .
 . The App	 Class was Coded by : Alexandre BOLOT
 .
 . Last Modified : 27/12/2019 12:59
 .
 . Contact : bolotalex06@gmail.com
 ...............................................................................................................................*/

public class App {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            System.out.println("AlgoNaif =\t" + Fibonacci.algorithmeNaif(i));
            System.out.println("Memoise =\t" + Fibonacci.memoise(i));
            System.out.println("Lineaire =\t" + Fibonacci.lineaire(i));

            System.out.println();
        }
    }
}