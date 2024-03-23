package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import modele.Agence;

import java.io.IOException;

import dao.AgenceDao;
import dao.LoaderImg;
import forms.AgenceForm;


@MultipartConfig
public class AgenceController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	AgenceDao agenceDao=new AgenceDao();
	String CHEMIN_IMG_AGENCE ="C:\\Users\\PC\\OneDrive\\Documents\\Eclipse\\Projet\\Exam\\rentMe\\src\\main\\webapp\\img";
	
	
	public AgenceController() {
		super();
		
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		String vues = "Vues/agences/";
		
		request.setAttribute("listes", agenceDao.listeAgence());
		String idA=request.getParameter("idAg");
		if (action != null) {
			switch (action) {
			case "addAgence" -> {
				vues += "addAganece.jsp";
			}
			case"listeAgence"->{			
				vues+="liste.jsp";		
			}
			case"supprimer"->{
				int idAgence=Integer.valueOf(idA);
				agenceDao.supprimer(idAgence);
				response.sendRedirect( "AgenceController?action=listeAgence" );
                return;
				
			}
			case"modifier"->{
			
				int idAgence=Integer.valueOf(idA);			
				request.setAttribute("agence", agenceDao.getAgence(idAgence));
				vues += "upAganece.jsp";
				
			}
			}
		}
		request.getRequestDispatcher(vues).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action = request.getParameter("action");
		AgenceForm agenceForm=new AgenceForm();
	
		if(action!=null) {	
			
			switch(action) {
			
			case"addAgence"->{	
				Agence ag=agenceForm.getAgence(request);
				
				if(ag!=null) {
					try {
						
						LoaderImg load = new LoaderImg();
						String fileName = load.load( request, CHEMIN_IMG_AGENCE );
						ag.setImage(fileName);
						
						if(!agenceDao.existe(ag)) {
							
							agenceDao.save(ag);				
							response.sendRedirect( "AgenceController?action=listeAgence" );
		                    return;	
						}else {	
							
							request.setAttribute("agence", ag);
							request.setAttribute("verifie", agenceDao.existe(ag));						
							request.getRequestDispatcher( "Vues/agences/addAganece.jsp" ).forward( request, response );
						}	
						
	                    
					} catch (Exception e) {
						System.err.println("dans save agence "+e.getMessage());
					}
					
					
				}			
			}
			case"upAgence"->{	
				
				Agence ag=agenceForm.getAgence(request);
				String id=request.getParameter("idA");
				
				if(ag!=null) {
					try {
						
						LoaderImg load = new LoaderImg();
						String fileName = load.load( request, CHEMIN_IMG_AGENCE );
						ag.setImage(fileName);
						
						if(ag!=null) {
						
							int idA=Integer.valueOf(id);
							agenceDao.modifier(ag, idA);				
							response.sendRedirect( "AgenceController?action=listeAgence" );
							return;	
						}
					} catch (Exception e) {
						System.err.println("dans modifier agence "+e.getMessage());
					}
					
					
				}			
			}
			}
			
			
		}

	}

}
