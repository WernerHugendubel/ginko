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
@WebServlet("/patientOrders")
public class OrderController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private PatientDBService patientDBService;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public OrderController() {
		super();
		this.patientDBService = new PatientDBService();
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		//get patientid from request
		int patientId = Integer.parseInt(request.getParameter("patientId"));
		Patient pat = this.patientDBService.getPatient(patientId);

		request.setAttribute("patient", pat);

		RequestDispatcher dispatcher = request
				.getRequestDispatcher("/WEB-INF/jsp/patientOrders.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		// Read values from request
//		String patname = request.getParameter("patientName");
//		String bednrstring = request.getParameter("bedNr");
//		if (!patname.equals("") && !bednrstring.equals("")) {
//			int patientbednr = Integer.parseInt(request.getParameter("bedNr"));
//
//			Patient pat = new Patient();
//			pat.setName(patname);
//			pat.setBednr(patientbednr);
//
//			// TODO: Business logic: check patient constraints before save
//
//			// save to db
//			this.patientDBService.addNew(pat);
//		}
//
//		// pass generated patient to next page
//		request.setAttribute("patientlist", this.patientDBService.getPatients());
//		RequestDispatcher dispatcher = request
//				.getRequestDispatcher("/WEB-INF/jsp/patientList.jsp");
//		dispatcher.forward(request, response);
	}

}
