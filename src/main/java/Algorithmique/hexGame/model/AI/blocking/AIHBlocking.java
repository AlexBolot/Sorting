package Algorithmique.hexGame.model.AI.blocking;

import Algorithmique.hexGame.model.AI.AIPlayer;
import Algorithmique.hexGame.model.Cell;

import java.awt.*;
import java.util.Observable;

/*................................................................................................................................
 . Copyright (c)
 .
 . The AIHBlocking	 Class was Coded by : Alexandre BOLOT
 .
 . Last Modified : 08/06/17 16:28
 .
 . Contact : bolotalex06@gmail.com
 ...............................................................................................................................*/

public class AIHBlocking implements AIPlayer
{
    @Override
    public Color getAIColor ()
    {
        return Color.RED;
    }
    
    @Override
    public Cell getNextMove ()
    {
        return null;
    }
    
    @Override
    public void update (Observable o, Object arg)
    {
    
    }
}
