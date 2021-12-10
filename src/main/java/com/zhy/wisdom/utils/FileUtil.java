package com.zhy.wisdom.utils;

import org.junit.Test;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class FileUtil {

    @Test
    public void test() throws IOException {
        String path = "E:\\yue\\test";		//要遍历的路径
        File file = new File(path);		//获取其file对象

        getFilesName(file);
        //System.out.println(filePaths);
        //System.out.println(fileCount);

        String newPath = "E:\\yue\\newData\\";
        for (String filePath:filePaths) {
            File fileItem = new File(filePath);
            String name = fileItem.getName();
            String date = name.substring(0, 8);
            String year = name.substring(0, 4);
            System.out.println(year);
            File yearFile = new File(newPath + year+"\\"+date);
            if (!yearFile.exists()){
                yearFile.mkdirs();
            }
            copyFile(fileItem, newPath + year+"\\"+date+"\\"+fileItem.getName());
        }
    }

    private int fileCount = 0;

    private List<String> filePaths = new ArrayList<>();

    /**
     * 获取所有目录下文件根路径
     * @param file
     * @return
     */
    private void getFilesName(File file) {
        File[] fs = file.listFiles();
        for (File f : fs) {
            if (f.isDirectory())    //若是目录，则递归打印该目录下的文件
                getFilesName(f);
            if (f.isFile()){
                //若是文件，直接打印
                fileCount++;
                filePaths.add(f.getPath());
                // copyFile(f, "E:\\yue\\test\\"+f.getName());
                //System.out.println(f.getPath());
            }
        }
    }

    /**
     * 移动文件
     * @param toPath
     * @param file
     */
    public void moveFile(String toPath, File file){
        file.renameTo(new File(toPath + file.getName()));
    }

    /**
     * 复制单个文件
     * @param oldFile File 原文件
     * @param newPath String 复制后路径 如：f:/fqf.txt
     * @return boolean
     */
    public void copyFile(File oldFile, String newPath) {
        try {
            int bytesum = 0;
            int byteread = 0;
            if (oldFile.exists()) { //文件存在时
                InputStream inStream = new FileInputStream(oldFile.getPath()); //读入原文件
                FileOutputStream fs = new FileOutputStream(newPath);
                byte[] buffer = new byte[1444];
                while ( (byteread = inStream.read(buffer)) != -1) {
                    bytesum += byteread; //字节数 文件大小
                    fs.write(buffer, 0, byteread);
                }
                inStream.close();
            }
        }
        catch (Exception e) {
            System.out.println("复制单个文件操作出错");
            e.printStackTrace();
        }
    }

    @Test
    public void test2(){
        String s = "123456";
        System.out.println(s.substring(0,2));
    }

}
