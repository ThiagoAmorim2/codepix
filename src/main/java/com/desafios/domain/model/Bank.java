package com.desafios.domain.model;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_bank")
public class Bank {
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	@Column(name = "bank_id", unique = true)
	private UUID bankId;
	
	@Column(name = "created_at", nullable = false)
	private LocalDate createdAt;
	
	@Column(name = "updated_at")
	private LocalDate updatedAt;
	
	@Column(name = "code", nullable = false)
	private String code;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "accounts")
	@OneToMany(mappedBy = "bank", cascade = CascadeType.ALL)
	private List<Account> accounts;
}
