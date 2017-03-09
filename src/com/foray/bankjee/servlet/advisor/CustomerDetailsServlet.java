package com.foray.bankjee.servlet.advisor;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.foray.bankjee.dao.AccountDao;
import com.foray.bankjee.dao.AdvisorDao;
import com.foray.bankjee.dao.DaoFactory;
import com.foray.bankjee.dao.UserDao;
import com.foray.bankjee.db.Account;
import com.foray.bankjee.db.Advisor;
import com.foray.bankjee.db.User;
import com.foray.bankjee.utils.UserType;

/**
 * Servlet implementation class UserServlet
 */
@WebServlet("/auth/advisor/customers/details")
public class CustomerDetailsServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;

    public static final String ATT_SESSION_USER = "user";
    public static final String VIEW = "/WEB-INF/views/advisor/customerDetails.jsp";
    
	public CustomerDetailsServlet()
	{
        super();
    }

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
        HttpSession session = request.getSession();
    	User user = (User) session.getAttribute( ATT_SESSION_USER );
    	
        if (user == null || UserType.Convert(user) != UserType.ADVISOR)
        {
        	response.sendRedirect(request.getContextPath() + "/login");
            return;
        }
        else
        {
    		String userId = request.getParameter("userId");
        	
        	if(userId != null)
        	{
            	UserDao userDao = DaoFactory.getUserDao();
            	AccountDao accountDao = DaoFactory.getAccountDao();
            	User customer = userDao.getOne(userId);

            	List<Account> accounts = accountDao.findAll(customer);

            	request.setAttribute("customer", customer);
            	request.setAttribute("accounts", accounts);
            	request.getRequestDispatcher( VIEW ).forward( request, response );
    	        return;
            	
        	}
        	else
        	{
    	    	response.sendRedirect(request.getContextPath() + "/auth/advisor/dashboard");
    	        return;
        	}
        }
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		HttpSession session = request.getSession();
    	User user = (User) session.getAttribute( ATT_SESSION_USER );
    	
        if (user == null || UserType.Convert(user) != UserType.ADVISOR)
        {
        	response.sendRedirect(request.getContextPath() + "/login");
            return;
        }
        else
        {
    		doGet(request, response);
	        return;
        }
	}

}
