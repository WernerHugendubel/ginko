package it.unibz.internet.controller;


import it.unibz.internet.db.PatientDBService;
import it.unibz.internet.domain.Patient;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class PatientController
 */
@WebServlet("/blumentopferde")
public class HomeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private PatientDBService patientDBService;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HomeController() {
    	super();
        this.patientDBService=new PatientDBService();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		
    	//Read values from request
    	int patientId = Integer.parseInt(request.getParameter("patientid"));
		String patname=request.getParameter("patientname");
		int patientbednr=Integer.parseInt(request.getParameter("bednr"));

		//create patient POJO object
		Patient pat = new Patient();
		pat.setPatientId(patientId);
		pat.setName(patname);
		pat.setBednr(patientbednr);
		
		//TODO: Business logic: check patient constraints before save
		
		//save to db
		this.patientDBService.addNew(pat);
		
		//pass generated patient to next page
        request.setAttribute("newPatient",pat);
		RequestDispatcher dispatcher=request.getRequestDispatcher("/WEB-INF/jsp/patientDetails.jsp");
		dispatcher.forward(request, response);		
	}
	
	
	

}
