package test;

import java.util.LinkedList;
import java.util.List;

import org.junit.Test;

public class MainTest {
	
	
	
	@Test
	public void test1() {
		String s = "http://www.cnblogs.com/shenjp/default.html?page=3";
		String regex = "http://www\\.cnblogs\\.com/shenjp/default\\.html\\?page=\\w+";
		System.out.println(regex);
		System.out.println(s.matches(regex));
		
	}
	
	
	
	@Test
	public void test2() {
		List<String> pages = new LinkedList<String>();
		pages.add("0");
		pages.add("1");
		pages.add("2");
		pages.add("3");
		pages.add("4");
		pages.add("5");
		System.out.println(pages.size());

		System.out.println(pages.get(0));

	}


	@Test
	public void test3(){

		showMe("http://www.qq.com/","123","456","-7a890");
	}

	private void showMe(String url,String... path){

		System.out.println(url);
		StringBuilder sb = new StringBuilder();
		for(String s : path){
			sb.append(s + "\\");
		}
		System.out.println(sb);

	}

}
