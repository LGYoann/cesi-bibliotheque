package fr.cesi.commerce.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.cesi.commerce.object.Livre;
import fr.cesi.sun.commerce.dao.LivreDao;

/**
 * Servlet implementation class ShowProductServlet
 */
@WebServlet("/showLivre")
public class ShowLivreServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowLivreServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
    	
    	Livre item = new Livre();
    	item = LivreDao.findProductById(Long.parseLong(request.getParameter("id")));
    		 PrintWriter writer = response.getWriter();
             
             // build HTML code
             String htmlRespone = "<html>";
             htmlRespone += "<h2> Nom du produit : " + item.getNom() + "<br/>";       
             htmlRespone += "</html>";
              
             // return response
             writer.println(htmlRespone);
     
		//response.getWriter().append("Served at: ").append(request.getContextPath());
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	

}
