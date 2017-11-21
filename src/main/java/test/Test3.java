package test;

import java.util.UUID;

import cn.acyou.utils.DownloadImage2;

public class Test3 {
	
	private final static String rootPath = "F:\\\\Qzone\\";
	
	public static void main(String[] args) {
		String url = "http://www.xxx.con/xxxx.jpg";
		String number = "783806290";
		String path = rootPath + number;
		String fileName = UUID.randomUUID() + ".jpg";
		try {
			DownloadImage2.downloadImage(url, path, fileName);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	

}
