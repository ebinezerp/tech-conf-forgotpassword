package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Entity
@Data
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank(message = "Username should not be blank")
	@NotNull(message = "Username should not be null")
	@Column(nullable = false, unique = true)
	private String username;

	@NotBlank(message = "name should not be blank")
	@NotNull(message = "name should not be null")
	@Column(nullable = false, unique = false)
	private String name;

	@NotBlank(message = "email should not be blank")
	@NotNull(message = "email should not be null")
	@Column(nullable = false, unique = true)
	private String email;

	@NotBlank(message = "email should not be blank")
	@NotNull(message = "email should not be null")
	@Column(nullable = false, unique = false)
	private String password;

}
