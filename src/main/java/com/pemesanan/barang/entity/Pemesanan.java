package com.pemesanan.barang.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "Pemesanan")
@Table(name = "pemesanan")
@Setter
@Getter
@NoArgsConstructor
public class Pemesanan {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "nama_barang")
	private String namaBarang;
	
	@Column(name = "keterangan_pemesanan")
	private String keteranganPemesanan;
	
	@Column(name = "jumlah")
	private int jumlah;
	
	@Column(name = "nama_pemesan")
	private String namaPemesan;
	
	@Column(name = "alamat_pemesan")
	private String alamatPemesan;
	
	@Column(name = "tanggal_pemesanan")
	private Date tanggalPesan;

}
