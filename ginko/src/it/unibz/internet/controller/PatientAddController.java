package it.unibz.internet.controller;

import it.unibz.internet.Business.MealReservationService;

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
@WebServlet("/patientAdd")
public class PatientAddController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private MealReservationService mealReservationService;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public PatientAddController() {
		super();
		this.mealReservationService = new MealReservationService();
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request
				.getRequestDispatcher("/WEB-INF/jsp/patientAdd.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		// Read values from request
		String patname = request.getParameter("patientName");
		String bednrstring = request.getParameter("bedNr");
		if (!patname.equals("") && !bednrstring.equals("")) {
			int patientbednr = Integer.parseInt(request.getParameter("bedNr"));
			this.mealReservationService.addPatient(patname, patientbednr);
		}

		// pass generated patient to next page
		request.setAttribute("patientlist", this.mealReservationService.getPatients());
		RequestDispatcher dispatcher = request
				.getRequestDispatcher("/WEB-INF/jsp/patientList.jsp");
		dispatcher.forward(request, response);
	}

}
