package com.desafios.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.desafios.domain.model.Bank;

public interface BankRepository extends JpaRepository<Bank, Long>{

	Optional<Bank> findByCode(String code);

	void deleteByCode(String code);

}
