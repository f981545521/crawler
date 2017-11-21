package cn.acyou.utils;

import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import us.codecraft.webmagic.ResultItems;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.Pipeline;
import us.codecraft.webmagic.utils.FilePersistentBase;

public class ImagePipeline extends FilePersistentBase implements Pipeline {

	private Logger logger = LoggerFactory.getLogger(getClass());
	
	private static Integer COUNTER = 0;

	public ImagePipeline() {
		setPath("F:\\Qzone\\");
	}

	public ImagePipeline(String path) {
		setPath(path);
	}

	public void process(ResultItems resultItems, Task task) {
		COUNTER++;		
		Map<String, Object> map = resultItems.getAll();
		String url = (String) map.get("URL");
		
		logger.warn("当前下载" + COUNTER + "："+ url);
		DownloadImage.downloadImage(url, getPath());
		
		
		
		/*//通过：entry.getKey()获取Key；使用entry.getValue()获取Value。
	    Set<Entry<String, Object>> entrySet = map.entrySet();
	    for(Entry<String, Object> entry:entrySet){
	        System.out.println(entry.getKey() + "," + entry.getValue());
	    }*/
	    
	    
	}

}
