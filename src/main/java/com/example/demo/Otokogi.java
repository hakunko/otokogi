package com.example.demo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="otokogi")
@Getter 
@Setter 
public class Otokogi {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Long id;
	
	@Column(name="price")
	private Long price;
	
	@Column(name="win")
	private String win;
	
	@Column(name="year")
	private Long year;
	
	@Column(name="day")
	private Long day;
	
	@Column(name="month")
	private Long month;
	
	@Column(name="name")
	private String name;
}
