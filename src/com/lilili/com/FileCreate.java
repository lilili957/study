package com.lilili.com;

import java.io.File;
import java.io.IOException;

/**
 * @Author LiYuan
 * @Date 2021/11/11
 **/
public class FileCreate {

    public static void main(String[] args) throws IOException {
        File file = new File("D:/Demo/excel/fileCreate2.txt");
        boolean newFile = file.createNewFile();
    }
}
