package Algorithmique.hexGame;

import Algorithmique.hexGame.controller.HexController;
import Algorithmique.hexGame.model.AI.AIPlayer;
import Algorithmique.hexGame.model.AI.blocking.AIHBlocking;
import Algorithmique.hexGame.model.HexModel;
import Algorithmique.hexGame.view.HexView;

/*................................................................................................................................
 . Copyright (c)
 .
 . The Main	 Class was Coded by : Alexandre BOLOT
 .
 . Last Modified : 10/06/17 14:31
 .
 . Contact : bolotalex06@gmail.com
 ...............................................................................................................................*/

/**
 Abomnes Gauthier
 Bretheau Yann
 S3C
 */

public class Main
{
    public Main ()
    {
        //Who plays first ?
        boolean aiFirst = false;
        
        //AIPlayer ai = new AIPathFinding();
        AIPlayer ai = new AIHBlocking();
        //AIPlayer ai = aiFirst ? new AIVStraightLine() : new AIHStraightLine();
        
        //Creation du model
        HexModel model = new HexModel();
        model.addObserver(ai);
        //Creation de la vue
        HexView view = new HexView(model, "HexGame - Abomnes - Bretheau - S3C");
        //Creation du controller
        new HexController(model, view, ai, aiFirst);
    }
    
    public static void main (String[] args)
    {
        new Main();
    }
}
