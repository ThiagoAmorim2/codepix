package com.desafios.domain.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "tb_pixKey")
@Getter
@Setter
public class PixKey implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "pixkey_id", unique = true)
	private Long pixKeyId;
	
	@Column(name = "created_at", nullable = false)
	private LocalDate createdAt;
	
	@Column(name = "updated_at")
	private LocalDate updatedAt;
	
	@Column(name = "kind", nullable = false)
	private String kind;
	
	@Column(name = "keyPix", nullable = false, unique = true)
	private String key;
	
	@ManyToOne
	@JoinColumn(name = "account_id")
	private Account account;
}
