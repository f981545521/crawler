package cn.acyou.apps.vooc;

import cn.acyou.utils.ConsolePipeline;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.processor.PageProcessor;
import us.codecraft.webmagic.selector.Selectable;

import java.util.List;

/**
 * @author youfang
 */
public class VoocProcessor implements PageProcessor{
	
	int temp = 1;
	
	/**
	 * 部分一：抓取网站的相关配置，包括编码、抓取间隔、重试次数等
	 * 
	 * 第一部分关于爬虫的配置，包括编码、抓取间隔、超时时间、重试次数等，也包括一些模拟的参数，例如User Agent、cookie，以及代理的设置，
	 * 重试次数为3次，抓取间隔为一秒。
	 */
    private Site site = Site.me().setRetryTimes(3).setSleepTime(5000);

    /**
     * process是定制爬虫逻辑的核心接口，在这里编写抽取逻辑
     */
    @Override
	public void process(Page page) {
        /**
         * 部分二：定义如何抽取页面信息，并保存下来
         * 
         * get()		返回一条String类型的结果				String link= html.links().get()
         * toString()	功能同get()，返回一条String类型的结果	String link= html.links().toString()
         * all()		返回所有抽取结果						List links= html.links().all()
         * match()		是否有匹配结果						if (html.links().match()){ xxx; }
         */
		String title = page.getHtml().xpath("//*[@id=\"content\"]/div[1]/h1/text()").toString();
		System.out.println(title);
		List<String> imgLinks = page.getHtml().xpath("//*[@id=\"post_content\"]/p/img/@src").all();
		System.out.println(imgLinks);

		page.putField("title", title);
		page.putField("imgLinks", imgLinks);



		/**
		 * 部分三：从页面发现后续的url地址来抓取
		 */
		List<String> previousPage = page.getHtml().xpath("//*[@id=\"content\"]/div[3]/ul/div[1]").links().all();
		List<String> nextPage = page.getHtml().xpath("//*[@id=\"content\"]/div[3]/ul/div[2]").links().all();
		System.out.println("上一页：" + previousPage);
		System.out.println("下一页：" + nextPage);
        page.addTargetRequests(nextPage);
        
	}

	@Override
	public Site getSite() {
		return site;
	}
	
	public static void main(String[] args) {
		/**
		 * Spider是爬虫启动的入口
		 * 从"http://www.cnblogs.com/shenjp/default.html?page=2"开始抓，开启1个线程抓取，启动爬虫
		 */
        Spider.create(new VoocProcessor()).addUrl("https://www.vooc.net/48428.html").addPipeline(new VoocPipeline()).thread(1).run();
	}
	

}
