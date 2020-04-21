//package example;
//
//import static org.junit.Assert.fail;
//
//import org.junit.After;
//import org.junit.AfterClass;
//import org.junit.Before;
//import org.junit.BeforeClass;
//import org.junit.Ignore;
//import org.junit.Test;
//
//public class annotationTest {
//	@Test
//	public void test1() {
//		fail("fail");
//	}
//	
//	@Test
//	public void test2() {
//		fail("true");
//		System.out.println("test 2");
//	}
//	@Test
//	@Ignore
//	public void test3() {
//		fail("true");
//		System.out.println("test 3");
//	}
//	
//	@BeforeClass
//	public static void setup() {
//		// set up requirements here
//		System.out.println("beforeCLass");
//	}
//
//	@AfterClass
//	public static void teardown() {
//		// close any used resources etc here
//		System.out.println("afterClass");
//	}
//	@Before
//	public void init() {
//		System.out.println("before tst");
//	}
//	
//	@After
//	public void postit() {
//		System.out.println("after tst");
//	}
//	
//	
//}
