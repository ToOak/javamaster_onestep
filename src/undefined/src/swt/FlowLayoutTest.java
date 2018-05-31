package undefined.src.swt;

import java.awt.*;

/**
 * Created by xushuailong on 2017/3/27.
 */
public class FlowLayoutTest {
    public static void main(String[] args){
        Frame frame = new Frame("测试窗口");
        // 左对齐 垂直间距20 水平间距5
        frame.setLayout(new FlowLayout(FlowLayout.LEFT, 20, 5));
        for (int i = 0; i< 10; i++){
            frame.add(new Button("按钮" + i));
        }
        // 设置窗口为最佳大小eswn
        frame.pack();
        frame.setVisible(true);
    }
}
