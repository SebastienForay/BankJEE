package com.foray.bankjee.servlet;

import java.io.IOException;
import java.util.Date;
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
 * Servlet implementation class TransactionServlet
 */
@WebServlet("/auth/transaction")
public class TransactionServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;

    public static final String ATT_SESSION_USER = "user";
    public static final String VIEW = "/WEB-INF/views/customer/transaction.jsp";
    
    public TransactionServlet()
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
			AccountDao accountDao = DaoFactory.getAccountDao();
        	List<Account> accounts = accountDao.findAll(user);
        	request.setAttribute("accounts", accounts);
        	
        	request.getRequestDispatcher( VIEW ).forward( request, response );
        	return;
    	}
	}

    @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
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
	    	int debitAccountId = Integer.parseInt(request.getParameter("debitAccountId"));
	    	int creditAccountId = Integer.parseInt(request.getParameter("creditAccountId"));
	    	Double amount = Double.parseDouble(request.getParameter("transactionAmount"));
	    	String transactionReason = request.getParameter("transactionReason");
	    	
	    	if(debitAccountId <= 0 ||
    		   creditAccountId <= 0 ||
    		   debitAccountId == creditAccountId ||
    		   amount <= 0.0)
	    	{
	    		doGet(request, response);
	    		return;
	    	}
	    	else
	    	{
	    		AccountDao accountDao = DaoFactory.getAccountDao();
	    		Account debitAccount = accountDao.getOne(user, new Long((long)debitAccountId));
	    		Account creditAccount = accountDao.getOne(user, new Long((long) creditAccountId));
	    		
	    		if((debitAccount.getBalance() - amount) > 0.0)
	    		{
	    			debitAccount.setBalance(debitAccount.getBalance() - amount);	
	    			creditAccount.setBalance(creditAccount.getBalance() + amount);
	
		    		accountDao.update(debitAccount);
		    		accountDao.update(creditAccount);
		    		
		    		TransactionDao transactionDao = DaoFactory.getTransactionDao();
		    		CustomerDao customerDao = DaoFactory.getCustomerDao();
		    		Customer customer = customerDao.getOne(user);
		    		
		    		Transaction transaction = new Transaction();
		    			transaction.setAmount(amount);
		    			transaction.setComment(transactionReason);
		    			transaction.setDate(new Date());
		    			transaction.setDebitAccount(debitAccount);
		    			transaction.setCreditAccount(creditAccount);
		    			transaction.setCustomer(customer);
		    			
		    		
		    		transactionDao.add(transaction);
		        	response.sendRedirect(request.getContextPath() + "/auth/dashboard");
		        	return;
	    		}
	    	}
    	}
	}

}
