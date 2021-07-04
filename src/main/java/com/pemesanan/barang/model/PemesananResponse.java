package com.pemesanan.barang.model;

import java.sql.Date;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class PemesananResponse {
	String code;
	String description;
	String massege;
	
	public  PemesananResponse() {
		this.code = "01";
		this.description = "Success";
	

	}
	public PemesananResponse(String code, String description) {
		this.code = code;
		this.description = description;
		
	}	
}

	