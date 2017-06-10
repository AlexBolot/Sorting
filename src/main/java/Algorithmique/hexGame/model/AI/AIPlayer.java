package Algorithmique.hexGame.model.AI;

import Algorithmique.hexGame.model.Cell;
import Algorithmique.hexGame.model.HexModel;

import java.awt.*;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
import java.util.Random;

/*................................................................................................................................
 . Copyright (c)
 .
 . The AIPlayer	 Class was Coded by : Alexandre BOLOT
 .
 . Last Modified : 10/06/17 14:45
 .
 . Contact : bolotalex06@gmail.com
 ...............................................................................................................................*/

public abstract class AIPlayer implements Observer
{
    protected HexModel        model       = new HexModel();
    protected ArrayList<Cell> playedCells = new ArrayList<>();
    protected Random          random      = new Random();
    protected Cell lastOpponentMove;
    
    public Cell getNextMove ()
    {
        return playedCells.size() == 0 ? getFirstMove() : getFollowingMove();
    }
    
    protected abstract Cell getFirstMove ();
    
    protected abstract Cell getFollowingMove ();
    
    protected Cell getCell (int x, int y)
    {
        return model.grid.getCell(x, y);
    }
    
    protected boolean isValid (Cell cell)
    {
        return cell != null && !model.grid.getPast(cell) && cell.getColor() == Color.WHITE;
    }
    
    public abstract Color getAIColor ();
    
    public void setLastMove (Cell cell)
    {
        lastOpponentMove = cell;
    }
    
    @Override
    public void update (Observable o, Object arg)
    {
        if(o == null) return;
        if(!(o instanceof HexModel)) return;
        
        model = (HexModel) o;
        
        //If game restarts
        if(!model.getCurrentGame())
        {
            playedCells.clear();
        }
    }
}
