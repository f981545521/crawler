package cn.acyou.douyin;

import cn.acyou.utils.DownloadImage;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * @author youfang
 * @date 2018-04-22 下午 01:56
 **/
public class MainDown {
    public static void main(String[] args) throws Exception{
        String url = "http://v3-dy.ixigua.com/106ef514b28d5139c33490f4323dee8e/5adc2f1d/video/m/220b42cb24f03a64ff8aa5bdc6e0700252d11569ea600000012c0042292/?device_platform=android&device_type=MI+6&version_code=179&device_id=39195370781&channel=update";
        URL originalURL = new URL(url);
        //打开连接
        HttpURLConnection conn = (HttpURLConnection) originalURL.openConnection();
        //设置请求方式为GET
        conn.setRequestMethod("GET");
        //设置超时时间为5s
        conn.setConnectTimeout(5 * 1000);
        //通过输入流获取图片数据
        InputStream inStream = conn.getInputStream();
        //得到图片的二进制数据，以二进制封装得到数据（具有通用性）
        byte[] data = DownloadImage.readInputStream(inStream);
        File imageFile = new File("F:\\iotest", "do.mp4");
        //创建输出流
        FileOutputStream outStream = new FileOutputStream(imageFile);
        //写入数据
        outStream.write(data);
        //关闭输出流
        outStream.close();

    }


}
