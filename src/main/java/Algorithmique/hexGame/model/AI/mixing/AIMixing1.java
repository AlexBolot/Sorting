package Algorithmique.hexGame.model.AI.mixing;

import Algorithmique.hexGame.model.AI.AIPlayer;
import Algorithmique.hexGame.model.AI.blocking.AIBlocking1;
import Algorithmique.hexGame.model.AI.straightLine.AIStraightLine1;
import Algorithmique.hexGame.model.Cell;

import java.awt.*;

/*................................................................................................................................
 . Copyright (c)
 .
 . The AIMixing1	 Class was Coded by : Alexandre BOLOT
 .
 . Last Modified : 22/06/17 09:25
 .
 . Contact : bolotalex06@gmail.com
 ...............................................................................................................................*/

public class AIMixing1 extends AIPlayer
{
    @Override
    protected Cell getFirstMove ()
    {
        int x = 1;
        int y = getRandCoord(4);
        
        Cell cell = getCell(x, y);
        while (!isValid(cell))
        {
            y = getRandCoord(4);
            cell = getCell(x, y);
        }
        
        playedCells.add(cell);
        return cell;
    }
    
    @Override
    protected Cell getFollowingMove ()
    {
        AIPlayer aiPlayer = random.nextBoolean() ? new AIStraightLine1() : new AIBlocking1();
        return aiPlayer.getNextMove();
    }
    
    @Override
    public Color getAIColor ()
    {
        return color1;
    }
}
