package Algorithmique.hexGame.controller;

import Algorithmique.hexGame.model.AI.AIPlayer;
import Algorithmique.hexGame.model.Cell;
import Algorithmique.hexGame.model.HexModel;
import Algorithmique.hexGame.view.HexView;

import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.net.URL;

/*................................................................................................................................
 . Copyright (c)
 .
 . The HexController	 Class was Coded by : Alexandre BOLOT
 .
 . Last Modified : 22/06/17 12:45
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
    private Boolean  aiFirst;
    private Color    playerColor;
    
    public HexController (HexModel model, HexView view, AIPlayer player, Boolean aiFirst)
    {
        this.model = model;
        this.view = view;
        this.aiPlayer = player;
        this.aiFirst = aiFirst;
    
        playerColor = aiFirst ? Color.RED : Color.BLUE;
        
        view.pMenu.bPlay.addActionListener(this);
        view.pMenu.bReset.addActionListener(this);
        view.pMenu.bQuit.addActionListener(this);
        
        view.pGame.addMouseListener(this);
        view.pGame.bReturn.addActionListener(this);
        
        view.pVictory.panel.bReturn.addActionListener(this);
    }
    
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
    
                if(aiFirst) playAiMove();
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
    
                if(aiFirst) playAiMove();
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
                    c.setColor(playerColor);
                    validMove = true;
                    playSound();
                    aiPlayer.addLastMove(c);
                }
            }
    
            if(validMove)
            {
                playAiMove();
            }
    
            model.researchVictory(0, 1);
            model.researchVictory(1, 0);
        }
    }
    
    private void playSound ()
    {
        URL resource = getClass().getClassLoader().getResource("BlopSound.wav");
        AudioClip clip = Applet.newAudioClip(resource);
        clip.play();
    }
    
    private void playAiMove ()
    {
        aiPlayer.getNextMove().setColor(aiPlayer.getAIColor());
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
