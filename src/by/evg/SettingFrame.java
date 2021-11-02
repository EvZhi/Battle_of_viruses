package by.evg;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SettingFrame extends JFrame {

    SettingFrame settingFrame = this;
    public SettingFrame(){


        setTitle("Game settings");
        setBounds(450, 450, 240, 190);
        setResizable(false);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        JLabel jLabelMode = new JLabel("Select the game mode:");
        add(jLabelMode);
        JRadioButton radioButtonModeTwoPlayers = new JRadioButton("Player vs player");
        add(radioButtonModeTwoPlayers);
        radioButtonModeTwoPlayers.setSelected(true);
        JRadioButton radioButtonModeAgainstAI = new JRadioButton("Player vs computer");
        add(radioButtonModeAgainstAI);
        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(radioButtonModeTwoPlayers);
        buttonGroup.add(radioButtonModeAgainstAI);
        JButton jButtonSetSettings = new JButton("Play");
        add(jButtonSetSettings);
        setVisible(true);


        jButtonSetSettings.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                MainFrame mainFrame = MainFrame.getInstance();
                mainFrame.activeButtonGameBoard();
                GameLogic gameLogic = GameLogic.getInstance();
                if(radioButtonModeAgainstAI.isSelected()){
                    gameLogic.gameMode = 2;
                }
                System.out.println("Выбран gameMod "+gameLogic.gameMode);
                System.out.println("Началась игра");
                Button.setNextTurn(false);
                gameLogic.startGame();
                mainFrame.update();
                settingFrame.dispose();

            }

        });
    }
}

