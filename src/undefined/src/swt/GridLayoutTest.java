package undefined.src.swt;

import java.awt.*;

import static java.awt.BorderLayout.NORTH;

/**
 * Created by xushuailong on 2017/3/27.
 */
public class GridLayoutTest {
    public static void main(String[] args) {
        Frame frame = new Frame("计算器");
        Panel panel = new Panel();
        panel.add(new TextField(30));
        frame.add(panel, NORTH);
        Panel panel1 = new Panel();
        panel1.setLayout(new GridLayout(3, 5, 4, 4));
        String[] name = {
                "0", "1", "2", "3", "4",
                "5", "6", "7", "8", "9",
                "+", "-", "*", "/", "."
        };
        for (int i = 0;i < name.length;i++){
            panel1.add(new Button(name[i]));
        }
        frame.add(panel1);
        frame.pack();
        frame.setVisible(true);
    }
}
