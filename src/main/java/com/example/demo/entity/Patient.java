package com.example.demo.entity;


import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "patient")
public class Patient {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "first_name")
	private String firstName;

	@Column(name = "last_name")
	private String lastName;

	@Column(name = "address")
	private String address;

	@Column(name = "day_of_birth")
	private String dayOfBirth;

	@Column(name = "phone_number")
	private String phoneNumber;

	@Column(name = "note")
	private String note;

	@OneToMany(mappedBy = "patient")
	private List<Visit> visit;

	public Patient() {

	}

	public Patient(int id, String firstName, String lastName, String address, String dayOfBirth, String phoneNumber,
			String note) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.dayOfBirth = dayOfBirth;
		this.phoneNumber = phoneNumber;
		this.note = note;
	}

	@Override
	public String toString() {
		return lastName + " " + firstName;
	}

}
