package Algorithmique.hexGame;

import Algorithmique.hexGame.controller.HexController;
import Algorithmique.hexGame.model.AI.AIStraightLine;
import Algorithmique.hexGame.model.HexModel;
import Algorithmique.hexGame.view.HexView;

/*................................................................................................................................
 . Copyright (c)
 .
 . The Main	 Class was Coded by : Alexandre BOLOT
 .
 . Last Modified : 06/06/17 15:54
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
        AIStraightLine ai = new AIStraightLine();
    
        //Creation du model
        HexModel model = new HexModel();
        model.addObserver(ai);
        //Creation de la vue
        HexView view = new HexView(model, "HexGame - Abomnes - Bretheau - S3C");
        //Creation du controller
        new HexController(model, view, ai);
    }
    
    public static void main (String[] args)
    {
        new Main();
    }
}
