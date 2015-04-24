package it.unibz.internet.controller;


import it.unibz.internet.db.PatientDAO;
import it.unibz.internet.domain.Patient;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = { "/"})
public class PatientListController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private PatientDAO patientDAO;
	public PatientListController(){
		this.patientDAO=new PatientDAO();
	}
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String applicationContextPath = request.getContextPath();

		if (request.getRequestURI().equals(applicationContextPath + "/")) {
			List<Patient> patientlist = patientDAO.getPatients();
			RequestDispatcher dispatcher = request
					.getRequestDispatcher("/WEB-INF/jsp/patientList.jsp");
			request.getSession().setAttribute("patientlist", patientlist);
			dispatcher.forward(request, response);
		} 
	}
}
