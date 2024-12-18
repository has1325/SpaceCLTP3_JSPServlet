package mall.history;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mall.younghun.Buyer;


@WebServlet("/buyerhistory")
public class BuyerHistoryServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		process(req,resp);
	}
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		process(req, resp);
	}
	
	private void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String uri = request.getRequestURI();
		int lastIndex = uri.lastIndexOf("/");
		String action = uri.substring(lastIndex + 1);
		
		if(action.equals("buyerhistory")) {
			HttpSession session = request.getSession();
			Buyer buyer = (Buyer) session.getAttribute("buyer");
			HistoryDao historyDao = new JdbcHistoryDao();
			List<History> history = historyDao.findByBuyerNumber(buyer.getBuyer_number());
			request.setAttribute("history", history);
			
		}
		
		
		String dispatcherUrl = null;
		
		if(action.equals("buyerhistory")) {
			dispatcherUrl = "pages/history/buyerhistory.jsp";
		}
		
	    if(dispatcherUrl != null) {
	    	RequestDispatcher rd = request.getRequestDispatcher(dispatcherUrl);
	    	rd.forward(request, response);
	    }
		
	}
	
	

	
}
