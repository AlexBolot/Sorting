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
 . Last Modified : 10/06/17 18:22
 .
 . Contact : bolotalex06@gmail.com
 ...............................................................................................................................*/

public abstract class AIPlayer implements Observer
{
    protected static HexModel        model       = new HexModel();
    protected static ArrayList<Cell> playedCells = new ArrayList<>();
    protected static Cell lastOpponentMove;
    protected static Color  color1 = Color.BLUE;
    protected static Color  color2 = Color.RED;
    protected static Random random = new Random();
    
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
    
    protected int getRandCoord ()
    {
        return random.nextInt(8) + 1;
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
