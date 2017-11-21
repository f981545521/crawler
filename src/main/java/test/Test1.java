package test;

public class Test1 {
	
    public static final String URL_LIST = "http://blog\\.sina\\.com\\.cn/s/articlelist_1487828712_0_\\d+\\.html";
	
	public static void main(String[] args) {
		String s =                       "http://blog\\.sina\\.com\\.cn/s/articlelist_1487828712_0_\\d+\\.html";
		String regx = "";
		String ss = "http://blog.sina.com.cn/s/articlelist_1487828712_0_1.html";
		System.out.println(ss.matches(s));
	}

}
