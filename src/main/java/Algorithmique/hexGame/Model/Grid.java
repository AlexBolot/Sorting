package Algorithmique.hexGame.model;

import java.awt.*;
import java.util.ArrayList;

/*................................................................................................................................
 . Copyright (c)
 .
 . The Grid	 Class was Coded by : Alexandre BOLOT
 .
 . Last Modified : 27/12/2019 12:59
 .
 . Contact : bolotalex06@gmail.com
 ...............................................................................................................................*/

/**
 * Abomnes Gauthier
 * Bretheau Yann
 * S3C
 */

public class Grid extends ArrayList<Cell> {
    private int nbLines;
    private int nbColumns;

    public Grid(int nbLines, int nbColumns) {
        this.nbLines = nbLines;
        this.nbColumns = nbColumns;
    }

    public void buildGrid() {
        Cell c;

        for (int i = 0; i < nbLines; i++) {
            for (int j = 0; j < nbColumns; j++) {
                if ((i != 0 && j != nbColumns - 1) || (i != nbLines - 1 && j != 0)) {
                    if (i == 0) {
                        c = new Cell(i, j, Color.BLUE, true);
                    } else if (i == nbLines - 1) {
                        c = new Cell(i, j, Color.BLUE, true);
                    } else if (j == 0) {
                        c = new Cell(i, j, Color.RED, true);
                    } else if (j == nbColumns - 1) {
                        c = new Cell(i, j, Color.RED, true);
                    } else c = new Cell(i, j, Color.WHITE, false);

                    add(c);
                }
            }
        }
    }

    public int getNbLines() {
        return nbLines;
    }

    public int getNbColumns() {
        return nbColumns;
    }

    public Cell getCell(int i, int j) {
        Cell cell = null;
        for (Cell c : this) {
            if (c.getX() == i && c.getY() == j) {
                cell = c;
            }
        }
        return cell;
    }

    public void setPast(Cell cell) {
        cell.setPast(true);
    }

    public boolean isNotPast(Cell cell) {
        return !cell.getPast();
    }

    public void resetPast() {
        this.forEach(c -> c.setPast(false));
    }
}
