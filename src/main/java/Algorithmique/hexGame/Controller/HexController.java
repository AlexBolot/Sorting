package Algorithmique.hexGame.controller;

import Algorithmique.hexGame.model.AI.AIPlayer;
import Algorithmique.hexGame.model.Cell;
import Algorithmique.hexGame.model.HexModel;
import Algorithmique.hexGame.view.HexView;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/*................................................................................................................................
 . Copyright (c)
 .
 . The HexController	 Class was Coded by : Alexandre BOLOT
 .
 . Last Modified : 08/06/17 13:47
 .
 . Contact : bolotalex06@gmail.com
 ...............................................................................................................................*/

/**
 Abomnes Gauthier
 Bretheau Yann
 S3C
 */

public class HexController implements ActionListener, MouseListener
{
    private HexModel model;
    private HexView  view;
    private AIPlayer aiPlayer;
    private boolean  aiFirst;
    
    /**
     **
 
     Constructeurs
 
     ***
     */

    public HexController (HexModel model, HexView view, AIPlayer player, boolean aiFirst)
    {
        this.model = model;
        this.view = view;
        this.aiPlayer = player;
        this.aiFirst = aiFirst;
        
        view.pMenu.bPlay.addActionListener(this);
        view.pMenu.bReset.addActionListener(this);
        view.pMenu.bQuit.addActionListener(this);
        
        view.pGame.addMouseListener(this);
        view.pGame.bReturn.addActionListener(this);
        
        view.pVictory.panel.bReturn.addActionListener(this);
    }
    
    /**
     ********
     
     Action des boutons
     
     Les attributs du model enJeu et enCours permettent de connaitre l'état du jeu.
     L'attribut enJeu permet de différencier le panel du menu et du jeu et l'attribut enCours permet de savoir si une partie est en cours.
     Grâce à l'attribut enCours on peut proposer différente action dans le menu, comme une action de reset si une partie est en cours.
 
     *********
     */
    
    @Override
    public void actionPerformed (ActionEvent e)
    {
        /*
          Action dans la fenêtre du menu sans que le jeu sois lancé
         */
        if(!model.getInGame() && !model.getCurrentGame())
        {
            // Si on clique sur le bouton play le jeu se lance
            if(e.getSource() == view.pMenu.bPlay)
            {
                model.setInGame(true);
                model.setCurrentGame(true);
    
                if(aiFirst)
                {
                    aiPlayer.getNextMove().setColor(Color.BLUE);
        
                    // On test la victoire pour le joueur bleu, c'est à dire en partant de la cellule bleu en 0,1
                    this.model.researchVictory(0, 1);
                }
            }
            else if(e.getSource() == view.pMenu.bQuit)
            {
                // Si on clique sur le bouton quitter on quitte le jeu
                view.dispose();
                System.exit(0);
            }
        }

        /*
          Action dans la fenêtre du menu avec le jeu lancé
         */
        else if(!model.getInGame() && model.getCurrentGame())
        {
            // Si on clique sur le bouton play on retourne au jeu et on continue la partie en cours
            if(e.getSource() == view.pMenu.bPlay)
            {
                model.setInGame(true);
                model.setCurrentGame(true);
            }
            else if(e.getSource() == view.pMenu.bReset)
            {
                // Si on clique sur le bouton reset on relance une nouvelle partie
                model.rebuild();
                model.setInGame(true);
                model.setCurrentGame(true);
            }
            else if(e.getSource() == view.pMenu.bQuit)
            {
                // Si on clique sur le bouton quitter on quitte le jeu
                view.dispose();
                System.exit(0);
            }
        }

        /*
          Action dans la fenêtre de jeu
         */
        else if(model.getInGame() && model.getCurrentGame())
        {
            // Si on clique sur le bouton retour on retourne au menu et la partie est toujours en cours, c'est à dire qu'on pourra y revenir
            // en appuyant sur play dans le menu
            if(e.getSource() == view.pGame.bReturn)
            {
                model.setInGame(false);
                model.setCurrentGame(true);
                view.pVictory.setVisible(false);
            }
            // Si on clique sur le bouton retour de la fenêtre de victoire on retourne au menu, ce qui arrête la partie en cours puisqu'on a eu un gagant
            if(e.getSource() == view.pVictory.panel.bReturn)
            {
                view.pVictory.setVisible(false);
                model.rebuild();
            }
        }
    }
    
    /**
     ****************
     
     Action de la souris en jeu
 
     *****************
     */
    
    @Override
    public void mouseClicked (MouseEvent e)
    {
        if(model.getInGame())
        {
            // On recupère les coordonnées du clique de la souris
            float x = e.getX();
            float y = e.getY();
            boolean validMove = false;
            /*
              Pour toutes les cellules de la grid si les coordonnées de la souris sont comprises dans une cellule de la grid alors on change la couleur
              de cette cellule avec la couleur du joueur en courant.
              On appel aussi la méthode victoire du model après chaque clique du joueur. On test la victoire par rapport a la couleur du joueur.
             */
            for (Cell c : model.grid)
            {
                if(c.contains(x, y) && c.getColor() == Color.WHITE)
                {
                    c.setColor(Color.RED);
                    // On test la victoire pour le joueur rouge, c'est à dire en partant de la cellule bleu en 1,0
                    model.researchVictory(1, 0);
                    validMove = true;
                }
            }
    
            if(validMove)
            {
                Cell aiNextMove = aiPlayer.getNextMove();
                aiNextMove.setColor(Color.BLUE);
                // On test la victoire pour le joueur bleu, c'est à dire en partant de la cellule bleu en 0,1
                model.researchVictory(0, 1);
            }
        }
    }
    
    //region empty methods
    @Override
    public void mousePressed (MouseEvent e)
    {
    
    }
    
    @Override
    public void mouseReleased (MouseEvent e)
    {
    
    }
    
    @Override
    public void mouseEntered (MouseEvent e)
    {
    
    }
    
    @Override
    public void mouseExited (MouseEvent e)
    {
    
    }
    //endregion
}
