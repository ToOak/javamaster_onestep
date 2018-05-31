package undefined.src.file;

import java.io.File;
import java.io.IOException;

import static java.lang.System.out;

/**
 * Created by xushuailong on 2017/3/28.
 */
public class FileTest {
    public static void main(String[] args) throws IOException, InterruptedException {
        // 当前路径
        File file = new File(".");
        out.println("name: " + file.getName());
        // 试图获取相对路径的父路径
        out.println("name: " + file.getParent());
        out.println("name: " + file.getAbsoluteFile());
        out.println("name: " + file.getAbsoluteFile().getParent());
//        File tempFile = File.createTempFile("bbb",".txt",new File(file.getAbsoluteFile().getParent()));
        File tempFile = File.createTempFile("aaa",".txt",file);
        // 指定当JVM退出时删除该File
        Thread.sleep(1000);
        tempFile.deleteOnExit();
        File newFile = new File(System.currentTimeMillis() + "");
        out.println("newFile是否存在： " + newFile.exists());
        // 以newFile对象创建一个文件
        out.println("createNewFile: " + newFile.createNewFile());
        // 试图以newFile对象创建一个目录 因newFile已经存在 以下操作不成功 返回false
        out.println("mkdir：" + newFile.mkdir());
        String[] fileList = file.list();
        out.println("当前路径下所有文件和路径：");
        for (String fileNmae : fileList){
            out.println(fileNmae);
        }
        File[] roots = File.listRoots();
        out.println("系统所有根路径：");
        for (File root : roots){
                out.println(root);
        }
    }
}
