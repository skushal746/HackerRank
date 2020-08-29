package testing;

public interface TestInterface {
	
	static void testStaticMethod(){
		System.out.println("Inside static method of an interface");
	}
	
	default void testDefaultMethod() {
		System.out.println("Inside default method of an interface");
	}
}

class TestingInterfaceInstanceCreation{
	private void yolo() {
		
	}
}
