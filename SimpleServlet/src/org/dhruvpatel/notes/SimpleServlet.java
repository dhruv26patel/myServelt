package org.dhruvpatel.notes;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sun.xml.internal.ws.util.StringUtils;

/**
 * Servlet implementation class SimpleServlet
 */
@WebServlet(description = "A simple servlet", urlPatterns = { "/advancedServlet" })
public class SimpleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Hello from get Method");
		response.setContentType("text/html");
		PrintWriter writer = response.getWriter(); 
		String firstName = request.getParameter("first_name");
		String lastName = request.getParameter("last_name");
		String emailAddress = request.getParameter("email");
		String comments = request.getParameter("comments");
	
		HttpSession session = request.getSession();
		if(emailAddress != "" && emailAddress !=null) {  
			session.setAttribute("savedEmail", emailAddress);
		}
		
		writer.println("Hello " + firstName + " " + lastName + "<br>" + "Your Email: " + session.getAttribute("savedEmail") + "<br>" + "Comments: " + comments);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Hello from post Method");
		PrintWriter writer = response.getWriter(); 
		String firstName = request.getParameter("first_name");
		String lastName = request.getParameter("last_name");
		String emailAddress = request.getParameter("email");
		String comments = request.getParameter("comments");
	
		writer.println("Hello " + firstName + " " + lastName + "<br>" + "Your Email: " + emailAddress + "<br>" + "Comments: " + comments);
	}

}
