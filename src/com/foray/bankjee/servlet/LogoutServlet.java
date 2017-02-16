package com.foray.bankjee.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.foray.bankjee.db.User;

/**
 * Servlet implementation class LogoutServlet
 */
@WebServlet("/auth/logout")
public class LogoutServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;

    public static final String ATT_SESSION_USER = "user";
    public static final String VIEW = "/WEB-INF/views/logout.jsp";
    
    public LogoutServlet()
    {
        super();
    }

    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute( ATT_SESSION_USER );
    	
        if (user == null )
        {
        	response.sendRedirect(request.getContextPath() + "/login");
            return;
        }
        else
        {        	
        	session.setAttribute(ATT_SESSION_USER, null);
        	
        	request.getRequestDispatcher( VIEW ).forward( request, response );
            return;
        }
	}

    @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		doGet(request, response);
	}

}
