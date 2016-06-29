import static org.junit.Assert.*;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import DBUtility.DBUtility;

public class Test {

	@org.junit.Test
	public void test() throws SQLException {
		List<String> mylist = new ArrayList<String>();
		mylist=DBUtility.select("Select * from customers");
		
		for(int i=0;i<mylist.size();i++)
		{
			System.out.println(mylist.get(i));
		}
			
			
		
		
		
		
	}

}
