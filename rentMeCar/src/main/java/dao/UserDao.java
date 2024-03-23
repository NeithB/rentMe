package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import modele.Membre;

public class UserDao extends DAO<Membre> {
	
	public void save(Membre mbre){
		
		String query="INSERT INTO membre VALUES (NULL,?,?,?,?,?,?,?,?,?,?,?)";
		
		try {
			PreparedStatement statement=connection.prepareStatement(query);
			
			
			statement.setString(1, mbre.getPrenom());
			statement.setString(2, mbre.getNom());
			statement.setString(3, mbre.getLogin());
			statement.setString(4, mbre.getMdp());
			statement.setInt(5, mbre.getTel());
			statement.setString(6, mbre.getEmail());
			statement.setString(7, mbre.getAdresse());
			statement.setInt(8, mbre.getCp());
			statement.setString(9, mbre.getVille());
			statement.setString(10, mbre.getStatut());
			statement.setObject(11, mbre.getDate_inscr());
			
			statement.executeUpdate();		
			
			
		} catch (SQLException e) {
			System.out.println("dans userDao save "+e.getMessage());
			
		}		
	}
    public boolean existe( Membre user ) {
        String query = "SELECT * FROM membre WHERE login = ? OR email=?";
        try {
            PreparedStatement statement = connection.prepareStatement( query );
            statement.setString( 1, user.getLogin() );
            statement.setString( 2, user.getEmail() );

            if ( statement.executeQuery().next() )
                return true;
        } catch ( SQLException e ) {

        }
        return false;
    }  
	public Membre login(String login, String mdp) {
		String query = "SELECT * FROM membre where login=? AND mdp=?";

		try {
			PreparedStatement statement = connection.prepareStatement(query);

			statement.setString(1, login);
			statement.setString(2, mdp);

			ResultSet resultset = statement.executeQuery();
			if (resultset.next()) {

				return new Membre(
						resultset.getInt("id_membre"),
						resultset.getString("prenom"),
						resultset.getString("nom"),
						resultset.getString("login"), 
						resultset.getString("mdp"),
						resultset.getInt("tel"),
						resultset.getString("email"),
						resultset.getString("adresse"), 
						resultset.getInt("cp"),
						resultset.getString("ville"),
						resultset.getString("statut"),	
						resultset.getDate("date_inscription")	
						);

			}
			
		} catch (SQLException e) {
			System.out.println("dans UserDao connecter" + e.getMessage());
		}

		return null;
	}
	
	public List<Membre> listeUsers() {
		
		String query = "SELECT * FROM membre";
		
		List<Membre> liste = new ArrayList<>();
		try {

			PreparedStatement statement = connection.prepareStatement(query);
			ResultSet resultset = statement.executeQuery();

			while (resultset.next()) {
				Membre user = new Membre(
						resultset.getInt("id_membre"),
						resultset.getString("prenom"),
						resultset.getString("nom"),
						resultset.getString("login"), 
						resultset.getString("mdp"),
						resultset.getInt("tel"),
						resultset.getString("email"),
						resultset.getString("adresse"), 
						resultset.getInt("cp"),
						resultset.getString("ville"),
						resultset.getString("statut"),	
						resultset.getDate("date_inscription")
						);

				liste.add(user);
			}
			;
			return liste;

		} catch (SQLException e) {
			System.out.println("Dans userDao listeUser " + e.getMessage());
		}
		return null;

	}
	
	public void supprimer(int id) {

		String query = "DELETE FROM membre WHERE id_membre=?";

		try {
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setInt(1, id);

			statement.executeUpdate();

		} catch (SQLException e) {
			System.out.println("Dans UserDao methode supprimer " + e.getMessage());
		}

	}	

	public void modifier(Membre mbre, int id) {
		
		String query="UPDATE membre SET prenom=?,nom=?,login=?,mdp=?,tel=?,email=?,adresse=?,cp=?,ville=?,statut=?,date_inscription=? WHERE id_membre=?";
		try {
			PreparedStatement statement=connection.prepareStatement(query);		

			statement.setString(1, mbre.getPrenom());
			statement.setString(2, mbre.getNom());
			statement.setString(3, mbre.getLogin());
			statement.setString(4, mbre.getMdp());
			statement.setInt(5, mbre.getTel());
			statement.setString(6, mbre.getEmail());
			statement.setString(7, mbre.getAdresse());
			statement.setInt(8, mbre.getCp());
			statement.setString(9, mbre.getVille());
			statement.setString(10, mbre.getStatut());
			statement.setObject(11, mbre.getDate_inscr());
			
			statement.setInt(12, id);
			
			statement.executeUpdate();
			
		} catch (SQLException e) {
			System.out.println("dans userDao methode modifier "+e.getMessage());
		}
		
		
	}

	public Membre getUser(int id) {
		String query = "SELECT * FROM membre WHERE id_membre= ?";

		try {

			PreparedStatement statement = connection.prepareStatement(query);

			statement.setInt(1, id);

			ResultSet resultset = statement.executeQuery();

			if (resultset.next()) {
				return new Membre(						
								resultset.getInt("id_membre"),
								resultset.getString("prenom"),
								resultset.getString("nom"),
								resultset.getString("login"), 
								resultset.getString("mdp"),
								resultset.getInt("tel"),
								resultset.getString("email"),
								resultset.getString("adresse"), 
								resultset.getInt("cp"),
								resultset.getString("ville"),
								resultset.getString("statut"),	
								resultset.getDate("date_inscription")
								);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

		return null;

	}
}
