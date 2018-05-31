package undefined.src.annotation;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.lang.reflect.Field;

/**
 * Created by xushuailong on 2017/3/28.
 */
public class ActionListenerInstaller {
    public static void processAnnotations(Object object) {
        try {
            Class c1 = object.getClass();
            for (Field f : c1.getDeclaredFields()) {
                f.setAccessible(true);
                ActionListenerFor a = f.getAnnotation(ActionListenerFor.class);
                Object fObj = f.get(object);
                if (a != null && fObj != null && fObj instanceof AbstractButton){
                    Class<? extends ActionListener> listenerClass = a.listener();
                    ActionListener a1 = listenerClass.newInstance();
                    AbstractButton ab = (AbstractButton) fObj;
                    ab.addActionListener(a1);
                }
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
    }
}
