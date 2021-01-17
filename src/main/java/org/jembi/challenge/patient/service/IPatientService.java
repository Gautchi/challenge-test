package org.jembi.challenge.patient.service;

import java.io.InputStream;
import java.sql.SQLException;

import org.jembi.challenge.patient.model.PatientEntity;

/**
 * Service interface for Patient
 * 
 * @author Gautchi R. Chambe (chambegautchi@gmail.com)
 */
public interface IPatientService {

	public void createPatient(PatientEntity patient) throws SQLException;

	public void createPatients(InputStream openStream) throws SQLException;
}