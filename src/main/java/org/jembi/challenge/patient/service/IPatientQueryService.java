package org.jembi.challenge.patient.service;

import java.sql.SQLException;
import java.util.List;

import org.jembi.challenge.patient.model.PatientEntity;

/**
 * Query Service interface for Patient
 * 
 * @author Gautchi R. Chambe (chambegautchi@gmail.com)
 */
public interface IPatientQueryService {

	public int countPatients() throws SQLException;

	public List<PatientEntity> findPatientsByIdentityNumberOrByFirstNameAndLastName(String identityNumber, String firstName, String lastName) throws SQLException;

	public List<PatientEntity> findAllPatientsByMaxRows(int maxResult) throws SQLException;
}