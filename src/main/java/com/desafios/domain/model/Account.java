package com.desafios.domain.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "tb_account")
@Getter
@Setter
public class Account implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "account_id", unique = true)
	private Long accountId;
	
	@Column(name = "created_at", nullable = false)
	private LocalDate createdAt;
	
	@Column(name = "updated_at")
	private LocalDate updatedAt;
	
	@Column(name = "ownerName", nullable = false)
	private String ownerName;
	
	@JoinColumn(name = "bank", nullable = false)
	@ManyToOne
	private Bank bank;
	
	@Column(name = "bank_id", nullable = false, unique = true)
	private String bankId;
	
	@Column(name = "number", nullable = false)
	private String number;
	
	@Column(name = "pix_keys")
	@OneToMany(mappedBy = "key", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<PixKey> pixKeys;
}
