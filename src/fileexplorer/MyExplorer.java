package fileexplorer;

import java.io.*;
import java.util.Objects;
import java.util.Scanner;

/**
 * @author: liuqing
 * date: 2022/3/10 14:22
 * Description:
 */
public class MyExplorer implements Explorer {

    //将文件(夹)从源文件夹复制到目的文件夹
    @Override
    public void copyFile(File sourceFile, File desFile) throws IOException {
        if (!desFile.exists()) {
            boolean isMade = desFile.mkdirs();
        }
        String souPath = sourceFile.getAbsolutePath();
        String desPath = desFile.getAbsolutePath();
        if (sourceFile.isDirectory()) {
            File[] files = sourceFile.listFiles();
            if (files != null) {
                for (File file : files) {
                    if (file.isDirectory()) {
                        copyFile(new File(souPath + "\\" + file.getName()),
                                new File(desPath + "\\" + file.getName()));
                    } else {
                        copyOnlyFile(new File(file.getAbsolutePath()),
                                new File(desPath + "\\" + file.getName()));//写入到目的文件要加文件名字，
                        //desPath是一个文件夹，并不是一个文件，需要加上文件名才能创建一个可写入的文件，（文本是不能写到文件夹里面的
                    }
                }
            }
        } else {
            copyOnlyFile(new File(souPath), desFile);
        }
    }

    //删除文件或文件夹
    @Override
    public void delFile(File file) {
        if (file.isDirectory()) {
            File[] files = file.listFiles();
            if (files != null) {
                for (File f : files) {
                    if (f.isFile()) {
                        boolean isDeleted = f.delete();
                    } else {
                        delFile(f);
                    }
                }
            }
        }
        boolean isDeleted = file.delete();
    }

    //将文件(夹)从源文件夹剪切到目的文件夹
    @Override
    public void shearFile(File sourceFile, File desFile) throws IOException {
        if (sourceFile.exists()) {
            copyFile(sourceFile, desFile);
            delFile(sourceFile);
        } else {
            System.out.println("File Not Exists !");
        }
    }

    //重命名文件
    @Override
    public void renameFile(File desFile) {
        if (!desFile.exists()) {
            System.out.println("文件不存在");
        } else {
            System.out.println("请输入新的名字：");
            String newName = new Scanner(System.in).nextLine();
            //System.out.println(newName);
            if (newName != null) {
                if (desFile.renameTo(new File(desFile.getParentFile().getAbsolutePath() + "/" + newName))) {
                    System.out.println("重命名成功!");
                }
            } else {
                System.out.println("输入为空，重命名失败");
            }
        }
    }

    //打印文件夹中的所有文件的文件名
    @Override
    public void showFiles(File filePath) {
        if (filePath.isDirectory()) {
            String[] str = filePath.list();
            if (str == null) {
                System.out.println("指定文件夹为空");
            } else {
                System.out.println("Directory < " + filePath.getName() + " > Include : ");
                for (String s : str) {
                    System.out.println(s);
                }
            }
        } else {
            System.out.println("指定文件夹为非文件夹格式");
        }
    }

    //创建在指定文件夹中创建文件
    @Override
    public void createFile(File desFile, String suffix, String name) throws IOException {
        boolean isCreated = false;
        if (!desFile.exists()) {
            if (desFile.mkdirs()) {
                System.out.println("The destination folder < " + desFile.getName() + " > does not exist. It has been created automatically for you !");
            } else {
                System.out.println("The destination folder < " + desFile.getName() + " > does not exist, the system failed to automatically create it for you !");
            }
        }
        if (name != null && suffix != null) {
            if (new File(desFile + "//" + name + "." + suffix).createNewFile()) {
                isCreated = true;
            }
        }
        if (isCreated) {
            System.out.println("创建成功!");
        } else {
            System.out.println("创建失败!");
        }
    }

    //复制文件到指定文件夹下
    public void copyOnlyFile(File souFile, File desFile) {
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
        try {
            bis = new BufferedInputStream(new FileInputStream(souFile));
            bos = new BufferedOutputStream(new FileOutputStream(desFile));
            byte[] bytes = new byte[1024];
            int len = 0;
            while ((len = bis.read(bytes)) != -1) {
                bos.write(bytes, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bis != null) {
                try {
                    bis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (bos != null) {
                try {
                    bos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    //将目标文件以特定方式加密
    @Override
    public void encode(File desFile) throws IOException {
        if (desFile.exists()) {
            File seFile = new File(desFile.getParentFile().getAbsolutePath() + "/encoded-" + desFile.getName());
            boolean isSeFileCreated = seFile.createNewFile();

            File ef = new File("C:\\Users\\Public\\encodedFiles");
            if (!ef.exists()) {
                boolean temp = ef.mkdirs();
            }

            File passwordFile = new File(ef.getAbsolutePath() + "/" + seFile.hashCode() + ".txt");
            boolean isPwFileCreated = passwordFile.createNewFile();

            System.out.println("Please Input Password (0 ~ 9 And Length < 6):");
            String password = new Scanner(System.in).next();

            RandomAccessFile raf = new RandomAccessFile(passwordFile, "rw");
            raf.write(password.getBytes());
            raf.close();

            FileInputStream fis = new FileInputStream(desFile);
            FileOutputStream fos = new FileOutputStream(seFile);
            BufferedInputStream bis = new BufferedInputStream(fis);
            BufferedOutputStream bos = new BufferedOutputStream(fos);

            int len;
            while ((len = bis.read()) != -1) {
                len = len ^ Integer.parseInt(password);
                bos.write(len);
            }
            bis.close();
            bos.close();
            boolean isDelete = desFile.delete();//删除文件之前必须先关闭调用文件的流，否则无法删除文件

            if (isSeFileCreated && isPwFileCreated && isDelete) {
                System.out.println("Encode Successfully !");
            } else {
                System.out.println("Encode Fail !");

            }
        } else {
            System.out.println("This File Not Exists !");
        }
    }

    //将目标文件以特定方式解密
    @Override
    public void decode(File desFile) throws IOException {
        if (desFile.exists()) {

            File pw = new File("C:\\Users\\Public\\encodedFiles\\" + desFile.hashCode() + ".txt");

            if (pw.exists()) {
                boolean isRight = false;
                boolean isDelete = false;
                boolean isCreated = false;

                BufferedReader br = new BufferedReader(new FileReader(pw));
                String password = br.readLine();
                br.close();

                System.out.println("Please Input Password (0 ~ 9 And Length < 6):");
                String inPut = new Scanner(System.in).nextLine();

                if (password.equals(inPut)) {
                    File seFile = new File(desFile.getParentFile().getAbsolutePath() + "/" + desFile.getName().substring(8));
                    isCreated = seFile.createNewFile();

                    isRight = true;

                    FileInputStream fis = new FileInputStream(desFile);
                    FileOutputStream fos = new FileOutputStream(seFile);
                    BufferedInputStream bis = new BufferedInputStream(fis);
                    BufferedOutputStream bos = new BufferedOutputStream(fos);

                    int len;
                    while ((len = bis.read()) != -1) {
                        len = len ^ Integer.parseInt(password);
                        bos.write(len);
                    }
                    bis.close();
                    bos.close();

                    isDelete = desFile.delete() && pw.delete();

                } else {
                    System.out.println("Password Is Wrong !");
                }

                if (isCreated && isRight && isDelete) {
                    System.out.println("Decode Successfully !");
                } else {
                    System.out.println("Decode Fail !");
                }

            } else {
                System.out.println("This File Is Not Encoded !");
            }
        } else {
            System.out.println("This File Not Exists !");
        }
    }

    //将文件内容打印出来
    @Override
    public void printFile(File file) {
        if (file.exists() && file.isFile()) {
            FileInputStream fis = null;
            BufferedInputStream bis = null;
            try {
                fis = new FileInputStream(file);
                bis = new BufferedInputStream(fis);
                byte[] bytes = new byte[1024];
                int len;
                while ((len = bis.read(bytes)) != -1) {
                    System.out.println(new String(bytes, 0, len));
                }

            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    if (bis != null) {
                        bis.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } else {
            System.out.println("File printing failed, because the file does not exist !");
        }

    }

    //将数据写入文件
    @Override
    public void writeData(File file, String data) throws IOException {
        if (data != null) {
            if (!file.exists()) {
                boolean isCreated = file.createNewFile();
            }
            BufferedOutputStream bos = null;
            try {
                bos = new BufferedOutputStream(new FileOutputStream(file));
                bos.write(data.getBytes());
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (bos != null) {
                    try {
                        bos.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
            System.out.println("File Writing Successfully !");
        }
    }

    //根据正则表达式在查找对应文件
    @Override
    public void listFilesMatchRegex(File root, String regex) {
        String fileName = null;
        if (regex.matches("^[A-z]:\\\\\\S+$")) {
            fileName = regex.substring(regex.lastIndexOf("\\") + 1, regex.length());
        }
        listFilesMatchString(root, fileName);
    }

    //模糊查找
    @Override
    public void listFilesMatchString(File root, String name) {
        boolean isDirectory = root.isDirectory();
        boolean isExists = root.exists();
        boolean isEmpty = root.listFiles() == null;
        boolean isNameEmpty = name == null;
        if (isExists && isDirectory && !isEmpty && !isNameEmpty) {
            for (File file : Objects.requireNonNull(root.listFiles())) {
                if (file.getName().contains(name)) {
                    System.out.println(file.getName());
                }
                if (file.isDirectory()) {
                    listFilesMatchString(file, name);
                }
            }

        } else if (!isExists) {
            System.out.println("File 《" + name + "》 Not Exist !");
        } else if (!isDirectory) {
            System.out.println("File 《" + name + "》 is not folder !");
        } else if (isEmpty) {
            System.out.println("File 《" + name + "》 Is Empty !");
        } else {
            System.out.println("Name Is Empty !");
        }
    }
}