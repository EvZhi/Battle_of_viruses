package by.evg;

public abstract class Gamer {
    protected String sign;
    protected String signDeath;
    protected  int count = 0;


    public abstract boolean reproduction(int x, int y);
    public abstract boolean killing(int x, int y);

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int incrementCount(){
        return ++count;
    }

}
