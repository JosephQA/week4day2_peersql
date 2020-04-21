package annotation;

public class UniqueSum {

	public Object weirdSum(int i, int j, int k) {
		// take ints, discard copies of ints
		int tmpi=i,tmpj=j,tmpk=k;
		if(tmpi == tmpj) {i = 0;j =0;}
		if(tmpj == tmpk) {j =0;}
		if(tmpk ==tmpi) {k=0;}
		//if(tmpj == tmpi) {j =0;}
		
		return i+j+k;
	}

}
