package cn.acyou.entity;

import java.io.Serializable;
import java.util.List;

public class Data implements Serializable{

	private static final long serialVersionUID = 1L;
	private String first;
	private String isfriend;
	private String last;
	private String limit;
	private List<Photos> photos;
	private String picPosInPage;
	private String picPosInTotal;
	private String picTotal;
	private String showMode;
	private String single;
	private String t;
	private Topic topic;
	public Data() {
		super();
	}
	@Override
	public String toString() {
		return "Data [first=" + first + ", isfriend=" + isfriend + ", last=" + last + ", limit=" + limit + ", photos="
				+ photos + ", picPosInPage=" + picPosInPage + ", picPosInTotal=" + picPosInTotal + ", picTotal="
				+ picTotal + ", showMode=" + showMode + ", single=" + single + ", t=" + t + ", topic=" + topic + "]";
	}
	public String getFirst() {
		return first;
	}
	public void setFirst(String first) {
		this.first = first;
	}
	public String getIsfriend() {
		return isfriend;
	}
	public void setIsfriend(String isfriend) {
		this.isfriend = isfriend;
	}
	public String getLast() {
		return last;
	}
	public void setLast(String last) {
		this.last = last;
	}
	public String getLimit() {
		return limit;
	}
	public void setLimit(String limit) {
		this.limit = limit;
	}
	public List<Photos> getPhotos() {
		return photos;
	}
	public void setPhotos(List<Photos> photos) {
		this.photos = photos;
	}
	public String getPicPosInPage() {
		return picPosInPage;
	}
	public void setPicPosInPage(String picPosInPage) {
		this.picPosInPage = picPosInPage;
	}
	public String getPicPosInTotal() {
		return picPosInTotal;
	}
	public void setPicPosInTotal(String picPosInTotal) {
		this.picPosInTotal = picPosInTotal;
	}
	public String getPicTotal() {
		return picTotal;
	}
	public void setPicTotal(String picTotal) {
		this.picTotal = picTotal;
	}
	public String getShowMode() {
		return showMode;
	}
	public void setShowMode(String showMode) {
		this.showMode = showMode;
	}
	public String getSingle() {
		return single;
	}
	public void setSingle(String single) {
		this.single = single;
	}
	public String getT() {
		return t;
	}
	public void setT(String t) {
		this.t = t;
	}
	public Topic getTopic() {
		return topic;
	}
	public void setTopic(Topic topic) {
		this.topic = topic;
	}
	
	

}
