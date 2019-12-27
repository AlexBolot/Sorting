package Algorithmique.glouton;

import java.util.Comparator;

/*................................................................................................................................
 . Copyright (c)
 .
 . The Article	 Class was Coded by : Alexandre BOLOT
 .
 . Last Modified : 27/12/2019 12:59
 .
 . Contact : bolotalex06@gmail.com
 ...............................................................................................................................*/

class Article {
    public static final Comparator<Article> DescValComparator = (o1, o2) -> o2.value - o1.value;

    public static final Comparator<Article> CroiWeiComparator = Comparator.comparingInt(o -> o.weight);

    public static final Comparator<Article> RatioComparator = (o1, o2) -> (o2.value / o2.weight) - (o1.value / o1.weight);

    String name;
    int value;
    int weight;

    public Article(int weight, int value, String name) {
        this.weight = weight;
        this.value = value;
        this.name = name;
    }
}
