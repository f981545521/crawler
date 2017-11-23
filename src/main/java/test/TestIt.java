package test;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.List;

import org.junit.Test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import cn.acyou.entity.People;
import cn.acyou.entity.PhotosAllInfo;

public class TestIt {
	
	@Test
	public void test() {
		File dir = new File("F:\\Qzone\\har");
		if (dir.isDirectory()) {
			File[] files = dir.listFiles();
			for (File file : files) {
				System.out.println(file.getName());
			}
		}
	}

	@Test
	public void test1() throws Exception {
		Path path = Paths.get("F:\\Qzone\\har\\cgi_floatview_photo_list_v2_2");
		byte[] bytes = Files.readAllBytes(path);
		String content = new String(bytes, "utf-8");
//		System.out.println(content);
		int begin = content.indexOf("{");
		int end = content.lastIndexOf("}");
		System.out.println(content.substring(begin, end + 1));
		
	}
	
	
	@Test
	public void test2() {
		//简单对象转JSON字符串
		People people = new People("张三", 22);
		String txt = JSON.toJSONString(people);
		System.out.println(txt);
		//List对象转JSON字符串
		List<People> p = new LinkedList<People>();
		p.add(new People("张三", 22));
		p.add(new People("李四",33));
		String text = JSON.toJSONString(p);
		System.out.println(text);
		
		//JSON转JavaBean 如：{key,value}
		String str = "{\"age\":22}";
		People p2 = JSON.parseObject(str, People.class);
		System.out.println(p2);
	}
	
	@Test
	public void test3() throws Exception {
		Path path = Paths.get("F:\\Qzone\\har\\cgi_floatview_photo_list_v2");
		byte[] bytes = Files.readAllBytes(path);
		String content = new String(bytes, "utf-8");
		//JSON字符串数组转JSON对象  如：[{},{},{}]
		JSONArray jsonArray = JSONArray.parseArray(content);
		System.out.println(jsonArray);
        //遍历JSON数组
        for (Object obj : jsonArray) {
            JSONObject jsonObject = (JSONObject) obj;
            System.out.println(jsonObject.getString("pre"));//获取指定KEY
        }
	}
	
	/**
	 * PhotosAllInfo
	 * @throws Exception
	 */
	@Test
	public void test11() throws Exception {
		Path path = Paths.get("F:\\Qzone\\har\\cgi_floatview_photo_list_v2_2");
		byte[] bytes = Files.readAllBytes(path);
		String content = new String(bytes, "utf-8");
		int begin = content.indexOf("{");
		int end = content.lastIndexOf("}");
		//复杂JSON字符串转JavaBean
		PhotosAllInfo allInfo = (PhotosAllInfo) JSON.parseObject(content.substring(begin, end + 1), PhotosAllInfo.class);
		System.out.println(allInfo.getData().getTopic().getOwnerName());
	}
	
	@Test
	public void test4() throws Exception {
		Path path = Paths.get("F:\\Qzone\\har\\cgi_floatview_photo_list_v2_2");
		byte[] bytes = Files.readAllBytes(path);
		String content = new String(bytes, "utf-8");
		JSONArray jsonArray = JSONArray.parseArray(content);
		System.out.println(jsonArray);
        //遍历JSON数组
        for (Object obj : jsonArray) {
            JSONObject jsonObject = (JSONObject) obj;
            System.out.println(jsonObject.getString("photos"));//获取指定KEY
        }
		
	}
	
	@Test
	public void test5() {
		String s = " \"photos\" : [\r\n" + 
				"      {\r\n" + 
				"         \"albumId\" : \"V12J1vIf3ZkdYK\",\r\n" + 
				"         \"batchId\" : \"255569290\",\r\n" + 
				"         \"browser\" : 0,\r\n" + 
				"         \"cmtTotal\" : 0,\r\n" + 
				"         \"desc\" : \"我要安安静静的\",\r\n" + 
				"      }],";
		System.out.println(s);
		int index = s.indexOf("photos");
		System.out.println(s.indexOf("[", index));
		System.out.println(s.indexOf("]", index));
		System.out.println(s.substring(s.indexOf("[", index), s.indexOf("]", index) + 1));
	}
	
	@Test
	public void test6() {
		System.out.println(9<10 && 19<20);
	}
	
	@Test
	public void test7() {
		String url = "http://www.umei.cc/meinvtupian/siwameinv/";
		String regex = ".*/$";
		System.out.println(url.matches(regex));
		
	}
	
	
	

}
