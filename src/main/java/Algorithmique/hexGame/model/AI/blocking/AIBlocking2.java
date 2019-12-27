package Algorithmique.hexGame.model.AI.blocking;

import Algorithmique.hexGame.model.AI.AIPlayer;
import Algorithmique.hexGame.model.Cell;

import java.awt.*;
import java.util.ArrayList;

import static Algorithmique.hexGame.model.AI.blocking.BlockingService.*;

/*................................................................................................................................
 . Copyright (c)
 .
 . The AIBlocking2	 Class was Coded by : Alexandre BOLOT
 .
 . Last Modified : 27/12/2019 12:59
 .
 . Contact : bolotalex06@gmail.com
 ...............................................................................................................................*/

public class AIBlocking2 extends AIPlayer {
    private boolean blockRight;

    public AIBlocking2() {
        blockRight = random.nextBoolean();
    }

    @Override
    public Cell getNextMove() {
        return getFollowingMove();
    }

    protected Cell getFirstMove() {
        int x = getRandCoord(4);
        int y = 1;

        int attempts = 0;

        Cell cell = getCell(x, y);
        while (!isValid(cell)) {
            x = attempts < 10 ? getRandCoord(4) : getRandCoord();
            cell = getCell(x, y);

            attempts++;
        }

        playedCells.add(cell);
        return cell;
    }

    protected Cell getFollowingMove() {
        int lastIndex = opponentMoves.size() - 1;

        int x = opponentMoves.get(lastIndex).getX();
        int y = opponentMoves.get(lastIndex).getY();

        boolean blockTop = getBlockTop();

        ArrayList<Cell> cellsToPlay = new ArrayList<>();
        Cell currentCell = new Cell(x, y);

        //region --> Add Cells to play
        if (blockTop) {
            if (blockRight) {
                blockTopRight(cellsToPlay, model.grid, currentCell);
            } else {
                blockTopLeft(cellsToPlay, model.grid, currentCell);
            }
        } else {
            if (blockRight) {
                blockBottomRight(cellsToPlay, model.grid, currentCell);
            } else {
                blockBottomLeft(cellsToPlay, model.grid, currentCell);
            }
        }
        //endregion

        blockRight = random.nextBoolean();

        for (Cell cell : cellsToPlay) {
            if (isValid(cell)) {
                System.out.println("result");
                System.out.println(cell.getX() + " " + cell.getY());
                return cell;
            }
        }

        Cell newStart = getFirstMove();

        while (!isValid(newStart)) {
            newStart = getFirstMove();
        }

        return newStart;
    }

    public Color getAIColor() {
        return color2;
    }

    public boolean getBlockTop() {
        int nbTop = 0;
        int nbBottom = 0;

        for (Cell cell : opponentMoves) {
            if (cell.getX() >= 4) nbBottom++;
            else nbTop++;
        }
        //Si il y a plus de cases à droite on bloque vers la gauche.
        //Sinon on bloque vers la droite.
        return nbTop < nbBottom;
    }
}