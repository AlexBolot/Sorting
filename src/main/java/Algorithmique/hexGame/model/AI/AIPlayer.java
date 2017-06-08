package Algorithmique.hexGame.model.AI;

import Algorithmique.hexGame.model.Cell;

import java.util.Observer;

/*................................................................................................................................
 . Copyright (c)
 .
 . The AIPlayer	 Class was Coded by : Alexandre BOLOT
 .
 . Last Modified : 08/06/17 13:37
 .
 . Contact : bolotalex06@gmail.com
 ...............................................................................................................................*/

public interface AIPlayer extends Observer
{
    Cell getNextMove ();
}
