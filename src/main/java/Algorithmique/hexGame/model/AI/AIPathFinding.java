package Algorithmique.hexGame.model.AI;

import Algorithmique.hexGame.model.Cell;
import Algorithmique.hexGame.model.HexModel;

import java.awt.*;
import java.util.ArrayList;
import java.util.Observable;

/*................................................................................................................................
 . Copyright (c)
 .
 . The AIPathFinding	 Class was Coded by : Alexandre BOLOT
 .
 . Last Modified : 08/06/17 13:37
 .
 . Contact : bolotalex06@gmail.com
 ...............................................................................................................................*/

public class AIPathFinding implements AIPlayer
{
    private HexModel        model       = new HexModel();
    private ArrayList<Cell> playedCells = new ArrayList<>();
    
    public AIPathFinding ()
    {
        for (int i = 0; i < model.grid.getNbColumns() - 1; i++)
        {
            playedCells.add(new Cell(i, 0, Color.RED, true));
        }
    }
    
    @Override
    public Cell getNextMove ()
    {
        Cell optimalCell = getPotentialCells().get(0);
        
        for (Cell cell : getPotentialCells())
        {
            if(getCellWeight(optimalCell) > getCellWeight(cell)) optimalCell = cell;
        }
        
        playedCells.add(optimalCell);
        return optimalCell;
    }
    
    private int getCellWeight (Cell cell)
    {
        if(cell.getY() == model.grid.getNbColumns() - 2) return 0;
        
        int minWheight = Integer.MAX_VALUE;
        
        ArrayList<Cell> neighborCells = getNeighborCells(cell);
        
        for (Cell c : neighborCells)
        {
            if(c != null)
            {
                int weight = getCellWeight(c);
                if(weight < minWheight) minWheight = weight;
            }
        }
        
        return minWheight + 1;
    }
    
    private ArrayList<Cell> getPotentialCells ()
    {
        ArrayList<Cell> potentialCells = new ArrayList<>();
        
        for (Cell cell : playedCells)
        {
            potentialCells.addAll(getNeighborCells(cell));
        }
        
        return potentialCells;
    }
    
    private ArrayList<Cell> getNeighborCells (Cell cell)
    {
        ArrayList<Cell> neighborCells = new ArrayList<>();
        
        int i = cell.getX();
        int j = cell.getY();
        
        // On crée 6 celules qui correspondent aux 6 cellules voisines d'une cellule
        Cell c1 = model.grid.getCell(i - 1, j);
        Cell c2 = model.grid.getCell(i - 1, j + 1);
        Cell c3 = model.grid.getCell(i, j + 1);
        Cell c4 = model.grid.getCell(i + 1, j);
        Cell c5 = model.grid.getCell(i + 1, j - 1);
        Cell c6 = model.grid.getCell(i, j - 1);
        
        // En revanche pour les cellules des coins et du bord il n'y a pas 6 cellules voisines mais moins, c'est pourquoi on test si elles sont null.
        // Si elles le sont c'est qu'il n'existe pas de cellule voisines avec les coordonées reseignéé.
        if(isValid(c1)) neighborCells.add(c1);
        if(isValid(c2)) neighborCells.add(c2);
        if(isValid(c3)) neighborCells.add(c3);
        if(isValid(c4)) neighborCells.add(c4);
        if(isValid(c5)) neighborCells.add(c5);
        if(isValid(c6)) neighborCells.add(c6);
        
        return neighborCells;
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
