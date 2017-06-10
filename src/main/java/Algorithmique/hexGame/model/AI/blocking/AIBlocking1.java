package Algorithmique.hexGame.model.AI.blocking;

import Algorithmique.hexGame.model.AI.AIPlayer;
import Algorithmique.hexGame.model.Cell;

import java.awt.*;
import java.util.ArrayList;

/*................................................................................................................................
 . Copyright (c)
 .
 . The AIBlocking1	 Class was Coded by : Alexandre BOLOT
 .
 . Last Modified : 10/06/17 16:13
 .
 . Contact : bolotalex06@gmail.com
 ...............................................................................................................................*/

public class AIBlocking1 extends AIPlayer
{
    private boolean blockTop;
    
    public AIBlocking1 ()
    {
        blockTop = random.nextBoolean();
    }
    
    @Override
    public Cell getNextMove ()
    {
        return playedCells.size() == 0 && lastOpponentMove == null ? getFirstMove() : getFollowingMove();
    }
    
    protected Cell getFirstMove ()
    {
        int x = 1;
        int y = getRandCoord();
        
        Cell cell = getCell(x, y);
        while (!isValid(cell))
        {
            y = getRandCoord();
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
        
        //Right
        cellsToPlay.add(getCell(x, y + 1));
        
        //region if(blockTop) -> Adding Top first
        if(blockTop)
        {
            //Top-Right
            cellsToPlay.add(getCell(x - 1, y + 1));
            
            //Bottom-Right
            cellsToPlay.add(getCell(x + 1, y));
            
            //Top-Left
            cellsToPlay.add(getCell(x - 1, y));
            
            //Bottom-Left
            cellsToPlay.add(getCell(x + 1, y - 1));
        }
        //endregion
        //region else -> Adding Bottom first
        else
        {
            //Bottom-Right
            cellsToPlay.add(getCell(x + 1, y));
            
            //Top-Right
            cellsToPlay.add(getCell(x - 1, y + 1));
            
            //Bottom-Left
            cellsToPlay.add(getCell(x + 1, y - 1));
            
            //Top-Left
            cellsToPlay.add(getCell(x - 1, y));
        }
        //endregion
        
        //Left
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
    
    public Color getAIColor ()
    {
        return Color.BLUE;
    }
}
