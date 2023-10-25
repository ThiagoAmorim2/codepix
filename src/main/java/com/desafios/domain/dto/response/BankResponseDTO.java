package com.desafios.domain.dto.response;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import com.desafios.domain.model.Account;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.OneToMany;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class BankResponseDTO {

	private Long bankId;
	
	private LocalDate createdAt;
	
	private LocalDate updatedAt;
	
	private String code;
	
	private String name;
	
	private List<Account> accounts;
	
}
