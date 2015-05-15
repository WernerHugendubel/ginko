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
@WebServlet("/rateDishes")
public class RateDishesController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private MealReservationService mealReservationService;
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RateDishesController() {
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
		}
		Order o = this.mealReservationService.getOrder(orderId);
		request.setAttribute("order", o);
		Patient pat = this.mealReservationService.getPatient(o.getPatientId());
		request.setAttribute("patient",  pat);
		//List<Dish> availdishes = this.mealReservationService.getDishsRated();
		List<Dish> availdishes = this.mealReservationService.getAvailableDishs(o);
		request.setAttribute("availabledishes", availdishes);
		RequestDispatcher dispatcher = request
				.getRequestDispatcher("/WEB-INF/jsp/rateDishes.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		    // now rate the dish
	    int rating = Integer.parseInt(request.getParameter("rating"));
	    int orderId = Integer.parseInt(request.getParameter("orderId"));
	    int dishId = Integer.parseInt(request.getParameter("dishId"));
		    
		this.mealReservationService.setDishRating(orderId, dishId, rating);
		Order o = this.mealReservationService.getOrder(orderId);
		request.setAttribute("order", o);
		Patient pat = this.mealReservationService.getPatient(o.getPatientId());
		request.setAttribute("patient",  pat);
		//List<Dish> availdishes = this.mealReservationService.getDishsRated();
		List<Dish> availdishes = this.mealReservationService.getAvailableDishs(o);
		request.setAttribute("availabledishes", availdishes);
		RequestDispatcher dispatcher = request
				.getRequestDispatcher("/WEB-INF/jsp/rateDishes.jsp");
		dispatcher.forward(request, response);


	}

}
