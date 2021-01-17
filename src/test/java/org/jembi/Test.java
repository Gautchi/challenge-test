package org.jembi;

import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Statement;

import org.jembi.challenge.framework.DBUtility;
import org.jembi.challenge.patient.service.PatientQueryService;
import org.jembi.challenge.patient.service.PatientService;
import org.junit.Assert;

public class Test {

	@org.junit.Test
	public void testChallenge() throws Exception {

		InputStream openStream = new FileInputStream("/patients.json");
		Statement statement = DBUtility.getInstance().getConnection().createStatement();
		new PatientService(statement).createPatients(openStream);
		PatientQueryService patientQueryService = new PatientQueryService(statement);
		Assert.assertEquals(1000, patientQueryService.countPatients());
		Assert.assertEquals(50, patientQueryService.findAllPatientsByMaxRows(50).size());
		Assert.assertEquals(1, patientQueryService
				.findPatientsByIdentityNumberOrByFirstNameAndLastName("5427698752539", "Peria", "Cowely").size());

	}
}
