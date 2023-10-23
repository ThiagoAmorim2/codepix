package com.desafios.domain.model;

import java.time.LocalDate;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_pixKey")
public class PixKey {
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	@Column(name = "pix_key_id", unique = true)
	private UUID pixKeyId;
	
	@Column(name = "created_at", nullable = false)
	private LocalDate createdAt;
	
	@Column(name = "updated_at")
	private LocalDate updatedAt;
	
	@Column(name = "kind", nullable = false)
	private String kind;
	
	@Column(name = "key", nullable = false, unique = true)
	private String key;
	
	@Column(name = "account", unique = true)
	@ManyToOne
	private String account;
	
}
