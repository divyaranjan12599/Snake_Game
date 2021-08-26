
package snake;

import java.awt.Color;
import javax.swing.JFrame;

public class Main
{
 public static void main(String[] args) throws Exception
    {
        JFrame obj = new JFrame();
        GamePlay g = new GamePlay();
        obj.setBounds(10, 10, 905, 700);
        obj.setResizable(false);
        obj.setVisible(true);
        obj.setBackground(Color.DARK_GRAY);
        obj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        obj.add(g);
    }
    
}
