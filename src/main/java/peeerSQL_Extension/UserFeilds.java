package peeerSQL_Extension;

enum UserFeilds {
USERID("userID"),
USERNAME("userName"),
PASS("password"),
FIRSTNAME("firstName"),
LASTNAME("lastName");

	
	
	private String fld;
	UserFeilds(String envfld){ this.fld = envfld;}
	public String getFeild() {
		return fld;
	}
}
