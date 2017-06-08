package Algorithmique.hexGame.model.AI;

import Algorithmique.hexGame.model.Cell;
import Algorithmique.hexGame.model.HexModel;

import java.awt.*;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Random;

/*................................................................................................................................
 . Copyright (c)
 .
 . The AIStraightLine	 Class was Coded by : Alexandre BOLOT
 .
 . Last Modified : 08/06/17 13:37
 .
 . Contact : bolotalex06@gmail.com
 ...............................................................................................................................*/

public class AIStraightLine implements AIPlayer
{
    private HexModel        model       = new HexModel();
    private ArrayList<Cell> playedCells = new ArrayList<>();
    
    public AIStraightLine ()
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
    
        int i = 1;
        int j = random.nextInt(8) + 1;
    
        Cell cell = model.grid.getCell(i, j);
        while (!isValid(cell))
        {
            j = random.nextInt(8) + 1;
            cell = model.grid.getCell(i, j);
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
        cellsToPlay.add(getCell(i + 1, j));
    
        //Bottom-Left
        cellsToPlay.add(getCell(i + 1, j - 1));
    
        //Right
        cellsToPlay.add(getCell(i, j + 1));
    
        //Left
        cellsToPlay.add(getCell(i, j - 1));
    
        //Top-Right
        cellsToPlay.add(getCell(i - 1, j + 1));
    
        //Top-Left
        cellsToPlay.add(getCell(i - 1, j));
    
        for (Cell cell : cellsToPlay)
        {
            if(isValid(cell))
            {
                playedCells.add(cell);
                return cell;
            }
        }
    
        int randX = new Random().nextInt(8) + 1;
        int randY = new Random().nextInt(8) + 1;
    
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
    public void update (Observable o, Object arg)
    {
        if(o == null) return;
        if(!(o instanceof HexModel)) return;
        
        this.model = (HexModel) o;
    
        //If game restarts
        if(!this.model.getCurrentGame())
        {
            playedCells.clear();
        }
    }
}
