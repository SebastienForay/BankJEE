package com.foray.bankjee.servlet.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.foray.bankjee.dao.DaoFactory;
import com.foray.bankjee.dao.UserDao;
import com.foray.bankjee.db.User;

/**
 * Servlet implementation class AdvisorServlet
 */
@WebServlet("/auth/admin/advisors")
public class AdvisorServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;

    public static final String ATT_SESSION_USER = "user";
    public static final String VIEW = "/WEB-INF/views/admin/advisors.jsp";
    
	public AdvisorServlet()
	{
        super();
    }

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
        HttpSession session = request.getSession();
    	User user = (User) session.getAttribute( ATT_SESSION_USER );
    	
        if (user == null || user.getType() != 2)
        {
        	response.sendRedirect(request.getContextPath() + "/login");
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
    	
        if (user == null || user.getType() != 2)
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
