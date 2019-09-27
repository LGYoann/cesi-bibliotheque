package fr.cesi.commerce.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
 * Servlet implementation class ListAuteurServlet
 */
@WebServlet("/listAuteur")
public class ListAuteurServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListAuteurServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    @Override
    public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
    	EntityManagerFactory emf = Persistence.createEntityManagerFactory("bibliotheque") ;

        EntityManager em = emf.createEntityManager() ;
        OperationAuteur OA = new OperationAuteur();
        
        for (AuteurJPA item : OA.getAllAuteurs()) {
        	System.out.println(item.getName());
        }
        List<AuteurJPA> mesAuteurs = OA.getAllAuteurs();
        
    	request.setAttribute("mesAuteurs", mesAuteurs);
    	ServletContext context = getServletContext();
    	RequestDispatcher dispatcher = context.getRequestDispatcher("/listAuteur.jsp");
    	dispatcher.forward(request, response);
//    	for (Product item :mesProduits) {
//    		 PrintWriter writer = response.getWriter();
//             
//             // build HTML code
//             String htmlRespone = "<html>";
//             htmlRespone += "<h2> Nom du produit : " + item.getNom() + "<br/>";
//             htmlRespone += "ID du produit : " +  item.getId() + "</h2>";    
//             htmlRespone += "Prix du produit : " +  item.getPrix() + "</h2>";    
//             htmlRespone += "</html>";
//              
//             // return response
//             writer.println(htmlRespone);
//        }
    	}
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		service(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
