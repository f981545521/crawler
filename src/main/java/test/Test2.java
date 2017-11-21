package test;

import java.util.UUID;

public class Test2 {
	public static void main(String[] args) {
		
		//System.out.println(UUID.randomUUID() + ".jpg");
		
		String str = "umei3";
		String regx = "\\S:\\S+";
		System.out.println(str.matches(regx));
				

	}

}
