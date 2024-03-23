package forms;

import jakarta.servlet.http.HttpServletRequest;
import modele.Agence;

public class AgenceForm {

  
    private static final String NOM     = "nom";
    private static final String TEL   = "tel";
    private static final String EMAIL    = "email";
    private static final String ADRESSE = "adresse";
    private static final String CP    = "cp";
    private static final String VILLE   = "ville";
    private static final String PHOTO   = "photo";
    
    public Agence getAgence(HttpServletRequest request) {
    	
    	String nom=request.getParameter(NOM);
    	int tel=Integer.valueOf(request.getParameter(TEL));
    	String email=request.getParameter(EMAIL);
    	String adresse=request.getParameter(ADRESSE);
    	int cp=Integer.valueOf(request.getParameter(CP));
    	String ville=request.getParameter(VILLE);
    	String photo=request.getParameter(PHOTO);
    	

		return new Agence(0, nom, tel, email, adresse, tel, ville, photo);
    	
    }
    

}
