package hs;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@SuppressWarnings("serial") 
@WebServlet("/signinBuyer") 
public class SigninBuyerServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request, response);
	}
	
	private void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		String uri = request.getRequestURI();
		int lastIndex = uri.lastIndexOf("/"); 
		String action = uri.substring(lastIndex+1); 
		
		if(action.equals("loginForm")) {
			
		}else if(action.equals("login")) {
			

			String _id = request.getParameter("BUYER_ID");
			String _password = request.getParameter("PASSWORD");
			
		
			BuyerDao buyerDao = new JdbcBuyerDao();
			Buyer buyer = buyerDao.findById(_id);
			
			String resultMessage = null;
			
			if(buyer != null && buyer.getPASSWORD().equals(_password)) {
				HttpSession session = request.getSession();
				session.setAttribute("buyer", buyer);
				
				resultMessage = buyer.getNAME() + "´Ô ¹Ý°©½À´Ï´Ù.";
			}else if(action.equals("signinBuyer")) {
				
				String NAME = request.getParameter("NAME");
				String BUYER_ID = request.getParameter("BUYER_ID");
				String PASSWORD = request.getParameter("PASSWORD");
				String POSTAL_CODE = request.getParameter("POSTAL_CODE");
				String STREET_ADDRESS = request.getParameter("STREET_ADDRESS");
				String ADDRESS_DETAIL = request.getParameter("ADDRESS_DETAIL");
				String PHONE_NUMBER = request.getParameter("PHONE_NUMBER");
				String EMAIL = request.getParameter("EMAIL");
				
				Buyer buyer1 = new Buyer();
			    buyer1.setNAME(NAME);
			    buyer1.setBUYER_ID(BUYER_ID);
			    buyer1.setPASSWORD(PASSWORD);
			    buyer1.setPOSTAL_CODE(POSTAL_CODE);
			    buyer1.setSTREET_ADDRESS(STREET_ADDRESS);
			    buyer1.setADDRESS_DETAIL(ADDRESS_DETAIL);
			    buyer1.setPHONE_NUMBER(PHONE_NUMBER);
			    buyer1.setEMAIL(EMAIL);
			
				BuyerDao buyerDao1 = new JdbcBuyerDao();
				buyerDao1.insert(buyer1);
				
				
				if(buyer1 != null && buyer1.getPASSWORD().equals(_password)) {
					HttpSession session = request.getSession();
					session.setAttribute("buyer1", buyer1);
				}
			}
			
			
			request.setAttribute("resultMsg", resultMessage);
		}else if(action.equals("logout")) {
			
			HttpSession session = request.getSession();
			session.removeAttribute("buyer");
		}
		
		if(action.equals("loginForm")) {
			
		}else if(action.equals("login")) {
			
			HttpSession session = request.getSession();
			
			if(session.getAttribute("buyer") != null) {
				
			}else {
			}
		}else if(action.equals("logout")) {
			}
		
		System.out.println(action);

		String dispatcherUrl ="/pages/authentication/signinBuyer.jsp";
		
		RequestDispatcher rd = request.getRequestDispatcher(dispatcherUrl);
		rd.forward(request, response);
		
	}
}
