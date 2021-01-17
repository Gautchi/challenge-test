package org.jembi.challenge.patient.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import org.jembi.challenge.framework.DTOUtility;
import org.jembi.challenge.patient.model.PatientEntity;

/**
 * Provides CRUD operations for Patient entity
 * 
 * @author Gautchi R. Chambe(chambegautchi@gmail.com)
 */
public class PatientRepository implements IPatientRepository {

	private Statement statement;

	public PatientRepository(Statement statement) {
		this.statement = statement;
	}

	@Override
	public void createTableIfNotExist() throws SQLException {
		getStatement().executeUpdate(IPatientRepository.QUERY.CREATE_TABLE_IF_NOT_EXISTS);
	}

	private Statement getStatement() {
		return statement;
	}

	@Override
	public void createPatient(PatientEntity patient) throws SQLException {

		String insertPatientQuery = String.format(IPatientRepository.QUERY.INSERT_PATIENT, patient.getIdentityNumber(),
				patient.getFirstName(), patient.getLastName(), patient.getPhoneNumber(), patient.getAddress(),
				patient.getGender(), patient.getRace());

		getStatement().executeUpdate(insertPatientQuery);
	}

	@Override
	public int count() throws SQLException {

		return getStatement().executeQuery(IPatientRepository.QUERY.COUNT).getInt("count");
	}

	@Override
	public List<PatientEntity> findByIdentityNumberOrByFirstNameAndLastName(String identityNumber, String firstName,
			String lastName) throws SQLException {

		String query = String.format(IPatientRepository.QUERY.FIND_BY_IDENTITY_NUMBER_OR_BY_FIRST_NAME_AND_LAST_NAME,
				identityNumber, firstName, lastName);

		ResultSet result = getStatement().executeQuery(query);

		return DTOUtility.toPatients(result);
	}

	@Override
	public List<PatientEntity> findAllAndLimitResult(int limitRows) throws SQLException {

		ResultSet result = getStatement()
				.executeQuery(String.format(IPatientRepository.QUERY.FIND_ALL_AND_LIMIT, limitRows));

		return DTOUtility.toPatients(result);
	}
}
