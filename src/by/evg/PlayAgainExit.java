package by.evg;

import javax.swing.*;


public class PlayAgainExit extends JButton {

    private Logic logic;
    private Frame frame;
    private Button[][] buttons;

    PlayAgainExit(String text, Logic logic, Frame frame, Button[][] buttons) {
        super(text);
        this.logic = logic;
        this.frame = frame;
        this.buttons = buttons;
    }

    public void play() {
        logic.startPosition();
        frame.update();
    }

    public void restart(){
        clearGameBoard();
        logic.startPosition();
        frame.update();
    }

    public void clearGameBoard() {
        for (int x = 0; x < 10; x++) {
            for (int y = 0; y < 10; y++) {
                logic.array[x][y] = null;
                buttons[x][y].setIcon(null);
            }
        }
    }
}
