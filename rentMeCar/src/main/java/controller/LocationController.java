package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import modele.Location;
import modele.Vehicule;
import modele.VehiculeDisponible;

import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;
import java.time.LocalDate;

import dao.LocationDao;
import dao.VehiculeDao;
import forms.LocationForm;


public class LocationController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       VehiculeDao vehiculeDao=new VehiculeDao();
       LocationDao locationDao=new LocationDao();
       
       
       LocalDate lcl=LocalDate.now();
      
       
       
    public LocationController() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action=request.getParameter("action");
		String idV=request.getParameter("idV");
		String idVhc = request.getParameter("idVehicule");
		
		String vue = "Vues/location/";
		
		String idLocation=request.getParameter("idLo");
		
		String idMe=request.getParameter("id");	
		
		if(action!=null) {
			switch(action) {
			case"reserver"->{
				int id=Integer.valueOf(idV);		
				request.setAttribute("vehicule", vehiculeDao.getVehicule(id));
				vehiculeDao.supprimeDispo(id);
				vue+="louer.jsp";		
			}
			case"historique"->{    
				int id=Integer.valueOf(idMe);			
				request.setAttribute("locations", locationDao.listeLoactionsPasses(lcl));
				vue+="historique.jsp";
			}
			case"encours"->{  
				
				int id=Integer.valueOf(idMe);		
				request.setAttribute("locations", locationDao.listeLoactionsEncours(lcl));
				vue+="encours.jsp";
			}
			case"supprimer"->{
				
				int id=Integer.valueOf(idLocation);
				int idVcl=Integer.valueOf(idVhc);
				Vehicule vehicl= vehiculeDao.getVehicule(idVcl);
				vehiculeDao.saveDispo(vehicl);			
				locationDao.supprimer(id);
				response.sendRedirect("MembreController?action=compte");
				return;
				
				
				
			}
			}
			request.getRequestDispatcher(vue).forward(request, response);
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action=request.getParameter("action");
		
		
		LocationForm locationForm=new LocationForm();
		LocationDao locationDao=new LocationDao();
		
		if(action!=null) {
			switch(action) {
			
			case"louer"->{				
				try {
					Location location=locationForm.getLocation(request);
					float prix=Float.valueOf(request.getParameter("prix"));
					
					
					float tarif=locationDao.getTarif(location.getDateDebut(), location.getDateFin(),prix);
					location.setTotal(tarif);
					
					if(location!=null){
						locationDao.save(location);
						response.sendRedirect("MembreController?action=compte");
						return;
					}
					
					
					
			
				} catch (ParseException e) {
					System.out.println("dans locationController louer "+e.getMessage());
				}
				
			}
			}
		}
		
		
	}

}
