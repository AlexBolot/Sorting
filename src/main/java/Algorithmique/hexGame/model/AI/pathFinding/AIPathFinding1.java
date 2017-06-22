package Algorithmique.hexGame.model.AI.pathFinding;

import Algorithmique.hexGame.model.AI.AIPlayer;
import Algorithmique.hexGame.model.Cell;

import java.awt.*;
import java.util.ArrayList;

/*................................................................................................................................
 . Copyright (c)
 .
 . The AIPathFinding1	 Class was Coded by : Alexandre BOLOT
 .
 . Last Modified : 22/06/17 13:38
 .
 . Contact : bolotalex06@gmail.com
 ...............................................................................................................................*/

public class AIPathFinding1 extends AIPlayer
{
    ArrayList<Cell> listExplored  = new ArrayList<>();
    ArrayList<Cell> listToExplore = new ArrayList<>();
    
    @Override
    protected Cell getFirstMove ()
    {
        int x = 1;
        int y = getRandCoord(4);
    
        int attempts = 0;
        
        Cell cell = getCell(x, y);
        while (!isValid(cell))
        {
            y = attempts < 10 ? getRandCoord(4) : getRandCoord();
            cell = getCell(x, y);
    
            attempts++;
        }
    
        playedCells.add(cell);
        return cell;
    }
    
    @Override
    protected Cell getFollowingMove ()
    {
        return null;
    }
    
    @Override
    public Color getAIColor ()
    {
        return color1;
    }
}
