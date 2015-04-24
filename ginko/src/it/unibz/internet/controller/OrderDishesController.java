package it.unibz.internet.controller;

import it.unibz.internet.db.DishDAO;
import it.unibz.internet.db.OrderDAO;
import it.unibz.internet.db.PatientDAO;
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

	private OrderDAO orderDAO;
	private DishDAO dishDAO;
	private PatientDAO patientDAO;
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public OrderDishesController() {
		super();
		this.orderDAO = new OrderDAO();
		this.dishDAO = new DishDAO();
		this.patientDAO = new PatientDAO();
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		//get orderid from request
		int orderId = Integer.parseInt(request.getParameter("orderId"));
		Order o = this.orderDAO.getOrder(orderId);
		request.setAttribute("order", o);
		
		Patient pat = this.patientDAO.getPatient(o.getPatientId());
		request.setAttribute("patient",  pat);
		List<Dish> availdishes = this.dishDAO.getDishs();
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
