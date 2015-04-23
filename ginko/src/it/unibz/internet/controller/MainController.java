package it.unibz.internet.controller;

import it.unibz.internet.db.PatientDBService;
import it.unibz.internet.domain.Patient;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = { "/", "/addPatient", "/deletePatient"})
public class MainController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String applicationContextPath = request.getContextPath();

		if (request.getRequestURI().equals(applicationContextPath + "/")) {
			PatientDBService patientDBService = new PatientDBService();
			List<Patient> patientlist = patientDBService.getPatients();
			RequestDispatcher dispatcher = request
					.getRequestDispatcher("/WEB-INF/jsp/home.jsp");
			request.getSession().setAttribute("patientlist", patientlist);
			
			dispatcher.forward(request, response);
		} else if (request.getRequestURI().equals(
				applicationContextPath + "/addPatient")) {
			RequestDispatcher dispatcher = request
					.getRequestDispatcher("/WEB-INF/jsp/addPatient.jsp");
			dispatcher.forward(request, response);		
			}
//			else if (request.getRequestURI().equals(
//				applicationContextPath + "/deletePatient")) {
//			RequestDispatcher dispatcher = request
//					.getRequestDispatcher("/WEB-INF/jsp/deletePatient.jsp");
//			dispatcher.forward(request, response);
//		}
	}

}
