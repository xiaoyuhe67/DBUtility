package DBUtility;
import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.List;

public class DBUtility {
	
	    private static Connection con = null;
		
	
		public static ResultSet getResultSet(String query) throws SQLException
		{
			
			 con = ConnectionManager.getConnection();
			 
			  ResultSet rs;
			 
			  PreparedStatement st = con.prepareStatement(query);
			 
			   rs = st.executeQuery();
			 
			  return rs;
			 
	  }
		
		 public static void runQuery(String query) throws SQLException 
		 {
			
			 con = ConnectionManager.getConnection();
			
			 PreparedStatement st = con.prepareStatement(query);
			
			 st.executeUpdate();
			
	      }
		 
		 
		public static List<String> select(String query)  throws SQLException
		 {

			 List<String> mylist = new ArrayList<String>();
			 ResultSet rs=null;
				try {
					con = ConnectionManager.getConnection();
					rs =getResultSet(query);
					
					ResultSetMetaData rsmd = rs.getMetaData();
					int numberOfColumns = rsmd.getColumnCount();
					
						
					while (rs.next()) {
						
						for(int i=1;i<=numberOfColumns;i++)
						{
							mylist.add(rs.getString(i));
						}
					}

				} catch (SQLException e) {

					e.printStackTrace();
				} finally {

					try {
						rs.close();
						
						con.close();
					}catch(SQLException e){
						e.printStackTrace();
					}			

				}
				return mylist;

			}
		
		public static int columnnum(String query) throws SQLException
		{
			 List<String> mylist = new ArrayList<String>();
			 ResultSet rs=null;
				try {
					con = ConnectionManager.getConnection();
					rs =getResultSet(query);
					
					ResultSetMetaData rsmd = rs.getMetaData();
					int numberOfColumns = rsmd.getColumnCount();			

				} catch (SQLException e) {

					e.printStackTrace();
				} finally {

					try {
						rs.close();
						
						con.close();
					}catch(SQLException e){
						e.printStackTrace();
					}			

				}
				return numberOfColumns;
		}
		 
		public static List<String> insert(String query) throws SQLException 
		 {
			 
			 List<String> mylist = new ArrayList<String>();
			 ResultSet rs=null;
				try {
					con = ConnectionManager.getConnection();
					rs =getResultSet(query);		

				} catch (SQLException e) {

					e.printStackTrace();
				} finally {

					try {
						rs.close();				
						con.close();
					}catch(SQLException e){
						e.printStackTrace();
					}			

				}
				return mylist;
		 }
		 

}
