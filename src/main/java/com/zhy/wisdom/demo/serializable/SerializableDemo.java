package com.zhy.wisdom.demo.serializable;

import org.junit.Test;

import java.io.*;

public class SerializableDemo {

    @Test
    public void test(){
        Student st = new Student("Tom", 'M', 20, 3.6);
        System.out.println("序列化前的原对象"+st);
        File file = new File("E:\\student.txt");
        try {
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            // Student对象序列化过程
            //FileOutputStream fos = new FileOutputStream(file);
            //ObjectOutputStream oos = new ObjectOutputStream(fos);
            //oos.writeObject(st);
            //oos.flush();
            //oos.close();
            //fos.close();

            // Student对象反序列化过程
            FileInputStream fis = new FileInputStream(file);
            ObjectInputStream ois = new ObjectInputStream(fis);
            Student st1 = (Student) ois.readObject();
            System.out.println("序列化得到的对象"+st1);
            ois.close();
            fis.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



}
