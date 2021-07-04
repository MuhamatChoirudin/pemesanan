package com.pemesanan.barang.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pemesanan.barang.entity.Pemesanan;
import com.pemesanan.barang.repository.PemesananRepository;

@Service
@Transactional
public class PemesananService {
	
	@PersistenceContext
	private EntityManager em;
	
	@Autowired
	private PemesananRepository pemesananRepository;
	
	public Pemesanan createPemesanan(Pemesanan pemesanan, int registrasi) {
		pemesanan.setId(registrasi);
		pemesanan.setTanggalPesan(new Date());
		return pemesananRepository.save(pemesanan);
		
	}
	
	public Pemesanan getById(int id) {
		
		return pemesananRepository.findById(id);
		
	}
	
	public List<Pemesanan> getByNamePemesan(String namePemesan) {
		
		return pemesananRepository.findByNamaPemesan(namePemesan);
		
	}
	
	public Pemesanan updatePemesanan(Pemesanan pemesanan) {
		return em.merge(pemesanan);
		
	}

}
