package com.zhy.wisdom.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.hwpf.extractor.WordExtractor;
import org.apache.poi.hwpf.usermodel.Range;
import org.apache.poi.xwpf.extractor.XWPFWordExtractor;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DocUtil {

    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    public static String doc2String(FileInputStream fs) throws IOException {
        StringBuilder result = new StringBuilder();
        WordExtractor re = new WordExtractor(fs);
        result.append(re.getText());
        re.close();
        return result.toString();
    }

    public static String doc2String(File file) throws IOException {
        return doc2String(new FileInputStream(file));
    }

    public static void readAndWriterDOC(String path) throws IOException {
        System.out.println("readAndWriterDOC start path:"+path);
        File file = new File(path);
        String str = "";
        try {
            FileInputStream fis = new FileInputStream(file);
            HWPFDocument doc = new HWPFDocument(fis);
            String doc1 = doc.getDocumentText();

            System.out.println(doc1);
            System.out.println(doc1);
            StringBuilder doc2 = doc.getText();
            System.out.println(doc2);
            Range rang = doc.getRange();
            String doc3 = rang.text();
            System.out.println(doc3);
            fis.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void readAndWriterDOCX(String path) throws IOException {
        System.out.println("readAndWriterDOCX start path:"+path);
        File file = new File(path);
        String str = "";
        try {
            FileInputStream fis = new FileInputStream(file);
            XWPFDocument xdoc = new XWPFDocument(fis);
            XWPFWordExtractor extractor = new XWPFWordExtractor(xdoc);
            String doc1 = extractor.getText();
            System.out.println(doc1);
            fis.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        // File file = new File("E:\\月月\\2021-1-6王亚芳.doc");
        // try {
        //     System.out.println(doc2String(file));
        // } catch (IOException e) {
        //     e.printStackTrace();
        // }
        // readAndWriterTest4();
    }

    @Test
    public void test() throws IOException {
        readAndWriterDOC("E:\\yue\\新建文件夹 (3)\\2013\\2015-10\\2015-10\\2015-10-27薛恩虎择泰拔针后血肿.doc");
    }
}