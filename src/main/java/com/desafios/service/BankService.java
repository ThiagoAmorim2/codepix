package com.desafios.service;

import java.util.List;

import com.desafios.domain.dto.request.BankRequest;
import com.desafios.domain.dto.response.BankResponseDTO;
import com.desafios.domain.model.Bank;

public interface BankService {

	String createBank(BankRequest bank);

	List<BankResponseDTO> getAllBanks();

	BankResponseDTO findByCode(String code);

	void deleteByCode(String code);

}
