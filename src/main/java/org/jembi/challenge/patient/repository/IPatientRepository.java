package org.jembi.challenge.patient.repository;

import java.sql.SQLException;
import java.util.List;

import org.jembi.challenge.patient.model.PatientEntity;

/**
 * Provides CRUD operations for Patient entity
 * 
 * @author Gautchi R. Chambe(chambegautchi@gmail.com)
 */
public interface IPatientRepository {

	public interface QUERY {

		public final String CREATE_TABLE_IF_NOT_EXISTS = "create table if not exists patients (id primary key, identityNumber string, "
				+ "firstName string, lastName string, phoneNumber string, address string, gender string, race string)";

		public final String INSERT_PATIENT = "insert into patients(identityNumber, firstName, lastName, phoneNumber, address, gender, race) "
				+ "values(\"%s\", \"%s\", \"%s\", \"%s\", \"%s\", \"%s\", \"%s\")";

		public final String FIND_BY_IDENTITY_NUMBER_OR_BY_FIRST_NAME_AND_LAST_NAME = "select * from patients "
				+ " where identityNumber ='%s' or (firstName = \"%s\" and lastName = \"%s\") ";

		public final String COUNT = "select count(*) as count from patients";

		public final String FIND_ALL_AND_LIMIT = "select * from patients limit %d ";

	}

	public void createTableIfNotExist() throws SQLException;

	public void createPatient(final PatientEntity patient) throws SQLException;

	public int count() throws SQLException;

	public List<PatientEntity> findByIdentityNumberOrByFirstNameAndLastName(final String identityNumber,
			final String firstName, final String lastName) throws SQLException;

	public List<PatientEntity> findAllAndLimitResult(final int limitRows) throws SQLException;

}
