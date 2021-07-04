package com.pemesanan.barang.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pemesanan.barang.entity.Pemesanan;

@Repository
public interface PemesananRepository extends JpaRepository<Pemesanan, Long>{
	
	Pemesanan findById(int id);
	
	List<Pemesanan> findByNamaPemesan(String name);

}
