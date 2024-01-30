package org.example;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;


public class TicTacTo {
    int brettWidth = 600;
    int brettHoyde = 700; // 50px til tekst boks i top og bunn

    JFrame frame = new JFrame("Tic tac to!");
    JLabel textLabel = new JLabel();
    JPanel textPanel = new JPanel();
    JPanel boardPanel = new JPanel();

    public TicTacTo() {

        //Sett størrelse på brettspillet
        frame.setVisible(true);
        frame.setSize(brettWidth, brettHoyde);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        //Sett tekst og font i brettspillet
        frame.setFont(new Font("Helvetica", Font.BOLD, 50));
        textLabel.setHorizontalAlignment(JLabel.CENTER);



    }
}
