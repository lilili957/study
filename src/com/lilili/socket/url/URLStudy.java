package com.lilili.socket.url;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * @Author LiYuan
 * @Date 2022/1/4
 **/
public class URLStudy {
    public static void main(String[] args) {
        //url
        String url = "https://www.baidu.com/";
        URL reqUrl = null;
        try {

            reqUrl = new URL(url);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        try (
                InputStream is = reqUrl.openStream();
                InputStreamReader isr = new InputStreamReader(is, "UTF-8");
                BufferedReader buffer = new BufferedReader(isr);
        ) {
            StringBuilder str = new StringBuilder();
            String line = null;
            while ((line = buffer.readLine()) != null) {
                str.append(line);
                str.append("\n");
            }
            System.out.println(str);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
