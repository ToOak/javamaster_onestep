package undefined.src.swt;

import java.awt.*;
import java.io.UnsupportedEncodingException;

/**
 * Created by xushuailong on 2017/3/27.
 */
public class FrameTest {
    public static void main(String[] args) throws UnsupportedEncodingException {
        Frame frame = new Frame("测试窗口");
        /*
        // 创建一个Panel容器
        Panel panel = new Panel();
        // 向Panel容器中添加两个控件
        panel.add(new TextField(20));
        panel.add(new Button("单击我"));
        // 将panel添加到frame容器中
        frame.add(panel);
        */
        // 创建一个Scrollpane 制定总是具有滚动条
        ScrollPane sp = new ScrollPane(ScrollPane.SCROLLBARS_ALWAYS);
        sp.add(new TextField(20));
        sp.add(new Button("单击我"));
        frame.add(sp);
        // 设置串口的大小位置
        frame.setBounds(30,30,250,200);
        // 将窗口显示出来 （窗口默认隐藏状态）
        frame.setVisible(true);

    }
}
