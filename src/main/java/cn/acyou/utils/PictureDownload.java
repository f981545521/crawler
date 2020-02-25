package cn.acyou.utils;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * @author youfang
 * @version [1.0.0, 2020-02-14 下午 11:04]
 * @since [司法公证]
 **/
public class PictureDownload {
    public static void main(String[] args) {
        String url = "https://name.meinv.pw/201911/564bb21641ce202610dfbc8c3382f011.jpg";
        downloadPicture(url);
    }
    //链接url下载图片
    private static void downloadPicture(String urlList) {
        URL url = null;
        try {
            url = new URL(urlList);
            DataInputStream dataInputStream = new DataInputStream(url.openStream());

            String imageName =  "E:\\VOOC\\test.jpg";

            FileOutputStream fileOutputStream = new FileOutputStream(new File(imageName));
            ByteArrayOutputStream output = new ByteArrayOutputStream();

            byte[] buffer = new byte[1024];
            int length;

            while ((length = dataInputStream.read(buffer)) > 0) {
                output.write(buffer, 0, length);
            }
            byte[] context=output.toByteArray();
            fileOutputStream.write(output.toByteArray());
            dataInputStream.close();
            fileOutputStream.close();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
