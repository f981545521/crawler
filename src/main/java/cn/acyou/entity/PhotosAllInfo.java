package cn.acyou.entity;

import java.io.Serializable;

public class PhotosAllInfo implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private String code;
	private Data data;
	private String message;
	private String subcode;
	public PhotosAllInfo() {
		super();
	}
	@Override
	public String toString() {
		return "PhotosAllInfo [code=" + code + ", data=" + data + ",  message=" + message
				+ ", subcode=" + subcode + "]";
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public Data getData() {
		return data;
	}
	public void setData(Data data) {
		this.data = data;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getSubcode() {
		return subcode;
	}
	public void setSubcode(String subcode) {
		this.subcode = subcode;
	}
	
	

}
