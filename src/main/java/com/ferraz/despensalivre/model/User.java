package com.ferraz.despensalivre.model;

import static javax.persistence.GenerationType.AUTO;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Entity
@Table(name="TAB_USER")
@Data
public class User {
	
	@Id
	@GeneratedValue(strategy=AUTO)
	@Column(name="USER_ID")
	private Integer id;
	
	@NotNull
	@ManyToOne()
	@JoinColumn(name="CONDOMINIUM_ID")
	private Condominium condominium;
	
	@NotBlank
	@Column(name="NAME")
	private String name;

	@NotBlank
	@Column(name="EMAIL")
	private String email;

	@NotBlank
	@Column(name="PASSWORD")
	private String password;

}
