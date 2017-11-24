package cn.acyou.utils;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import us.codecraft.webmagic.ResultItems;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.Pipeline;

public class ConsolePipeline implements Pipeline{

    private static Logger log = LoggerFactory.getLogger(ConsolePipeline.class);

    private static Integer Counter = 0;

	public void process(ResultItems resultItems, Task task) {
	    log.warn("get page: " + resultItems.getRequest().getUrl());
        //遍历所有结果，输出到控制台；结果为key-value
        for (Map.Entry<String, Object> entry : resultItems.getAll().entrySet()) {
            Counter++;
            log.warn("当前记数：" + Counter + "---->" + entry.getKey() + ":\t" + entry.getValue());
        }
	}

}
