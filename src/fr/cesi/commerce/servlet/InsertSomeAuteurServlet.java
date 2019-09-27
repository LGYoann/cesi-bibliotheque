package fr.cesi.commerce.servlet;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.cesi.commerce.entity.AuteurJPA;
import fr.cesi.commerce.object.Auteur;
import fr.cesi.commerce.operations.OperationAuteur;
import fr.cesi.sun.commerce.dao.AuteurDao;

/**
 * Servlet implementation class InsertSomeAuteurServlet
 */
@WebServlet("/insertAuteur")
public class InsertSomeAuteurServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertSomeAuteurServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    @Override
    public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
    	String username = request.getParameter("user");
    	if (username != null) {
    		
    	OperationAuteur OA = new OperationAuteur();
       	 Auteur a = new Auteur();
       	 a.setNom(username);
       	 OA.saveAuteur(a);
       	doPost(request, response);
    	}
    	    
    	doGet(request, response);
    	//response.sendRedirect("/commerce/listAuteur");
    }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		  RequestDispatcher RequetsDispatcherObj = request.getRequestDispatcher("/ajoutAuteur.jsp");
	        RequetsDispatcherObj.forward(request, response);
	        doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
    	 

    	
       	 RequestDispatcher rd = request.getRequestDispatcher("/listAuteur");
       	 rd.forward(request, response);
    	
	}

}
