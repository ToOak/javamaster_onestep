package undefined.src.extendsTest;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by xushuailong on 2017/3/16.
 */
public class Main {
    public static void main(String[] args){
        //编译时 与 运行时 的不同表现
        Parent ps = new Stub();
        System.out.println("ps.a : " + ps.a);
        ps.base();
        ps.test();
        try {
            Field psA = ps.getClass().getField("a");
            Object a = psA.get(ps);
            System.out.println("stub a : " + a);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        Method[] psMethod = ps.getClass().getDeclaredMethods();
        if (psMethod.length > 0 ){
            for (Method method : psMethod){
                System.out.println("psMethod: " + method.getName());
                if (method.getName().equals("stub")){
                    try {
//                        method.invoke(ps,null);
//                        method.invoke(ps,new Class[0]);
//                        method.invoke(ps,new Object[0]);
                        method.invoke(ps,new Object[]{});
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    } catch (InvocationTargetException e) {
                        e.printStackTrace();
                    }
                }
                if (method.getName().equals("studPrivate")){
                    method.setAccessible(true);
                    try {
                        method.invoke(ps,new Object[0]);
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    } catch (InvocationTargetException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

        try {
            Class parent = Class.forName("extendsTest.Parent");
            try {
                Method method = parent.getMethod("test",new Class[0]);
                method.invoke(new Parent(),new Object[0]);
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            Class methodClass = Class.forName("java.lang.Object");
            Method[] methods = methodClass.getDeclaredMethods();
            for (Method method : methods){
                System.out.println("methodClass: " + method.getName());
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        Pattern pattern = Pattern.compile("^(((13[0-9]{1})|(15[0-9]{1})|(18[0-9]{1}))\\d{8})$");
        Matcher matcher = pattern.matcher("15978654321");
        System.out.println(matcher.matches());
    }
}
