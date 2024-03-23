package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import modele.Location;
import modele.Membre;
import modele.Vehicule;

public class LocationDao extends DAO<Location> {
	
	
	public float getTarif(Date dD, Date dF, float t) {
		
		 long diff = dF.getTime() - dD.getTime();
         float res = (diff / (1000*60*60*24));
      
         float total=t*res;  
         
         return total;	
	}

	public void save(Location location){
		
		String query="INSERT INTO location VALUES (NULL,?,?,?,?,?,?)";
		
		try {
			
			PreparedStatement statement=connection.prepareStatement(query);
			
			
			statement.setInt(1, location.getMembre().getIdM());
			statement.setInt(2, location.getVehicule().getIdV());
			statement.setObject(3, location.getDateDebut());
			statement.setObject(4, location.getDateFin());
			statement.setFloat(5, location.getTotal());
			statement.setObject(6, location.getDateReservation());
						
			statement.executeUpdate();		
			
			
		} catch (SQLException e) {
			System.out.println("dans vehiculeDao save "+e.getMessage());
			
		}		
	}
	
	public List<Location> listeLoactions() {
		
		String query = "SELECT * FROM location";
		
		List<Location> liste = new ArrayList<>();
		try {

			PreparedStatement statement = connection.prepareStatement(query);
			ResultSet resultset = statement.executeQuery();

			while (resultset.next()) {
				int idM=resultset.getInt("id_client");
				int idV=resultset.getInt("id_vehicule");
				
				UserDao userDao=new UserDao();
				VehiculeDao vehiculeDao=new VehiculeDao();
				
				Membre membre=userDao.getUser(idM);
				Vehicule vehicule=vehiculeDao.getVehicule(idV);
				
				Date dcl=resultset.getDate("dateDebut");
				
				LocalDate localDate = Instant.ofEpochMilli(dcl.getTime())
					      .atZone(ZoneId.systemDefault())
					      .toLocalDate();
							
				
				Location location = new Location(
						resultset.getInt("id_location"),
						membre,
						vehicule,
						resultset.getDate("dateDebut"), 
						resultset.getDate("dateFin"), 	
						resultset.getFloat("total"),
						localDate	
						);

				liste.add(location);
			}
			;
			return liste;

		} catch (SQLException e) {
			System.out.println("Dans localDao listeLocation " + e.getMessage());
		}
		return null;

	}
	
	public List<Location> listeLoaction(int id) {
		
		String query = "SELECT * FROM location WHERE id_client=?";
		
		List<Location> liste = new ArrayList<>();
		try {

			PreparedStatement statement = connection.prepareStatement(query);
			statement.setInt(1, id);
			
			ResultSet resultset = statement.executeQuery();

			while (resultset.next()) {
				int idM=resultset.getInt("id_client");
				int idV=resultset.getInt("id_vehicule");
				
				UserDao userDao=new UserDao();
				VehiculeDao vehiculeDao=new VehiculeDao();
				
				Membre membre=userDao.getUser(idM);
				Vehicule vehicule=vehiculeDao.getVehicule(idV);
				
				Date dcl=resultset.getDate("dateDebut");
				
				LocalDate localDate = Instant.ofEpochMilli(dcl.getTime())
					      .atZone(ZoneId.systemDefault())
					      .toLocalDate();
							
				
				Location location = new Location(
						resultset.getInt("id_location"),
						membre,
						vehicule,
						resultset.getDate("dateDebut"), 
						resultset.getDate("dateFin"), 	
						resultset.getFloat("total"),
						localDate	
						);

				liste.add(location);
			}
			;
			return liste;

		} catch (SQLException e) {
			System.out.println("Dans localDao listeLocation " + e.getMessage());
		}
		return null;

	}	

	public LocalDate temps() {		
		return LocalDate.now() ;	
	}
	
	public static Date convertToDate(LocalDate date) {
	        return Date.from(date
	            .atStartOfDay().atZone(
	                ZoneId.systemDefault())
	            .toInstant());
	    }
	
	public void supprimer(int id) {
			String query = "DELETE FROM location WHERE id_location=?";

			try {
				PreparedStatement statement = connection.prepareStatement(query);
				statement.setInt(1, id);

				statement.executeUpdate();

			} catch (SQLException e) {
				System.out.println("Dans vehiculeDao methode supprimer " + e.getMessage());
			}	
		}
	
	public List<Location> listeLoactionsEncours(LocalDate lcl) {
		
		String query = "SELECT * FROM location WHERE dateFin > ?";
		
		List<Location> liste = new ArrayList<>();
		try {

			PreparedStatement statement = connection.prepareStatement(query);
			statement.setObject(1,lcl);
			
			ResultSet resultset = statement.executeQuery();

			while (resultset.next()) {
				
				int idM=resultset.getInt("id_client");
				int idV=resultset.getInt("id_vehicule");
				
				UserDao userDao=new UserDao();
				VehiculeDao vehiculeDao=new VehiculeDao();
				
				Membre membre=userDao.getUser(idM);
				Vehicule vehicule=vehiculeDao.getVehicule(idV);
				
				Date dcl=resultset.getDate("dateDebut");
				
				LocalDate localDate = Instant.ofEpochMilli(dcl.getTime())
					      .atZone(ZoneId.systemDefault())
					      .toLocalDate();
							
				
				Location location = new Location(
						resultset.getInt("id_location"),
						membre,
						vehicule,
						resultset.getDate("dateDebut"), 
						resultset.getDate("dateFin"), 	
						resultset.getFloat("total"),
						localDate	
						);

				liste.add(location);
			}
			;
			return liste;

		} catch (SQLException e) {
			System.out.println("Dans localDao listeLocation " + e.getMessage());
		}
		return null;

	}
	
	public List<Location> listeLoactionsPasses(LocalDate lcl) {
		
		String query = "SELECT * FROM location WHERE dateFin < ?";
		
		List<Location> liste = new ArrayList<>();
		try {
			
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setObject(1,lcl);
			
			ResultSet resultset = statement.executeQuery();
			
			while (resultset.next()) {
				
				int idM=resultset.getInt("id_client");
				int idV=resultset.getInt("id_vehicule");
				
				UserDao userDao=new UserDao();
				VehiculeDao vehiculeDao=new VehiculeDao();
				
				Membre membre=userDao.getUser(idM);
				Vehicule vehicule=vehiculeDao.getVehicule(idV);
				
				Date dcl=resultset.getDate("dateDebut");
				
				LocalDate localDate = Instant.ofEpochMilli(dcl.getTime())
						.atZone(ZoneId.systemDefault())
						.toLocalDate();
				
				
				Location location = new Location(
						resultset.getInt("id_location"),
						membre,
						vehicule,
						resultset.getDate("dateDebut"), 
						resultset.getDate("dateFin"), 	
						resultset.getFloat("total"),
						localDate	
						);
				
				liste.add(location);
			}
			;
			return liste;
			
		} catch (SQLException e) {
			System.out.println("Dans localDao listeLocation " + e.getMessage());
		}
		return null;
		
	}



}

