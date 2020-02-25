package cn.acyou.utils;


import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.log4j.Logger;

/**
 * @author youfang
 * @version [1.0.0, 2020-02-14 下午 11:07]
 * @since [司法公证]
 **/
public class DownloadPictureTest {
    private static Logger logger = Logger.getLogger(DownloadPictureTest.class);

    /**
     * @param args
     */
    public static void main(String[] args) {
        String link = "https://name.meinv.pw/201911/564bb21641ce202610dfbc8c3382f011.jpg";
        String folder = "E:\\VOOC\\heyzo\\";
        //downloadPicture(link, folder, "123.jpg");
        downLoadFromUrl(link, "233.jpg", folder);
    }

    public static void downLoadFromUrl(String urlStr, String savePath) {
        downLoadFromUrl(urlStr, null, savePath);
    }
    public static void downLoadFromUrl(String urlStr, String fileName, String savePath) {
        try {
            URL url = new URL(urlStr);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            // 设置超时间为3秒
            conn.setConnectTimeout(10 * 1000);
            // 防止屏蔽程序抓取而返回403错误
            //conn.setRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 5.0; Windows NT; DigExt)");
            conn.setRequestProperty("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3");
            conn.setRequestProperty("Accept-Encoding", "gzip, deflate, br");
            conn.setRequestProperty("Accept-Language", "zh-CN,zh;q=0.9,en;q=0.8");
            conn.setRequestProperty("Cache-Control", "no-cache");
            conn.setRequestProperty("Connection", "keep-alive");
            conn.setRequestProperty("Host", "name.meinv.pw");
            conn.setRequestProperty("Pragma", "no-cache");
            conn.setRequestProperty("Sec-Fetch-Mode", "navigate");
            conn.setRequestProperty("Sec-Fetch-Site", "none");
            conn.setRequestProperty("Sec-Fetch-User", "?1");
            conn.setRequestProperty("Sec-Fetch-User", "?1");
            conn.setRequestProperty("Upgrade-Insecure-Requests", "1");
            conn.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/78.0.3904.70 Safari/537.36");

            // 得到输入流
            InputStream inputStream = conn.getInputStream();
            // 获取自己数组
            byte[] getData = readInputStream(inputStream);

            // 文件保存位置
            File saveDir = new File(savePath);
            if (!saveDir.exists()) {
                saveDir.mkdir();
            }
            if (StringUtils.isEmpty(fileName)){
                fileName = urlStr.substring(urlStr.lastIndexOf('/')+1);
            }
            File file = new File(saveDir + File.separator + fileName);
            FileOutputStream fos = new FileOutputStream(file);
            fos.write(getData);
            if (fos != null) {
                fos.close();
            }
            if (inputStream != null) {
                inputStream.close();
            }
        } catch (Exception e) {
            logger.error("下载失败!", e);
        }
    }

    /**
     * 从输入流中获取字节数组
     *
     * @param inputStream
     * @return
     * @throws IOException
     */
    public static byte[] readInputStream(InputStream inputStream)
            throws IOException {
        byte[] buffer = new byte[1024];
        int len = 0;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        while ((len = inputStream.read(buffer)) != -1) {
            bos.write(buffer, 0, len);
        }
        bos.close();
        return bos.toByteArray();
    }



    /**
     * 从网络上下载图片
     */
    public static void downloadPicture(String url, String dirPath,
                                       String filePath) {

        DefaultHttpClient httpclient = new DefaultHttpClient();

        HttpGet httpget = new HttpGet(url);

        httpget
                .setHeader(
                        "User-Agent",
                        "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.1 (KHTML, like Gecko) Chrome/21.0.1180.79 Safari/537.1");
        httpget
                .setHeader("Accept",
                        "text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8");

        try {
            HttpResponse resp = httpclient.execute(httpget);
            if (HttpStatus.SC_OK == resp.getStatusLine().getStatusCode()) {
                HttpEntity entity = resp.getEntity();

                InputStream in = entity.getContent();

                savePicToDisk(in, dirPath, filePath);

                System.out.println("保存图片 "+filePath+" 成功....");
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            httpclient.getConnectionManager().shutdown();
        }
    }

    /**
     * 将图片写到 硬盘指定目录下
     * @param in
     * @param dirPath
     * @param filePath
     */
    private static void savePicToDisk(InputStream in, String dirPath,
                                      String filePath) {

        try {
            File dir = new File(dirPath);
            if (dir == null || !dir.exists()) {
                dir.mkdirs();
            }

            //文件真实路径
            String realPath = dirPath.concat(filePath);
            File file = new File(realPath);
            if (file == null || !file.exists()) {
                file.createNewFile();
            }

            FileOutputStream fos = new FileOutputStream(file);
            byte[] buf = new byte[1024];
            int len = 0;
            while ((len = in.read(buf)) != -1) {
                fos.write(buf, 0, len);
            }
            fos.flush();
            fos.close();

        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            try {
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


}
