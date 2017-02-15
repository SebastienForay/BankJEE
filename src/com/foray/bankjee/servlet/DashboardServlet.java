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
import com.foray.bankjee.dao.DaoFactory;
import com.foray.bankjee.db.Account;
import com.foray.bankjee.db.User;

/**
 * Servlet implementation class Dashboard
 */
@WebServlet("/auth/dashboard")
public class DashboardServlet extends HttpServlet
{
    private static final long serialVersionUID = 1L;

    public static final String ATT_SESSION_USER = "user";
    public static final String VIEW = "/WEB-INF/views/dashboard.jsp";
    

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
        	AccountDao accountDao = DaoFactory.getAccountDao();
        	
        	request.setAttribute("firstname", user.getFirstname());
        	request.setAttribute("lastname", user.getLastname());
        	request.setAttribute("email", user.getEmail());
        	
        	List<Account> accounts = accountDao.findAll(user);
        	request.setAttribute("accounts", accounts);
        	
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
