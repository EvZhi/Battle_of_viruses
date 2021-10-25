package by.evg;

public class GameApp {

    public static void main(String[] args) {
         //JFrame.setDefaultLookAndFeelDecorated(true);
         javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Frame();
            }
    });

}
}
