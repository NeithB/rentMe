package forms;



import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

import dao.AgenceDao;
import dao.UserDao;
import dao.VehiculeDao;
import jakarta.servlet.http.HttpServletRequest;
import modele.Agence;
import modele.Vehicule;
import modele.Location;
import modele.Membre;


public class LocationForm {

    private static final String DATED   = "dateD";
    private static final String DATEF   = "dateF";
    private static final String IDM     = "idM";
    private static final String IDV 	= "idV";
 
    
    public Location getLocation(HttpServletRequest request) throws ParseException {
    	
    	SimpleDateFormat dateParser = new SimpleDateFormat("yyyy-MM-dd");
    	
    	String dateD=request.getParameter(DATED);
    	String dateF=request.getParameter(DATEF);
    	int idM=Integer.valueOf(request.getParameter(IDM));
    	int idV=Integer.valueOf(request.getParameter(IDV));
    	
    	Date dateDe=dateParser.parse(dateD);
    	Date dateFi=dateParser.parse(dateF);
    	
    	LocalDate dateR=LocalDate.now();
    	
    	VehiculeDao vehiculeDao=new VehiculeDao();
    	UserDao userDao=new UserDao();
    	
    	Vehicule vehicule= vehiculeDao.getVehicule(idV);
    	Membre membre=userDao.getUser(idM);
    	
    	
    	
		return new Location(0, membre, vehicule, dateDe, dateFi, null, dateR);
    }
}
