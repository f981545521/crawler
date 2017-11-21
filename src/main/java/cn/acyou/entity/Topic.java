package cn.acyou.entity;

import java.io.Serializable;

public class Topic implements Serializable{

	private static final long serialVersionUID = 1L;
	private String bitmap;
	private String desc;
	private String descType;
	private String index;
	private String is_share_album;
	private String loginName;
	private String ownerName;
	private String ownerUin;
	private String priv;
	private String pypriv;
	private String share_album_owner;
	private String topicId;
	private String topicName;
	public Topic() {
		super();
	}
	@Override
	public String toString() {
		return "Topic [bitmap=" + bitmap + ", desc=" + desc + ", descType=" + descType + ", index=" + index
				+ ", is_share_album=" + is_share_album + ", loginName=" + loginName + ", ownerName=" + ownerName
				+ ", ownerUin=" + ownerUin + ", priv=" + priv + ", pypriv=" + pypriv + ", share_album_owner="
				+ share_album_owner + ", topicId=" + topicId + ", topicName=" + topicName + "]";
	}
	public String getBitmap() {
		return bitmap;
	}
	public void setBitmap(String bitmap) {
		this.bitmap = bitmap;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public String getDescType() {
		return descType;
	}
	public void setDescType(String descType) {
		this.descType = descType;
	}
	public String getIndex() {
		return index;
	}
	public void setIndex(String index) {
		this.index = index;
	}
	public String getIs_share_album() {
		return is_share_album;
	}
	public void setIs_share_album(String is_share_album) {
		this.is_share_album = is_share_album;
	}
	public String getLoginName() {
		return loginName;
	}
	public void setLoginName(String loginName) {
		this.loginName = loginName;
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
	public String getPriv() {
		return priv;
	}
	public void setPriv(String priv) {
		this.priv = priv;
	}
	public String getPypriv() {
		return pypriv;
	}
	public void setPypriv(String pypriv) {
		this.pypriv = pypriv;
	}
	public String getShare_album_owner() {
		return share_album_owner;
	}
	public void setShare_album_owner(String share_album_owner) {
		this.share_album_owner = share_album_owner;
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

	
	

}
