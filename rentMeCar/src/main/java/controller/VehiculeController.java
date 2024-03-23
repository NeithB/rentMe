package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import modele.Vehicule;

import java.io.IOException;

import dao.AgenceDao;
import dao.LoaderImg;
import dao.VehiculeDao;
import forms.VehiculeForm;

@MultipartConfig
public class VehiculeController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	AgenceDao agenceDao          = new AgenceDao();
	VehiculeForm vehiculeForm    = new VehiculeForm();
	VehiculeDao vehiculeDao      = new VehiculeDao();
	String CHEMIN_IMG_AGENCE     ="C:\\Users\\PC\\OneDrive\\Documents\\Eclipse\\Projet\\Exam\\rentMe\\src\\main\\webapp\\img";
	public VehiculeController() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");

		request.setAttribute("listes", agenceDao.listeAgence());
		request.setAttribute("listesV", vehiculeDao.listeVehicule());
		
		String id=request.getParameter("idV");
		
		String vues = "Vues/vehicules/";
		if (action != null) {
			switch (action) {
			case "addVcl" -> {
				vues += "addVcl.jsp";
			}
			case"listeVcl"->{
				vues += "listeVcl.jsp";
			}
			case"supprimer"->{
				int idV=Integer.valueOf(id);
				vehiculeDao.supprimer(idV);
				response.sendRedirect("VehiculeController?action=listeVcl");
				return;		
			}
			case"modifier"->{
				int idV=Integer.valueOf(id);
				request.setAttribute("vehicule", vehiculeDao.getVehicule(idV));
				vues+="upModifier.jsp";
			}
			case"dispo"->{
				vues+="disponible.jsp";
			}
			}
		}
		request.getRequestDispatcher(vues).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");

		if (action != null) {
			switch (action) {
			case "addVcl" -> {

				Vehicule vehicule = vehiculeForm.getAgence(request);

				if (vehicule != null) {
					try {

						LoaderImg load = new LoaderImg();
						String fileName = load.load(request, CHEMIN_IMG_AGENCE);
						vehicule.setImage(fileName);

						if (!vehiculeDao.existe(vehicule)) {

							vehiculeDao.save(vehicule);
							response.sendRedirect("VehiculeController?action=listeVcl");
							return;
						} else {

							request.setAttribute("vehicule", vehicule);
							request.setAttribute("verifie", vehiculeDao.existe(vehicule));
							request.getRequestDispatcher("Vues/vehicules/addVcl.jsp").forward(request, response);
						}

					} catch (Exception e) {
						System.err.println("dans save Vehicule " + e.getMessage());
					}

				}

			}
			case"upVcl"->{
				Vehicule vehicule = vehiculeForm.getAgence(request);
				String id=request.getParameter("idV");
				
				if (vehicule != null) {

					LoaderImg load = new LoaderImg();
					String fileName = load.load(request, CHEMIN_IMG_AGENCE);
					vehicule.setImage(fileName);
					
					int idV=Integer.valueOf(id);

					vehiculeDao.modifier(vehicule, idV);
					response.sendRedirect("VehiculeController?action=listeVcl");
					return;
					
				}
				
			}
			case"dispo"->{
				String idD=request.getParameter("vehicule");
				int idI=Integer.valueOf(idD);
				
				Vehicule vh=vehiculeDao.getVehicule(idI);
				if(vh!=null) {
					vehiculeDao.saveDispo(vh);
					response.sendRedirect("MembreController?action=compte");
					return;
					
				}
				
				
			}
			}
		}
	}

}
