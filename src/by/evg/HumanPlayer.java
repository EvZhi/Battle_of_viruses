package by.evg;

import java.util.Objects;

public class HumanPlayer extends Gamer{

    GameLogic gameLogic;
    String [][] gameField;
    private boolean isReadyGo = false;




    public HumanPlayer(String sign, String signDeath){
        this.sign = sign;
        this.signDeath = signDeath;
    }

    public void setReadyGo(boolean isReadyGo){
        this.isReadyGo = isReadyGo;
    }

    public boolean getReadyGo(){
        return this.isReadyGo;
    }

    @Override
    public boolean reproduction(int x, int y) {
        gameLogic = GameLogic.getInstance();
        gameField = gameLogic.getGameField();
            if (Objects.equals(gameField[x][y], gameLogic.NOT_SIGN)) {
                gameField[x][y] = sign;
                if (Objects.equals(sign, gameLogic.player1.sign)){
                    MainFrame.buttons[x][y].stateButton = Button.StateButton.CROSS;
                    gameLogic.makeMoveAvailableX(x,y);
                }
                if (Objects.equals(sign, gameLogic.player2.sign)){
                    MainFrame.buttons[x][y].stateButton = Button.StateButton.ZERO;
                    gameLogic.makeMoveAvailableO(x,y);
                }
                count = incrementCount();
                System.out.println(this + " Count = " + count);
                System.out.println(this + " " + "размножился на " + "x:" + MainFrame.buttons[x][y].get_X() + " " + "y:" + MainFrame.buttons[x][y].get_Y());
                return true;
            }
        return false;
    }




    @Override
    public boolean killing(int x, int y) {
            if(Objects.equals(gameField[x][y], gameLogic.player1.sign)){
                gameField[x][y] = gameLogic.player1.signDeath;
                MainFrame.buttons[x][y].stateButton = Button.StateButton.DEATH_CROSS;
                gameLogic.makeMoveAvailableO(x,y);
                gameLogic.makeBanMoveX(x,y);
                count = incrementCount();
                System.out.println(this + " Count = " + count);
                System.out.println(this + " " + "убил " + "x:" + MainFrame.buttons[x][y].get_X() + " " + "y:" + MainFrame.buttons[x][y].get_Y());
                return true;
            }
            if(Objects.equals(gameField[x][y], gameLogic.player2.sign)){
                gameField[x][y] = gameLogic.player2.signDeath;
                MainFrame.buttons[x][y].stateButton = Button.StateButton.DEATH_ZERO;
                gameLogic.makeMoveAvailableX(x,y);
                gameLogic.makeBanMoveO(x,y);
                count = incrementCount();
                System.out.println(this + " Count = " + count);
                System.out.println(this + " " + "убил " + "x:" + MainFrame.buttons[x][y].get_X() + " " + "y:" + MainFrame.buttons[x][y].get_Y());
                return true;
            }
        return false;
    }

}
