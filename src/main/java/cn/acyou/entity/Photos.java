package cn.acyou.entity;

import java.io.Serializable;

public class Photos implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private String albumId;
	private String batchId;
	private String browser;
	private String cmtTotal;
	private String desc;
	private String desctype;
	private String faceList;
	private String height;
	private String is_video;
	private String is_weixin_mode;
	private Lbs lbs;
	private String likeTotal;
	private String lloc;
	private String name;
	private String ownerName;//所有者昵称
	private String ownerUin;//所有者
	private String photocubage;
	private String phototype;
	private String picKey;
	private String picmark_flag;
	private String platformId;
	private String platformSubId;
	private String pre;
	private String raw_upload;//1:原图
	private String raw;
	private ShootGeo shootGeo;
	private String shootTime;
	private String shorturl;
	private String topicId;
	private String topicName;
	private String uploadTime;
	private String url;
	private String width;
	private String yurl;
	public Photos() {
		super();
	}
	@Override
	public String toString() {
		return "Photos [albumId=" + albumId + ", batchId=" + batchId + ", browser=" + browser + ", cmtTotal=" + cmtTotal
				+ ", desc=" + desc + ", desctype=" + desctype + ", faceList=" + faceList + ", height=" + height
				+ ", is_video=" + is_video + ", is_weixin_mode=" + is_weixin_mode + ", lbs=" + lbs + ", likeTotal="
				+ likeTotal + ", lloc=" + lloc + ", name=" + name + ", ownerName=" + ownerName + ", ownerUin="
				+ ownerUin + ", photocubage=" + photocubage + ", phototype=" + phototype + ", picKey=" + picKey
				+ ", picmark_flag=" + picmark_flag + ", platformId=" + platformId + ", platformSubId=" + platformSubId
				+ ", pre=" + pre + ", raw_upload=" + raw_upload + ", raw=" + raw + ", shootGeo=" + shootGeo
				+ ", shootTime=" + shootTime + ", shorturl=" + shorturl + ", topicId=" + topicId + ", topicName="
				+ topicName + ", uploadTime=" + uploadTime + ", url=" + url + ", width=" + width + ", yurl=" + yurl
				+ "]";
	}
	public String getAlbumId() {
		return albumId;
	}
	public void setAlbumId(String albumId) {
		this.albumId = albumId;
	}
	public String getBatchId() {
		return batchId;
	}
	public void setBatchId(String batchId) {
		this.batchId = batchId;
	}
	public String getBrowser() {
		return browser;
	}
	public void setBrowser(String browser) {
		this.browser = browser;
	}
	public String getCmtTotal() {
		return cmtTotal;
	}
	public void setCmtTotal(String cmtTotal) {
		this.cmtTotal = cmtTotal;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public String getDesctype() {
		return desctype;
	}
	public void setDesctype(String desctype) {
		this.desctype = desctype;
	}
	public String getFaceList() {
		return faceList;
	}
	public void setFaceList(String faceList) {
		this.faceList = faceList;
	}
	public String getHeight() {
		return height;
	}
	public void setHeight(String height) {
		this.height = height;
	}
	public String getIs_video() {
		return is_video;
	}
	public void setIs_video(String is_video) {
		this.is_video = is_video;
	}
	public String getIs_weixin_mode() {
		return is_weixin_mode;
	}
	public void setIs_weixin_mode(String is_weixin_mode) {
		this.is_weixin_mode = is_weixin_mode;
	}
	public Lbs getLbs() {
		return lbs;
	}
	public void setLbs(Lbs lbs) {
		this.lbs = lbs;
	}
	public String getLikeTotal() {
		return likeTotal;
	}
	public void setLikeTotal(String likeTotal) {
		this.likeTotal = likeTotal;
	}
	public String getLloc() {
		return lloc;
	}
	public void setLloc(String lloc) {
		this.lloc = lloc;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getOwnerName() {
		return ownerName;
	}
	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}
	public String getOwnerUin() {
		return ownerUin;
	}
	public void setOwnerUin(String ownerUin) {
		this.ownerUin = ownerUin;
	}
	public String getPhotocubage() {
		return photocubage;
	}
	public void setPhotocubage(String photocubage) {
		this.photocubage = photocubage;
	}
	public String getPhototype() {
		return phototype;
	}
	public void setPhototype(String phototype) {
		this.phototype = phototype;
	}
	public String getPicKey() {
		return picKey;
	}
	public void setPicKey(String picKey) {
		this.picKey = picKey;
	}
	public String getPicmark_flag() {
		return picmark_flag;
	}
	public void setPicmark_flag(String picmark_flag) {
		this.picmark_flag = picmark_flag;
	}
	public String getPlatformId() {
		return platformId;
	}
	public void setPlatformId(String platformId) {
		this.platformId = platformId;
	}
	public String getPlatformSubId() {
		return platformSubId;
	}
	public void setPlatformSubId(String platformSubId) {
		this.platformSubId = platformSubId;
	}
	public String getPre() {
		return pre;
	}
	public void setPre(String pre) {
		this.pre = pre;
	}
	public String getRaw_upload() {
		return raw_upload;
	}
	public void setRaw_upload(String raw_upload) {
		this.raw_upload = raw_upload;
	}
	public String getRaw() {
		return raw;
	}
	public void setRaw(String raw) {
		this.raw = raw;
	}
	public ShootGeo getShootGeo() {
		return shootGeo;
	}
	public void setShootGeo(ShootGeo shootGeo) {
		this.shootGeo = shootGeo;
	}
	public String getShootTime() {
		return shootTime;
	}
	public void setShootTime(String shootTime) {
		this.shootTime = shootTime;
	}
	public String getShorturl() {
		return shorturl;
	}
	public void setShorturl(String shorturl) {
		this.shorturl = shorturl;
	}
	public String getTopicId() {
		return topicId;
	}
	public void setTopicId(String topicId) {
		this.topicId = topicId;
	}
	public String getTopicName() {
		return topicName;
	}
	public void setTopicName(String topicName) {
		this.topicName = topicName;
	}
	public String getUploadTime() {
		return uploadTime;
	}
	public void setUploadTime(String uploadTime) {
		this.uploadTime = uploadTime;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getWidth() {
		return width;
	}
	public void setWidth(String width) {
		this.width = width;
	}
	public String getYurl() {
		return yurl;
	}
	public void setYurl(String yurl) {
		this.yurl = yurl;
	}
	
	
	
	
	

}
