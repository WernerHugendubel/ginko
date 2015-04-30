package it.unibz.internet.controller;

import it.unibz.internet.business.MealReservationService;
import it.unibz.internet.domain.Dish;
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
@WebServlet("/orderDishes")
public class OrderDishesController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private MealReservationService mealReservationService;
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public OrderDishesController() {
		super();
		this.mealReservationService = new MealReservationService();
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		//get action from request
		String action = request.getParameter("action");
		//get orderid from request
		int orderId = Integer.parseInt(request.getParameter("orderId"));

		if (action==null){
			//do nothing
		}else if (action.equals("error")){
			//do nothing
		}else if (action.equals("addDish"))
			//do nothing
		{
			//insert dish into orderdetails
			int dishId=Integer.parseInt(request.getParameter("dishId"));
			try {
				this.mealReservationService.addDishToOrder(orderId, dishId);
			} catch (Exception e) {
				//pass exception to request 
				request.setAttribute("error", e.getMessage());
				request.setAttribute("action", "error");
			}
		}else if (action.equals("removeDish")){
			//remove dish from orderdetails
			int dishId=Integer.parseInt(request.getParameter("dishId"));
			this.mealReservationService.removeDishFromOrder(orderId, dishId);

		}
		Order o = this.mealReservationService.getOrder(orderId);
		request.setAttribute("order", o);
		Patient pat = this.mealReservationService.getPatient(o.getPatientId());
		request.setAttribute("patient",  pat);
		List<Dish> availdishes = this.mealReservationService.getDishs();
		request.setAttribute("availabledishes", availdishes);
		RequestDispatcher dispatcher = request
				.getRequestDispatcher("/WEB-INF/jsp/orderDishes.jsp");
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
