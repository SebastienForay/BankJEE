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
import com.foray.bankjee.dao.CustomerDao;
import com.foray.bankjee.dao.DaoFactory;
import com.foray.bankjee.dao.UserDao;
import com.foray.bankjee.db.Advisor;
import com.foray.bankjee.db.Customer;
import com.foray.bankjee.db.User;
import com.foray.bankjee.utils.UserType;

/**
 * Servlet implementation class AdvisorServlet
 */
@WebServlet("/auth/admin/advisors")
public class ListAdvisorServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;

    public static final String ATT_SESSION_USER = "user";
    public static final String VIEW = "/WEB-INF/views/admin/advisors.jsp";
    
	public ListAdvisorServlet()
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
        	response.sendRedirect(request.getContextPath() + "/login");
            return;
        }
        else
        {
        	String advisorId = request.getParameter("id");
        	String assignUserId = request.getParameter("assignUser");
        	String unAssignUserId = request.getParameter("unAssignUser");
        	
        	if(advisorId != null)
        	{
            	AdvisorDao advisorDao = DaoFactory.getAdvisorDao();
            	UserDao userDao = DaoFactory.getUserDao();
            	
            	Advisor advisor = advisorDao.get(advisorId);
            	User advisorAsUser = advisor.getUser();
            	
            	if(assignUserId != null)
            	{
            		CustomerDao customerDao = DaoFactory.getCustomerDao();
            		
            		User userToAssign = userDao.getOne(assignUserId);
            		Customer customerToAssign = customerDao.getOne(userToAssign);
            		customerToAssign.setAdvisor(advisor);
            		customerDao.update(customerToAssign);
            	}
            	if(unAssignUserId != null)
            	{
            		CustomerDao customerDao = DaoFactory.getCustomerDao();
            		
            		User userToAssign = userDao.getOne(unAssignUserId);
            		Customer customerToAssign = customerDao.getOne(userToAssign);
            		customerToAssign.setAdvisor(null);
            		customerDao.update(customerToAssign);
            	}
            	
            	if(advisorAsUser != null && UserType.Convert(advisorAsUser) == UserType.ADVISOR)
            	{
            		List<User> advisorCustomersAsUser = advisorDao.getAllCustomersForAdvisor(advisor);
            		List<User> customersNotAssigned = advisorDao.getAllCustomersNotForAdvisor(advisor);

                	request.setAttribute("advisor", advisorAsUser);
                	request.setAttribute("customers", advisorCustomersAsUser);
                	request.setAttribute("customersNotAssigned", customersNotAssigned);
                	request.getRequestDispatcher( VIEW ).forward( request, response );
        	        return;
            	}
            	else
            	{
                	response.sendRedirect(request.getContextPath() + "/auth/admin/advisors");
        	        return;
            	}
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
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		HttpSession session = request.getSession();
    	User user = (User) session.getAttribute( ATT_SESSION_USER );
    	
        if (user == null || UserType.Convert(user) != UserType.ADMINISTRATOR)
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
