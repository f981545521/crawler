package cn.acyou.utils;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DownloadImage {
	
	private static final String ROOT_PATH = "F:\\Qzone\\";
	
	private static Logger log = LoggerFactory.getLogger(DownloadImage.class);
	
	

	/**
	 * 指定文件名下载图片
	 * @param url	下载路径
	 * @param path	指定文件路径
	 * @param fileName	文件名
	 * @throws Exception
	 */
	public static void downloadImage(String url,String path,String fileName) throws Exception {
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
		byte[] data = readInputStream(inStream);
		//创建文件夹与一个文件对象来保存图片
		File dir = new File(path);
		if(!dir.exists()) {
			dir.mkdirs();
		}
		File imageFile = new File(path, fileName);
		//创建输出流
		FileOutputStream outStream = new FileOutputStream(imageFile);
		//写入数据
		outStream.write(data);
		//关闭输出流
		outStream.close();
		
		log.info("图片大小：" + imageFile.length()/1024 + "K");
		
	}
	
	/**
	 * 使用默认路径/绝对路径下载图片
	 * @param url	下载路径
	 * @param path	文件路径/"F:\\Qzone\\umei3	"	"234567"
	 * @throws IOException 
	 * @throws Exception
	 */
	public static Long downloadImage(String url,String path) {
		URL originalURL;
		byte[] data;
		File imageFile = null;
		try {
			originalURL = new URL(url);
			//打开连接
			HttpURLConnection conn;
			conn = (HttpURLConnection) originalURL.openConnection();
			//设置请求方式为GET
			conn.setRequestMethod("GET");
			//设置超时时间为5s
			conn.setConnectTimeout(5 * 1000);
			//通过输入流获取图片数据
			InputStream inStream = conn.getInputStream();
			//得到图片的二进制数据，以二进制封装得到数据（具有通用性）
			data = readInputStream(inStream);
			//创建文件夹与一个文件对象来保存图片
			File dir;
			String regex = "\\S:\\S+";
			if(path.matches(regex)) {
				//全路径
				dir = new File(path);
			}else {
				dir = new File(ROOT_PATH + path);
			}
			if(!dir.exists()) {
				dir.mkdirs();
			}
			imageFile = new File(dir, UUID.randomUUID() + ".jpg");
			//创建输出流
			FileOutputStream outStream = new FileOutputStream(imageFile);
			//写入数据
			outStream.write(data);
			//关闭输出流
			outStream.close();
			
			log.info("图片大小：" + imageFile.length()/1024 + "K");
			
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}catch (ProtocolException e) {
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}
		return imageFile.length()/1024;
	}

	/**
	 * 使用默认路径下载图片
	 * @param url	路径
	 * @param paths	多文件路径/"F:\\Qzone\\umei3	"	"234567"
	 * @throws IOException
	 * @throws Exception
	 */
	public static Long downloadImageMultipath(String url,String... paths) {
		URL originalURL;
		byte[] data;
		File imageFile = null;
		try {
			originalURL = new URL(url);
			//打开连接
			HttpURLConnection conn;
			conn = (HttpURLConnection) originalURL.openConnection();
			//设置请求方式为GET
			conn.setRequestMethod("GET");
			//设置超时时间为5s
			conn.setConnectTimeout(5 * 1000);
			//通过输入流获取图片数据
			InputStream inStream = conn.getInputStream();
			//得到图片的二进制数据，以二进制封装得到数据（具有通用性）
			data = readInputStream(inStream);
			//创建文件夹与一个文件对象来保存图片
			StringBuilder sb = new StringBuilder();
			for(String path : paths){
				sb.append(path + "\\");
			}
			File dir = new File(ROOT_PATH + sb);
			if(!dir.exists()) {
				dir.mkdirs();
			}
			imageFile = new File(dir, UUID.randomUUID() + ".jpg");
			//创建输出流
			FileOutputStream outStream = new FileOutputStream(imageFile);
			//写入数据
			outStream.write(data);
			//关闭输出流
			outStream.close();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}catch (ProtocolException e) {
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}
		return imageFile.length();
	}

    public static byte[] readInputStream(InputStream inStream){  
        ByteArrayOutputStream outStream = new ByteArrayOutputStream();  
        //创建一个Buffer字符串  
        byte[] buffer = new byte[1024];  
        //每次读取的字符串长度，如果为-1，代表全部读取完毕  
        int len = 0;  
        //使用一个输入流从buffer里把数据读取出来  
        try {
			while( (len=inStream.read(buffer)) != -1 ){  
			    //用输出流往buffer里写入数据，中间参数代表从哪个位置开始读，len代表读取的长度  
			    outStream.write(buffer, 0, len);  
			}
		} catch (IOException e) {
			e.printStackTrace();
		}  finally {
			//关闭输入流  
			try {
				inStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}  
		}
        //把outStream里的数据写入内存  
        return outStream.toByteArray();  
    }
    
    
	/**
	 * 获取字符串的Photos内容
	 * @param content
	 * @return
	 */
	public static String getPhotosJsonString(String content) {
		int startIndex = content.indexOf("photos");
		int start = content.indexOf("[", startIndex);
		
		int endIndex = content.indexOf("picPosInPage");
		int end = content.lastIndexOf("]", endIndex);
		
		return content.substring(start, end + 1);
	}
	
	/**
	 * 获取字符串全部内容
	 * @param content
	 * @return
	 */
	public static String getPhotosAllInfo(String content) {
		int begin = content.indexOf("{");
		int end = content.lastIndexOf("}");
		return content.substring(begin, end + 1);
	}

}
