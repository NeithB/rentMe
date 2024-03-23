package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import modele.Membre;
import modele.VehiculeDisponible;

import java.io.IOException;
import java.text.ParseException;
import java.time.LocalDate;

import dao.LocationDao;
import dao.UserDao;
import dao.VehiculeDao;
import forms.userForm;
import forms.userFormModifier;

public class MembreController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	UserDao userDao = new UserDao();
	VehiculeDao vehiculeDao=new VehiculeDao();
	LocationDao locationDao=new LocationDao();
	
	
	 LocalDate lcl=LocalDate.now();
	
	public MembreController() {
		super();
		
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String vue = "Vues/users/";
		String action = request.getParameter("action");
		
		
		request.setAttribute("vehicules", vehiculeDao.listeVehicule());	
		request.setAttribute("listes", userDao.listeUsers());
		
		
		HttpSession session=request.getSession();
		
		

		if (action != null) {
			
			switch (action) {
			case "logon" -> {
				vue += "logon.jsp";
			}
			case "login" -> {
				vue += "login.jsp";
			}
			case "listeMbre" -> {
				vue += "liste.jsp";
			}
			case"supprimer"->{				
				int id=Integer.parseInt(request.getParameter("idUser"));
				userDao.supprimer(id);
				request.setAttribute("msg", "supprimer avec success");
				response.sendRedirect( "MembreController?action=listeMbre" );
				return;
			}
			case"modifier"->{
				int id=Integer.parseInt(request.getParameter("idUser"));
				request.setAttribute("users", userDao.getUser(id));
				vue+="update.jsp";
			}
			case"ajouter"->{
				vue+="ajouter.jsp";
				
			}
			case"deconnexion"->{
				 session.removeAttribute( "user" );
	             response.sendRedirect( "HomeController" );
	             return;
				
			}
			case"compte"->{			
				request.setAttribute("locs", vehiculeDao.listeVehiculeDispo());
				vue+="espace.jsp";			
			}
			
			}
			request.getRequestDispatcher(vue).forward(request, response);
			
		}else {		
			
			request.getRequestDispatcher("Vues/users/welcome.jsp").forward(request, response);
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");
		
		HttpSession session=request.getSession();
		
		userForm userForm = new userForm();
		userFormModifier userFormM=new userFormModifier();
		

		if (action != null) {
			switch (action) {
			case "inscription" -> {
					try {				
						Membre m = userForm.getUser(request);
							if(!userDao.existe(m)) {	
								
								userDao.save(m);
								response.sendRedirect( "HomeController" );
								return;
								
							}else {								
								request.setAttribute("verifie", userDao.existe(m));
								request.setAttribute("user", m);
								request.getRequestDispatcher( "Vues/users/logon.jsp" ).forward( request, response );
							}			
					} catch (ParseException e) {}	
			}
			case"connecter"->{
				String login=request.getParameter("login");
				String mdp=request.getParameter("mdp");
				
				Membre m=userDao.login(login,mdp);
				
				if(m!=null) {					
					session.setAttribute("user", m);		
					response.sendRedirect( "MembreController" );
					return;
				}else {	
					response.sendRedirect( "HomeController" );
					return;
				}
				
			}
			case"modifier"->{
				System.out.println("modifier");
				String id =request.getParameter("idU");
				
					try {
						Membre m=userFormM.getUser(request);
						
						if(!userDao.existe(m)) {
							
							int idUser=Integer.valueOf(id);
							userDao.modifier(m, idUser);
							response.sendRedirect( "MembreController?action=listeMbre" );
							return;				
						}else {								
							request.setAttribute("verifie", userDao.existe(m));
							request.setAttribute("user", m);
							request.getRequestDispatcher( "Vues/users/update.jsp" ).forward( request, response );
						}	
						
					} catch (ParseException e) {
						System.out.println("dans modifier membreController "+e.getMessage());
						
					}
			
			}
			case "add" -> {
				
				try {				
					Membre m = userForm.getUser(request);
					
						if(!userDao.existe(m)) {	
							
							userDao.save(m);
							response.sendRedirect( "MembreController?action=listeMbre" );
							return;
																
						}else {								
							request.setAttribute("verifie", userDao.existe(m));
							request.setAttribute("use", m);
							request.getRequestDispatcher( "Vues/users/ajouter.jsp" ).forward( request, response );
						}			
				} catch (ParseException e) {}	
		}
			
			}}}

}
