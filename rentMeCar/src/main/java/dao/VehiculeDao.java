package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import modele.Vehicule;
import modele.VehiculeDisponible;

public class VehiculeDao extends DAO<Vehicule> {
	AgenceDao agenceDao=new AgenceDao();
	
	public void save(Vehicule vehicule){
		
		String query="INSERT INTO vehicule VALUES (NULL,?,?,?,?,?,?)";
		
		try {
			
			PreparedStatement statement=connection.prepareStatement(query);
			
			
			statement.setString(1, vehicule.getMarque());
			statement.setString(2, vehicule.getModele());
			statement.setDouble(3, vehicule.getPrixJ());
			statement.setString(4, vehicule.getDescription());
			statement.setString(5, vehicule.getImage());
			statement.setInt(6, vehicule.getAgence().getIdA());
			
			
			statement.executeUpdate();		
			
			
		} catch (SQLException e) {
			System.out.println("dans vehiculeDao save "+e.getMessage());
			
		}		
	}
	
	public boolean existe( Vehicule vehicule ) {
        String query = "SELECT * FROM vehicule WHERE marque =?";
        
        try {
        	
            PreparedStatement statement = connection.prepareStatement( query );
            statement.setString( 1, vehicule.getMarque() );
            
            
            if ( statement.executeQuery().next() )
                return true;
        } catch ( SQLException e ) {
        	System.out.println("dans vehiculeDao methode existe "+e.getMessage());
        }
        return false;
    } 

	public Vehicule getVehicule(int id) {
		String query = "SELECT * FROM vehicule WHERE id_vehicule= ?";

		try {
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setInt(1, id);
			ResultSet resultset = statement.executeQuery();

			if (resultset.next()) {
				int idV =resultset.getInt("agence");
				return new Vehicule(						
									resultset.getInt("id_vehicule"),
									resultset.getString("marque"),
									resultset.getString("modele"),
									resultset.getDouble("prix_journalier"),
									resultset.getString("description"),
									resultset.getString("image"),
									agenceDao.getAgence(idV)							
								);
			}
		} catch (SQLException e) {
			System.out.println("Dans VehiculeDao getVehicule"+e.getMessage());
		}
		return null;
	} 

	public List<Vehicule> listeVehicule() {
		
		String query = "SELECT * FROM vehicule";		
		List<Vehicule> liste = new ArrayList<>();
		
		try {

			PreparedStatement statement = connection.prepareStatement(query);
			ResultSet resultset = statement.executeQuery();

			while (resultset.next()) {
				int idV =resultset.getInt("agence");
				Vehicule vehicule = new Vehicule(						
						resultset.getInt("id_vehicule"),
						resultset.getString("marque"),
						resultset.getString("modele"),
						resultset.getDouble("prix_journalier"),
						resultset.getString("description"),
						resultset.getString("image"),
						agenceDao.getAgence(idV)							
					);

				liste.add(vehicule);
			}			
			return liste;

		} catch (SQLException e) {
			System.out.println("Dans agenceDao listeAgence " + e.getMessage());
		}
		return null;

	}

	public void supprimer(int id) {
		String query = "DELETE FROM vehicule WHERE id_vehicule=?";

		try {
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setInt(1, id);

			statement.executeUpdate();

		} catch (SQLException e) {
			System.out.println("Dans vehiculeDao methode supprimer " + e.getMessage());
		}	
	}

	public void modifier(Vehicule vehicule, int id) {
		
		String query="UPDATE vehicule SET marque=?,modele=?,prix_journalier=?,description=?,image=?,agence=? WHERE id_vehicule=?";
		try {
			PreparedStatement statement=connection.prepareStatement(query);		

			statement.setString(1, vehicule.getMarque());
			statement.setString(2, vehicule.getModele());
			statement.setDouble(3, vehicule.getPrixJ());
			statement.setString(4, vehicule.getDescription());
			statement.setString(5, vehicule.getImage());
			statement.setInt(6, vehicule.getAgence().getIdA());
			
			statement.setInt(7, id);
			
			statement.executeUpdate();
			
		} catch (SQLException e) {
			System.out.println("dans vehiculeDao methode modifier "+e.getMessage());
		}	
}
	
    //Methode pour Vehicule Disponible	
	
	public void saveDispo(Vehicule vehicule){
		
		String query="INSERT INTO vhcDispo VALUES (?)";
		
		try {
			
			PreparedStatement statement=connection.prepareStatement(query);
			
			statement.setInt(1, vehicule.getIdV());
		
			statement.executeUpdate();		
			
			
		} catch (SQLException e) {
			System.out.println("dans vehiculeDao save "+e.getMessage());
			
		}		
	}
	
	public List<VehiculeDisponible> listeVehiculeDispo() {
		
		String query = "SELECT * FROM vhcDispo";		
		List<VehiculeDisponible> liste = new ArrayList<>();
		
		try {

			PreparedStatement statement = connection.prepareStatement(query);
			ResultSet resultset = statement.executeQuery();

			while (resultset.next()) {
				
				VehiculeDao vhDao=new VehiculeDao();
				
				int idV =resultset.getInt("idDisp");
				Vehicule vehicule=vhDao.getVehicule(idV);
				
				VehiculeDisponible vehDispo = new VehiculeDisponible(vehicule);

				liste.add(vehDispo);
			}			
			return liste;

		} catch (SQLException e) {
			System.out.println("Dans vehiculeDao listeVehiculeDispo " + e.getMessage());
		}
		return null;

	}
	
	public VehiculeDisponible getVehiculeDIspo(int id) {
		String query = "SELECT * FROM vhcDispo WHERE idDisp= ?";

		try {
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setInt(1, id);
			ResultSet resultset = statement.executeQuery();

			if (resultset.next()) {
				
				VehiculeDao vhDao=new VehiculeDao();
				
				int idDis =resultset.getInt("idDisp");							
				Vehicule vehicule=vhDao.getVehicule(idDis);
				
				return  new VehiculeDisponible(vehicule);
							
			}
		} catch (SQLException e) {
			System.out.println("Dans VehiculeDao getVehiculeDispo"+e.getMessage());
		}
		return null;
	} 

	public void supprimeDispo(int id) {
		String query = "DELETE FROM vhcDispo WHERE idDisp=?";

		try {
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setInt(1, id);

			statement.executeUpdate();

		} catch (SQLException e) {
			System.out.println("Dans vehiculeDao methode supprimerDispo " + e.getMessage());
		}	
	}
}
