package com.example.demo.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "medical_service")
public class MedicalService {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "name")
	private String name;

	@OneToMany(mappedBy = "medicalService")
	private List<Visit> visit;

	public MedicalService() {

	}

	public MedicalService(int id, String name) {
		this.id = id;
		this.name = name;
	}

	@Override
	public String toString() {
		return "MedicalService [id=" + id + ", name=" + name + "]";
	}

}
