package cc;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.*;

/**
 * 输出文件夹下的视屏名称 并对其按前边的序号排序 诸如：01、02、10、11、12、100、101、102、110、120
 */
public class traverse {
    public static void main(String[] args) {
        File file = new File("E:\\BaiduYunDownload\\java视频\\java视频");
        String[] files = file.list();
        List<String> fileNameList = new ArrayList<>(Arrays.asList(files));
        Set<String> fileNams = new TreeSet<>((o1, o2) -> {
            String head1 = o1.substring(0, o1.indexOf("."));
            String head2 = o2.substring(0, o2.indexOf("."));
            int headInt1 = Integer.parseInt(head1);
            int headInt2 = Integer.parseInt(head2);
            return headInt1 - headInt2;
        });
        assert files != null;
        fileNams.addAll(Arrays.asList(files));
        Properties properties = new SortedProperties();
        for (String name : fileNams) {
            properties.setProperty(name.substring(0, name.indexOf(".")), name.substring(name.indexOf(".")));
            System.out.println(name);
        }

        System.out.println("****************************");
        for (String name : fileNameList) {
            System.out.println(name);
        }

        System.out.println("++++++++++++++++++++++++++++++++++");
        for (String name : files) {
            System.out.println(name);
        }


        try {
            System.out.println("============" + properties);
            properties.store(
                    new OutputStreamWriter(new FileOutputStream(new File("d:\\3.txt")), "utf-8"),
                    "java 学习大纲");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static class SortedProperties extends Properties {
        @Override
        public synchronized Enumeration<Object> keys() {
            Enumeration keysEnum = super.keys();
            Vector<Object> keyList = new Vector<>();
            while (keysEnum.hasMoreElements()) {
                keyList.add(keysEnum.nextElement().toString());
            }

//            Collections.sort(keyList, (Comparator<Object>) (o1, o2) -> {
            keyList.sort((o1, o2) -> {
                int a = Integer.parseInt(o1.toString());
                int b = Integer.parseInt(o2.toString());
                return a - b;
            });

//            Vector<Object> result = new Vector<>();
//            for (Object o : keyList) {
//                result.add(o.toString());
//            }
            return keyList.elements();
        }
    }
}
