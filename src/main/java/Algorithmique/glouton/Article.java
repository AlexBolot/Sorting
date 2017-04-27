package Algorithmique.glouton;

import java.util.Comparator;

/*................................................................................................................................
 . Copyright (c)
 .
 . The Article	 Class was Coded by : Alexandre BOLOT
 .
 . Last Modified : 27/04/17 16:06
 .
 . Contact : bolotalex06@gmail.com
 ...............................................................................................................................*/

class Article
{
    public static final Comparator<Article> DescValComparator = new Comparator<Article>()
    {
        public int compare (Article o1, Article o2)
        {
            return o2.value - o1.value;
        }
    };
    
    public static final Comparator<Article> CroiWeiComparator = new Comparator<Article>()
    {
        public int compare (Article o1, Article o2)
        {
            return o1.weight - o2.weight;
        }
    };
    
    public static final Comparator<Article> RatioComparator = new Comparator<Article>()
    {
        public int compare (Article o1, Article o2)
        {
            return (o2.value / o2.weight) - (o1.value / o1.weight);
        }
    };
    
    String name;
    int    value;
    int    weight;
    
    public Article (int weight, int value, String name)
    {
        this.weight = weight;
        this.value = value;
        this.name = name;
    }
}
