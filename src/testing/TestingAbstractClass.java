package testing;

public class TestingAbstractClass {
	public static void main(String[] args) {
		ExtendAbstractClass e = new ExtendAbstractClass();
		e.ExtendAbstractClassMethod1();
	}
}

class ExtendAbstractClass extends AbstractClass{
	
	public void ExtendAbstractClassMethod1() {
		System.out.println("Inside ExtendAbstractClassMethod1");
	}
	
}


abstract class AbstractClass{
	public AbstractClass() {
		System.out.println("Dfeault Constructor of AbstractClass");
	}
}