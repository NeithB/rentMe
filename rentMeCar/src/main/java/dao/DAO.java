package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public abstract class DAO<T> {
	
	 protected Connection connection;
	 

	    public DAO() {
	        try {
	            Class.forName( "com.mysql.cj.jdbc.Driver" );
	            connection = DriverManager.getConnection( "jdbc:mysql://127.0.0.1:3306/projet_sira", "root", "" );
	        } catch ( ClassNotFoundException e ) {

	        } catch ( SQLException e ) {

	        }
	    }
	    public ResultSet find( String t, int id ) {

	        String query = "SELECT * FROM " + t + " WHERE id = ?";
	        try {
	            PreparedStatement statement = connection.prepareStatement( query );
	            statement.setInt( 1, id );

	            return statement.executeQuery();
	        } catch ( SQLException e ) {

	        }

	        return null;
	    }
	    public ResultSet getAll( String table ) {

	        try {
	            Statement statement = connection.createStatement();
	            return statement.executeQuery( "SELECT * FROM " + table );
	        } catch ( SQLException e ) {
	            System.out.println( e.getMessage() );
	        }

	        return null;
	    }


}
