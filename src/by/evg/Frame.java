package by.evg;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Frame extends JFrame {

    private Logic logic = new Logic();

    private JPanel gameBoard;

    private final int fieldSize = 10;

    private Button[][] buttons = new Button[fieldSize][fieldSize];

    private PlayAgainExit play;
    private PlayAgainExit play_again;
    private PlayAgainExit exit;

    ImageIcon virus1 = new ImageIcon(getClass().getResource("resource/virus11.png"));
    ImageIcon virus2 = new ImageIcon(getClass().getResource("resource/virus22.png"));
    ImageIcon X1 = new ImageIcon(getClass().getResource("resource/X11.png"));
    ImageIcon X2 = new ImageIcon(getClass().getResource("resource/X22.png"));

    public Frame() {
        JFrame frame = new JFrame("BATTLE OF VIRUSES");
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(650, 650);
        frame.setResizable(true);
        frame.setLocationRelativeTo(null);

        JPanel defBoard = new JPanel();
        defBoard.setLayout(new FlowLayout(FlowLayout.LEFT));
        frame.add(defBoard);

        gameBoard = new JPanel(new GridLayout(fieldSize, fieldSize));
        gameBoard.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        gameBoard.setPreferredSize(new Dimension(500, 500));
        defBoard.add(gameBoard);
        createGameBoard();


        JPanel buttonBoard = new JPanel();
        buttonBoard.setLayout(new GridLayout(3, 0, 0, 3));
        defBoard.add(buttonBoard);

        play = new PlayAgainExit("Play", logic, this, buttons);
        play_again = new PlayAgainExit("Play again", logic, this, buttons);
        exit = new PlayAgainExit("Exit", logic, this, buttons);

        play.addActionListener(e -> play.play());
        buttonBoard.add(play);

        play_again.addActionListener(e -> play_again.restart());
        buttonBoard.add(play_again);

        exit.addActionListener(e -> frame.dispose());
        buttonBoard.add(exit);


    }


        public void createGameBoard() {
            int index = 0;
            for (int x = 0; x < fieldSize; x++) {
                for (int y = 0; y < fieldSize; y++) {
                    gameBoard.add(buttons[x][y] = new Button(index, x, y, logic, this));
                    index++;
                }

            }
        }

        public void update () {
            for (int x = 0; x < fieldSize; x++) {
                for (int y = 0; y < fieldSize; y++) {
                    if(logic.array[x][y] == "o"){
                    buttons[x][y].setIcon(virus1);
                    }else if(logic.array[x][y] == "x"){
                        buttons[x][y].setIcon(virus2);
                    }else if(logic.array[x][y]=="o1"){
                        buttons[x][y].setIcon(X2);
                    }else if(logic.array[x][y]=="x1"){
                        buttons[x][y].setIcon(X1);
                    }
                }
            }
        }


}
