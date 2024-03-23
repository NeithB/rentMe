package forms;

import dao.AgenceDao;
import jakarta.servlet.http.HttpServletRequest;
import modele.Agence;
import modele.Vehicule;

public class VehiculeForm {

    private static final String MARQUE     = "marque";
    private static final String MODELE   = "modele";
    private static final String PRIX    = "prix";
    private static final String DESCRIPTION = "description";
    private static final String AGENCE = "agence";
    private static final String PHOTO   = "photo";
    
    public Vehicule getAgence(HttpServletRequest request) {
    	
    	String marque=request.getParameter(MARQUE);
    	String modele=request.getParameter(MODELE);
    	String description=request.getParameter(DESCRIPTION);
    	Double prix=Double.valueOf(request.getParameter(PRIX));
    	String photo=request.getParameter(PHOTO);
    	
    	int agence=Integer.valueOf(request.getParameter("agence"));
    	
    	AgenceDao agenceDao=new AgenceDao();
    	Agence ag= agenceDao.getAgence(agence);
    	

		return new Vehicule(0,marque,modele,prix,description,photo,ag);
    }
}
