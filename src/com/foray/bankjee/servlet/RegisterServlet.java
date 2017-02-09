package com.foray.bankjee.servlet;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.foray.bankjee.db.Account;
import com.foray.bankjee.db.Customer;
import com.foray.bankjee.db.User;
import com.foray.bankjee.dao.AccountDao;
import com.foray.bankjee.dao.CustomerDao;
import com.foray.bankjee.dao.DaoFactory;
import com.foray.bankjee.dao.UserDao;
import com.foray.bankjee.utils.Encrypt;

/**
 * Servlet implementation class Register
 */
@WebServlet("/register")
public class RegisterServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;
	public static final String PARAM_FNAME = "firstname";
	public static final String PARAM_LNAME = "lastname";
	public static final String PARAM_EMAIL = "email";
	public static final String PARAM_PASSWORD = "password";
	public static final String PARAM_CONFIRM = "confirm";
	public static final String VIEW = "/WEB-INF/views/register.jsp";
	public static final String LOGIN = "/login";
	public static final String REGISTER = "/register";
	
	private final String SALT = "PIp94epLRRLpboRykw8YKDPT34Jg4HRt4bpJAkMR";
	
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		request.getRequestDispatcher( VIEW ).forward( request, response );
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		String firstname = request.getParameter( PARAM_FNAME );
		String lastname = request.getParameter( PARAM_LNAME );
		String email = request.getParameter( PARAM_EMAIL );
		String password = request.getParameter( PARAM_PASSWORD );
		String confirm = request.getParameter( PARAM_CONFIRM );
		
		if(password == null || password.isEmpty() ||
			 email == null || email.isEmpty() ||
			 firstname == null || firstname.isEmpty() ||
			 lastname == null || lastname.isEmpty())
		{
			response.sendRedirect( request.getContextPath() + REGISTER );
		}
		else if(!(password.equals(confirm)))
		{
			response.sendRedirect( request.getContextPath() + REGISTER );
		}
		else
		{
			User user = new User();
	    	user.setEmail( email );
	    	user.setPassword( email + SALT + password );
	    	user.setFirstname( firstname );
	    	user.setLastname( lastname );

	    	UserDao userDao = DaoFactory.getUserDao();
	    	Long ifExist = userDao.findIfExist(email);
	    	if(ifExist == 0)
	    	{
	    		userDao.add( user );
		    	CustomerDao customerDao = DaoFactory.getCustomerDao();
		    	AccountDao accountDao = DaoFactory.getAccountDao();

		    	Customer customer = new Customer();
		    	customer.setUser(user);
		    	customer.setShares(0);
		    	
		    	Account checkingAccount = new Account();
			    	checkingAccount.setLabel("Compte courant");
			    	checkingAccount.setInterest(0.0);
			    	checkingAccount.setBalance(0.0);
			    	checkingAccount.setCreationDate(new Date());
		    	
		    	Account savingAccount = new Account();
			    	savingAccount.setLabel("Livret A");
			    	savingAccount.setInterest(0.9);
			    	savingAccount.setBalance(0.0);
			    	savingAccount.setCreationDate(new Date());

			    	customer.setCheckingAccount(checkingAccount);
			    	customer.setSavingAccount(savingAccount);
		    	
		    	accountDao.add( checkingAccount );
		    	accountDao.add( savingAccount );
	    		customerDao.add( customer );
		    	
	    		response.sendRedirect( request.getContextPath() + LOGIN );
	    	}
	    	else
	    	{
	    		response.sendRedirect( request.getContextPath() + REGISTER );
	    	}       
		}
	}
}
