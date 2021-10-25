package by.evg;

public class Logic {
    public String[][] array = new String[10][10];

    public boolean write(int x, int y, String symbol) {
        if(array[x][y]==null){
            array[x][y] = symbol;
            return true;
        }else if(array[x][y]=="o"){
            array[x][y] = "o1";
            return true;
        }else if(array[x][y]=="x"){
            array[x][y] = "x1";
            return true;
        }else {return false; }
        }

    public boolean positionUser1(int x, int y) {
        return write(x, y,"o");
    }

    public boolean positionUser2(int x, int y) {
        return write(x, y,"x");
    }

    public void startPosition(){
        this.positionUser1(0,0);
        this.positionUser2(9,9);
    }




}
