package Algorithmique.hexGame.model.AI.straightLine;

import Algorithmique.hexGame.model.AI.AIPlayer;
import Algorithmique.hexGame.model.Cell;

import java.awt.*;
import java.util.ArrayList;

/*................................................................................................................................
 . Copyright (c)
 .
 . The AIVStraightLine	 Class was Coded by : Alexandre BOLOT
 .
 . Last Modified : 10/06/17 14:53
 .
 . Contact : bolotalex06@gmail.com
 ...............................................................................................................................*/

public class AIVStraightLine extends AIPlayer
{
    protected Cell getFirstMove ()
    {
        int x = 1;
        int y = random.nextInt(8) + 1;
    
        Cell cell = getCell(x, y);
        while (!isValid(cell))
        {
            y = random.nextInt(8) + 1;
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
        cellsToPlay.add(getCell(x + 1, y));
        
        //Bottom-Left
        cellsToPlay.add(getCell(x + 1, y - 1));
        
        //Right
        cellsToPlay.add(getCell(x, y + 1));
        
        //Left
        cellsToPlay.add(getCell(x, y - 1));
        
        //Top-Right
        cellsToPlay.add(getCell(x - 1, y + 1));
        
        //Top-Left
        cellsToPlay.add(getCell(x - 1, y));
        
        
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
        return Color.BLUE;
    }
}
