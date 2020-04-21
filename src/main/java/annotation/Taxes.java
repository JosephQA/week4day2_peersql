package annotation;

public class Taxes {
	public int taxes(int i) {

		if (i >= 0 && i <= 14999) {

			return 0;

		} else if (i >= 15000 && i <= 19999) {

			return 10;

		} else if (i >= 20000 && i <= 29999) {

			return 15;

		} else if (i >= 30000 && i <= 44999) {

			return 20;

		} else if (i >= 45000) {

			//System.out.println(i);

			return 25;

		}

		return 0;

	}

	public Object taxamo(double salary) {
		// TODO Auto-generated method stub
		double retVal;
		int intsal = (int) salary;
		retVal =(taxes(intsal))*salary/100;
		//if( retVal == 0) { retVal = salary;}
		System.out.println(retVal);

		return retVal;
	}
}
