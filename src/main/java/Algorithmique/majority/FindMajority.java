package Algorithmique.majority;

import java.util.HashMap;

/*................................................................................................................................
 . Copyright (c)
 .
 . The FindMajority	 Class was Coded by : Alexandre BOLOT
 .
 . Last Modified : 26/06/17 16:30
 .
 . Contact : bolotalex06@gmail.com
 ...............................................................................................................................*/

@SuppressWarnings({"unchecked", "WeakerAccess"})
public class FindMajority<T>
{
    public T AlgorithmeNaif (T[] table)
    {
        int count = 0;
    
        for (T aTable1 : table)
        {
            for (T aTable : table)
            {
                if(aTable.equals(aTable1)) count++;
            }
    
            if(count > table.length / 2) return aTable1;
        
            count = 0;
        }
        
        return null;
    }
    
    public T TableauCompteur (T[] table)
    {
        if(table.length == 0) return null;
        if(table.length == 1) return table[0];
    
        HashMap<T, Integer> listValues = new HashMap<>();
    
        for (T aTable : table)
        {
            if(listValues.containsKey(aTable))
            {
                listValues.replace(aTable, listValues.get(aTable) + 1);
            }
            else
            {
                listValues.put(aTable, 1);
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
        return Private_Diviser(table, 0, table.length - 1).value;
    }
    
    private CoupleValues Private_Diviser (T[] table, int start, int end)
    {
        if(end - start == 0) return new CoupleValues(table[end], 1);
    
        if(start != end && start >= 0 && end > 0 && end < table.length)
        {
            int middle = (start + end) / 2;
            CoupleValues couple1 = Private_Diviser(table, start, middle);
            CoupleValues couple2 = Private_Diviser(table, middle + 1, end);
            
            int occ1 = couple1.amount + Occurences(couple1.value, table, middle + 1, end);
            int occ2 = couple2.amount + Occurences(couple2.value, table, start, middle);
            
            if(occ1 > table.length / 2 && couple1.amount > 0) return new CoupleValues(couple1.value, occ1);
            if(occ2 > table.length / 2 && couple2.amount > 0) return new CoupleValues(couple2.value, occ2);
        }
        
        return new CoupleValues(null, -1);
    }
    
    private int Occurences (T t, T[] table, int start, int end)
    {
        int occurences = 0;
    
        if(t == null) return occurences;
    
        for (int i = start; i < end; i++)
        {
            if(table[i].equals(t)) occurences++;
        }
    
        return occurences;
    }
    
    private class CoupleValues
    {
        T   value;
        int amount;
        
        private CoupleValues (T value, int amount)
        {
            this.value = value;
            this.amount = amount;
        }
    }
}
