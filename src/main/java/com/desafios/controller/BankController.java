package com.desafios.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.desafios.domain.dto.request.BankRequest;
import com.desafios.domain.dto.response.BankResponseDTO;
import com.desafios.service.BankService;

@RestController
@RequestMapping("/bank")
public class BankController {

	private final BankService service;
	
	@Autowired
	public BankController(BankService service) {
		this.service = service;
	}

	@PostMapping
	public String createBank(@RequestBody BankRequest bank) {
		return service.createBank(bank);
	}
	
	@GetMapping
	public List<BankResponseDTO> getAllBanks(){
		return service.getAllBanks();
	}
	
	@GetMapping("/{code}")
	public BankResponseDTO findByCode(@PathVariable(name = "code") String code) {
		return service.findByCode(code);
	}

	@DeleteMapping("/{code}")
	public void deleteByCode(@PathVariable(name = "code") String code) {
		service.deleteByCode(code);
	}
}
