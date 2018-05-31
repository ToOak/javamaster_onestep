package undefined.src.swt;

import java.awt.*;

import static java.awt.BorderLayout.*;

/**
 * Created by xushuailong on 2017/3/27.
 */
public class BorderLayoutTest {
    public static void main(String[] args){
        Frame frame = new Frame("测试窗口");
        frame.setLayout(new BorderLayout(30,5));
        frame.add(new Button("东"),EAST);
        frame.add(new Button("南"),SOUTH);
        frame.add(new Button("西"),WEST);
        frame.add(new Button("北"),NORTH);
//        frame.add(new Button("中"),CENTER);
        Panel p = new Panel();
        p.add(new TextField(20));
        p.add(new Button("单击我"));
        // 默认添加到中间区域中
        frame.add(p);
        frame.pack();
        frame.setVisible(true);
    }
}
