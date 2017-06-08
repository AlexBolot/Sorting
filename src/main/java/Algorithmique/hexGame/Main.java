package Algorithmique.hexGame;

import Algorithmique.hexGame.controller.HexController;
import Algorithmique.hexGame.model.AI.AIPlayer;
import Algorithmique.hexGame.model.AI.AIStraightLine;
import Algorithmique.hexGame.model.HexModel;
import Algorithmique.hexGame.view.HexView;

/*................................................................................................................................
 . Copyright (c)
 .
 . The Main	 Class was Coded by : Alexandre BOLOT
 .
 . Last Modified : 08/06/17 09:40
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
        //AIPlayer ai = new AIPathFinding();
        AIPlayer ai = new AIStraightLine();
    
        //Creation du model
        HexModel model = new HexModel();
        model.addObserver(ai);
        //Creation de la vue
        HexView view = new HexView(model, "HexGame - Abomnes - Bretheau - S3C");
        //Creation du controller
        new HexController(model, view, ai, true);
    }
    
    public static void main (String[] args)
    {
        new Main();
    }
}
