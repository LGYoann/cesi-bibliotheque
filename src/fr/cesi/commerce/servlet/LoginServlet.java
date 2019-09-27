package fr.cesi.commerce.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.ProcessBuilder.Redirect;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());

        RequestDispatcher RequetsDispatcherObj = request.getRequestDispatcher("/login.jsp");
        RequetsDispatcherObj.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("user");
   	 String pass = request.getParameter("pass");
   	 
   	 ServletContext sc = getServletContext();
   	 sc.setAttribute("user", username);
   	 RequestDispatcher rd = request.getRequestDispatcher("/inscription");
   	 rd.forward(request, response);
//   	  // get response writer
//        PrintWriter writer = response.getWriter();         
//        // build HTML code
//        String htmlRespone = "<html>";
//        htmlRespone += "<h2>Your username is: " + username + "<br/>";      
//        htmlRespone += "Your msg is: " + pass + "</h2>";          
//        htmlRespone += "</html>";         
//        // return response
//        writer.println(htmlRespone);
		doGet(request, response);
	}
		

}
