package com.lsk.huffman;

import java.io.*;
import java.util.Map;

/**
 * @Author:${六月的雨}
 * @Date:2020/11/7 15:28
 * @Description:20data_structure com.lsk.huffman
 */
public class FilesCompress {
    public static void main(String[] args) {
        String srcFile = "D:\\test.png";
        String outFile = "D:\\test.zip";
        zipFile(srcFile,outFile);
//        unZipFile(outFile,srcFile);

    }
    public static void zipFile(String src,String out){
        InputStream is = null;
        OutputStream os = null;
        ObjectOutputStream oos = null;
        try {
            is = new FileInputStream(src);
            byte[] bytes = new byte[is.available()];
            is.read(bytes);
            byte[] huffmanBytes = HuffmanCode.huffmanZip(bytes);
            os = new FileOutputStream(out);
            //与对象流关联，方便解压
            oos = new ObjectOutputStream(os);
            //直接以对象流形式写入
            oos.writeObject(huffmanBytes);
            oos.writeObject(HuffmanCode.huffmanCodes);
            } catch (IOException e) {
                e.printStackTrace();
            }finally {
            try {
                oos.close();
                os.close();
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        System.out.println("压缩成功");

    }
    public static void unZipFile(String src,String out){
        InputStream is = null;
        OutputStream os = null;
        ObjectInputStream ois = null;
        try {
            is = new FileInputStream(src);
            ois = new ObjectInputStream(is);
            byte[] huffmanBytes = (byte[]) ois.readObject();
            Map<Byte,String> huffmanCodeS = (Map<Byte, String>) ois.readObject();
            byte[] bytes = HuffmanCode.decode(huffmanCodeS, huffmanBytes);
            os = new FileOutputStream(out);
            os.write(bytes);

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                ois.close();
                os.close();
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        System.out.println("解压成功");
    }

}
