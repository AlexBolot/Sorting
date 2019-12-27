package Algorithmique.hexGame.model.AI.blocking;

import Algorithmique.hexGame.model.Cell;
import Algorithmique.hexGame.model.Grid;

import java.util.ArrayList;

/*................................................................................................................................
 . Copyright (c)
 .
 . The BlockingService	 Class was Coded by : Alexandre BOLOT
 .
 . Last Modified : 27/12/2019 12:59
 .
 . Contact : bolotalex06@gmail.com
 ...............................................................................................................................*/

abstract class BlockingService {
    static void blockTopLeft(ArrayList<Cell> cellsToPlay, Grid grid, Cell cell) {
        int x = cell.getX();
        int y = cell.getY();

        //Top-Left
        cellsToPlay.add(grid.getCell(x - 1, y));

        //Top-Right
        cellsToPlay.add(grid.getCell(x - 1, y + 1));

        //Left
        cellsToPlay.add(grid.getCell(x, y - 1));

        //Right
        cellsToPlay.add(grid.getCell(x, y + 1));

        //Bottom-Left
        cellsToPlay.add(grid.getCell(x + 1, y - 1));

        //Bottom-Right
        cellsToPlay.add(grid.getCell(x + 1, y));
    }

    static void blockBottomLeft(ArrayList<Cell> cellsToPlay, Grid grid, Cell cell) {
        int x = cell.getX();
        int y = cell.getY();

        //Bottom-Left
        cellsToPlay.add(grid.getCell(x + 1, y - 1));

        //Bottom-Right
        cellsToPlay.add(grid.getCell(x + 1, y));

        //Left
        cellsToPlay.add(grid.getCell(x, y - 1));

        //Right
        cellsToPlay.add(grid.getCell(x, y + 1));

        //Top-Left
        cellsToPlay.add(grid.getCell(x - 1, y));

        //Top-Right
        cellsToPlay.add(grid.getCell(x - 1, y + 1));
    }

    static void blockTopRight(ArrayList<Cell> cellsToPlay, Grid grid, Cell cell) {
        int x = cell.getX();
        int y = cell.getY();

        //Top-Right
        cellsToPlay.add(grid.getCell(x - 1, y + 1));

        //Top-Left
        cellsToPlay.add(grid.getCell(x - 1, y));

        //Right
        cellsToPlay.add(grid.getCell(x, y + 1));

        //Left
        cellsToPlay.add(grid.getCell(x, y - 1));

        //Bottom-Right
        cellsToPlay.add(grid.getCell(x + 1, y));

        //Bottom-Left
        cellsToPlay.add(grid.getCell(x + 1, y - 1));
    }

    static void blockBottomRight(ArrayList<Cell> cellsToPlay, Grid grid, Cell cell) {
        int x = cell.getX();
        int y = cell.getY();

        //Bottom-Right
        cellsToPlay.add(grid.getCell(x + 1, y));

        //Bottom-Left
        cellsToPlay.add(grid.getCell(x + 1, y - 1));

        //Right
        cellsToPlay.add(grid.getCell(x, y + 1));

        //Left
        cellsToPlay.add(grid.getCell(x, y - 1));

        //Top-Right
        cellsToPlay.add(grid.getCell(x - 1, y + 1));

        //Top-Left
        cellsToPlay.add(grid.getCell(x - 1, y));
    }

    static void blockLeftTop(ArrayList<Cell> cellsToPlay, Grid grid, Cell cell) {
        int x = cell.getX();
        int y = cell.getY();

        //Left
        cellsToPlay.add(grid.getCell(x, y - 1));

        //Top-Left
        cellsToPlay.add(grid.getCell(x - 1, y));

        //Bottom-Left
        cellsToPlay.add(grid.getCell(x + 1, y - 1));

        //Top-Right
        cellsToPlay.add(grid.getCell(x - 1, y + 1));

        //Bottom-Right
        cellsToPlay.add(grid.getCell(x + 1, y));

        //Right
        cellsToPlay.add(grid.getCell(x, y + 1));
    }

    static void blockLeftBottom(ArrayList<Cell> cellsToPlay, Grid grid, Cell cell) {
        int x = cell.getX();
        int y = cell.getY();

        //Left
        cellsToPlay.add(grid.getCell(x, y - 1));

        //Bottom-Left
        cellsToPlay.add(grid.getCell(x + 1, y - 1));

        //Top-Left
        cellsToPlay.add(grid.getCell(x - 1, y));

        //Bottom-Right
        cellsToPlay.add(grid.getCell(x + 1, y));

        //Top-Right
        cellsToPlay.add(grid.getCell(x - 1, y + 1));

        //Right
        cellsToPlay.add(grid.getCell(x, y + 1));
    }

    static void blockRightTop(ArrayList<Cell> cellsToPlay, Grid grid, Cell cell) {
        int x = cell.getX();
        int y = cell.getY();

        //Right
        cellsToPlay.add(grid.getCell(x, y + 1));

        //Top-Right
        cellsToPlay.add(grid.getCell(x - 1, y + 1));

        //Bottom-Right
        cellsToPlay.add(grid.getCell(x + 1, y));

        //Top-Left
        cellsToPlay.add(grid.getCell(x - 1, y));

        //Bottom-Left
        cellsToPlay.add(grid.getCell(x + 1, y - 1));

        //Left
        cellsToPlay.add(grid.getCell(x, y - 1));
    }

    static void blockRightBottom(ArrayList<Cell> cellsToPlay, Grid grid, Cell cell) {
        int x = cell.getX();
        int y = cell.getY();

        //Right
        cellsToPlay.add(grid.getCell(x, y + 1));

        //Bottom-Right
        cellsToPlay.add(grid.getCell(x + 1, y));

        //Top-Right
        cellsToPlay.add(grid.getCell(x - 1, y + 1));

        //Bottom-Left
        cellsToPlay.add(grid.getCell(x + 1, y - 1));

        //Top-Left
        cellsToPlay.add(grid.getCell(x - 1, y));

        //Left
        cellsToPlay.add(grid.getCell(x, y - 1));
    }
}
