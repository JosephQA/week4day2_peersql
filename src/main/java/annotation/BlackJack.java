package annotation;

public class BlackJack {
// 1 , 22
	public double play(int a, int b) {
		// TODO Auto-generated method stub
//		int aClose;
//		int bClose;
//		aClose = 21 -a ; //20
//		bClose = 21 -b ; // -1
//		System.out.println("A"+a+"B"+b+"bCLose"+bClose+"Aclose"+aClose);
//		System.out.println(Math.abs(bClose));
//		if(aClose >= 0 && aClose <= Math.abs(bClose)) { ;return a;}
//		else if( Math.abs(bClose) >= 0 && Math.abs(bClose) <= Math.abs(aClose)) {return b;}
//		return 0;
		
		
//		if(Math.abs(21-a) <= Math.abs(21-b) && b>21  ) {return a;}
//		if(Math.abs(21-a) >= Math.abs(21-b) && a21) {return b;}
		
		double aclose = 21 - a;
		double bclose = 21 - b;
		
		if(aclose >=0 && bclose >= 0 && a <=21 && b<= 21) {return a;}
		else if(bclose >=0 && aclose >= 0 && a <=21 && b<= 21) {return b;}
		else if( a <= 21 && b > 21 ) {return a;}
		else if( b <= 21 && a >21 || true ) {return b;}
//		System.out.println(a);
//		System.out.println(b);
//		System.out.println(aclose);
//		System.out.println(bclose);//		
//		System.out.println("all fail");
//		
//		if(b<a) {
//			if(b<=21) {return b;}
//		}else if(a<b) {
//			if(a<= 21) {return a;}
//		}
//		
		
		return 0;
	}

}
