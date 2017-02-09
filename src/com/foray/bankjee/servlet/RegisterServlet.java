package com.foray.bankjee.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.foray.bankjee.db.Customer;
import com.foray.bankjee.dao.DaoFactory;
import com.foray.bankjee.dao.CustomerDao;
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
	public static final String PARAM_MAIL = "email";
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
		String mail = request.getParameter( PARAM_MAIL );
		String password = request.getParameter( PARAM_PASSWORD );
		String confirm = request.getParameter( PARAM_CONFIRM );
		
		if(password == null || password.isEmpty() ||
			 mail == null || mail.isEmpty() ||
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
			String concat = mail + SALT + password;
			concat = Encrypt.encryptPassword(concat);
			
			Customer customer = new Customer();
			customer.setMail( mail );
			customer.setPassword( password );
			customer.setFirstname( firstname );
			customer.setLastname( lastname );
	    	
	    	CustomerDao customerDao = DaoFactory.getCustomerDao();
	    	Long ifExist = customerDao.findIfExist(mail);
	    	if(ifExist == 0)
	    	{
	    		customerDao.add( customer );
	    		response.sendRedirect( request.getContextPath() + REGISTER );
	    	}
	    	else
	    	{
	    		response.sendRedirect( request.getContextPath() + REGISTER );
	    	}       
		}
	}
}
