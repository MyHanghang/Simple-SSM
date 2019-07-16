package com.lzh.model;

import java.io.Serializable;

public class Province implements Serializable {

	private int id;
	private String provinceName;

	@Override
	public String toString() {
		return "Province [id=" + id + ", provinceName=" + provinceName + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getProvinceName() {
		return provinceName;
	}

	public void setProvinceName(String provinceName) {
		this.provinceName = provinceName;
	}

}
