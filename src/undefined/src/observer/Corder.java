package undefined.src.observer;

import java.util.Observable;
import java.util.Observer;

/**
 * Created by xushuailong on 2016/12/15.
 */
public class Corder implements Observer {
    private String name;
    public Corder(String name){
        this.name = name;
    }
    @Override
    public void update(Observable o, Object arg) {
        System.out.println(name + " 已收到消息 : " + arg);
    }
}
