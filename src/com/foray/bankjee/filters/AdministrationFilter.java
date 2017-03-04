package com.foray.bankjee.filters;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.foray.bankjee.db.User;
import com.foray.bankjee.utils.UserType;

@WebFilter( urlPatterns = "/admin/*" )
public class AdministrationFilter implements Filter
{
    public static final String ATT_SESSION_USER = "user";
    
    public void init( FilterConfig config ) throws ServletException
    {
    
    }

    public void doFilter( ServletRequest request, ServletResponse response, FilterChain chain ) throws IOException,ServletException
    {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute( ATT_SESSION_USER );
        
        if ( user == null || UserType.Convert(user) != UserType.ADMINISTRATOR)
        {
            res.sendRedirect( req.getContextPath()+"/login" );
            return;
        }
        
        chain.doFilter( req, res );
    }

    public void destroy()
    {
        
    }
}
