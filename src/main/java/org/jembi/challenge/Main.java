package org.jembi.challenge;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import org.jembi.challenge.framework.DBUtility;
import org.jembi.challenge.patient.model.PatientEntity;
import org.jembi.challenge.patient.service.IPatientQueryService;
import org.jembi.challenge.patient.service.IPatientService;
import org.jembi.challenge.patient.service.PatientQueryService;
import org.jembi.challenge.patient.service.PatientService;

public class Main {

	public static void main(String[] args) throws IOException, SQLException {

		URL url = new URL("https://www.mockaroo.com/04de5930/download?count=1000&key=e27814e0");

		Connection db = DBUtility.getInstance().getConnection();
		Statement statement = db.createStatement();

		IPatientService patientService = new PatientService(statement);
		patientService.createPatients(url.openStream());

		IPatientQueryService patientQueryService = new PatientQueryService(statement);
		System.out.println(patientQueryService.countPatients());

		List<PatientEntity> firs10 = patientQueryService.findAllPatientsByMaxRows(10);
		for (PatientEntity patient : firs10) {
			System.out.println(patient.toString());
		}

		statement.close();
		db.close();
	}
}
