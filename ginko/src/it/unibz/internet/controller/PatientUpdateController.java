package it.unibz.internet.controller;

import it.unibz.internet.business.MealReservationService;
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
@WebServlet("/patientUpdate")
public class PatientUpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private MealReservationService mealReservationService;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public PatientUpdateController() {
		super();
		this.mealReservationService = new MealReservationService();
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		int patientId = Integer.parseInt(request.getParameter("patientId"));
		Patient pat = this.mealReservationService.getPatient(patientId);

		request.setAttribute("patient", pat);
		RequestDispatcher dispatcher = request
				.getRequestDispatcher("/WEB-INF/jsp/patientUpdate.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		// Read values from request
		int patientid = Integer.parseInt(request.getParameter("patientId"));
		String patname = request.getParameter("patientName");
		int patientbednr = Integer.parseInt(request.getParameter("bedNr"));

		this.mealReservationService.updatePatient(patientid, patname, patientbednr);
		
		// Return to list - reload the new dataset
		request.setAttribute("patientlist", this.mealReservationService.getPatients());
		RequestDispatcher dispatcher = request
				.getRequestDispatcher("/WEB-INF/jsp/patientList.jsp");
		dispatcher.forward(request, response);
	}

}
