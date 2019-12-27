package Algorithmique.hexGame.model.AI.blocking;

import Algorithmique.hexGame.model.AI.AIPlayer;
import Algorithmique.hexGame.model.Cell;

import java.awt.*;
import java.util.ArrayList;

import static Algorithmique.hexGame.model.AI.blocking.BlockingService.*;

/*................................................................................................................................
 . Copyright (c)
 .
 . The AIBlocking1	 Class was Coded by : Alexandre BOLOT
 .
 . Last Modified : 27/12/2019 12:59
 .
 . Contact : bolotalex06@gmail.com
 ...............................................................................................................................*/

public class AIBlocking1 extends AIPlayer {
    private boolean blockTop;

    public AIBlocking1() {
        blockTop = random.nextBoolean();
    }

    @Override
    public Cell getNextMove() {
        return playedCells.size() == 0 && opponentMoves.size() == 0 ? getFirstMove() : getFollowingMove();
    }

    protected Cell getFirstMove() {
        int x = 1;
        int y = getRandCoord(4);

        int attempts = 0;

        Cell cell = getCell(x, y);
        while (!isValid(cell)) {
            y = attempts < 10 ? getRandCoord(4) : getRandCoord();
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

        boolean blockRight = getBlockRight();

        ArrayList<Cell> cellsToPlay = new ArrayList<>();
        Cell currentCell = new Cell(x, y);

        //region --> Add Cells to play
        if (blockRight) {
            if (blockTop) {
                blockRightTop(cellsToPlay, model.grid, currentCell);
            } else {
                blockRightBottom(cellsToPlay, model.grid, currentCell);
            }
        } else {
            if (blockTop) {
                blockLeftTop(cellsToPlay, model.grid, currentCell);
            } else {
                blockLeftBottom(cellsToPlay, model.grid, currentCell);
            }
        }
        //endregion

        blockTop = random.nextBoolean();

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
        return color1;
    }

    public boolean getBlockRight() {
        int nbRight = 0;
        int nbLeft = 0;

        for (Cell cell : opponentMoves) {
            if (cell.getY() <= 4) nbLeft++;
            else nbRight++;
        }

        //Si il y a plus de cases à droite on bloque vers la gauche.
        //Sinon on bloque vers la droite.
        return nbRight < nbLeft;
    }
}