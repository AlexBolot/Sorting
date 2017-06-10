package Algorithmique.hexGame;

import Algorithmique.hexGame.controller.HexController;
import Algorithmique.hexGame.model.AI.AIPlayer;
import Algorithmique.hexGame.model.AI.blocking.AIHBlocking;
import Algorithmique.hexGame.model.AI.pathFinding.AIPathFinding;
import Algorithmique.hexGame.model.AI.straightLine.AIHStraightLine;
import Algorithmique.hexGame.model.AI.straightLine.AIVStraightLine;
import Algorithmique.hexGame.model.HexModel;
import Algorithmique.hexGame.view.HexView;

import java.util.InputMismatchException;
import java.util.Scanner;

/*................................................................................................................................
 . Copyright (c)
 .
 . The Main	 Class was Coded by : Alexandre BOLOT
 .
 . Last Modified : 10/06/17 15:45
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
        System.out.println("AI Plays First ? (y/n)");
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
        System.out.println("Which AI ?");
        System.out.println("(1) StraightLine - (2) Blocking - (3) PathFinding ");
    
        try
        {
            switch (sc.nextInt())
            {
                case 1:
                    return aiFirst ? new AIVStraightLine() : new AIHStraightLine();
                case 2:
                    return aiFirst ? new AIHBlocking() : new AIHBlocking();
                case 3:
                    return aiFirst ? new AIPathFinding() : new AIPathFinding();
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
