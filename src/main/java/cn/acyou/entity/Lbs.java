package cn.acyou.entity;

import java.io.Serializable;

public class Lbs implements Serializable{

	private static final long serialVersionUID = 1L;

	private String id;
	
	private String idname;
	
	private String name;
	
	private String pos_x;
	
	private String pos_y;

	public Lbs(String id, String idname, String name, String pos_x, String pos_y) {
		super();
		this.id = id;
		this.idname = idname;
		this.name = name;
		this.pos_x = pos_x;
		this.pos_y = pos_y;
	}

	public Lbs() {
		super();
	}
	
	@Override
	public String toString() {
		return "Lbs [id=" + id + ", idname=" + idname + ", name=" + name + ", pos_x=" + pos_x + ", pos_y=" + pos_y
				+ "]";
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getIdname() {
		return idname;
	}

	public void setIdname(String idname) {
		this.idname = idname;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPos_x() {
		return pos_x;
	}

	public void setPos_x(String pos_x) {
		this.pos_x = pos_x;
	}

	public String getPos_y() {
		return pos_y;
	}

	public void setPos_y(String pos_y) {
		this.pos_y = pos_y;
	}
	
	

}
