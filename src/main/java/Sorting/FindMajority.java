package Sorting;

import java.util.HashMap;

@SuppressWarnings("unchecked")
public class FindMajority<T>
{
    public T AlgorithmeNaif (T[] table)
    {
        int count = 0;
        
        for (int i = 0; i < table.length; i++)
        {
            for (int j = 0; j < table.length; j++)
            {
                if(table[j].equals(table[i])) count++;
                
                if(count > table.length / 2) return table[i];
            }
        }
        
        return null;
    }
    
    public T TableauCompteur (T[] table)
    {
        HashMap<T, Integer> listValues = new HashMap<T, Integer>();
        
        for (int i = 0; i < table.length; i++)
        {
            if(listValues.containsKey(table[i]))
            {
                listValues.replace(table[i], listValues.get(table[i]) + 1);
            }
            else
            {
                listValues.put(table[i], 1);
            }
        }
        
        for (T t : listValues.keySet())
        {
            if(listValues.get(t) > table.length / 2) return t;
        }
        
        return null;
    }
    
    public T DiviserPourMieuxRegner (T[] table)
    {
        return null;
    }
}
