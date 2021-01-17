package org.jembi.challenge.framework;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.jembi.challenge.patient.model.PatientEntity;

/**
 * Utility class for the DTOs
 * 
 * @author Gautchi R. Chambe (chambegautchi@gmail.com)
 */
public class DTOUtility {

	public static PatientEntity toPatient(String[] fields) {

		PatientEntity patient = new PatientEntity();
		patient.setIdentityNumber(fields[0].substring(fields[0].indexOf(":") + 1));
		patient.setFirstName(fields[1].substring(fields[1].indexOf(":") + 1));
		patient.setLastName(fields[2].substring(fields[2].indexOf(":") + 1));
		patient.setPhoneNumber(fields[3].substring(fields[3].indexOf(":") + 1));
		patient.setAddress(fields[4].substring(fields[4].indexOf(":") + 1));
		patient.setGender(fields[5].substring(fields[5].indexOf(":") + 1));
		patient.setRace(fields[6].substring(fields[6].indexOf(":") + 1));

		return patient;
	}

	public static List<PatientEntity> toPatients(ResultSet result) throws SQLException {

		List<PatientEntity> patients = new ArrayList<>();

		while (result.next()) {
			patients.add(new PatientEntity(result.getString("identityNumber"), result.getString("firstName"),
					result.getString("lastName"), result.getString("phoneNumber"), result.getString("address"),
					result.getString("gender"), result.getString("race")));
		}

		return patients;
	}
}