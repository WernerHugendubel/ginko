package it.unibz.internet.controller;

import it.unibz.internet.business.MealReservationService;
import it.unibz.internet.domain.Order;
import it.unibz.internet.domain.Patient;

import java.io.IOException;
import java.util.List;

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
public class PatientOrdersController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private MealReservationService mealReservationService;
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public PatientOrdersController() {
		super();
		this.mealReservationService = new MealReservationService();
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		//get patientid from request
		int patientId = Integer.parseInt(request.getParameter("patientId"));
		Patient pat = this.mealReservationService.getPatient(patientId);
		request.setAttribute("patient", pat);
		List<Order> orders = this.mealReservationService.getOrderList(patientId);
		request.setAttribute("orders", orders);

		RequestDispatcher dispatcher = request
				.getRequestDispatcher("/WEB-INF/jsp/patientOrders.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

	}

}
