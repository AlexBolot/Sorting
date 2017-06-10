package Algorithmique.hexGame;

import Algorithmique.hexGame.controller.HexController;
import Algorithmique.hexGame.model.AI.AIPlayer;
import Algorithmique.hexGame.model.AI.blocking.AIBlocking1;
import Algorithmique.hexGame.model.AI.blocking.AIBlocking2;
import Algorithmique.hexGame.model.AI.mixing.AIMixing1;
import Algorithmique.hexGame.model.AI.mixing.AIMixing2;
import Algorithmique.hexGame.model.AI.pathFinding.AIPathFinding;
import Algorithmique.hexGame.model.AI.straightLine.AIStraightLine1;
import Algorithmique.hexGame.model.AI.straightLine.AIStraightLine2;
import Algorithmique.hexGame.model.HexModel;
import Algorithmique.hexGame.view.HexView;

import java.util.InputMismatchException;
import java.util.Scanner;

/*................................................................................................................................
 . Copyright (c)
 .
 . The Main	 Class was Coded by : Alexandre BOLOT
 .
 . Last Modified : 10/06/17 18:39
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
    public static void main (String[] args)
    {
        Scanner sc = new Scanner(System.in);
        Boolean aiFirst;
        AIPlayer ai;
        
        //Who plays first ?
        System.out.print("AI Plays First ? (y/n)  ");
        aiFirst = sc.nextLine().equalsIgnoreCase("y");
    
        //Which IA ?
        ai = aiChoice(sc, aiFirst);
        
        //Creation du model
        HexModel model = new HexModel();
        model.addObserver(ai);
        //Creation de la vue
        HexView view = new HexView(model, "HexGame - Abomnes - Bretheau - S3C");
        //Creation du controller
        new HexController(model, view, ai, aiFirst);
    }
    
    private static AIPlayer aiChoice (Scanner sc, Boolean aiFirst)
    {
        System.out.println("Which AI : ");
        System.out.println("(1) StraightLine\n" + "(2) Blocking\n" + "(3) PathFinding\n" + "(4) Mixing");
        
        try
        {
            switch (sc.nextInt())
            {
                case 1:
                    return aiFirst ? new AIStraightLine1() : new AIStraightLine2();
                case 2:
                    return aiFirst ? new AIBlocking1() : new AIBlocking2();
                case 3:
                    return aiFirst ? new AIPathFinding() : new AIPathFinding();
                case 4:
                    return aiFirst ? new AIMixing1() : new AIMixing2();
            }
        }
        catch (InputMismatchException ignored)
        {
        }
    
        sc = new Scanner(System.in);
        System.out.println("\n");
        return aiChoice(sc, aiFirst);
    }
}
