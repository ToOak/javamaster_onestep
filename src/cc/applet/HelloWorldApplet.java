package cc.applet;

import java.applet.Applet;
import java.awt.*;

public class HelloWorldApplet extends Applet {
    String s = "";
    int x;
    int y;

    @Override
    public void init() {
        super.init();
        s = getParameter("vstring");
        x = Integer.parseInt(getParameter("x"));
        y = Integer.parseInt(getParameter("y"));
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.drawString("Hello World!", 20, 20);
        if (s != null) {
            g.drawString(s, x, y);
        }
    }
}
