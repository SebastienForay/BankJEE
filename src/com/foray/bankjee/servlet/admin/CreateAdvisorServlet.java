package com.foray.bankjee.servlet.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.foray.bankjee.dao.AdvisorDao;
import com.foray.bankjee.dao.DaoFactory;
import com.foray.bankjee.dao.UserDao;
import com.foray.bankjee.db.Advisor;
import com.foray.bankjee.db.User;
import com.foray.bankjee.utils.UserType;

/**
 * Servlet implementation class CreateAdvisorServlet
 */
@WebServlet("/auth/admin/advisors/create")
public class CreateAdvisorServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;

    public static final String ATT_SESSION_USER = "user";

	public static final String PARAM_FNAME = "firstname";
	public static final String PARAM_LNAME = "lastname";
	public static final String PARAM_EMAIL = "email";
	public static final String PARAM_PASSWORD = "password";
	public static final String PARAM_CONFIRM = "confirm";
    public static final String VIEW = "/WEB-INF/views/admin/createAdvisor.jsp";
	public static final String LOGIN = "/login";
	public static final String CREATE_ADVISOR = "/auth/admin/advisors/create";
	public static final String ADVISORS = "/auth/admin/advisors";
	
    
	public CreateAdvisorServlet()
	{
        super();
    }

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
        HttpSession session = request.getSession();
    	User user = (User) session.getAttribute( ATT_SESSION_USER );
    	
        if (user == null || UserType.Convert(user) != UserType.ADMINISTRATOR)
        {
        	response.sendRedirect(request.getContextPath() + LOGIN);
            return;
        }
        else
        {
	    	UserDao userDao = DaoFactory.getUserDao();
	    	List<User> users = userDao.getAllByType(1);
	    	request.setAttribute("users", users);
	    	request.getRequestDispatcher( VIEW ).forward( request, response );
	        return;
        }
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		HttpSession session = request.getSession();
    	User user = (User) session.getAttribute( ATT_SESSION_USER );
    	
        if (user == null || UserType.Convert(user) != UserType.ADMINISTRATOR)
        {
        	response.sendRedirect(request.getContextPath() + LOGIN);
            return;
        }
        else
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
    			response.sendRedirect( request.getContextPath() + CREATE_ADVISOR );
    		}
    		else if(!(password.equals(confirm)))
    		{
    			response.sendRedirect( request.getContextPath() + CREATE_ADVISOR );
    		}
    		else
    		{
    			User userAdvisor = new User();
	    			userAdvisor.setEmail( email );
	    			userAdvisor.setPassword( email + password );
	    			userAdvisor.setFirstname( firstname );
	    			userAdvisor.setLastname( lastname );
	    			userAdvisor.setType(1);

    	    	UserDao userDao = DaoFactory.getUserDao();
    	    	Long ifExist = userDao.findIfExist(email);
    	    	if(ifExist == 0)
    	    	{
    	    		userDao.add( userAdvisor );
    		    	AdvisorDao advisorDao = DaoFactory.getAdvisorDao();
    		    	Advisor advisor = new Advisor();
    		    		advisor.setUser(userAdvisor);
    		    		
    		    	advisorDao.add(advisor);
    		    	
    	    		response.sendRedirect( request.getContextPath() + ADVISORS );
    	    	}
    	    	else
    	    	{
    	    		response.sendRedirect( request.getContextPath() + CREATE_ADVISOR );
    	    	}       
    		}
	        return;
        }
	}

}
