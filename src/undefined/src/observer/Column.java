package undefined.src.observer;


import java.util.Observable;

/**
 * Created by xushuailong on 2016/12/15.
 */
public class Column extends Observable{
    public void postNewPublication(String content){
        setChanged();
        notifyObservers(content);
    }
}
