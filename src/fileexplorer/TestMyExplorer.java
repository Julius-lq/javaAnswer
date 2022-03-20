package fileexplorer;

import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.Scanner;

/**
 * @author yuansk
 */
public class TestMyExplorer {
    public static void main(String[] args) throws IOException {

        //在当前项目的文件夹下创建一个文件夹用于存储待操作的文件及文件夹
        File file = new File("");
        String path = file.getAbsolutePath()+"\\src\\fileexplorer\\fileplace";
        System.out.println(path);

        MyExplorer me = new MyExplorer();

        me.createFile(new File(path+"/Test"),"txt","op");
        //在C盘创建一个op.txt文件
//        me.createFile(new File("/Test"),"txt","op");
//        //显示Test文件夹下的文件
//        me.showFiles(new File("F:/Test"));
//        me.delFile(new File("F:/Test/op.txt"));
//        System.out.println(".");
//        me.printFile(new File("f1.txt"));
//        me.writeData(new File("f2.txt"),"new");
//        me.shearFile(new File("F:/副本"),new File("F:/oo"));
//        File f = new File("F:/oo");
//        me.delFile(f);
//        f.mkdir();
////        System.out.println(f.isDirectory());
//        //System.out.println(f.delete());
//        //me.listFilesMatchString(new File("F:/ii"),"1");
////        String source = "C:\\system32\\blogs\\changle\\";
////        //验证通过-匹配windows路径
////        System.out.println(source.matches("^[A-z]:\\\\(.+?\\\\)*$"));
////
//        String fileName = "C:/Users/hp/Pictures/my.png";
//        //验证通过-匹配windows文件全名
//        System.out.println(fileName.matches("^[A-z]:\\\\\\S+$"));
//        //验证通过-匹配windows文件全名
//        System.out.println(fileName.matches("^[A-z]:\\\\(\\S+)*$"));
////
//        me.listFilesMatchRegex(new File("F:/TestPicture"),"F:/TestPicture/01.bmp");
//        new File("F:/ii/新建文件夹").mkdir();
//        me.renameFile(new File("F:/ii/新建文件夹"));
//        me.encode(new File("F:/ii/111 - 副本.txt"));
//        me.decode(new File("F:/ii/encoded-111 - 副本.txt"));
//        me.encode(new File("F:/TestPicture/02 - 副本.jpg"));
//        me.decode(new File("F:/TestPicture/encoded-02 - 副本.jpg"));
////

    }
}
