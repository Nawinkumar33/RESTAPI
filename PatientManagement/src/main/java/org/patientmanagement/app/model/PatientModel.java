package org.patientmanagement.app.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "patient")
public class PatientModel {
	

	public PatientModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PatientModel(int patientId, String firstName, String lastName, int age, String email, long phoneNumber,
			String problem, String prescription, String charge, int weight) {
		super();
		this.patientId = patientId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.problem = problem;
		this.prescription = prescription;
		this.charge = charge;
		this.weight = weight;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "patient_id")
	private int patientId;
	
	@Column(name = "first_name", nullable = false)
	private String firstName;

	@Column(name = "last_name", nullable = false)
	private String lastName;
	
	@Column(name = "age", nullable = false)
	private int age;
	
	@Column(name = "email", nullable = false)
	private String email;
	
	@Column(name = "phone_number", nullable = false)
	private long phoneNumber;
	
	@Column(name = "problem", nullable = false)
	private String problem;
	
	@Column(name = "prescription", nullable = false)
	private String prescription;
	
	@Column(name = "charge", nullable = false)
	private String charge;
	
	@Column(name = "weight", nullable = false)
	private int weight;

	public int getPatientId() {
		return patientId;
	}

	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public long getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getProblem() {
		return problem;
	}

	public void setProblem(String problem) {
		this.problem = problem;
	}

	public String getPrescription() {
		return prescription;
	}

	public void setPrescription(String prescription) {
		this.prescription = prescription;
	}

	public String getCharge() {
		return charge;
	}

	public void setCharge(String charge) {
		this.charge = charge;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	@Override
	public String toString() {
		return "PatientModel [patientId=" + patientId + ", firstName=" + firstName + ", lastName=" + lastName + ", age="
				+ age + ", email=" + email + ", phoneNumber=" + phoneNumber + ", problem=" + problem + ", prescription="
				+ prescription + ", charge=" + charge + ", weight=" + weight + "]";
	}
	
	
}