package it.unibz.internet.controller;


import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;






import it.unibz.internet.db.DatabaseConnectionFactory;
import it.unibz.internet.db.PatientDBService;
import it.unibz.internet.domain.Patient;

/**
 * Servlet implementation class PatientController
 */
@WebServlet("/addPatientCheck")
public class PatientController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private PatientDBService patientDBService;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PatientController() {
    	super();
        this.patientDBService=new PatientDBService();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		
    	int patientId = Integer.parseInt(request.getParameter("patientid"));
		String patname=request.getParameter("patientname");
		int patientbednr=Integer.parseInt(request.getParameter("bednr"));

		//create patient dao object
		Patient pat = new Patient();
		pat.setPatientId(patientId);
		pat.setName(patname);
		pat.setBednr(patientbednr);
		
		//TODO: Business logic: check patient constraints before save
		
		
		this.patientDBService.addNew(pat);
		
		//pass generated patient to next page
        request.setAttribute("newPatient",pat);
		RequestDispatcher dispatcher=request.getRequestDispatcher("/WEB-INF/jsp/patientDetails.jsp");
		dispatcher.forward(request, response);		
	}
	
	
	

}
