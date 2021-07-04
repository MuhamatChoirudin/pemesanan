package com.pemesanan.barang.model;

public class PemesananResponse<T> {
	String code;
	String description;
	String data;
	
	public  PemesananResponse() {
		this.code = "01";
		this.description = "Success";
	

	}
	public PemesananResponse(String code, String description) {
		this.code = code;
		this.description = description;
		
	}
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}
	
	
}

	