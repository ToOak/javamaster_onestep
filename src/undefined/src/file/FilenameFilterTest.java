package undefined.src.file;

import java.io.File;
import java.io.FilenameFilter;

/**
 * Created by xushuailong on 2017/3/29.
 */
public class FilenameFilterTest {
    public static void main(String[] args){
        File file = new File(".");
        String[] nameList = file.list(new MyFilenameFilter());
        System.out.println("this list ============================ ");
        for (String name : nameList){
            System.out.println(name);
        }
    }
}

class MyFilenameFilter implements FilenameFilter{

    @Override
    public boolean accept(File dir, String name) {
        // 如果文件以Java结尾 或是一个文件夹就返回true
        System.out.println("FilenameFilter accept: " + dir.getPath() + "\t" + name);
//        return name.endsWith("java") || new File(name).isDirectory();
        return name.endsWith("java") || new File(dir + File.separator + name).isDirectory();
    }
}