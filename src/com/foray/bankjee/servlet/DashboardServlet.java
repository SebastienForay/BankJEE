package com.foray.bankjee.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//import com.foray.sebastien.filters.Authentification;

/**
 * Servlet implementation class Dashboard
 */
@WebServlet("/dashboard")
public class DashboardServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DashboardServlet()
    {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		HttpSession session = request.getSession();
		String isLogged = (String) session.getAttribute("isLogged");
		
		//Authentification auth = new Authentification();
		//auth.doFilter(request, response, null);
		
		if(isLogged.length() <= 0 || isLogged.isEmpty())
			isLogged = "";
		
		if(!isLogged.equals("true"))
		{
			isLogged = "";
			request.setAttribute("errorMsg", "Vous devez être connecté !");
			
			this.getServletContext()
				.getRequestDispatcher("/WEB-INF/login.jsp")
				.forward(request, response);
		}	
		else
		{
			this.getServletContext()
				.getRequestDispatcher("/WEB-INF/dashboard.jsp")
				.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		doGet(request, response);
	}
}
