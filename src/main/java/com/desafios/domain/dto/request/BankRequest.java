package com.desafios.domain.dto.request;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import com.desafios.domain.model.Account;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class BankRequest {

	private LocalDate createdDate;
	private LocalDate updatedDate;
	private String code;
	private String name;
}
