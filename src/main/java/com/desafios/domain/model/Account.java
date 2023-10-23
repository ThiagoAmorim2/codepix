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
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_account")
public class Account {
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	@Column(name = "account_id", unique = true)
	private UUID accountId;
	
	@Column(name = "created_at", nullable = false)
	private LocalDate createdAt;
	
	@Column(name = "updated_at")
	private LocalDate updatedAt;
	
	@Column(name = "ownerName", nullable = false)
	private String ownerName;
	
	@Column(name = "bank", nullable = false)
	@ManyToOne
	private Bank bank;
	
	@Column(name = "bank_id", nullable = false, unique = true)
	private String bankId;
	
	@Column(name = "number", nullable = false)
	private String number;
	
	@Column(name = "pix_keys", unique = true)
	@OneToMany(mappedBy = "account", cascade = CascadeType.ALL)
	private List<PixKey> pixKeys;
}
