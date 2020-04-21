package peeerSQL_Extension;

public enum ProductFields {
PRODID("productID"),
PRODNAME("productName"),
PRODPRICE("price"),
PRODSTOCK("stock");
	private String fld;
	ProductFields(String envfld){ this.fld = envfld;}
	public String getFeild() {
		return fld;
	}
}
