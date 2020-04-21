package peeerSQL_Extension;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseHandler {
	Connection conn;
	Statement stmnt;
	static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost:3306/peersql";
	static final String USER = "root";
	static final String PASS = "root";
 
	DatabaseHandler() {
		try {
			Class.forName(JDBC_DRIVER).newInstance();
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			stmnt = conn.createStatement();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public ResultSet selectOrder(int orderId) {
		ResultSet rs;
		String slctString = "select * from orders where " + OrderFields.ORDID.getFeild() + " = " + orderId;
		rs = selector(slctString);
		return rs;
	}

	public ResultSet selectProduct(int prodId) {
		ResultSet rs;
		String slctString = "select * from products where " + ProductFields.PRODID.getFeild()  + " = " + prodId;
		rs = selector(slctString);
		return rs;
	}

	public ResultSet selectUser(int userId) {
		ResultSet rs;
		String slctString = "select * from users where " + UserFeilds.USERID.getFeild()  + " = " + userId;
		rs = selector(slctString);
		return rs;
	}

	private ResultSet selector(String qry) {
		ResultSet rs;
		try {
			System.out.println(qry);
			rs = stmnt.executeQuery(qry);
			//System.out.println(rs); // print memory location only
			//while(rs.next()) {System.out.println(rs.getInt(1));}
			return rs;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	private int selectproductQuan(int prodID) {
		String qry = "select " + ProductFields.PRODSTOCK.getFeild()  +" from products where " + ProductFields.PRODID.getFeild() + " ="
				+ prodID + ";";
		return getintfromdb(qry, ProductFields.PRODSTOCK.getFeild());

	}
	private double selectproductprice(int prodID) {
		String qry = "select " + ProductFields.PRODPRICE.getFeild()  + " from products where " + ProductFields.PRODID.getFeild() + " ="
				+ prodID + ";";
		return getdoublefromdb(qry);
	}
	private double getdoublefromdb(String qry) {
		ResultSet rs = selector(qry);

		double result;
		try {
			rs = stmnt.executeQuery(qry);
			rs.next();
			//System.out.println(rs.getDouble(1));
			result = rs.getDouble(1);
			return result;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0.0;
		}

	}
	private int getintfromdb(String qry, String col) {
		ResultSet rs = selector(qry);

		int result;
		try {
			rs = stmnt.executeQuery(qry);
			System.out.println(qry);
			rs.next();
			//System.out.println(rs);
			result = rs.getInt(col);
			return result;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}
	}

	public boolean createOrder(/*int orderID,*/ int ProductID, int userID, int quan) {
		// check product exists
		if (selectProduct(ProductID) != null) {
		} else {
			System.out.println("product does not exist");
			return false;
		}
		// check user exists
		if (selectUser(userID) != null) {
		} else {
			System.out.println("user does not exist");
			return false;
		}
		// check product quantity available
		if (selectproductQuan(ProductID) >= quan) {
		} else {
			System.out.println("not enough product");
			return false;
		}
		// on fail any of above
//		return false;
		// on all pass
		
		// update available product quan in products table
		 updateProduct(ProductID, ProductFields.PRODSTOCK ,""+(selectproductQuan(ProductID)-quan));
		//price order
		double price = 0 ;
		double unitPrice = selectproductprice(ProductID);
		price = unitPrice*quan;
		System.out.println(price+ "="+unitPrice+"*"+quan);
		// create order
		
		String comma = " , ";
		String insertString = " INSERT INTO orders VALUES(0,"+ProductID+comma+userID+comma+quan+comma+price+ ");";

		return creator(insertString);

	}

	public boolean createProduct(String name, double price, int stock) {
		String comma = " , ";
		String insertString = " INSERT INTO products VALUES(0,'" + name + "'" + comma + price +comma + stock+ ");";

		return creator(insertString);
	}

	public boolean createUser(String name, String pass, String firstname, String lastname) {
		String comma = " , ";
		String insertString = " INSERT INTO users VALUES(0,'" + name + "'" + comma + "'" + pass + "'" + comma + "'"
				+ firstname + "'" + comma + "'" + lastname + "');";
		return creator(insertString);
	}

	private boolean creator(String qry) {
		try {
			stmnt.execute(qry);
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	public boolean updateOrder(int id, OrderFields field, String value) {
		// this needs to be sneaky-er
		value = sneakyCheck(value);
		System.out.println("sneaaky val = " + value);
		String updateString = "update orders set " + field.getFeild() + " = " + value + " where " + OrderFields.ORDID.getFeild()  + " = " + id + ";";
		return updater(updateString);
	}

	public boolean updateProduct(int id, ProductFields field, String value) {
		// this needs to be sneaky-er
		value = sneakyCheck(value);
		String updateString = "update products set " + field.getFeild() + " = " + value + " where " + ProductFields.PRODID.getFeild()  + " = "  + id
				+ ";";
		return updater(updateString);
	}

	public boolean updateUser(int custid, UserFeilds field, String value) {
		// this needs to be sneaky-er
		value = sneakyCheck(value);
		String updateString = "update users set " + field.getFeild() + " = " + value + " where " + UserFeilds.USERID.getFeild()  + " = " + custid
				+ ";";
		return updater(updateString);
	}

	private String sneakyCheck(String value) {
		try {
			Integer.parseInt(value);
			return value;
		} catch (Exception e) {
			// do nothing

		}
		try {
			Double.parseDouble(value);
			return value;
		} catch (Exception e) {
			// do nothing

		}

		return "'" + value + "'";
	}

	private boolean updater(String qry) {
		try {
			stmnt.execute(qry);
			System.out.println(qry);
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	public boolean deleteOrder(int id) {
		String deleteString = "delete from orders where orderID = " + id;
		return deleter(deleteString);
	}

	public boolean deleteProduct(int id) {
		String deleteString = "delete from products where productID =" + id;
		return deleter(deleteString);
	}

	public boolean deleteUser(int userid) {
		String deleteString = "delete from users where userID = " + userid;
		return deleter(deleteString);
	}

	private boolean deleter(String qry) {
		try {
			stmnt.executeUpdate(qry);
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
}
