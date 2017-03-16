package Sorting;

@SuppressWarnings("ALL")
public class Sorting
{
    public static int MaxLin (int[] table)
    {
        int maxValue = table[0];
    
        for (int i = 1; i < table.length; i++)
        {
            if(maxValue < table[i]) maxValue = table[i];
        }
        
        return maxValue;
    }
    
    public static int MaxTriSelection (int[] table)
    {
        return TriSelection(table)[table.length - 1];
    }
    
    public static int[] TriSelection (int[] table)
    {
        int minValue = 0;
        int i = 0;
        int j = 0;
        
        for (i = 0; i < table.length - 1; i++)
        {
            minValue = i;
    
            for (j = i + 1; j < table.length; j++)
            {
                if(table[j] < table[minValue]) minValue = j;
            }
            
            int temp = table[i];
            table[i] = table[minValue];
            table[minValue] = temp;
        }
        
        return table;
    }
    
    public static int MaxTriFusion (int[] table)
    {
        if(table.length > 1)
        {
            return TriFusion(table, 0, table.length - 1)[table.length - 1];
        }
        else
        {
            return -1;
        }
    }
    
    public static int[] TriFusion (int[] table, int from, int to)
    {
        if(from != to)
        {
            int[] tab1 = TriFusion(table, from, (from + to) / 2);
            int[] tab2 = TriFusion(table, (from + to) / 2 + 1, to);
            return Fusion(tab1, tab2);
        }
        
        return new int[]{table[0]};
    }
    
    public static int[] Fusion (int[] table1, int[] table2)
    {
        int[] newTab = new int[table1.length + table2.length];
        
        for (int i = 0; i < table1.length - 1; i++)
        {
            newTab[i] = table1[i];
        }
        
        for (int i = 0; i < table2.length - 1; i++)
        {
            newTab[table1.length + i] = table2[i];
        }
        
        return TriSelection(newTab);
    }
}