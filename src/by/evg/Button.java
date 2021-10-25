package by.evg;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Button extends JButton {
    private int index;

    private Logic logic;
    private Frame frame;


    private boolean freedom = true;

    private int x;
    private int y;

    public Button(int index, int x, int y, Logic logic, Frame frame) {
        this.index = index;
        this.logic = logic;
        this.frame = frame;
        this.x = x;
        this.y = y;


        this.addActionListener(new MyKeyAdapter());
    }

    private class MyKeyAdapter implements ActionListener {

        private static int count = 0;
        private static int countMotion = 0;

        @Override
        public void actionPerformed(ActionEvent e) {
           if (countMotion <= 3) {
                if (count > 1) {
                    logic.positionUser2(x, y);
                } else {
                    logic.positionUser1(x, y);
                }
                count++;
                switch (count) {
                    case 4:
                        count = 0;
                }
            } else {
                if (count > 2) {
                    logic.positionUser2(x, y);
                } else {
                    logic.positionUser1(x, y);
                }
                count++;
                switch (count) {
                    case 6:
                        count = 0;

                }
            }
            countMotion++;
            frame.update();
        }


    }
}




