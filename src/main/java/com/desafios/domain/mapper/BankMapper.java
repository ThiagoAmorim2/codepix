package com.desafios.domain.mapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.desafios.domain.dto.request.BankRequest;
import com.desafios.domain.dto.response.BankResponseDTO;
import com.desafios.domain.model.Bank;

import lombok.experimental.var;

@Component
public class BankMapper {

	public static Bank toBank(BankRequest bank) {
		Bank obj = new Bank();
		obj.setCode(bank.getCode());
		obj.setName(bank.getName());
		return obj;
	}

	public static List<BankResponseDTO> toBankListResponseDTO(List<Bank> banks) {
		List<BankResponseDTO> banksResponse = new ArrayList<>(); 
		for(Bank bank : banks) {
			var obj = BankResponseDTO.builder()
					.accounts(bank.getAccounts())
					.bankId(bank.getBankId())
					.code(bank.getCode())
					.createdAt(bank.getCreatedAt())
					.updatedAt(bank.getUpdatedAt())
					.name(bank.getName())
					.build();
					banksResponse.add(obj);
		}
		return banksResponse;
	}

	public static BankResponseDTO toBankResponseDTO(Optional<Bank> optional) {
		return BankResponseDTO.builder()
				.bankId(optional.get().getBankId())
				.accounts(optional.get().getAccounts())
				.code(optional.get().getCode())
				.name(optional.get().getName())
				.createdAt(optional.get().getCreatedAt())
				.updatedAt(optional.get().getUpdatedAt())
				.build();
	}

}
