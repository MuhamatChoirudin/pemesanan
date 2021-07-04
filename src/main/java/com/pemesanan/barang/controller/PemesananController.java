package com.pemesanan.barang.controller;

import java.util.Date;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pemesanan.barang.entity.Pemesanan;
import com.pemesanan.barang.exception.EntityNotFoundException;
import com.pemesanan.barang.model.CommonResponse;
import com.pemesanan.barang.model.PemesananResponse;
import com.pemesanan.barang.service.PemesananService;


@RestController
@RequestMapping("/api/pemesanan")
public class PemesananController {

	public static final String URL_REQUEST_PEMESANAN_BY_ID = "/pemesanan/{id}";
	public static final String URL_REQUEST_PEMESANAN_BY_NAME = "/{name}";
	public static final String URL_REQUEST_PEMESANAN = "/post";
	public static final String URL_REQUEST_PEMESANAN_UPDATE_BY_ID = "/{id}/update";

	@Autowired
	private PemesananService pemesananService;
	
	@PostMapping(value=URL_REQUEST_PEMESANAN)
	public PemesananResponse createCustomer(@RequestBody Pemesanan pemesanan) throws EntityNotFoundException {
		PemesananResponse resp = new PemesananResponse();
		
		int int_random = ThreadLocalRandom.current().nextInt();
		pemesananService.createPemesanan(pemesanan, int_random);
		resp.setMassege("Pesan telah ditrima dengan nomer registrasi "+int_random);
		return resp;

	}
	
	@GetMapping(value = URL_REQUEST_PEMESANAN_BY_ID)
	public CommonResponse<Pemesanan> getByCustomerId(@PathVariable(name = "id") int id) throws EntityNotFoundException{
		Pemesanan customer = pemesananService.getById(id);
		CommonResponse<Pemesanan> resp = new CommonResponse<>();
		if (customer == null) {
			throw new EntityNotFoundException();
		} else {
			resp.setData(customer);
		}
		return resp;
	}
	
	
	@GetMapping(value = URL_REQUEST_PEMESANAN_BY_NAME)
	public CommonResponse<List<Pemesanan>> getByName(@PathVariable(name = "name") String name) throws EntityNotFoundException{
		List<Pemesanan> customer = pemesananService.getByNamePemesan(name);
		CommonResponse<List<Pemesanan>> resp = new CommonResponse<>();
		if (customer == null) {
			throw new EntityNotFoundException();
		} else {
			resp.setData((List<Pemesanan>) customer);
		}
		return resp;
	}
	
	@Transactional
	@PutMapping(value = URL_REQUEST_PEMESANAN_UPDATE_BY_ID)
	public PemesananResponse updateAccount(@PathVariable(name = "id") int id,@RequestBody Pemesanan pemesanan) throws EntityNotFoundException{
		Pemesanan data = pemesananService.getById(id);
		PemesananResponse resp = new PemesananResponse();
		if(data == null) {
			throw new EntityNotFoundException();
		} else {
			pemesanan.setId(data.getId());
			pemesanan.setTanggalPesan(new Date());
		pemesananService.updatePemesanan(pemesanan);
		resp.setMassege("Update Data dengan id registrasi "+id+" telah berhasil");
		}
		return resp;
		 
	}
}
