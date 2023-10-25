package com.desafios.service.impl;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.desafios.domain.dto.request.BankRequest;
import com.desafios.domain.dto.response.BankResponseDTO;
import com.desafios.domain.mapper.BankMapper;
import com.desafios.domain.model.Bank;
import com.desafios.repository.BankRepository;
import com.desafios.service.BankService;

import jakarta.transaction.Transactional;

@Service
public class BankServiceImp implements BankService{
	
	private final BankRepository repository;
	
	@Autowired
	public BankServiceImp(BankRepository repository) {
		this.repository = repository;
	}

	@Transactional
	@Override
	public String createBank(BankRequest bank) {
		Bank newBank = BankMapper.toBank(bank);
		isValidBank(newBank);
		newBank.setCreatedAt(LocalDate.now());
		repository.save(newBank);
		return "Banco cadastrado com sucesso!";
	}

	private boolean isValidBank(Bank newBank) {
		Integer codeChar = newBank.getCode().length();
		Integer nameChar = newBank.getName().length();
		return codeChar<=20 &&  nameChar<=255;
	}

	@Override
	public List<BankResponseDTO> getAllBanks() {
		List<Bank> banks = repository.findAll();
		return BankMapper.toBankListResponseDTO(banks);
	}

	@Override
	public BankResponseDTO findByCode(String code) {
		Optional<Bank> optional = Optional.of(repository.findByCode(code)).orElseThrow(IllegalStateException::new);
		return BankMapper.toBankResponseDTO(optional);
	}

	@Transactional
	@Override
	public void deleteByCode(String code) {
		Optional<Bank> optional = Optional.of(repository.findByCode(code)).orElseThrow(IllegalStateException::new);
		repository.deleteById(optional.get().getBankId());
	}

}
