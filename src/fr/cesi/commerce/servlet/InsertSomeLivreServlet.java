package fr.cesi.commerce.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.cesi.commerce.entity.AuteurJPA;
import fr.cesi.commerce.entity.LivreJPA;
import fr.cesi.commerce.object.Auteur;
import fr.cesi.commerce.object.Livre;
import fr.cesi.commerce.operations.OperationAuteur;
import fr.cesi.commerce.operations.OperationLivre;
import fr.cesi.sun.commerce.dao.LivreDao;


/**
 * Servlet implementation class InsertSomeProductServlet
 */
@WebServlet("/insertLivre")
public class InsertSomeLivreServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public InsertSomeLivreServlet() {
        // TODO Auto-generated constructor stub
    }
    
    @Override
    public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	String titre = request.getParameter("titre");
    	String[] auteur = request.getParameterValues("auteurs");
    	
    	if (titre != null) {
    		
    	OperationLivre OL = new OperationLivre();
    	OperationAuteur OA = new OperationAuteur();
       	 LivreJPA l = new LivreJPA();
       	 int size = OL.getAllLivres().size();
       	 l.setId(size++);
       	 l.setTitre(titre);
       	 l.setAuteur(OA.queryForAuteurByName(auteur[0]));
       	OL.saveLivre(l);
    	}
    	    
    	doGet(request, response);
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		  RequestDispatcher RequetsDispatcherObj = request.getRequestDispatcher("/ajoutLivre.jsp");
	        RequetsDispatcherObj.forward(request, response);
	        doPost(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		doGet(request, response);
	   	 RequestDispatcher rd = request.getRequestDispatcher("/listLivre");
       	 rd.forward(request, response);
	}

}
