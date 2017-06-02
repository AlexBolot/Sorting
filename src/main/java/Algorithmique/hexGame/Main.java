package Algorithmique.hexGame;


import Algorithmique.hexGame.model.AI.AIStraightLine;

/*................................................................................................................................
 . Copyright (c)
 .
 . The Main	 Class was Coded by : Alexandre BOLOT
 .
 . Last Modified : 24/05/17 14:20
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
        System.out.println(new AIStraightLine().getNextMove());
        
       /* //Creation du model
        HexModel model = new HexModel();
        model.addObserver(new AIStraightLine());
        //Creation de la vue
        HexView view = new HexView(model, "HexGame - Abomnes - Bretheau - S3C");
        //Creation du controller
        new HexController(model, view);*/
    }
    
    public static void main (String[] args)
    {
        new Main();
    }
}
