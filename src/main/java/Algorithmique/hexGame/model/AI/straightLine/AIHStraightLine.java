package Algorithmique.hexGame.model.AI.straightLine;

import Algorithmique.hexGame.model.AI.AIPlayer;
import Algorithmique.hexGame.model.Cell;
import Algorithmique.hexGame.model.HexModel;

import java.awt.*;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Random;

/*................................................................................................................................
 . Copyright (c)
 .
 . The AIHStraightLine	 Class was Coded by : Alexandre BOLOT
 .
 . Last Modified : 09/06/17 13:43
 .
 . Contact : bolotalex06@gmail.com
 ...............................................................................................................................*/

public class AIHStraightLine implements AIPlayer
{
    private HexModel        model       = new HexModel();
    private ArrayList<Cell> playedCells = new ArrayList<>();
    private Random          random      = new Random();
    
    public AIHStraightLine ()
    {
        playedCells = new ArrayList<>();
    }
    
    @Override
    public Cell getNextMove ()
    {
        return playedCells.size() == 0 ? getFirstMove() : getFollowingMove();
    }
    
    private Cell getFirstMove ()
    {
        Random random = new Random();
        
        int i = random.nextInt(8) + 1;
        int j = 1;
        
        Cell cell = getCell(i, j);
        while (!isValid(cell))
        {
            j = random.nextInt(8) + 1;
            cell = getCell(i, j);
        }
        
        playedCells.add(cell);
        return cell;
    }
    
    private Cell getFollowingMove ()
    {
        int size = playedCells.size();
        Cell lastPlayed = playedCells.get(size - 1);
        
        int i = lastPlayed.getX();
        int j = lastPlayed.getY();
        
        ArrayList<Cell> cellsToPlay = new ArrayList<>();
        
        //Bottom-Right
        cellsToPlay.add(getCell(i, j + 1));
        
        //Bottom-Left
        cellsToPlay.add(getCell(i - 1, j + 1));
        
        //Right
        cellsToPlay.add(getCell(i + 1, j));
        
        //Left
        cellsToPlay.add(getCell(i - 1, j));
        
        //Top-Right
        cellsToPlay.add(getCell(i + 1, j - 1));
        
        //Top-Left
        cellsToPlay.add(getCell(i, j - 1));
        
        for (Cell cell : cellsToPlay)
        {
            if(isValid(cell))
            {
                playedCells.add(cell);
                return cell;
            }
        }
    
        int randX = random.nextInt(8) + 1;
        int randY = random.nextInt(8) + 1;
        
        Cell nextCell = getCell(randX, randY);
        
        while (!isValid(nextCell))
        {
            randX = new Random().nextInt(8) + 1;
            randY = new Random().nextInt(8) + 1;
            
            nextCell = getCell(randX, randY);
        }
        
        playedCells.add(nextCell);
        return nextCell;
    }
    
    private Cell getCell (int x, int y)
    {
        return model.grid.getCell(x, y);
    }
    
    private boolean isValid (Cell cell)
    {
        return cell != null && !model.grid.getPast(cell) && cell.getColor() == Color.WHITE;
    }
    
    @Override
    public Color getAIColor ()
    {
        return Color.RED;
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
