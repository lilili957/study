package com.lilili.socket.url;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author LiYuan
 * @Date 2022/1/4
 **/
public class HttpURLConnectionStudy {
    public static void main(String[] args) {
        String webUrl = "http://localhost:8001/restTemplate/get?name=lilili";
        try {
            URL url = new URL(webUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            //打开网络通信输入流
            InputStream is = connection.getInputStream();
            //字节转字符
            InputStreamReader isr = new InputStreamReader(is, "UTF-8");
            //缓冲流， = 包装流
            BufferedReader buffer = new BufferedReader(isr);
            StringBuilder result = new StringBuilder();
            String append;
            while ((append = buffer.readLine())!= null) {
                result.append(append);
            }
            System.out.println(result);
            //关闭连接
            connection.disconnect();
            is.close();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
