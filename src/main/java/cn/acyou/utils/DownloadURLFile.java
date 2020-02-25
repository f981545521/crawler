package cn.acyou.utils;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.net.URL;

/**
 * @author youfang
 * @version [1.0.0, 2020-02-14 下午 10:53]
 **/
public class DownloadURLFile {
    /**
     * @param args
     */
    public static void main(String[] args) {

        //String res = downloadFromUrl("https://name.meinv.pw/201911/564bb21641ce202610dfbc8c3382f011.jpg","E:\\VOOC\\heyzo");
        String res = downloadFromUrl("https://name.meinv.pw/201911/564bb21641ce202610dfbc8c3382f011.jpg","E:\\VOOC\\heyzo");
        System.out.println(res);
    }


    public static String downloadFromUrl(String url,String dir) {

        try {
            URL httpurl = new URL(url);
            String fileName = getFileNameFromUrl(url);
            System.out.println(fileName);
            File f = new File(dir + fileName);
            FileUtils.copyURLToFile(httpurl, f);
        } catch (Exception e) {
            e.printStackTrace();
            return "Fault!";
        }
        return "Successful!";
    }

    public static String getFileNameFromUrl(String url){
        String name = new Long(System.currentTimeMillis()).toString() + ".X";
        int index = url.lastIndexOf("/");
        if(index > 0){
            name = url.substring(index + 1);
            if(name.trim().length()>0){
                return name;
            }
        }
        return name;
    }

}
