package com.foray.bankjee.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.foray.bankjee.db.User;
import com.foray.bankjee.dao.DaoFactory;
import com.foray.bankjee.dao.UserDao;

/**
 * Servlet implementation class Login
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet
{
    private static final long serialVersionUID = 1L;

    public static final String PARAM_EMAIL = "email";
    public static final String PARAM_PASSWORD = "password";
    public static final String ATT_SESSION_USER = "user";
    public static final String VIEW = "/WEB-INF/views/login.jsp";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        HttpSession session = request.getSession();
        
        if (session.getAttribute( ATT_SESSION_USER ) == null )
        {
        	request.getRequestDispatcher( VIEW ).forward( request, response );
            return;
        }
        else
        {
        	response.sendRedirect( request.getContextPath() + "/auth/dashboard" );
            return;
        }
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        String email = request.getParameter( PARAM_EMAIL );
        String password = request.getParameter( PARAM_PASSWORD );
        
        HttpSession session = request.getSession();
        
        User user = new User();
        user.setEmail(email);
        user.setPassword(email + password);
        
        UserDao userDao = DaoFactory.getUserDao();
        user = userDao.findConnectable(user);
       	if(user == null)
       	{
       		response.sendRedirect( request.getContextPath() + "/login" );
       	}
       	else
       	{
       		session.setAttribute( ATT_SESSION_USER, user );
            response.sendRedirect( request.getContextPath() + "/auth/dashboard" );
       	}
    }
}