package zone;

import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.acyou.utils.ConsolePipeline;
import cn.acyou.utils.DownloadImage;
import cn.acyou.utils.DownloadImage2;
import cn.acyou.utils.ImagePipeline;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.pipeline.FilePipeline;
import us.codecraft.webmagic.processor.PageProcessor;

/**
 * 第二版：传入列表URL
 * @author youfang
 *
 */
public class UmeiProcessor2 implements PageProcessor{
	
	//入口URL
	private final static String URL = "http://www.umei.cc/meinvtupian/jiepaimeinv/";
	
	private final static String PATH = "jiepai2";
	
	private static Logger log = LoggerFactory.getLogger(UmeiProcessor2.class);
	
	/**
	 * 部分一：抓取网站的相关配置，包括编码、抓取间隔、重试次数等
	 * 
	 * 第一部分关于爬虫的配置，包括编码、抓取间隔、超时时间、重试次数等，也包括一些模拟的参数，例如User Agent、cookie，以及代理的设置，
	 * 重试次数为3次，抓取间隔为一秒。
	 */
    private Site site = Site.me().setRetryTimes(3).setSleepTime(1000);

    /**
     * process是定制爬虫逻辑的核心接口，在这里编写抽取逻辑
     */
	public void process(Page page) {
        /**
         * 部分二：定义如何抽取页面信息，并保存下来
         * 
         * get()		返回一条String类型的结果				String link= html.links().get()
         * toString()	功能同get()，返回一条String类型的结果	String link= html.links().toString()
         * all()		返回所有抽取结果						List links= html.links().all()
         * match()		是否有匹配结果						if (html.links().match()){ xxx; }
         */		
		String u = page.getHtml().xpath("//div[@class='ImageBody']/p/img/@src").toString();
		if(StringUtils.isNotEmpty(u)){
			page.putField("URL", u);
		}

        /**
         * 部分三：从页面发现后续的url地址来抓取
         */
		List<String> linkList = page.getHtml().xpath("//div[@class='TypeList']/ul/li/a/@href").all();
		for(String link : linkList) {
			log.warn("---->列表链接：" + link );
		}
		// 通过page.addTargetRequests()方法来增加要抓取的URL
		page.addTargetRequests(linkList);

		List<String> links = page.getHtml().xpath("//div[@class='NewPages']").links().all();
		for(String link : links){
			log.warn("---->页脚链接：" + link );
		}
        page.addTargetRequests(links);
		
	}

	public Site getSite() {
		return site;
	}
	
	public static void main(String[] args) {
		/**
		 * Spider是爬虫启动的入口
		 * 从"http://www.cnblogs.com/shenjp/default.html?page=2"开始抓，开启5个线程抓取，启动爬虫
		 */
        Spider.create(new UmeiProcessor2()).addUrl(URL).addPipeline(new ConsolePipeline()).thread(5).run();
	}
	

}
