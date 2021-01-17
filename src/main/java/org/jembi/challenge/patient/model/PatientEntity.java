package org.jembi.challenge.patient.model;

import org.jembi.challenge.framework.BaseEntity;

/**
 * Domain entity for Patient
 * 
 * @author Gautchi R. Chambe (chambegautchi@gmail.com)
 */
public class PatientEntity extends BaseEntity {

	private static final long serialVersionUID = 1L;

	private String identityNumber;

	private String firstName;

	private String lastName;

	private String phoneNumber;

	private String address;

	private String gender;

	private String race;

	public PatientEntity() {
	}

	public PatientEntity(String identityNumber, String firstName, String lastName, String phoneNumber, String address,
			String gender, String race) {
		super();
		this.identityNumber = identityNumber;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNumber = phoneNumber;
		this.address = address;
		this.gender = gender;
		this.race = race;
	}

	public String getIdentityNumber() {
		return identityNumber;
	}

	public void setIdentityNumber(String identityNumber) {
		this.identityNumber = identityNumber;
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

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getRace() {
		return race;
	}

	public void setRace(String race) {
		this.race = race;
	}

	@Override
	public String toString() {
		return String.format("%s, %s, %s, %s, %s, %s", identityNumber, firstName, lastName, phoneNumber, address,
				gender, race);
	}
}
