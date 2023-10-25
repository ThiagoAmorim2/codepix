package com.desafios.domain.model;

import java.io.Serializable;
import java.math.BigInteger;
import java.time.LocalDate;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "tb_transaction")
@Getter
@Setter
public class Transaction implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "transaction_id", unique = true)
	private Long transactionId;
	
	@Column(name = "created_at", nullable = false)
	private LocalDate createdAt;
	
	@Column(name = "updated_at")
	private LocalDate updatedAt;
	
	@Column(name = "account_from", nullable = false)
	private Account accountFrom;
	
	@Column(name = "account_from_id", nullable = false)
	private String accountFromId;
	
	@Column(name = "amount")
	private BigInteger amount;
	
	@Column(name = "pix_key_to", nullable = false)
	private PixKey pixKeyTo;
	
	@Column(name = "pix_key_id_to", nullable = false)
	private String pixKeyIdTo;
	
	@Column(name = "status", nullable = false)
	private String status;
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "cancel_description")
	private String cancelDescription;
}
