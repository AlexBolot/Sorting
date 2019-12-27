package Algorithmique.hexGame.model.AI.mixing;

import Algorithmique.hexGame.model.AI.AIPlayer;
import Algorithmique.hexGame.model.AI.blocking.AIBlocking1;
import Algorithmique.hexGame.model.AI.straightLine.AIStraightLine1;
import Algorithmique.hexGame.model.Cell;

import java.awt.*;

/*................................................................................................................................
 . Copyright (c)
 .
 . The AIMixing1	 Class was Coded by : Alexandre BOLOT
 .
 . Last Modified : 27/12/2019 12:59
 .
 . Contact : bolotalex06@gmail.com
 ...............................................................................................................................*/

public class AIMixing1 extends AIPlayer {
    @Override
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

    @Override
    protected Cell getFollowingMove() {
        AIPlayer aiPlayer = random.nextBoolean() ? new AIStraightLine1() : new AIBlocking1();
        return aiPlayer.getNextMove();
    }

    @Override
    public Color getAIColor() {
        return color1;
    }
}
