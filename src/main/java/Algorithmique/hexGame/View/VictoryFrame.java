package Algorithmique.hexGame.view;


import Algorithmique.hexGame.model.HexModel;

import javax.swing.*;

/*................................................................................................................................
 . Copyright (c)
 .
 . The VictoryFrame	 Class was Coded by : Alexandre BOLOT
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

public class VictoryFrame {

    private static final int Width = 600;
    private static final int Height = 150;
    public VictoryPanel panel;
    private JFrame frame;

    VictoryFrame(HexModel model) {
        panel = new VictoryPanel(model);
        frame = new JFrame("Victoire!");
        frame.setBounds(400, 50, Width, Height);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        frame.getContentPane().add(panel);

        frame.setVisible(false);
    }

    public void setVisible(boolean visible) {
        frame.setVisible(visible);
    }
}
