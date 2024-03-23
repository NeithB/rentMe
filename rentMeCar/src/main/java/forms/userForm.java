package forms;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import jakarta.servlet.http.HttpServletRequest;
import modele.Membre;

public class userForm {
	
	 private static final String IDM= "idM";
	 private static final String PRENOM="prenom";
	 private static final String NOM="nom";
	 private static final String LOGIN="login";
	 private static final String MDP="mdp";
	 private static final String TEL="tel";
	 private static final String EMAIL="email";
	 private static final String ADRESSE="adresse";
	 private static final String CP="cp";
	 private static final String VILLE="ville";
	 private static final String STATUT="statut";
	 
	 private static final String DATE_INSCR="dateM";
	 
	 
	 private Map<String, String> erreurs = new HashMap<String, String>();

	    public String isValide( String champ, String value, int min, int max ) {
	        value = value.trim();

	        if ( value.length() >= min && value.length() <= max ) {
	            return value;
	        }

	        erreurs.put( champ, champ );

	        return value;
	    }
	    public Map<String, String> getErreurs() {
	        return erreurs;
	    }

	    public void setErreurs( Map<String, String> erreurs ) {
	        this.erreurs = erreurs;
	    }
	 
	 
	 public Membre getUser(HttpServletRequest request) throws ParseException {
		 

		 
		 SimpleDateFormat dateParser = new SimpleDateFormat("yyyy-MM-dd");
			 
		 String prenom=isValide(PRENOM,request.getParameter(PRENOM),2,15);
		 String nom=isValide(NOM,request.getParameter(NOM),2,15);
		 String login=isValide(LOGIN,request.getParameter(LOGIN),4,8);
		 String mdp=isValide(MDP,request.getParameter(MDP),4,8);
		 int tel=Integer.parseInt(request.getParameter(TEL));
		 String email=isValide(EMAIL,request.getParameter(EMAIL),2,50);
		 String adresse= isValide(ADRESSE,request.getParameter(ADRESSE),2,15);
		 int cp=Integer.parseInt(request.getParameter(CP));
		 String ville=isValide(VILLE,request.getParameter(VILLE),2,15);
		 
		
		 
		 String dte= request.getParameter(DATE_INSCR);
		 
			 
		 Date dateIns=dateParser.parse(dte);
		 LocalDate lcl=LocalDate.now();
		 			
	 
		Membre membre =new Membre(0, prenom, nom, login, mdp, tel, email, adresse, cp, ville, "client", dateIns);
		 	 
		return membre;
		 
	 }
	

}
