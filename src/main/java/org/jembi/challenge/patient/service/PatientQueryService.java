package org.jembi.challenge.patient.service;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import org.jembi.challenge.patient.model.PatientEntity;
import org.jembi.challenge.patient.repository.IPatientRepository;
import org.jembi.challenge.patient.repository.PatientRepository;

/**
 * Service Implementation for Patient
 * 
 * @author Gautchi R. Chambe (chambegautchi@gmail.com)
 */

public class PatientQueryService implements IPatientQueryService {

	private IPatientRepository patientRepository;

	public PatientQueryService(Statement statement) {

		patientRepository = new PatientRepository(statement);
	}

	@Override
	public int countPatients() throws SQLException {

		return patientRepository.count();
	}

	@Override
	public List<PatientEntity> findPatientsByIdentityNumberOrByFirstNameAndLastName(final String identityNumber,
			final String firstName, final String lastName) throws SQLException {

		return patientRepository.findByIdentityNumberOrByFirstNameAndLastName(identityNumber, firstName, lastName);
	}

	@Override
	public List<PatientEntity> findAllPatientsByMaxRows(final int maxResult) throws SQLException {

		return patientRepository.findAllAndLimitResult(maxResult);
	}
}
