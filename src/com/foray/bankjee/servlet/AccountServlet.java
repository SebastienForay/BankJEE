package com.foray.bankjee.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.foray.bankjee.dao.AccountDao;
import com.foray.bankjee.dao.CustomerDao;
import com.foray.bankjee.dao.DaoFactory;
import com.foray.bankjee.dao.TransactionDao;
import com.foray.bankjee.db.Account;
import com.foray.bankjee.db.Customer;
import com.foray.bankjee.db.Transaction;
import com.foray.bankjee.db.User;

/**
 * Servlet implementation class Account
 */
@WebServlet("/auth/account")
public class AccountServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;

    public static final String PARAM_ID = "id";
    public static final String ATT_SESSION_USER = "user";
    public static final String VIEW = "/WEB-INF/views/customer/account.jsp";
    
    public AccountServlet()
    {
        super();
    }

    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
    	HttpSession session = request.getSession();
    	User user = (User) session.getAttribute( ATT_SESSION_USER );
    	
    	if(user == null)
    	{
        	response.sendRedirect(request.getContextPath() + "/login");
            return;
    	}
    	else
    	{
			Long id = Long.valueOf(request.getParameter( PARAM_ID ));
			
			AccountDao accountDao = DaoFactory.getAccountDao();
			Account account = accountDao.getOne(user, id);
			
			if (account == null )
	        {
	        	response.sendRedirect(request.getContextPath() + "/dashboard");
	        	return;
	        }
	        else
	        {
	        	TransactionDao transactionDao = DaoFactory.getTransactionDao();
	        	CustomerDao customerDao = DaoFactory.getCustomerDao();
	        	Customer customer = customerDao.getOne(user);
	        	List<Transaction> transactions = transactionDao.findAll(customer, account);
	        	
	        	request.setAttribute("account", account);
	        	request.setAttribute("transactions", transactions);
	        	request.getRequestDispatcher( VIEW ).forward( request, response );
        		return;
	        }
    	}
	}

    @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		doGet(request, response);
	}

}
