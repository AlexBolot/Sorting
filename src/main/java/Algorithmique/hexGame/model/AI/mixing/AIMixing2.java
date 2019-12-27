package Algorithmique.hexGame.model.AI.mixing;

import Algorithmique.hexGame.model.AI.AIPlayer;
import Algorithmique.hexGame.model.AI.blocking.AIBlocking2;
import Algorithmique.hexGame.model.AI.straightLine.AIStraightLine2;
import Algorithmique.hexGame.model.Cell;

import java.awt.*;

/*................................................................................................................................
 . Copyright (c)
 .
 . The AIMixing2	 Class was Coded by : Alexandre BOLOT
 .
 . Last Modified : 27/12/2019 12:59
 .
 . Contact : bolotalex06@gmail.com
 ...............................................................................................................................*/

public class AIMixing2 extends AIPlayer {
    @Override
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

    @Override
    protected Cell getFollowingMove() {
        AIPlayer aiPlayer = random.nextBoolean() ? new AIStraightLine2() : new AIBlocking2();
        return aiPlayer.getNextMove();
    }

    @Override
    public Color getAIColor() {
        return color2;
    }
}
