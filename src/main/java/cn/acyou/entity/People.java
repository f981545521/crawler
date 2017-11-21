package cn.acyou.entity;

import java.io.Serializable;

public class People implements Serializable{

	private static final long serialVersionUID = 1L;
	/**
	 * 姓名
	 */
	private String name;
	/**
	 * 年龄
	 */
	private Integer age;
	
	@Override
	public String toString() {
		return "People [name=" + name + ", age=" + age + "]";
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}

	public People(String name, Integer age) {
		super();
		this.name = name;
		this.age = age;
	}
	public People() {
		super();
	}
	
	
	
	

}
