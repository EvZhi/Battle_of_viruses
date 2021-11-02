package by.evg;

import javax.swing.*;
import java.awt.*;
import java.util.LinkedList;

public class GameLogic {

    // Наше игровое поле, представляет собой реализацию шаблона "Singleton"
    private static GameLogic instance = null;

    private static String[][] gameField = new String[10][10];



    // Начальное значение ячеек поля
        public final String NOT_SIGN = "*";

    // Признак, что игра закончилась
    boolean gameOver = false;

    // Сообщение, которое появится при завершении игры
    String gameOverMessage = "";

    // 2 игрока
    HumanPlayer player1;
    HumanPlayer player2;

    // gameMode = 1 - режим игры против игрока
    // gameMode = 2 - режим игры против компьютера
    int gameMode = 1;

    public  GameLogic(){
        player1 = new HumanPlayer("X", "Rip_X");
        player2 = new HumanPlayer("O","Rip_O");
    }

    // Получение экземпляра GameField
    public static synchronized GameLogic getInstance() {
        if (instance == null)
            instance = new GameLogic();
        return instance;
    }


    public String[][] getGameField() {
        return gameField;
    }

    public void initializationGameField(){
        for(int x = 0; x < MainFrame.FIELD_SIZE; x++){
            for(int y = 0; y < MainFrame.FIELD_SIZE; y++){
                gameField[x][y] = NOT_SIGN;
            }
        }
    }

    public void startPositionPlayer(){
        MainFrame.buttons[0][0].setMoveAlowedX(true);
        MainFrame.buttons[9][9].setMoveAlowedO(true);
        makeMoveAvailableX(0,0);
        makeMoveAvailableO(9,9);
        System.out.println("Player 1");
        permissionCheckX(0,0);
        player1.reproduction(0,0);
        player1.setReadyGo(true);
        System.out.println("Player 2");
        permissionCheckO(9,9);
        player2.reproduction(9,9);
        player2.setReadyGo(false);
       }

    public void startGame () {
        initializationGameField();
        if (gameMode == 1) {
            startPositionPlayer();
        }else{

        }
    }

    public void makeMoveAvailableX(int x, int y){
        if(x > 0 && y > 0 && x < 9 && y < 9) {
            MainFrame.buttons[x - 1][y + 1].setMoveAlowedX(true);
            MainFrame.buttons[x][y + 1].setMoveAlowedX(true);
            MainFrame.buttons[x + 1][y + 1].setMoveAlowedX(true);
            MainFrame.buttons[x + 1][y].setMoveAlowedX(true);
            MainFrame.buttons[x + 1][y - 1].setMoveAlowedX(true);
            MainFrame.buttons[x][y - 1].setMoveAlowedX(true);
            MainFrame.buttons[x - 1][y - 1].setMoveAlowedX(true);
            MainFrame.buttons[x - 1][y].setMoveAlowedX(true);
        }else if(x == 0 && y == 0){
            MainFrame.buttons[x][y+1].setMoveAlowedX(true);
            MainFrame.buttons[x+1][y+1].setMoveAlowedX(true);
            MainFrame.buttons[x+1][y].setMoveAlowedX(true);
        }else  if(x < 9 && x > 0 && y == 9) {
            MainFrame.buttons[x-1][y].setMoveAlowedX(true);
            MainFrame.buttons[x-1][y-1].setMoveAlowedX(true);
            MainFrame.buttons[x][y-1].setMoveAlowedX(true);
            MainFrame.buttons[x+1][y-1].setMoveAlowedX(true);
            MainFrame.buttons[x+1][y].setMoveAlowedX(true);
        }else  if (x == 9 && y < 9 && y > 0) {
            MainFrame.buttons[x][y - 1].setMoveAlowedX(true);
            MainFrame.buttons[x - 1][y - 1].setMoveAlowedX(true);
            MainFrame.buttons[x - 1][y].setMoveAlowedX(true);
            MainFrame.buttons[x - 1][y+1].setMoveAlowedX(true);
            MainFrame.buttons[x][y+1].setMoveAlowedX(true);
        }else if(x == 9 && y == 9) {
            MainFrame.buttons[x - 1][y].setMoveAlowedX(true);
            MainFrame.buttons[x - 1][y - 1].setMoveAlowedX(true);
            MainFrame.buttons[x][y - 1].setMoveAlowedX(true);
        }else if(x > 0 && x < 9 && y == 0) {
            MainFrame.buttons[x - 1][y].setMoveAlowedX(true);
            MainFrame.buttons[x - 1][y + 1].setMoveAlowedX(true);
            MainFrame.buttons[x][y + 1].setMoveAlowedX(true);
            MainFrame.buttons[x + 1][y + 1].setMoveAlowedX(true);
            MainFrame.buttons[x + 1][y].setMoveAlowedX(true);
        }else if(x == 0 && y > 0 && y < 9) {
            MainFrame.buttons[x][y-1].setMoveAlowedX(true);
            MainFrame.buttons[x + 1][y - 1].setMoveAlowedX(true);
            MainFrame.buttons[x+1][y].setMoveAlowedX(true);
            MainFrame.buttons[x + 1][y + 1].setMoveAlowedX(true);
            MainFrame.buttons[x][y+1].setMoveAlowedX(true);
        }else  if (x == 9 && y == 0){
            MainFrame.buttons[x - 1][y].setMoveAlowedX(true);
            MainFrame.buttons[x - 1][y + 1].setMoveAlowedX(true);
            MainFrame.buttons[x][y + 1].setMoveAlowedX(true);
        }else if(x == 0 && y == 9){
            MainFrame.buttons[x][y-1].setMoveAlowedX(true);
            MainFrame.buttons[x + 1][y - 1].setMoveAlowedX(true);
            MainFrame.buttons[x+1][y].setMoveAlowedX(true);
        }
    }

    public void makeMoveAvailableO(int x, int y){
        if(x > 0 && y > 0 && x < 9 && y < 9) {
            MainFrame.buttons[x - 1][y + 1].setMoveAlowedO(true);
            MainFrame.buttons[x][y + 1].setMoveAlowedO(true);
            MainFrame.buttons[x + 1][y + 1].setMoveAlowedO(true);
            MainFrame.buttons[x + 1][y].setMoveAlowedO(true);
            MainFrame.buttons[x + 1][y - 1].setMoveAlowedO(true);
            MainFrame.buttons[x][y - 1].setMoveAlowedO(true);
            MainFrame.buttons[x - 1][y - 1].setMoveAlowedO(true);
            MainFrame.buttons[x - 1][y].setMoveAlowedO(true);
        }else if(x == 0 && y == 0){
            MainFrame.buttons[x][y+1].setMoveAlowedO(true);
            MainFrame.buttons[x+1][y+1].setMoveAlowedO(true);
            MainFrame.buttons[x+1][y].setMoveAlowedO(true);
        }else  if(x < 9 && x > 0 && y == 9) {
            MainFrame.buttons[x-1][y].setMoveAlowedO(true);
            MainFrame.buttons[x-1][y-1].setMoveAlowedO(true);
            MainFrame.buttons[x][y-1].setMoveAlowedO(true);
            MainFrame.buttons[x+1][y-1].setMoveAlowedO(true);
            MainFrame.buttons[x+1][y].setMoveAlowedO(true);
        }else  if (x == 9 && y < 9 && y > 0) {
            MainFrame.buttons[x][y - 1].setMoveAlowedO(true);
            MainFrame.buttons[x - 1][y - 1].setMoveAlowedO(true);
            MainFrame.buttons[x - 1][y].setMoveAlowedO(true);
            MainFrame.buttons[x - 1][y+1].setMoveAlowedO(true);
            MainFrame.buttons[x][y+1].setMoveAlowedO(true);
        }else if(x == 9 && y == 9) {
            MainFrame.buttons[x - 1][y].setMoveAlowedO(true);
            MainFrame.buttons[x - 1][y - 1].setMoveAlowedO(true);
            MainFrame.buttons[x][y - 1].setMoveAlowedO(true);
        }else if(x > 0 && x < 9 && y == 0) {
            MainFrame.buttons[x - 1][y].setMoveAlowedO(true);
            MainFrame.buttons[x - 1][y + 1].setMoveAlowedO(true);
            MainFrame.buttons[x][y + 1].setMoveAlowedO(true);
            MainFrame.buttons[x + 1][y + 1].setMoveAlowedO(true);
            MainFrame.buttons[x + 1][y].setMoveAlowedO(true);
        }else if(x == 0 && y > 0 && y < 9) {
            MainFrame.buttons[x][y-1].setMoveAlowedO(true);
            MainFrame.buttons[x + 1][y - 1].setMoveAlowedO(true);
            MainFrame.buttons[x+1][y].setMoveAlowedO(true);
            MainFrame.buttons[x + 1][y + 1].setMoveAlowedO(true);
            MainFrame.buttons[x][y+1].setMoveAlowedO(true);
        }else  if (x == 9 && y == 0){
            MainFrame.buttons[x - 1][y].setMoveAlowedO(true);
            MainFrame.buttons[x - 1][y + 1].setMoveAlowedO(true);
            MainFrame.buttons[x][y + 1].setMoveAlowedO(true);
        }else if(x == 0 && y == 9){
            MainFrame.buttons[x][y-1].setMoveAlowedO(true);
            MainFrame.buttons[x + 1][y - 1].setMoveAlowedO(true);
            MainFrame.buttons[x+1][y].setMoveAlowedO(true);
        }
    }

    public void makeBanMoveO(int x, int y){
        if(x > 0 && y > 0 && x < 9 && y < 9) {
            if( MainFrame.buttons[x][y + 1].stateButton == Button.StateButton.EMPTY){
                MainFrame.buttons[x][y + 1].setMoveAlowedO(false);
            }
            if( MainFrame.buttons[x + 1][y + 1].stateButton == Button.StateButton.EMPTY){
                MainFrame.buttons[x + 1][y + 1].setMoveAlowedO(false);
            }
            if( MainFrame.buttons[x - 1][y + 1].stateButton == Button.StateButton.EMPTY){
                MainFrame.buttons[x - 1][y + 1].setMoveAlowedO(false);
            }
            if( MainFrame.buttons[x + 1][y].stateButton == Button.StateButton.EMPTY){
                MainFrame.buttons[x + 1][y].setMoveAlowedO(false);
            }
            if( MainFrame.buttons[x + 1][y - 1].stateButton == Button.StateButton.EMPTY){
                MainFrame.buttons[x + 1][y - 1].setMoveAlowedO(false);
            }
            if( MainFrame.buttons[x][y - 1].stateButton == Button.StateButton.EMPTY){
                MainFrame.buttons[x][y - 1].setMoveAlowedO(false);
            }
            if( MainFrame.buttons[x - 1][y - 1].stateButton == Button.StateButton.EMPTY){
                MainFrame.buttons[x - 1][y - 1].setMoveAlowedO(false);
            }
            if( MainFrame.buttons[x - 1][y].stateButton == Button.StateButton.EMPTY){
                MainFrame.buttons[x - 1][y].setMoveAlowedO(false);
            }
        }else if(x == 0 && y == 0){
            if( MainFrame.buttons[x][y + 1].stateButton == Button.StateButton.EMPTY){
                MainFrame.buttons[x][y + 1].setMoveAlowedO(false);
            }
            if( MainFrame.buttons[x + 1][y + 1].stateButton == Button.StateButton.EMPTY){
                MainFrame.buttons[x + 1][y + 1].setMoveAlowedO(false);
            }
            if( MainFrame.buttons[x + 1][y].stateButton == Button.StateButton.EMPTY){
                MainFrame.buttons[x + 1][y].setMoveAlowedO(false);
            }
        }else  if(x < 9 && x > 0 && y == 9) {
            if( MainFrame.buttons[x - 1][y].stateButton == Button.StateButton.EMPTY){
                MainFrame.buttons[x - 1][y].setMoveAlowedO(false);
            }
            if( MainFrame.buttons[x - 1][y - 1].stateButton == Button.StateButton.EMPTY){
                MainFrame.buttons[x - 1][y - 1].setMoveAlowedO(false);
            }
            if( MainFrame.buttons[x][y - 1].stateButton == Button.StateButton.EMPTY){
                MainFrame.buttons[x][y - 1].setMoveAlowedO(false);
            }
            if( MainFrame.buttons[x + 1][y - 1].stateButton == Button.StateButton.EMPTY){
                MainFrame.buttons[x + 1][y - 1].setMoveAlowedO(false);
            }
            if( MainFrame.buttons[x + 1][y].stateButton == Button.StateButton.EMPTY){
                MainFrame.buttons[x + 1][y].setMoveAlowedO(false);
            }
        }else  if (x == 9 && y < 9 && y > 0) {
            if( MainFrame.buttons[x][y - 1].stateButton == Button.StateButton.EMPTY){
                MainFrame.buttons[x][y - 1].setMoveAlowedO(false);
            }
            if( MainFrame.buttons[x - 1][y - 1].stateButton == Button.StateButton.EMPTY){
                MainFrame.buttons[x - 1][y - 1].setMoveAlowedO(false);
            }
            if( MainFrame.buttons[x - 1][y].stateButton == Button.StateButton.EMPTY){
                MainFrame.buttons[x - 1][y].setMoveAlowedO(false);
            }
            if( MainFrame.buttons[x - 1][y + 1].stateButton == Button.StateButton.EMPTY){
                MainFrame.buttons[x - 1][y + 1].setMoveAlowedO(false);
            }
            if( MainFrame.buttons[x][y + 1].stateButton == Button.StateButton.EMPTY){
                MainFrame.buttons[x][y + 1].setMoveAlowedO(false);
            }
        }else if(x == 9 && y == 9) {
            if( MainFrame.buttons[x - 1][y].stateButton == Button.StateButton.EMPTY){
                MainFrame.buttons[x - 1][y].setMoveAlowedO(false);
            }
            if( MainFrame.buttons[x - 1][y - 1].stateButton == Button.StateButton.EMPTY){
                MainFrame.buttons[x - 1][y - 1].setMoveAlowedO(false);
            }
            if( MainFrame.buttons[x][y - 1].stateButton == Button.StateButton.EMPTY){
                MainFrame.buttons[x][y - 1].setMoveAlowedO(false);
            }
        }else if(x > 0 && x < 9 && y == 0) {
            if( MainFrame.buttons[x - 1][y].stateButton == Button.StateButton.EMPTY){
                MainFrame.buttons[x - 1][y].setMoveAlowedO(false);
            }
            if( MainFrame.buttons[x - 1][y + 1].stateButton == Button.StateButton.EMPTY){
                MainFrame.buttons[x - 1][y + 1].setMoveAlowedO(false);
            }
            if( MainFrame.buttons[x][y + 1].stateButton == Button.StateButton.EMPTY){
                MainFrame.buttons[x][y + 1].setMoveAlowedO(false);
            }
            if( MainFrame.buttons[x + 1][y + 1].stateButton == Button.StateButton.EMPTY){
                MainFrame.buttons[x + 1][y + 1].setMoveAlowedO(false);
            }
            if( MainFrame.buttons[x + 1][y].stateButton == Button.StateButton.EMPTY){
                MainFrame.buttons[x + 1][y].setMoveAlowedO(false);
            }
        }else if(x == 0 && y > 0 && y < 9) {
            if( MainFrame.buttons[x][y - 1].stateButton == Button.StateButton.EMPTY){
                MainFrame.buttons[x][y - 1].setMoveAlowedO(false);
            }
            if( MainFrame.buttons[x + 1][y - 1].stateButton == Button.StateButton.EMPTY){
                MainFrame.buttons[x + 1][y - 1].setMoveAlowedO(false);
            }
            if( MainFrame.buttons[x + 1][y].stateButton == Button.StateButton.EMPTY){
                MainFrame.buttons[x + 1][y].setMoveAlowedO(false);
            }
            if( MainFrame.buttons[x + 1][y + 1].stateButton == Button.StateButton.EMPTY){
                MainFrame.buttons[x + 1][y + 1].setMoveAlowedO(false);
            }
            if( MainFrame.buttons[x][y + 1].stateButton == Button.StateButton.EMPTY){
                MainFrame.buttons[x][y + 1].setMoveAlowedO(false);
            }
        }else  if (x == 9 && y == 0){
            if( MainFrame.buttons[x - 1][y].stateButton == Button.StateButton.EMPTY){
                MainFrame.buttons[x - 1][y].setMoveAlowedO(false);
            }
            if( MainFrame.buttons[x - 1][y + 1].stateButton == Button.StateButton.EMPTY){
                MainFrame.buttons[x - 1][y + 1].setMoveAlowedO(false);
            }
            if( MainFrame.buttons[x][y + 1].stateButton == Button.StateButton.EMPTY){
                MainFrame.buttons[x][y + 1].setMoveAlowedO(false);
            }
        }else if(x == 0 && y == 9){
            if( MainFrame.buttons[x][y - 1].stateButton == Button.StateButton.EMPTY){
                MainFrame.buttons[x][y - 1].setMoveAlowedO(false);
            }
            if( MainFrame.buttons[x + 1][y - 1].stateButton == Button.StateButton.EMPTY){
                MainFrame.buttons[x + 1][y - 1].setMoveAlowedO(false);
            }
            if( MainFrame.buttons[x + 1][y].stateButton == Button.StateButton.EMPTY){
                MainFrame.buttons[x + 1][y].setMoveAlowedO(false);
            }
        }
    }

    public void makeBanMoveX(int x, int y){
        if(x > 0 && y > 0 && x < 9 && y < 9) {
            if( MainFrame.buttons[x][y + 1].stateButton == Button.StateButton.EMPTY){
                MainFrame.buttons[x][y + 1].setMoveAlowedX(false);
            }
            if( MainFrame.buttons[x + 1][y + 1].stateButton == Button.StateButton.EMPTY){
                MainFrame.buttons[x + 1][y + 1].setMoveAlowedX(false);
            }
            if( MainFrame.buttons[x - 1][y + 1].stateButton == Button.StateButton.EMPTY){
                MainFrame.buttons[x - 1][y + 1].setMoveAlowedX(false);
            }
            if( MainFrame.buttons[x + 1][y].stateButton == Button.StateButton.EMPTY){
                MainFrame.buttons[x + 1][y].setMoveAlowedX(false);
            }
            if( MainFrame.buttons[x + 1][y - 1].stateButton == Button.StateButton.EMPTY){
                MainFrame.buttons[x + 1][y - 1].setMoveAlowedX(false);
            }
            if( MainFrame.buttons[x][y - 1].stateButton == Button.StateButton.EMPTY){
                MainFrame.buttons[x][y - 1].setMoveAlowedX(false);
            }
            if( MainFrame.buttons[x - 1][y - 1].stateButton == Button.StateButton.EMPTY){
                MainFrame.buttons[x - 1][y - 1].setMoveAlowedX(false);
            }
            if( MainFrame.buttons[x - 1][y].stateButton == Button.StateButton.EMPTY){
                MainFrame.buttons[x - 1][y].setMoveAlowedX(false);
            }
        }else if(x == 0 && y == 0){
            if( MainFrame.buttons[x][y + 1].stateButton == Button.StateButton.EMPTY){
                MainFrame.buttons[x][y + 1].setMoveAlowedX(false);
            }
            if( MainFrame.buttons[x + 1][y + 1].stateButton == Button.StateButton.EMPTY){
                MainFrame.buttons[x + 1][y + 1].setMoveAlowedX(false);
            }
            if( MainFrame.buttons[x + 1][y].stateButton == Button.StateButton.EMPTY){
                MainFrame.buttons[x + 1][y].setMoveAlowedX(false);
            }
        }else  if(x < 9 && x > 0 && y == 9) {
            if( MainFrame.buttons[x - 1][y].stateButton == Button.StateButton.EMPTY){
                MainFrame.buttons[x - 1][y].setMoveAlowedX(false);
            }
            if( MainFrame.buttons[x - 1][y - 1].stateButton == Button.StateButton.EMPTY){
                MainFrame.buttons[x - 1][y - 1].setMoveAlowedX(false);
            }
            if( MainFrame.buttons[x][y - 1].stateButton == Button.StateButton.EMPTY){
                MainFrame.buttons[x][y - 1].setMoveAlowedX(false);
            }
            if( MainFrame.buttons[x + 1][y - 1].stateButton == Button.StateButton.EMPTY){
                MainFrame.buttons[x + 1][y - 1].setMoveAlowedX(false);
            }
            if( MainFrame.buttons[x + 1][y].stateButton == Button.StateButton.EMPTY){
                MainFrame.buttons[x + 1][y].setMoveAlowedX(false);
            }
        }else  if (x == 9 && y < 9 && y > 0) {
            if( MainFrame.buttons[x][y - 1].stateButton == Button.StateButton.EMPTY){
                MainFrame.buttons[x][y - 1].setMoveAlowedX(false);
            }
            if( MainFrame.buttons[x - 1][y - 1].stateButton == Button.StateButton.EMPTY){
                MainFrame.buttons[x - 1][y - 1].setMoveAlowedX(false);
            }
            if( MainFrame.buttons[x - 1][y].stateButton == Button.StateButton.EMPTY){
                MainFrame.buttons[x - 1][y].setMoveAlowedX(false);
            }
            if( MainFrame.buttons[x - 1][y + 1].stateButton == Button.StateButton.EMPTY){
                MainFrame.buttons[x - 1][y + 1].setMoveAlowedX(false);
            }
            if( MainFrame.buttons[x][y + 1].stateButton == Button.StateButton.EMPTY){
                MainFrame.buttons[x][y + 1].setMoveAlowedX(false);
            }
        }else if(x == 9 && y == 9) {
            if( MainFrame.buttons[x - 1][y].stateButton == Button.StateButton.EMPTY){
                MainFrame.buttons[x - 1][y].setMoveAlowedX(false);
            }
            if( MainFrame.buttons[x - 1][y - 1].stateButton == Button.StateButton.EMPTY){
                MainFrame.buttons[x - 1][y - 1].setMoveAlowedX(false);
            }
            if( MainFrame.buttons[x][y - 1].stateButton == Button.StateButton.EMPTY){
                MainFrame.buttons[x][y - 1].setMoveAlowedX(false);
            }
        }else if(x > 0 && x < 9 && y == 0) {
            if( MainFrame.buttons[x - 1][y].stateButton == Button.StateButton.EMPTY){
                MainFrame.buttons[x - 1][y].setMoveAlowedX(false);
            }
            if( MainFrame.buttons[x - 1][y + 1].stateButton == Button.StateButton.EMPTY){
                MainFrame.buttons[x - 1][y + 1].setMoveAlowedX(false);
            }
            if( MainFrame.buttons[x][y + 1].stateButton == Button.StateButton.EMPTY){
                MainFrame.buttons[x][y + 1].setMoveAlowedX(false);
            }
            if( MainFrame.buttons[x + 1][y + 1].stateButton == Button.StateButton.EMPTY){
                MainFrame.buttons[x + 1][y + 1].setMoveAlowedX(false);
            }
            if( MainFrame.buttons[x + 1][y].stateButton == Button.StateButton.EMPTY){
                MainFrame.buttons[x + 1][y].setMoveAlowedX(false);
            }
        }else if(x == 0 && y > 0 && y < 9) {
            if( MainFrame.buttons[x][y - 1].stateButton == Button.StateButton.EMPTY){
                MainFrame.buttons[x][y - 1].setMoveAlowedX(false);
            }
            if( MainFrame.buttons[x + 1][y - 1].stateButton == Button.StateButton.EMPTY){
                MainFrame.buttons[x + 1][y - 1].setMoveAlowedX(false);
            }
            if( MainFrame.buttons[x + 1][y].stateButton == Button.StateButton.EMPTY){
                MainFrame.buttons[x + 1][y].setMoveAlowedX(false);
            }
            if( MainFrame.buttons[x + 1][y + 1].stateButton == Button.StateButton.EMPTY){
                MainFrame.buttons[x + 1][y + 1].setMoveAlowedX(false);
            }
            if( MainFrame.buttons[x][y + 1].stateButton == Button.StateButton.EMPTY){
                MainFrame.buttons[x][y + 1].setMoveAlowedX(false);
            }
        }else  if (x == 9 && y == 0){
            if( MainFrame.buttons[x - 1][y].stateButton == Button.StateButton.EMPTY){
                MainFrame.buttons[x - 1][y].setMoveAlowedX(false);
            }
            if( MainFrame.buttons[x - 1][y + 1].stateButton == Button.StateButton.EMPTY){
                MainFrame.buttons[x - 1][y + 1].setMoveAlowedX(false);
            }
            if( MainFrame.buttons[x][y + 1].stateButton == Button.StateButton.EMPTY){
                MainFrame.buttons[x][y + 1].setMoveAlowedX(false);
            }
        }else if(x == 0 && y == 9){
            if( MainFrame.buttons[x][y - 1].stateButton == Button.StateButton.EMPTY){
                MainFrame.buttons[x][y - 1].setMoveAlowedX(false);
            }
            if( MainFrame.buttons[x + 1][y - 1].stateButton == Button.StateButton.EMPTY){
                MainFrame.buttons[x + 1][y - 1].setMoveAlowedX(false);
            }
            if( MainFrame.buttons[x + 1][y].stateButton == Button.StateButton.EMPTY){
                MainFrame.buttons[x + 1][y].setMoveAlowedX(false);
            }
        }
    }

    public boolean permissionCheckX (int x, int y){
        if(MainFrame.buttons[x][y].getMoveAlowedX()){
            System.out.println("Ход разрешен");
            return true;
        }else {
            System.out.println("Ход запрещен");
        }
        return false;
    }

    public boolean permissionCheckO (int x, int y){
        if(MainFrame.buttons[x][y].getMoveAlowedO()){
            System.out.println("Ход разрешен");
            return true;
        }else {
            System.out.println("Ход запрещен");
        }
        return false;
    }

    public boolean victoryCheckX(){
        int countO = 0;
        for(int x = 0; x < MainFrame.FIELD_SIZE; x ++){
            for(int y = 0; y < MainFrame.FIELD_SIZE; y++){
                if(MainFrame.buttons[x][y].stateButton == Button.StateButton.ZERO ){
                    ++countO;
                }
            }
        }
        if(countO == 0) {
            return true;
        }
        return  false;
    }
    public boolean victoryCheckO(){
        int countX = 0;
        for(int x = 0; x < MainFrame.FIELD_SIZE; x ++){
            for(int y = 0; y < MainFrame.FIELD_SIZE; y++){
                if(MainFrame.buttons[x][y].stateButton == Button.StateButton.CROSS){
                    ++countX;
                }
            }
        }
        if(countX == 0){
            return true;
        }
        return  false;
    }





}

