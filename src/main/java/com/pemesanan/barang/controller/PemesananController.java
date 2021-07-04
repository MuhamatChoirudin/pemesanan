package com.pemesanan.barang.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pemesanan.barang.entity.Pemesanan;
import com.pemesanan.barang.exception.EntityNotFoundException;
import com.pemesanan.barang.model.CommonResponse;
import com.pemesanan.barang.service.PemesananService;


@RestController
@RequestMapping("/api/pemesanan")
public class PemesananController {

	public static final String URL_REQUEST_PEMESANAN_BY_ID = "/pemesanan/{id}";
	public static final String URL_REQUEST_PEMESANAN_BY_NAME = "/{name}";
	public static final String URL_REQUEST_PEMESANAN = "/post";

	@Autowired
	private PemesananService pemesananService;
	
	@PostMapping(value=URL_REQUEST_PEMESANAN)
	public CommonResponse<Pemesanan> createCustomer(@RequestBody Pemesanan pemesanan) throws EntityNotFoundException {
	  CommonResponse<Pemesanan> resp = new CommonResponse<>();
		resp.setData(pemesananService.createPemesanan(pemesanan));

		return resp;

	}
	
	@GetMapping(value = URL_REQUEST_PEMESANAN_BY_ID)
	public CommonResponse<Pemesanan> getByCustomerId(@PathVariable(name = "id") int id) throws EntityNotFoundException{
		Pemesanan customer = pemesananService.getByNamePemesan(id);
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
}
