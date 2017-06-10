package Algorithmique.hexGame.model.AI.straightLine;

import Algorithmique.hexGame.model.AI.AIPlayer;
import Algorithmique.hexGame.model.Cell;

import java.awt.*;
import java.util.ArrayList;

/*................................................................................................................................
 . Copyright (c)
 .
 . The AIStraightLine2	 Class was Coded by : Alexandre BOLOT
 .
 . Last Modified : 10/06/17 16:18
 .
 . Contact : bolotalex06@gmail.com
 ...............................................................................................................................*/

public class AIStraightLine2 extends AIPlayer
{
    protected Cell getFirstMove ()
    {
        int x = getRandCoord();
        int y = 1;
    
        Cell cell = getCell(x, y);
        while (!isValid(cell))
        {
            x = getRandCoord();
            cell = getCell(x, y);
        }
        
        playedCells.add(cell);
        return cell;
    }
    
    protected Cell getFollowingMove ()
    {
        int size = playedCells.size();
        Cell lastPlayed = playedCells.get(size - 1);
    
        int x = lastPlayed.getX();
        int y = lastPlayed.getY();
        
        ArrayList<Cell> cellsToPlay = new ArrayList<>();
        
        //Bottom-Right
        cellsToPlay.add(getCell(x, y + 1));
        
        //Bottom-Left
        cellsToPlay.add(getCell(x - 1, y + 1));
        
        //Right
        cellsToPlay.add(getCell(x + 1, y));
        
        //Left
        cellsToPlay.add(getCell(x - 1, y));
        
        //Top-Right
        cellsToPlay.add(getCell(x + 1, y - 1));
        
        //Top-Left
        cellsToPlay.add(getCell(x, y - 1));
        
        for (Cell cell : cellsToPlay)
        {
            if(isValid(cell))
            {
                playedCells.add(cell);
                return cell;
            }
        }
    
        Cell newStart = getFirstMove();
    
        while (!isValid(newStart))
        {
            newStart = getFirstMove();
        }
    
        playedCells.add(newStart);
        return newStart;
    }
    
    @Override
    public Color getAIColor ()
    {
        return color2;
    }
}
