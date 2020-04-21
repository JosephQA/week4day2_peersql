//package example;
//
//import static org.junit.Assert.assertEquals;
//
//import org.junit.Test;
//
//import annotation.Taxes;
//
//public class TaxesTest {
//	Taxes T = new Taxes();
//
//	
//	
//	
//	@Test
//	public void preciseTaxLow() {
//		double salary = 10000;
//		assertEquals(0.0,T.taxamo(salary));
//	}
//	@Test
//	public void preciseTaxMedLow() {
//		double salary = 17000;
//		assertEquals(salary*0.1,T.taxamo(salary));
//	}
//	@Test
//	public void preciseTaxMed() {
//		double salary = 22000;
//		assertEquals(salary*0.15,T.taxamo(salary));
//	}
//	@Test
//	public void preciseTaxMedHigh() {
//		double salary = 35000;
//		assertEquals(salary*0.20,T.taxamo(salary));
//	}
//	@Test
//	public void preciseTaxHigh() {
//		double salary = 999999;
//		assertEquals(salary*0.25,T.taxamo(salary));
//	}
//	@Test
//
//	public void lowTaxTest() {
//
//		assertEquals(0, T.taxes(14999));
//
//		assertEquals(0, T.taxes(7594));
//
//		assertEquals(0, T.taxes(0));
//
//	}
//
//	@Test
//
//	public void mediumLowTaxTest() {
//
//		assertEquals(10, T.taxes(19999));
//
//		assertEquals(10, T.taxes(17685));
//
//		assertEquals(10, T.taxes(15000));
//
//	}
//
//	@Test
//
//	public void mediumTaxTest() {
//
//		assertEquals(15, T.taxes(29999));
//
//		assertEquals(15, T.taxes(25685));
//
//		assertEquals(15, T.taxes(20000));
//
//	}
//
//	@Test
//
//	public void mediumHighTaxTest() {
//
//		assertEquals(20, T.taxes(44999));
//
//		assertEquals(20, T.taxes(37685));
//
//		assertEquals(20, T.taxes(30000));
//
//	}
//
//	@Test
//
//	public void highTaxTest() {
//
//		assertEquals(25, T.taxes(89999));
//
//		assertEquals(25, T.taxes(176850));
//
//		assertEquals(25, T.taxes(45000));
//
//	}
//}
