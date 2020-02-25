package cn.acyou.apps.vooc;

import cn.acyou.utils.DownloadImage;
import cn.acyou.utils.DownloadPictureTest;
import org.apache.commons.lang3.RandomStringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import us.codecraft.webmagic.ResultItems;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.Pipeline;
import us.codecraft.webmagic.utils.FilePersistentBase;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * @author youfang
 */
public class VoocPipeline extends FilePersistentBase implements Pipeline {

	private final static String BASE_PATH = "E:\\VOOC\\heyzo\\";

	@Override
	public void process(ResultItems resultItems, Task task) {
		Map<String, Object> map = resultItems.getAll();
		String title = (String) map.get("title");
		List<String> imgLinks  = (List) map.get("imgLinks");
		String currentFolder = BASE_PATH + title + "\\";
		File file = new File(currentFolder);
		if (!file.exists()){
			file.mkdirs();
		}
		for (String link: imgLinks){
			DownloadPictureTest.downLoadFromUrl(link, currentFolder);
		}


	}

}
