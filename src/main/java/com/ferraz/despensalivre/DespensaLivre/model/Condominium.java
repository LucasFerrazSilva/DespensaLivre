package com.ferraz.despensalivre.DespensaLivre.model;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="TAB_CONDOMINIUM")
@Data
public class Condominium {

	@Id
	@GeneratedValue(strategy=IDENTITY)
	@Column(name="CONDOMINIUM_ID")
	private Integer id;
	
	@Column(name="NAME")
	private String name;
	
	@Column(name="ADDRESS")
	private String address;
	
	
	
}
