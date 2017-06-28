package Algorithmique.glouton;

import java.util.ArrayList;

/*................................................................................................................................
 . Copyright (c)
 .
 . The Glouton	 Class was Coded by : Alexandre BOLOT
 .
 . Last Modified : 28/06/17 17:22
 .
 . Contact : bolotalex06@gmail.com
 ...............................................................................................................................*/

public class Glouton
{
    public static ArrayList<Article> ValDesc (ArrayList<Article> articles, int maxWeight)
    {
        articles.sort(Article.DescValComparator);
        return addToBag(articles, maxWeight);
    }
    
    public static ArrayList<Article> WeiCroi (ArrayList<Article> articles, int maxWeight)
    {
        articles.sort(Article.CroiWeiComparator);
        return addToBag(articles, maxWeight);
    }
    
    public static ArrayList<Article> Ratio (ArrayList<Article> articles, int maxWeight)
    {
        articles.sort(Article.RatioComparator);
        return addToBag(articles, maxWeight);
    }
    
    private static ArrayList<Article> addToBag (ArrayList<Article> articles, int maxWeight)
    {
        ArrayList<Article> sacADos = new ArrayList<>();
        int weightSacADos = 0;
        
        for (Article article : articles)
        {
            System.out.println(article.name);
            
            if(weightSacADos + article.weight <= maxWeight)
            {
                sacADos.add(article);
                weightSacADos += article.weight;
            }
        }
        
        System.out.println("");
        
        return sacADos;
    }
    
    public static ArrayList<Article> BruteForce (ArrayList<Article> articles, int maxWeight)
    {
        return backend_BruteForce(articles, maxWeight, articles.size() - 1);
    }
    
    private static ArrayList<Article> backend_BruteForce (ArrayList<Article> articles, int maxWeight, int index)
    {
        ArrayList<Article> sac = new ArrayList<>();
        
        if(index < 0) return sac;
        
        Article article = articles.get(index);
    
        if(articles.get(index).weight > maxWeight)
        {
            sac.addAll(backend_BruteForce(articles, maxWeight, index - 1));
            return sac;
        }
    
        ArrayList<Article> sacAvec = backend_BruteForce(articles, maxWeight - articles.get(index).weight, index - 1);
        int valueAvec = article.value + totalValueOf(sacAvec);
    
        ArrayList<Article> sacSans = backend_BruteForce(articles, maxWeight, index - 1);
        int valueSans = totalValueOf(sacSans);
    
        if(valueAvec > valueSans)
        {
            sac.addAll(sacAvec);
            sac.add(article);
        }
        else sac.addAll(sacSans);
        
        return sac;
    }
    
    private static int totalValueOf (ArrayList<Article> articles)
    {
        int total = 0;
        
        for (Article article : articles)
        {
            total += article.value;
        }
        
        return total;
    }
}
