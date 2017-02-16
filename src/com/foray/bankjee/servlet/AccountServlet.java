package com.foray.bankjee.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.foray.bankjee.dao.AccountDao;
import com.foray.bankjee.dao.DaoFactory;
import com.foray.bankjee.db.Account;

/**
 * Servlet implementation class Account
 */
@WebServlet("/auth/account")
public class AccountServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;

    public static final String PARAM_ID = "id";
    public static final String VIEW = "/WEB-INF/views/account.jsp";
    
    public AccountServlet()
    {
        super();
    }

    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		Long id = Long.valueOf(request.getParameter( PARAM_ID ));
		
		AccountDao accountDao = DaoFactory.getAccountDao();
		Account account = accountDao.getOne(id);
		
		if (account == null )
        {
        	response.sendRedirect(request.getContextPath() + "/dashboard");
            return;
        }
        else
        {
        	request.setAttribute("account", account);
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
