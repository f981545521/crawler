package cn.acyou.download;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;

import cn.acyou.entity.Photos;
import cn.acyou.utils.DownloadImage;

/**
 * cgi_floatview_photo_list
 * 
 * 下载JSON
 * @author youfang
 * 
 * document.getElementById('js-thumb-next').click();
 *
 */
public class Start {
	
	private static final int start = 1;
	private static final int end = 3;
	private static int Counter = 0;
	
	
	public static void main(String[] args) throws Exception {
		
		for(int i = start ; i <= end ; i++) {
			/**
			 * JSON文件存放路径，推荐：1,2,3,4方便在此处遍历
			 */
			Path path = Paths.get("F:\\Qzone\\har\\123\\" + i);
			byte[] bytes = Files.readAllBytes(path);
			String content = new String(bytes, "utf-8");
			//转换成JSON
			String jsonStr = DownloadImage.getPhotosJsonString(content);
			
			List<Photos> photos = JSON.parseObject(jsonStr, new TypeReference<ArrayList<Photos>>() {});
			for(Photos p : photos) {
				//限制图片大小（分辨率）
/*				if((Integer.parseInt(p.getWidth()) < 720) && (Integer.parseInt(p.getHeight()) < 1280)) {
					continue;
				}*/
				Counter ++;
				currentDownload(p);
				//限制图片太小重试
/*				Long len;
				do {
					len = currentDownload(p);
				}while(len < 50);*/
			}
			
		}
	}
	
	/**
	 * 当前下载
	 * @param p
	 * @return
	 */
	private static Long currentDownload(Photos p) {
		Long length;
		if(p.getRaw_upload().equals("1")) {
			System.out.println(Counter + "-->当前下载：" + p.getRaw());
			length = DownloadImage.downloadImage(p.getRaw(), p.getOwnerUin());
		}else {
			System.out.println(Counter + "-->当前下载：" + p.getPre());
			length = DownloadImage.downloadImage(p.getUrl(), p.getOwnerUin());
		}
		return length;
	}
}



