package org.jembi.challenge.patient.service;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Scanner;

import org.jembi.challenge.framework.DTOUtility;
import org.jembi.challenge.patient.model.PatientEntity;
import org.jembi.challenge.patient.repository.IPatientRepository;
import org.jembi.challenge.patient.repository.PatientRepository;

/**
 * Service Implementation for Patient
 * 
 * @author Gautchi R. Chambe (chambegautchi@gmail.com)
 */
public class PatientService implements IPatientService {

	private IPatientRepository patientRepository;

	public PatientService(Statement statement) throws SQLException {

		patientRepository = new PatientRepository(statement);
		this.createPatientTable();
	}

	public void createPatientTable() throws SQLException {
		patientRepository.createTableIfNotExist();
	}

	@Override
	public void createPatient(final PatientEntity patient) throws SQLException {

		List<PatientEntity> duplicates = patientRepository.findByIdentityNumberOrByFirstNameAndLastName(
				patient.getIdentityNumber(), patient.getFirstName(), patient.getLastName());

		if (!duplicates.isEmpty()) {

			for (PatientEntity duplicate : duplicates) {

				if (patient.getIdentityNumber() == duplicate.getIdentityNumber()) {
					continue;
				} else if (patient.getFirstName() == duplicate.getFirstName()
						&& patient.getLastName() == duplicate.getLastName()) {
					if (patient.getGender() == duplicate.getGender() && patient.getRace() == duplicate.getRace()) {
						continue;
					}
				} else {
					patientRepository.createPatient(patient);
				}
			}
		} else {
			patientRepository.createPatient(patient);
		}
	}

	@Override
	public void createPatients(InputStream openStream) throws SQLException {

		Scanner input = new Scanner(new BufferedReader(new InputStreamReader(openStream)));

		while (input.hasNextLine()) {

			String line = input.nextLine();
			line = line.replace("[", "");
			line = line.replace("]", "");
			line = line.replace("{", "");
			line = line.replace("}", "");
			line = line.replace("\"", "");

			String[] fields = line.split(",");

			this.createPatient(DTOUtility.toPatient(fields));
		}

		input.close();
	}
}
