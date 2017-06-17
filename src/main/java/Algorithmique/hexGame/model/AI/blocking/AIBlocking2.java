package Algorithmique.hexGame.model.AI.blocking;

import Algorithmique.hexGame.model.AI.AIPlayer;
import Algorithmique.hexGame.model.Cell;

import java.awt.*;
import java.util.ArrayList;

/*................................................................................................................................
 . Copyright (c)
 .
 . The AIBlocking2	 Class was Coded by : Alexandre BOLOT
 .
 . Last Modified : 17/06/17 22:41
 .
 . Contact : bolotalex06@gmail.com
 ...............................................................................................................................*/

public class AIBlocking2 extends AIPlayer
{
    private boolean blockRight;
    
    public AIBlocking2 ()
    {
        blockRight = random.nextBoolean();
    }
    
    @Override
    public Cell getNextMove ()
    {
        return getFollowingMove();
    }
    
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
        int x = lastOpponentMove.getX();
        int y = lastOpponentMove.getY();
        
        ArrayList<Cell> cellsToPlay = new ArrayList<>();
    
        //region if(blockRight) -> Adding Right first
        if(blockRight)
        {
            //Bottom-Right
            cellsToPlay.add(getCell(x + 1, y));
        
            //Bottom-Left
            cellsToPlay.add(getCell(x + 1, y - 1));
        
            //Right
            cellsToPlay.add(getCell(x, y + 1));
        
            //Left
            cellsToPlay.add(getCell(x, y - 1));
        }
        //endregion
        //region else -> Adding Left first
        else
        {
            //Bottom-Left
            cellsToPlay.add(getCell(x + 1, y - 1));
        
            //Bottom-Right
            cellsToPlay.add(getCell(x + 1, y));
        
            //Left
            cellsToPlay.add(getCell(x, y - 1));
        
            //Right
            cellsToPlay.add(getCell(x, y + 1));
        }
        //endregion
        
        //Top-Right
        cellsToPlay.add(getCell(x - 1, y + 1));
        
        //Top-Left
        cellsToPlay.add(getCell(x - 1, y));
        
        for (Cell cell : cellsToPlay)
        {
            if(isValid(cell))
            {
                playedCells.add(cell);
                blockRight = random.nextBoolean();
                return cell;
            }
        }
        
        Cell newStart = getFirstMove();
        
        while (!isValid(newStart))
        {
            newStart = getFirstMove();
        }
        
        playedCells.add(newStart);
        blockRight = random.nextBoolean();
        return newStart;
    }
    
    public Color getAIColor ()
    {
        return color2;
    }
}
