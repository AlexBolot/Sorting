package Algorithmique.hexGame.model.AI.pathFinding;

import Algorithmique.hexGame.model.AI.AIPlayer;
import Algorithmique.hexGame.model.Cell;

import java.awt.*;
import java.util.ArrayList;

/*................................................................................................................................
 . Copyright (c)
 .
 . The AIPathFinding	 Class was Coded by : Alexandre BOLOT
 .
 . Last Modified : 10/06/17 14:53
 .
 . Contact : bolotalex06@gmail.com
 ...............................................................................................................................*/

public class AIPathFinding extends AIPlayer
{
    @Override
    protected Cell getFirstMove ()
    {
        return null;
    }
    
    @Override
    protected Cell getFollowingMove ()
    {
        Cell optimalCell = getPotentialCells().get(0);
        
        for (Cell cell : getPotentialCells())
        {
            if(getCellWeight(optimalCell) > getCellWeight(cell)) optimalCell = cell;
        }
        
        playedCells.add(optimalCell);
        return optimalCell;
    }
    
    private int getCellWeight (Cell cell)
    {
        if(cell.getY() == model.grid.getNbColumns() - 2) return 0;
        
        int minWheight = Integer.MAX_VALUE;
    
        ArrayList<Cell> neighborCells = model.researchNeighborCells(cell);
        
        for (Cell c : neighborCells)
        {
            if(c != null)
            {
                int weight = getCellWeight(c);
                if(weight < minWheight) minWheight = weight;
            }
        }
        
        return minWheight + 1;
    }
    
    private ArrayList<Cell> getPotentialCells ()
    {
        ArrayList<Cell> potentialCells = new ArrayList<>();
        
        for (Cell cell : playedCells)
        {
            potentialCells.addAll(model.researchNeighborCells(cell));
        }
        
        return potentialCells;
    }
    
    @Override
    public Color getAIColor ()
    {
        return Color.GREEN;
    }
}
