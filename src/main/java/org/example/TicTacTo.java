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

    JButton [][] brett = new JButton[3][3];
    String spillerX = "X";
    String spillerO = "O";
    String novaarendesSpiller = spillerX;

    Boolean gameOver = false;
    int omganger = 0;

    public TicTacTo() {

        //Sett størrelse på brettspillet
        frame.setVisible(true);
        frame.setSize(brettWidth, brettHoyde);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        //Sett tekst, farger og font i brettspillet
        textLabel.setBackground(Color.darkGray);
        textLabel.setForeground(Color.white);
        frame.setFont(new Font("Helvetica", Font.BOLD, 50));
        textLabel.setHorizontalAlignment(JLabel.CENTER);
        textLabel.setText("Tic-Tac-Toe");
        textLabel.setOpaque(true);

        textPanel.setLayout(new BorderLayout());
        textPanel.add(textLabel);
        frame.add(textPanel,BorderLayout.NORTH);

        //Lage grid på brettet
        boardPanel.setLayout(new GridLayout(3, 3));
        boardPanel.setBackground(Color.darkGray);
        frame.add(boardPanel);

        /*Lag tekstboks i bunn
        textPanel.setLayout(new BorderLayout());
        textPanel.setBackground(Color.darkGray);
        textPanel.setForeground(Color.white);
        frame.setFont(new Font("Helvetica", Font.BOLD, 100));
        textLabel.setHorizontalAlignment(JLabel.CENTER);
        textLabel.setText("Spill igjen");
        textLabel.setOpaque(true);
        textPanel.add(textLabel);
        frame.add(textPanel,BorderLayout.SOUTH); */

        for(int r = 0; r < 3; r++){
            for(int k = 0; k < 3; k++){
                JButton flis = new JButton();
                brett[r][k] = flis;
                boardPanel.add(flis);

                flis.setForeground(Color.darkGray);
                flis.setBackground(Color.darkGray);
                flis.setFont(new Font("Arial", Font.BOLD ,120));
                flis.setFocusable(false);

                //Test om det fungerer
                //flis.setText(nåværendesSpiller);

                flis.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if(gameOver) return;
                        JButton flis = (JButton) e.getSource();
                        if(flis.getText().equals("")){
                            flis.setText(novaarendesSpiller);
                            omganger++;
                            sjekkVinner();
                            if(!gameOver){
                                novaarendesSpiller = novaarendesSpiller == spillerX ? spillerO : spillerX;
                                textLabel.setText(novaarendesSpiller + " ´s sin tur til å spille.");
                            }
                        }
                    }
                });

            }
        }
    }

    public void sjekkVinner() {
        //Horisontalt
        for (int r = 0; r < 3; r++) {
            if (brett[r][0].getText().equals("")) continue;

            if (brett[r][0].getText() == brett[r][1].getText() &&
                    brett[r][1].getText() == brett[r][2].getText()) {
                for (int i = 0; i < 3; i++) {
                    setVinner(brett[r][i]);
                }
                gameOver = true;
                return;
            }
        }

        //Vertikalt
        for (int k = 0; k < 3; k++) {
            if (brett[0][k].getText() == ("")) continue;

            if (brett[0][k].getText() == brett[1][k].getText() &&
                    brett[1][k].getText() == brett[2][k].getText()) {
                for (int i = 0; i < 3; i++) {
                    setVinner(brett[i][k]);
                }
                gameOver = true;
                return;
            }

        }


        //diagonalt

        if(brett[0][0].getText() == brett[1][1].getText() &&
                brett[1][1].getText() == brett[2][2].getText() &&
                brett[0][0].getText() != ""){
            for(int i = 0; i <3; i++){
                setVinner(brett[i][i]);
            }
            gameOver = true;
            return;
        }

        //omvendt diagonal
        if(brett [0][2].getText() == brett[1][1].getText() &&
                brett[1][1].getText() == brett[2][0].getText()&&
        brett[0][2].getText() != ""){
            setVinner(brett[0][2]);
            setVinner(brett[1][1]);
            setVinner(brett[2][0]);
            gameOver = true;
            return;
        }


        //Omganger
        if(omganger == 9){
            for(int r = 0; r < 3; r++){
                for(int k = 0; k < 3; k++){
                    setUavgjort(brett[r][k]);
                }
            }
            gameOver = true;
        }

    }

    private void setUavgjort(JButton flis) {
        flis.setForeground(Color.orange);
        flis.setBackground(Color.gray);
        textLabel.setText("Uavgjort!");

    }

    private void setVinner(JButton flis) {
        flis.setForeground(Color.green);
        flis.setBackground(Color.gray);
        textLabel.setText(novaarendesSpiller + " er vinneren!");
    }
}
