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
 . Last Modified : 06/06/17 15:54
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
    
        Cell nextCell = model.grid.getCell(i + 1, j);
        if(isValid(nextCell))
        {
            playedCells.add(nextCell);
            return nextCell;
        }
    
        nextCell = model.grid.getCell(i + 1, j - 1);
        if(isValid(nextCell))
        {
            playedCells.add(nextCell);
            return nextCell;
        }
    
        nextCell = model.grid.getCell(i + 1, j + 1);
        if(isValid(nextCell))
        {
            playedCells.add(nextCell);
            return nextCell;
        }
    
        while (!isValid(nextCell))
        {
            nextCell = model.grid.getCell(new Random().nextInt(8) + 1, new Random().nextInt(8) + 1);
        }
    
        playedCells.add(nextCell);
        return nextCell;
    }
    
    private boolean isValid (Cell cell)
    {
        return cell != null && !model.grid.getPast(cell) && cell.getColor() == Color.WHITE && !playedCells.contains(cell);
    }
    
    @Override
    public void update (Observable o, Object arg)
    {
        if(o == null) return;
        if(!(o instanceof HexModel)) return;
        
        this.model = (HexModel) o;
    }
}
