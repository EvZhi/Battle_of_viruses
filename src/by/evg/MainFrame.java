package by.evg;

import javax.swing.*;
import java.awt.*;
import java.util.Objects;

public class MainFrame extends JFrame {

    private static MainFrame instance = null;

    private String [][] gameField;

    GameLogic gameLogic;

    JPanel gameBoard;

    private static boolean gameIsOn = false;

    ImageIcon virus1 = new ImageIcon(getClass().getResource("resource/virus11.png"));
    ImageIcon virus2 = new ImageIcon(getClass().getResource("resource/virus22.png"));
    ImageIcon X1 = new ImageIcon(getClass().getResource("resource/X11.png"));
    ImageIcon X2 = new ImageIcon(getClass().getResource("resource/X22.png"));

    // Размер игрового поля
    public static final int FIELD_SIZE = 10;


    public static final Button[][] buttons = new Button[FIELD_SIZE][FIELD_SIZE];

    public MainFrame() {
        //Параметры основного окна Windows
        setTitle("BATTLE OF VIRUSES");
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(650, 650);
        setResizable(true);
        setLocationRelativeTo(null);

        //Дефолтная доска на которой распологаются все остальные доски
        JPanel defBoard = new JPanel();
        defBoard.setLayout(new FlowLayout(FlowLayout.LEFT));
        add(defBoard);

        //Игровая доска на которой распологается массив Button
        gameBoard = new JPanel();
        gameBoard.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        gameBoard.setPreferredSize(new Dimension(500, 500));
        gameBoard.setLayout(new GridLayout(10,10));
        defBoard.add(gameBoard);
        createGameBoard();

        gameLogic = GameLogic.getInstance();
        gameField = gameLogic.getGameField();

        //Доска для кнопок New game, Play again, Exit
        JPanel buttonBoard = new JPanel();
        buttonBoard.setLayout(new GridLayout(3, 0, 0, 3));
        defBoard.add(buttonBoard);

        JButton play = new JButton("New game");
        play.addActionListener(e -> {
            if(gameIsOn){
                System.out.println(play.getText());
                clearGameBoard();
                banMoves();
                update();
                gameLogic.player1.setCount(0);
                gameLogic.player2.setCount(0);
                SettingFrame settingFrame = new SettingFrame();
            } else{
                System.out.println(play.getText());
                SettingFrame settingFrame = new SettingFrame();
                gameIsOn = true;
            }
        });
        buttonBoard.add(play);

        JButton play_again = new JButton("Play again");
        play_again.addActionListener(e -> {
            if(gameIsOn){
                System.out.println(play_again.getText());
                clearGameBoard();
                banMoves();
                Button.setNextTurn(false);
                gameLogic.player1.setCount(0);
                gameLogic.player2.setCount(0);
                gameLogic.startGame();
                update();
                } else{
                System.out.println("Игра не началась");
            }
        });
        buttonBoard.add(play_again);

        JButton exit = new JButton("Exit");
        exit.addActionListener(e -> {
            System.out.println(exit.getText());
            this.dispose();

        });
        buttonBoard.add(exit);
    }

    public static synchronized MainFrame getInstance() {
        if (instance == null)
            instance = new MainFrame();
        return instance;
    }

    //Создание игрового поля
    public void createGameBoard() {
        int index = 0;
        for (int x = 0; x < FIELD_SIZE; x++) {
            for (int y = 0; y < FIELD_SIZE; y++) {
                gameBoard.add(buttons[x][y] = new Button(index, x, y,this));
                buttons[x][y].setEnabled(false);
                index++;
            }

        }
    }

    //Активация кнопок
    public void activeButtonGameBoard(){
        for (int x = 0; x < 10; x++) {
            for (int y = 0; y < 10; y++) {
                buttons[x][y].setEnabled(true);
            }
        }
    }

    //Очистка игровой доски
    public void clearGameBoard() {
        for (int x = 0; x < 10; x++) {
            for (int y = 0; y < 10; y++) {
                gameField[x][y] = gameLogic.NOT_SIGN;
                buttons[x][y].setIcon(null);
                buttons[x][y].stateButton = Button.StateButton.EMPTY;
            }
        }
    }

    public void banMoves(){
        for (int x = 0; x < 10; x++) {
            for (int y = 0; y < 10; y++) {
                buttons[x][y].setMoveAlowedX(false);
                buttons[x][y].setMoveAlowedO(false);
            }
        }
    }

    //Обновление игровой доски
    public void update () {
        for (int x = 0; x < FIELD_SIZE; x++) {
            for (int y = 0; y < FIELD_SIZE; y++) {
                if(Objects.equals(gameField[x][y], gameLogic.player1.sign)){
                    buttons[x][y].setIcon(virus1);
                }else if(Objects.equals(gameField[x][y], gameLogic.player2.sign)){
                    buttons[x][y].setIcon(virus2);
                }else if(Objects.equals(gameField[x][y], gameLogic.player1.signDeath)){
                    buttons[x][y].setIcon(X2);
                }else if(Objects.equals(gameField[x][y], gameLogic.player2.signDeath)){
                    buttons[x][y].setIcon(X1);
                }
            }
        }
    }

}
