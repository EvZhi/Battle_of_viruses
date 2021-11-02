package by.evg;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Button extends JButton {
    private int index;

    private MainFrame mainFrame;

    enum StateButton{EMPTY, CROSS, ZERO, DEATH_CROSS, DEATH_ZERO}

    StateButton stateButton = StateButton.EMPTY;

    private boolean moveAlowedX = false;
    private boolean moveAlowedO = false;

    private static boolean nextTurn;

    private int x;
    private int y;

    public Button(int index, int x, int y, MainFrame mainFrame) {
        this.index = index;
        this.mainFrame = mainFrame;
        this.x = x;
        this.y = y;

        this.addActionListener(new MyKeyAdapter());
    }

    public static void setNextTurn(boolean nextTurn){
        Button.nextTurn = nextTurn;
    }

    public void setMoveAlowedX(boolean moveAlowed){
        this.moveAlowedX = moveAlowed;
    }

    public void setMoveAlowedO(boolean moveAlowed){
        this.moveAlowedO = moveAlowed;
    }

    public boolean getMoveAlowedX(){
        return moveAlowedX;
    }

    public boolean getMoveAlowedO(){
        return moveAlowedO;
    }

    public int get_X() {
        return x;
    }
    public int get_Y() {
        return y;
    }

    private class MyKeyAdapter implements ActionListener {


        private GameLogic gameLogic = GameLogic.getInstance();
        private String[][] gameField = gameLogic.getGameField();


        void twoPlayersMode() {

            if (gameLogic.player1.getReadyGo()) {
                System.out.println("Player 1");
                if (stateButton == StateButton.CROSS || stateButton == StateButton.DEATH_CROSS || stateButton == StateButton.DEATH_ZERO) {
                    System.out.println("Клетка занята");
                } else {
                    if (gameLogic.permissionCheckX(x, y)) {
                        if (stateButton == StateButton.ZERO) {
                            gameLogic.player1.killing(x, y);
                        } else {
                            gameLogic.player1.reproduction(x, y);
                        }
                    }
                }
            }

            if (gameLogic.player2.getReadyGo()) {
               System.out.println("Player 2");
               if(stateButton == StateButton.ZERO || stateButton == StateButton.DEATH_CROSS || stateButton == StateButton.DEATH_ZERO){
                   System.out.println("Клетка занята");
               }else {
                   if(gameLogic.permissionCheckO(x,y)){
                       if (stateButton == StateButton.CROSS){
                           gameLogic.player2.killing(x,y);
                       }else{
                           gameLogic.player2.reproduction(x,y);
                       }
                   }
               }
            }

            if (gameLogic.victoryCheckX()){
                System.out.println("Player 1 win!!!");
            }

            if(gameLogic.victoryCheckO()){
                System.out.println("Player 2 win!!!");
            }

            if(gameLogic.player1.getCount() == 3){
               nextTurn = true;
            }

            if(gameLogic.player2.getCount() == 3){
                nextTurn = false;
            }

            if (nextTurn) {
                gameLogic.player1.setReadyGo(false);
                gameLogic.player2.setReadyGo(true);
            } else {
                gameLogic.player1.setReadyGo(true);
                gameLogic.player2.setReadyGo(false);
            }

            switch (gameLogic.player1.getCount()){
                case 3: gameLogic.player1.setCount(0);
            }

            switch (gameLogic.player2.getCount()){
                case 3: gameLogic.player2.setCount(0);
            }

        }



        @Override
        public void actionPerformed(ActionEvent e) {
           if (gameLogic.gameMode == 1){
               twoPlayersMode();
               mainFrame.update();
           }
        }
    }

}







