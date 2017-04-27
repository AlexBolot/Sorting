package Algorithmique.glouton;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/*................................................................................................................................
 . Copyright (c)
 .
 . The App	 Class was Coded by : Alexandre BOLOT
 .
 . Last Modified : 27/04/17 16:13
 .
 . Contact : bolotalex06@gmail.com
 ...............................................................................................................................*/

public class App
{
    public static void main (String[] args)
    {
        ArrayList<Article> result = Glouton.BruteForce(getArticles("liste_22objets.txt"), 194);
        
        int totalValue = 0;
        
        for (Article a : result)
        {
            System.out.println(a.name);
            totalValue += a.value;
        }
        
        System.out.println(totalValue);
    }
    
    private static ArrayList<Article> getArticles (String pathName)
    {
        ArrayList<Article> articles = new ArrayList<>();
        
        try
        {
            File filePathArticles = new File("src/main/java/Algorithmique/glouton/" + pathName);
            Scanner sLine = new Scanner(filePathArticles);
            
            while (sLine.hasNext())
            {
                int p = sLine.nextInt();
                int v = sLine.nextInt();
                String s = sLine.findInLine("[^ ].*");
                articles.add(new Article(p, v, s));
            }
            sLine.close();
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
        
        return articles;
    }
}
