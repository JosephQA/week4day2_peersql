package peeerSQL_Extension;

public enum OrderFields {
	ORDID("orderID"),
	ORDPROD("productID"),
	ORDUSER("userID"),
	ORDQUAN("quantity"),
	ORDPRICE("price");
		private String fld;
		OrderFields(String envfld){ this.fld = envfld;}
		public String getFeild() {
			return fld;
		}
	}