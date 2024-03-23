package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import modele.Agence;
import modele.Membre;

public class AgenceDao extends DAO<Agence> {
	
	public void save(Agence agence){
		
		String query="INSERT INTO agence VALUES (NULL,?,?,?,?,?,?,?)";
		
		try {
			PreparedStatement statement=connection.prepareStatement(query);
			
			
			statement.setString(1, agence.getNom());
			statement.setInt(2, agence.getTel());
			statement.setString(3, agence.getEmail());
			statement.setString(4, agence.getAdresse());
			statement.setInt(5, agence.getCp());
			statement.setString(6, agence.getVille());
			statement.setString(7, agence.getImage());
			
			statement.executeUpdate();		
			
			
		} catch (SQLException e) {
			System.out.println("dans userDao save "+e.getMessage());
			
		}		
	}

	public boolean existe( Agence agence ) {
	        String query = "SELECT * FROM agence WHERE nom =? OR email=?";
	        
	        try {
	        	
	            PreparedStatement statement = connection.prepareStatement( query );
	            statement.setString( 1, agence.getNom() );
	            statement.setString( 2, agence.getEmail() );
	            
	            if ( statement.executeQuery().next() )
	                return true;
	        } catch ( SQLException e ) {

	        }
	        return false;
	    }  

	public Agence getAgence(int id) {
		String query = "SELECT * FROM agence WHERE id_agence= ?";

		try {
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setInt(1, id);
			ResultSet resultset = statement.executeQuery();

			if (resultset.next()) {
				return new Agence(						
								resultset.getInt("id_agence"),							
								resultset.getString("nom"),
								resultset.getInt("tel"),
								resultset.getString("email"),
								resultset.getString("adresse"), 
								resultset.getInt("cp"),
								resultset.getString("ville"),	
								resultset.getString("image")
								);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return null;
	} 
	
	public List<Agence> listeAgence() {
		
		String query = "SELECT * FROM agence";		
		List<Agence> liste = new ArrayList<>();
		
		try {

			PreparedStatement statement = connection.prepareStatement(query);
			ResultSet resultset = statement.executeQuery();

			while (resultset.next()) {
				Agence agence = new Agence(
						resultset.getInt("id_agence"),							
						resultset.getString("nom"),
						resultset.getInt("tel"),
						resultset.getString("email"),
						resultset.getString("adresse"), 
						resultset.getInt("cp"),
						resultset.getString("ville"),	
						resultset.getString("image")
						);

				liste.add(agence);
			}			
			return liste;

		} catch (SQLException e) {
			System.out.println("Dans agenceDao listeAgence " + e.getMessage());
		}
		return null;

	}

	
	public void supprimer(int idAgence) {
		String query = "DELETE FROM agence WHERE id_agence=?";

		try {
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setInt(1, idAgence);

			statement.executeUpdate();

		} catch (SQLException e) {
			System.out.println("Dans UserDao methode supprimer " + e.getMessage());
		}

		
	}
	
	public void modifier(Agence agence, int id) {
		
		String query="UPDATE agence SET nom=?,tel=?,email=?,adresse=?,cp=?,ville=?,image=? WHERE id_agence=?";
		try {
			PreparedStatement statement=connection.prepareStatement(query);		

			statement.setString(1, agence.getNom());
			statement.setInt(2, agence.getTel());
			statement.setString(3, agence.getEmail());
			statement.setString(4, agence.getAdresse());
			statement.setInt(5, agence.getCp());
			statement.setString(6, agence.getVille());
			statement.setString(7, agence.getImage());
			
			statement.setInt(8, id);
			
			statement.executeUpdate();
			
		} catch (SQLException e) {
			System.out.println("dans agence methode modifier "+e.getMessage());
		}	
}
	}
