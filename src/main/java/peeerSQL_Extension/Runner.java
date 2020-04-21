package peeerSQL_Extension;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Runner {
public static void main(String[] args) {
	DatabaseHandler dbh = new DatabaseHandler();
	dbh.createProduct("best product", 12.20, 99);
	dbh.createProduct("worst product", 99.98, 3);
	dbh.createUser("johnDB", "bestpassword","JOSN", "dIGBY");
	dbh.createOrder(1, 1, 2);
	dbh.deleteProduct(3);
	dbh.updateProduct(2, ProductFields.PRODNAME, "medium product");
	dbh.updateOrder(1, OrderFields.ORDPRICE, "33.33");
	dbh.updateUser(1, UserFeilds.LASTNAME, "newlastname");
	ResultSet rs = dbh.selectUser(1);
	try {
	while(rs.next()) {
		System.out.println("results get");
			System.out.println(rs.getInt(1));
			System.out.println(rs.getString(2));
	}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
}

