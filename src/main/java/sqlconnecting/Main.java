package sqlconnecting;

import com.mysql.jdbc.*;

import java.sql.*;
import com.mysql.jdbc.Driver;

public class Main {
	static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost:3306/gamedb";
	static final String USER = "root";
	static final String PASS = "root";
	static java.sql.Statement stmnt;
	static java.sql.Statement stmnt2;
	public static void main(String[] args) {
		Connection conn; //can create once and 
		Statement statement ; //call statement.executeUpdate(String validsql);
		try {
			Class.forName(JDBC_DRIVER).newInstance();
			
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("connection DB starttign");
		try {
			conn = DriverManager.getConnection(DB_URL, USER,PASS);
			 DatabaseMetaData dm = (DatabaseMetaData) conn.getMetaData();
			System.out.println("connectioned "+dm.getDriverName());
			//stmnt = conn.createStatement();
//			 //String sqlInsert = "INSERT INTO customers VALUES(0,'jim bob',50,'jim.bob@qa.com','wc1 3sf','123 my road', 'jimBob','LA')";
			String tablename = " customers "; String name = "'bleh blah'"; String age = "'32'"; String email = "'email@email.co.co.co'";String postcode ="'123dsa!'";String adress = "'123 beverly chills'"; String pass ="'alsojimboblol'";String city = "'lAAHHNNDAAHHnnnn'"; String comma = ",";
			 String insert2 = "INSERT INTO"+tablename+"VALUES(0"+comma+name+comma+age+comma+email+comma+postcode+comma+adress+comma+pass+comma+city+");";
			String ins = "valid sql statement";
//			//stmnt.execute(sqlInsert);
			//stmnt.execute(insert2);
			////conn.close();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
			try {
				String separator = " , ";
				conn = DriverManager.getConnection(DB_URL, USER,PASS);
				stmnt2 = conn.createStatement();
				String slctstr = "SELECT * from customers;";
				ResultSet rs = stmnt2.executeQuery(slctstr);
				while(rs.next()) {
				System.out.println(rs.getInt(1)+separator+rs.getString(2)+separator+rs.getString(4));
				}
			}catch(SQLException e2) {
				e2.printStackTrace();
			}
			try {
				java.sql.Statement stmnt3 = DriverManager.getConnection(DB_URL, USER,PASS).createStatement();
				String updtstmnt = "update customers set cust_name='name' where customer_id=5;";
				stmnt3.execute(updtstmnt);
				
			}catch(SQLException e3) {
				e3.printStackTrace();
			}
			try {
				java.sql.Statement stmnt3 = DriverManager.getConnection(DB_URL, USER,PASS).createStatement();
				String delstmnt ="delete from customers where customer_id=5;";
				stmnt3.execute(delstmnt);
			}catch(SQLException e4) {
				e4.printStackTrace();
			}

	}

}
