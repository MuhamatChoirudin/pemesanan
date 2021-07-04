package com.pemesanan.barang.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pemesanan.barang.entity.Pemesanan;
import com.pemesanan.barang.repository.PemesananRepository;

@Service
@Transactional
public class PemesananService {
	
	@Autowired
	private PemesananRepository pemesananRepository;
	
	public Pemesanan createPemesanan(Pemesanan pemesanan) {
		
		return pemesananRepository.save(pemesanan);
		
	}
	
	public Pemesanan getByNamePemesan(int namePemesan) {
		
		return pemesananRepository.findById(namePemesan);
		
	}
	
	public List<Pemesanan> getByNamePemesan(String namePemesan) {
		
		return pemesananRepository.findByNamaPemesan(namePemesan);
		
	}

}
